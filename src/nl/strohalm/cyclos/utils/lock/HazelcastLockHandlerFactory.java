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
package nl.strohalm.cyclos.utils.lock;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

import nl.strohalm.cyclos.entities.accounts.Account;
import nl.strohalm.cyclos.entities.exceptions.LockingException;
import nl.strohalm.cyclos.entities.members.Member;
import nl.strohalm.cyclos.utils.EntityHelper;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;

import com.hazelcast.core.Hazelcast;

/**
 * A lock handler factory which uses Hazelcast for distributed locks
 * 
 * @author luis
 */
public class HazelcastLockHandlerFactory extends BaseLockHandlerFactory implements InitializingBean {

    public static class LockKey implements Serializable {
        private static final long serialVersionUID = 5893025909617161302L;
        private final LockType    type;
        private final long        id;

        public LockKey(final LockType type, final long id) {
            this.type = type;
            this.id = id;
        }

        @Override
        public boolean equals(final Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LockKey)) {
                return false;
            }
            LockKey key = (LockKey) obj;
            return key.type == key.type && id == key.id;
        }

        @Override
        public int hashCode() {
            return (int) (13 * type.hashCode() * id);
        }

        @Override
        public String toString() {
            return type + " " + id;
        }
    }

    public static enum LockType {
        ACCOUNT, SMS_STATUS
    }

    /**
     * Locks records in the current transaction
     * @author luis
     */
    private class HazelcastLockHandler implements LockHandler {

        // As we currently only lock accounts, we can use the id directly as key.
        // If we ever support other types of locking, the key would need to reflect entity + key
        private final Map<LockKey, Lock> acquiredLocks = new HashMap<LockKey, Lock>();

        @Override
        public void lock(final Account... accounts) throws LockingException {
            if (ArrayUtils.isEmpty(accounts)) {
                return;
            }
            Long[] ids = EntityHelper.toIds(accounts);
            for (Long id : ids) {
                acquire(new LockKey(LockType.ACCOUNT, id));
            }
        }

        @Override
        public void lockSmsStatus(final Member member) throws LockingException {
            if (member == null) {
                return;
            }
            acquire(new LockKey(LockType.SMS_STATUS, member.getId()));
        }

        @Override
        public void release() {
            for (Lock lock : acquiredLocks.values()) {
                try {
                    lock.unlock();
                } catch (Exception e) {
                    // Ignore and move to the next one
                }
            }
        }

        private void acquire(final LockKey key) {
            if (acquiredLocks.containsKey(key)) {
                // Already own the lock
                return;
            }
            Lock lock = Hazelcast.getLock(key);
            try {
                if (lock.tryLock(timeoutSeconds, TimeUnit.SECONDS)) {
                    acquiredLocks.put(key, lock);
                } else {
                    throw new LockingException();
                }
            } catch (InterruptedException e) {
                throw new LockingException(e);
            }

        }

    }

    public static final String TIMEOUT_SECONDS = PREFIX + "timeoutSeconds";

    private Properties         cyclosProperties;
    private int                timeoutSeconds  = 3;

    @Override
    public void afterPropertiesSet() throws Exception {
        // Read the configuration properties
        String secondsStr = cyclosProperties.getProperty(TIMEOUT_SECONDS);
        if (StringUtils.isNotEmpty(secondsStr)) {
            try {
                timeoutSeconds = Integer.parseInt(secondsStr);
            } catch (Exception e) {
                throw new IllegalStateException("Invalid value for property " + TIMEOUT_SECONDS + ": " + secondsStr);
            }
        }
    }

    @Override
    public LockHandler getLockHandler() {
        return new HazelcastLockHandler();
    }

    public void setCyclosProperties(final Properties cyclosProperties) {
        this.cyclosProperties = cyclosProperties;
    }

}
