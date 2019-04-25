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
package nl.strohalm.cyclos.exceptions;

import org.apache.cxf.common.util.StringUtils;

/**
 * Exception in sending mail
 * @author luis
 */
public class MailSendingException extends ApplicationException {

    private static final long serialVersionUID = 6339637732808928357L;

    private String            detailMessage;

    public MailSendingException(final String subject) {
        this(subject, null);
    }

    public MailSendingException(final String subject, final Throwable cause) {
        super(cause);
        detailMessage = (StringUtils.isEmpty(getMessage()) ? "" : getMessage() + ". ") + "Subject: " + subject;
    }

    @Override
    public String getMessage() {
        return detailMessage;
    }
}
