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
package nl.strohalm.cyclos.dao.ads.imports;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import nl.strohalm.cyclos.dao.BaseDAOImpl;
import nl.strohalm.cyclos.entities.ads.imports.AdImport;
import nl.strohalm.cyclos.utils.query.QueryParameters.ResultType;

public class AdImportDAOImpl extends BaseDAOImpl<AdImport> implements AdImportDAO {

    public AdImportDAOImpl() {
        super(AdImport.class);
    }

    public List<AdImport> listBefore(final Calendar time) {
        final Map<String, ?> namedParameters = Collections.singletonMap("time", time);
        final String hql = "select i from " + getEntityType().getName() + " i where i.date < :time";
        return list(ResultType.ITERATOR, hql, namedParameters, null);
    }

}
