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
package nl.strohalm.cyclos.controls.reports.statistics;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import nl.strohalm.cyclos.entities.reports.StatisticsWhatToShow;
import nl.strohalm.cyclos.entities.reports.ThroughTimeRange;

import org.apache.struts.action.ActionMapping;

/**
 * form used for showing statistics
 * @author rinke
 * 
 */
public class StatisticsKeyDevelopmentsForm extends StatisticsForm {

    private static final long serialVersionUID = 1544322259540189023L;

    public StatisticsKeyDevelopmentsForm() {
        super();
    }

    @Override
    public void reset(final ActionMapping mapping, final HttpServletRequest request) {
        super.reset(mapping, request);
        this.setQuery("numberOfMembers", false);
        this.setQuery("grossProduct", false);
        this.setQuery("numberOfTransactions", false);
        this.setQuery("transactionAmount", false);
        this.setQuery("numberOfAds", false);
        this.setQuery("numberOfMembersGraph", false);
        this.setQuery("grossProductGraph", false);
        this.setQuery("numberOfTransactionsGraph", false);
        this.setQuery("transactionAmountGraph", false);
        this.setQuery("numberOfAdsGraph", false);
        this.setQuery("thruTimeGraph", false);
        this.setQuery("whatToShow", StatisticsWhatToShow.COMPARE_PERIODS);
        this.setQuery("throughTimeRange", ThroughTimeRange.MONTH);
        this.setQuery("groups", Collections.emptyList());
    }

}
