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
package nl.strohalm.cyclos.http;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.strohalm.cyclos.annotations.Inject;
import nl.strohalm.cyclos.exceptions.ApplicationException;
import nl.strohalm.cyclos.utils.TransactionHelper;
import nl.strohalm.cyclos.utils.transaction.CurrentTransactionData;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;

/**
 * A filter which manages database transactions for web services
 * 
 * @author luis
 */
public class WebServicesTransactionFilter extends OncePerRequestFilter {

    private static final Log  LOG = LogFactory.getLog(WebServicesTransactionFilter.class);

    private TransactionHelper transactionHelper;

    @Inject
    public void setTransactionHelper(final TransactionHelper transactionHelper) {
        this.transactionHelper = transactionHelper;
    }

    @Override
    protected void execute(final HttpServletRequest request, final HttpServletResponse servletResponse, final FilterChain chain) throws IOException, ServletException {
        // As the CXF servlet manually flushes the response before we have the time to end the transaction, we must use a custom response, which never
        // flushes the buffer until we really want it
        final ForcedBufferResponse response = new ForcedBufferResponse(servletResponse);

        // Run the request in a new transaction
        final boolean commit = transactionHelper.runInCurrentThread(new TransactionCallback<Boolean>() {
            @Override
            public Boolean doInTransaction(final TransactionStatus status) {
                try {
                    LOG.debug("Running web service in a new transaction");
                    chain.doFilter(request, response);
                    // Handle silenced errors
                    final Throwable error = CurrentTransactionData.getError();
                    if (error != null) {
                        throw error;
                    }
                    // No writes still means rollbacks
                    if (!CurrentTransactionData.hasWrite()) {
                        status.setRollbackOnly();
                    }
                } catch (final ApplicationException e) {
                    if (e.isShouldRollback()) {
                        status.setRollbackOnly();
                    }
                } catch (final Throwable t) {
                    status.setRollbackOnly();
                }
                return !status.isRollbackOnly();
            }
        });

        if (commit) {
            LOG.debug("Web service transaction was committed");
        } else {
            LOG.debug("Web service transaction was rolled back");
        }

        // Now actually flush the response buffer
        response.doFlushBuffer();
    }

}
