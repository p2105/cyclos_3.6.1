/*
    This file is part of Cyclos (www.cyclos.org).
    A project of the Social Trade Organisation (www.socialtrade.org).

    Cyclos is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    Cyclos is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Cyclos; if not, write to the Free Software
    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA

 */
package nl.strohalm.cyclos.utils;

import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import nl.strohalm.cyclos.entities.accounts.LockedAccountsOnPayments;
import nl.strohalm.cyclos.entities.exceptions.LockingException;
import nl.strohalm.cyclos.exceptions.ApplicationException;
import nl.strohalm.cyclos.services.application.ApplicationServiceLocal;
import nl.strohalm.cyclos.utils.access.LoggedUser;
import nl.strohalm.cyclos.utils.transaction.CurrentTransactionData;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * Utility class used to run code in a new transaction, taking care of running {@link CurrentTransactionData#runCurrentTransactionCommitListeners()}
 * in case of commits, and always running {@link CurrentTransactionData#cleanup()} at the end
 * 
 * @author luis
 */
public class TransactionHelperImpl implements TransactionHelper {

    /**
     * Implementation for {@link Future} for {@link TransactionHelper#runAsync(TransactionCallback)}
     * @author luis
     */
    private final class FutureResult<T> implements Future<T> {
        private final TransactionThread<T> thread;
        private boolean                    cancelled;
        private boolean                    done;

        private FutureResult(final TransactionThread<T> thread) {
            this.thread = thread;
        }

        @Override
        public boolean cancel(final boolean mayInterruptIfRunning) {
            if (mayInterruptIfRunning && !cancelled) {
                thread.interrupt();
            }
            cancelled = true;
            return true;
        }

        @Override
        public T get() throws InterruptedException, ExecutionException {
            if (thread.isAlive()) {
                thread.join();
            }
            return getResult();
        }

        @Override
        public T get(final long timeout, final TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
            if (thread.isAlive()) {
                thread.join(unit.toMillis(timeout));
            }
            if (!done) {
                throw new TimeoutException();
            }
            return getResult();
        }

        @Override
        public boolean isCancelled() {
            return cancelled;
        }

        @Override
        public boolean isDone() {
            return done;
        }

        private T getResult() throws ExecutionException {
            RunResult<T> runResult = thread.runResult;
            final Throwable error = runResult.error;
            if (error != null) {
                throw new ExecutionException(error);
            }
            return runResult.result;
        }
    }

    private static class RunResult<T> {
        private T         result;
        private Throwable error;
        private boolean   commit;
        private boolean   retry;

        /**
         * Either throw the error if any, or return the result
         * @return
         */
        private T getResultOrThrowError() {
            // If there was an error, throw it here
            if (error != null) {
                throw (error instanceof RuntimeException) ? (RuntimeException) error : new RuntimeException(error);
            }
            return result;
        }

        /**
         * When the commit flag is set and the given callback is a {@link Transactional}, runs it's {@link Transactional#afterCommit(Object)} method;
         */
        private void maybeRunAfterCommit(final TransactionCallback<T> callback) {
            if (commit && callback instanceof Transactional) {
                Transactional<T> transactional = (Transactional<T>) callback;
                transactional.afterCommit(result);
            }
        }
    }

    /**
     * Thread used to start a new transaction
     */
    private class TransactionThread<T> extends Thread {
        private final Map<String, Object>    loggedUserAttributes;
        private final TransactionCallback<T> callback;
        private final boolean                logExceptions;
        private RunResult<T>                 runResult;
        private FutureResult<T>              futureResult;

        private TransactionThread(final Map<String, Object> loggedUserAttributes, final TransactionCallback<T> callback, final boolean logExceptions) {
            this.loggedUserAttributes = loggedUserAttributes;
            this.callback = callback;
            this.logExceptions = logExceptions;
        }

        @Override
        public void run() {
            try {
                LoggedUser.init(loggedUserAttributes);
                runResult = runInCurrentThreadWithResult(callback, false);
                // Exceptions are logged only in debug because most exceptions are already being
                if (logExceptions && runResult.error != null && !(runResult.error instanceof LockingException)) {
                    LOG.error("Error while executing task by TransactionHelper", runResult.error);
                }
            } finally {
                LoggedUser.cleanup();

                if (futureResult != null) {
                    futureResult.done = true;
                }
            }
        }
    }

    private static Log              LOG = LogFactory.getLog(TransactionHelper.class.getName());

    private TransactionTemplate     transactionTemplate;
    private ApplicationServiceLocal applicationService;
    private SessionFactory          sessionFactory;

    @Override
    public boolean hasActiveTransaction() {
        return TransactionSynchronizationManager.hasResource(sessionFactory);
    }

    @Override
    public <T> T maybeRunInNewTransaction(final TransactionCallback<T> callback) {
        return maybeRunInNewTransaction(callback, true, LockedAccountsOnPayments.ORIGIN);
    }

    @Override
    public <T> T maybeRunInNewTransaction(final TransactionCallback<T> callback, final boolean newTransaction) {
        return maybeRunInNewTransaction(callback, newTransaction, LockedAccountsOnPayments.ORIGIN);
    }

    @Override
    public <T> T maybeRunInNewTransaction(final TransactionCallback<T> callback, final boolean newTransaction, final LockedAccountsOnPayments minForNewTx) {
        if (newTransaction && applicationService.getLockedAccountsOnPayments().compareTo(minForNewTx) >= 0) {
            return runInNewTransaction(callback);
        } else {
            return callback.doInTransaction(null);
        }
    }

    @Override
    public <T> Future<T> runAsync(final TransactionCallback<T> callback) {
        if (callback instanceof Transactional) {
            throw new IllegalArgumentException("runAsync doesn't support a Transactional, only plain TransactionCallbacks");
        }
        final TransactionThread<T> thread = startThread(callback, true);
        return new FutureResult<T>(thread);
    }

    @Override
    public <T> T runInCurrentThread(final TransactionCallback<T> callback) {
        return runInCurrentThreadWithResult(callback, true).getResultOrThrowError();
    }

    @Override
    public <T> T runInNewTransaction(final TransactionCallback<T> callback) {
        final TransactionThread<T> thread = startThread(callback, false);
        try {
            thread.join();
        } catch (final InterruptedException e) {
            throw new IllegalStateException(e);
        }
        RunResult<T> runResult = thread.runResult;
        T result = runResult.getResultOrThrowError();
        runResult.maybeRunAfterCommit(callback);
        return result;
    }

    public void setApplicationServiceLocal(final ApplicationServiceLocal applicationService) {
        this.applicationService = applicationService;
    }

    public void setSessionFactory(final SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void setTransactionTemplate(final TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    private <T> RunResult<T> runInCurrentThreadWithResult(final TransactionCallback<T> callback, final boolean runTransactional) {
        RunResult<T> result;
        while (true) {
            result = transactionTemplate.execute(new TransactionCallback<RunResult<T>>() {
                @Override
                public RunResult<T> doInTransaction(final TransactionStatus status) {
                    final RunResult<T> result = new RunResult<T>();
                    try {
                        // Run the callback in transaction
                        result.result = callback.doInTransaction(status);
                        // If got to this point, there were no errors. Commit depends on the status
                        result.commit = !status.isRollbackOnly();
                    } catch (final LockingException e) {
                        // On locking exceptions, we have to retry
                        result.retry = true;
                    } catch (final ApplicationException e) {
                        // ApplicationExceptions controls whether rollbacks are done
                        if (e.isShouldRollback()) {
                            status.setRollbackOnly();
                        } else {
                            result.commit = true;
                        }
                        result.error = e;
                    } catch (final Throwable e) {
                        // On any other exception, rollback
                        status.setRollbackOnly();
                        result.error = e;
                    }
                    return result;
                }
            });
            // Run the transaction commit / rollback listeners
            CurrentTransactionData.detachListeners().runListeners(result.commit);
            CurrentTransactionData.cleanup();
            if (!result.retry) {
                // No retry is needed - break the loop
                break;
            }
        }

        // If the callback is a Transactional, we should invoke the afterCommit() method on commit
        if (runTransactional) {
            result.maybeRunAfterCommit(callback);
        }
        return result;
    }

    private <T> TransactionThread<T> startThread(final TransactionCallback<T> callback, final boolean logExceptions) {
        final TransactionThread<T> thread = new TransactionThread<T>(LoggedUser.getAttributes(), callback, logExceptions);
        thread.setName("Transaction thread for " + Thread.currentThread().getName());
        thread.start();
        return thread;
    }
}
