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
package nl.strohalm.cyclos.controls.members.printsettings;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.strohalm.cyclos.annotations.Inject;
import nl.strohalm.cyclos.controls.ActionContext;
import nl.strohalm.cyclos.controls.BaseAction;
import nl.strohalm.cyclos.services.preferences.ReceiptPrinterSettingsService;
import nl.strohalm.cyclos.utils.RequestHelper;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForward;

/**
 * Action used to list all receipt printer settings for the currently logged member
 * 
 * @author luis
 */
public class RemoveReceiptPrinterSettingsAction extends BaseAction {

    private ReceiptPrinterSettingsService receiptPrinterSettingsService;

    @Inject
    public void setReceiptPrinterSettingsService(final ReceiptPrinterSettingsService receiptPrinterSettingsService) {
        this.receiptPrinterSettingsService = receiptPrinterSettingsService;
    }

    @Override
    protected ActionForward executeAction(final ActionContext context) throws Exception {
        final HttpServletRequest request = context.getRequest();
        final RemoveReceiptPrinterSettingsForm form = context.getForm();
        final Long id = form.getId();
        receiptPrinterSettingsService.remove(id);
        context.sendMessage("receiptPrinterSettings.removed");
        final String currentReceiptPrinter = RequestHelper.getCookieValue(request, "receiptPrinterId");
        // If the member removes a printer he's currently using, clear the cookie. We cannot, however, do this for cookies on other clients.
        // They'll get an error when trying to print
        if (StringUtils.isNotEmpty(currentReceiptPrinter) && id.toString().equals(currentReceiptPrinter)) {
            final HttpServletResponse response = context.getResponse();
            final Cookie cookie = new Cookie("receiptPrinterId", "");
            cookie.setPath(request.getContextPath());
            response.addCookie(cookie);
        }
        return context.getSuccessForward();
    }

}
