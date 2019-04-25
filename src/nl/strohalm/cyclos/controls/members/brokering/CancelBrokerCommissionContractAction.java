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
package nl.strohalm.cyclos.controls.members.brokering;

import javax.servlet.http.HttpServletRequest;

import nl.strohalm.cyclos.annotations.Inject;
import nl.strohalm.cyclos.controls.ActionContext;
import nl.strohalm.cyclos.controls.BaseAction;
import nl.strohalm.cyclos.services.elements.CommissionService;
import nl.strohalm.cyclos.utils.ActionHelper;

import org.apache.struts.action.ActionForward;

/**
 * Action used to cancel a broker commission contract
 * @author Jefferson Magno
 */
public class CancelBrokerCommissionContractAction extends BaseAction {

    private CommissionService commissionService;

    @Inject
    public void setCommissionService(final CommissionService commissionService) {
        this.commissionService = commissionService;
    }

    @Override
    protected ActionForward executeAction(final ActionContext context) throws Exception {
        final HttpServletRequest request = context.getRequest();
        final CancelBrokerCommissionContractForm form = context.getForm();
        final long brokerCommissionContractId = form.getBrokerCommissionContractId();
        commissionService.cancelBrokerCommissionContract(brokerCommissionContractId);
        context.sendMessage("brokerCommissionContract.cancelled");
        return ActionHelper.redirectWithParam(request, context.getSuccessForward(), "brokerCommissionContractId", brokerCommissionContractId);
    }

}
