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
package nl.strohalm.cyclos.controls.accounts.cards;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import nl.strohalm.cyclos.annotations.Inject;
import nl.strohalm.cyclos.controls.ActionContext;
import nl.strohalm.cyclos.controls.BaseAction;
import nl.strohalm.cyclos.entities.accounts.cards.CardType;
import nl.strohalm.cyclos.services.accounts.cards.CardTypeService;

import org.apache.struts.action.ActionForward;

/**
 * 
 * @author rodrigo
 */
public class ListCardTypeAction extends BaseAction {

    private CardTypeService cardTypeService;

    public CardTypeService getCardTypeService() {
        return cardTypeService;
    }

    @Inject
    public void setCardTypeService(final CardTypeService cardTypeService) {
        this.cardTypeService = cardTypeService;
    }

    @Override
    protected ActionForward executeAction(final ActionContext context) throws Exception {

        final HttpServletRequest request = context.getRequest();
        final List<CardType> cardTypes = new ArrayList<CardType>();

        // Get all CardTypes
        cardTypes.addAll(cardTypeService.listAll());
        request.setAttribute("cardTypes", cardTypes);

        return context.getInputForward();
    }

}
