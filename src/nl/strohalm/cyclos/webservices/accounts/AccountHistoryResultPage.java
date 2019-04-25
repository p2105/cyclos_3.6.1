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
package nl.strohalm.cyclos.webservices.accounts;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import nl.strohalm.cyclos.webservices.model.AccountHistoryTransferVO;
import nl.strohalm.cyclos.webservices.model.AccountStatusVO;
import nl.strohalm.cyclos.webservices.model.ResultPage;

/**
 * Page results for account history transfers
 * @author luis
 */
public class AccountHistoryResultPage extends ResultPage<AccountHistoryTransferVO> {
    private static final long              serialVersionUID = -186613342878700230L;
    private AccountStatusVO                accountStatus;
    private List<AccountHistoryTransferVO> transfers;

    public AccountHistoryResultPage() {
    }

    public AccountHistoryResultPage(final int currentPage, final int totalCount, final List<AccountHistoryTransferVO> transfers) {
        super(currentPage, totalCount);
        this.transfers = transfers;
    }

    public AccountStatusVO getAccountStatus() {
        return accountStatus;
    }

    public List<AccountHistoryTransferVO> getTransfers() {
        return transfers;
    }

    @Override
    public Iterator<AccountHistoryTransferVO> iterator() {
        if (transfers == null) {
            return Collections.<AccountHistoryTransferVO> emptyList().iterator();
        }
        return transfers.iterator();
    }

    public void setAccountStatus(final AccountStatusVO accountStatus) {
        this.accountStatus = accountStatus;
    }

    public void setTransfers(final List<AccountHistoryTransferVO> transfers) {
        this.transfers = transfers;
    }

    @Override
    public String toString() {
        final StringBuilder buffer = new StringBuilder();
        buffer.append("AdResultPage[");

        buffer.append(accountStatus.toString());

        for (final AccountHistoryTransferVO vo : transfers) {
            buffer.append("," + vo.toString());
        }

        buffer.append("]");

        return buffer.toString();
    }

}
