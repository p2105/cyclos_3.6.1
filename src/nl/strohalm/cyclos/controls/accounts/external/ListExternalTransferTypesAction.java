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
package nl.strohalm.cyclos.controls.accounts.external;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import nl.strohalm.cyclos.access.AdminSystemPermission;
import nl.strohalm.cyclos.annotations.Inject;
import nl.strohalm.cyclos.controls.ActionContext;
import nl.strohalm.cyclos.controls.BaseAction;
import nl.strohalm.cyclos.entities.accounts.external.ExternalAccount;
import nl.strohalm.cyclos.entities.accounts.external.ExternalTransferType;
import nl.strohalm.cyclos.services.accounts.external.ExternalTransferTypeService;

import org.apache.struts.action.ActionForward;

/**
 * Action used to list the existing External Transfer Type
 * @author Lucas Geiss
 */
public class ListExternalTransferTypesAction extends BaseAction {

    private ExternalTransferTypeService externalTransferTypeService;

    @Inject
    public void setExternalTransferTypeService(final ExternalTransferTypeService externalTransferTypeService) {
        this.externalTransferTypeService = externalTransferTypeService;
    }

    @Override
    protected ActionForward executeAction(final ActionContext context) throws Exception {
        final HttpServletRequest request = context.getRequest();
        final ExternalAccount externalAccount = (ExternalAccount) request.getAttribute("externalAccount");
        final List<ExternalTransferType> externalTransferTypes = externalTransferTypeService.listByAccount(externalAccount);
        request.setAttribute("externalTransferTypes", externalTransferTypes);
        request.setAttribute("editable", permissionService.hasPermission(AdminSystemPermission.EXTERNAL_ACCOUNTS_MANAGE));
        return context.getInputForward();
    }
}
