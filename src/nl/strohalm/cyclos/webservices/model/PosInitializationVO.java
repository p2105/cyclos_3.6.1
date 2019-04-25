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
package nl.strohalm.cyclos.webservices.model;

import java.util.List;


/**
 * Contains data used by pos application when it's being initialized
 * 
 * @author luis
 */
public class PosInitializationVO {

    private MemberVO                    owner;
    private List<WSPrincipalTypeVO>       principalTypes;
    private List<DetailedAccountTypeVO> accountTypes;
    private TransactionNumberVO         transactionNumber;
    private int                         decimalDigits;
    private int                         maxSchedulingPayments;
    private int                         numberOfCopies;
    private int                         resultPageSize;
    private boolean                     allowMakePayment;

    public List<DetailedAccountTypeVO> getAccountTypes() {
        return accountTypes;
    }

    public int getDecimalDigits() {
        return decimalDigits;
    }

    public int getMaxSchedulingPayments() {
        return maxSchedulingPayments;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public MemberVO getOwner() {
        return owner;
    }

    public List<WSPrincipalTypeVO> getPrincipalTypes() {
        return principalTypes;
    }

    public int getResultPageSize() {
        return resultPageSize;
    }

    public TransactionNumberVO getTransactionNumber() {
        return transactionNumber;
    }

    public boolean isAllowMakePayment() {
        return allowMakePayment;
    }

    public void setAccountTypes(final List<DetailedAccountTypeVO> accountTypes) {
        this.accountTypes = accountTypes;
    }

    public void setAllowMakePayment(final boolean allowMakePayment) {
        this.allowMakePayment = allowMakePayment;
    }

    public void setDecimalDigits(final int decimalDigits) {
        this.decimalDigits = decimalDigits;
    }

    public void setMaxSchedulingPayments(final int maxSchedulingPayments) {
        this.maxSchedulingPayments = maxSchedulingPayments;
    }

    public void setNumberOfCopies(final int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public void setOwner(final MemberVO owner) {
        this.owner = owner;
    }

    public void setPrincipalTypes(final List<WSPrincipalTypeVO> principalTypes) {
        this.principalTypes = principalTypes;
    }

    public void setResultPageSize(final int resultPageSize) {
        this.resultPageSize = resultPageSize;
    }

    public void setTransactionNumber(final TransactionNumberVO transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

}
