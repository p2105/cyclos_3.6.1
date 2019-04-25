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
package nl.strohalm.cyclos.controls.accounts.guarantees.paymentobligations;

import nl.strohalm.cyclos.annotations.Inject;
import nl.strohalm.cyclos.controls.ActionContext;
import nl.strohalm.cyclos.controls.BaseAction;
import nl.strohalm.cyclos.entities.accounts.guarantees.PaymentObligation;
import nl.strohalm.cyclos.services.accounts.guarantees.PaymentObligationService;
import nl.strohalm.cyclos.services.accounts.guarantees.exceptions.PaymentObligationStatusChangeException;
import nl.strohalm.cyclos.utils.ActionHelper;

import org.apache.struts.action.ActionForward;

/**
 * Base class used to change the payment obligation's status. It must be extended to support a new status change
 * @author ameyer
 * 
 */
public abstract class ChangeStatusPaymentObligationAction extends BaseAction {

    protected PaymentObligationService paymentObligationService;

    @Override
    public ActionForward executeAction(final ActionContext context) throws Exception {
        final ChangeStatusPaymentObligationForm form = context.getForm();
        try {
            paymentObligationService.changeStatus(form.getPaymentObligationId(), getNewStatus());
        } catch (final PaymentObligationStatusChangeException e) {
            context.sendMessage("paymentObligation.error.changeStatus", context.message("paymentObligation.status." + e.getNewstatus()));
        }
        return ActionHelper.redirectWithParam(context.getRequest(), context.getSuccessForward(), "paymentObligationId", form.getPaymentObligationId());
    }

    @Inject
    public void setPaymentObligationService(final PaymentObligationService paymentObligationService) {
        this.paymentObligationService = paymentObligationService;
    }

    /**
     * @return the new payment obligation's status
     */
    protected abstract PaymentObligation.Status getNewStatus();
}
