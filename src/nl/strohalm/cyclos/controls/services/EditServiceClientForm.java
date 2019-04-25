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
package nl.strohalm.cyclos.controls.services;

import java.util.Collections;
import java.util.Map;

import nl.strohalm.cyclos.controls.BaseBindingForm;

/**
 * Form used to edit an web services client
 * @author luis
 */
public class EditServiceClientForm extends BaseBindingForm {

    private static final long serialVersionUID = 7459978429658952342L;
    private long              clientId;

    public EditServiceClientForm() {
        setServiceClient("permissions", Collections.emptyList());
        setServiceClient("doPaymentTypes", Collections.emptyList());
        setServiceClient("receivePaymentTypes", Collections.emptyList());
        setServiceClient("chargebackPaymentTypes", Collections.emptyList());
        setServiceClient("manageGroups", Collections.emptyList());
    }

    public long getClientId() {
        return clientId;
    }

    public Map<String, Object> getServiceClient() {
        return values;
    }

    public Object getServiceClient(final String key) {
        return values.get(key);
    }

    public void setClientId(final long clientId) {
        this.clientId = clientId;
    }

    public void setServiceClient(final Map<String, Object> map) {
        values = map;
    }

    public void setServiceClient(final String key, final Object value) {
        values.put(key, value);
    }
}
