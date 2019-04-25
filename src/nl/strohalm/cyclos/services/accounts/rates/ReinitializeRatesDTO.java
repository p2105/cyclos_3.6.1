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
package nl.strohalm.cyclos.services.accounts.rates;

import java.util.Calendar;

import nl.strohalm.cyclos.utils.DataObject;

/**
 * DTO for reinitializing rates
 * @author rinke
 */
public class ReinitializeRatesDTO extends DataObject {

    private static final long serialVersionUID = 2649137836387509372L;
    private Calendar          reinitSince;
    private boolean           maintainPastSettings;
    private Long              currencyId;
    private WhatRate          whatRate;

    public Long getCurrencyId() {
        return currencyId;
    }

    public Calendar getReinitSince() {
        return reinitSince;
    }

    public WhatRate getWhatRate() {
        return whatRate;
    }

    public void setCurrencyId(final Long currencyId) {
        this.currencyId = currencyId;
    }

    public void setReinitSince(final Calendar reinitSince) {
        this.reinitSince = reinitSince;
    }

    public void setWhatRate(final WhatRate whatRate) {
        this.whatRate = whatRate;
    }

    public void setMaintainPastSettings(boolean maintainPastSettings) {
        this.maintainPastSettings = maintainPastSettings;
    }

    public boolean isMaintainPastSettings() {
        return maintainPastSettings;
    }

}
