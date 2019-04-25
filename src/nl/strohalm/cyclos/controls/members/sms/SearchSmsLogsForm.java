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
package nl.strohalm.cyclos.controls.members.sms;

import javax.servlet.http.HttpServletRequest;

import nl.strohalm.cyclos.controls.BaseQueryForm;
import nl.strohalm.cyclos.utils.binding.MapBean;

import org.apache.struts.action.ActionMapping;

/**
 * Form used to search SMS logs
 * @author Jefferson Magno
 */
public class SearchSmsLogsForm extends BaseQueryForm {

    private static final long serialVersionUID = 6281818893462678896L;
    private long              memberId;

    public SearchSmsLogsForm() {
        resetForm();
    }

    public long getMemberId() {
        return memberId;
    }

    @Override
    public void reset(final ActionMapping mapping, final HttpServletRequest request) {
        values.clear();
        super.reset(mapping, request);
        resetForm();
    }

    public void setMemberId(final long memberId) {
        this.memberId = memberId;
    }

    private void resetForm() {
        setQuery("period", new MapBean("begin", "end"));
    }
}
