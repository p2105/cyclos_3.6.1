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
package nl.strohalm.cyclos.services.ads;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import nl.strohalm.cyclos.entities.Relationship;
import nl.strohalm.cyclos.entities.ads.Ad;
import nl.strohalm.cyclos.entities.ads.AdCategoryWithCounterQuery;
import nl.strohalm.cyclos.entities.ads.AdCategoryWithCounterVO;
import nl.strohalm.cyclos.entities.ads.AdQuery;
import nl.strohalm.cyclos.entities.ads.FullTextAdQuery;
import nl.strohalm.cyclos.entities.exceptions.DaoException;
import nl.strohalm.cyclos.entities.members.Member;
import nl.strohalm.cyclos.services.Service;
import nl.strohalm.cyclos.utils.validation.ValidationException;

/**
 * Service interface for Advertisements used to control ad operations like add, remove, expiration date, number of ads by member.
 * @author rafael
 */
public interface AdService extends Service {

    /**
     * @see AdDAO#fullTextSearch(FullTextAdQuery)
     */
    List<Ad> fullTextSearch(FullTextAdQuery query) throws DaoException;

    /**
     * Returns the counters for each category for the given query
     */
    List<AdCategoryWithCounterVO> getCategoriesWithCounters(AdCategoryWithCounterQuery query);

    /**
     * If a date is specified it returns the number of ads of a given member by date, otherwise<br>
     * returns the number of ads of a given member by status (Ad.Status)
     */
    Map<Ad.Status, Integer> getNumberOfAds(Calendar date, Member member);

    /**
     * Checks whether the given ad is editable by the logged user
     */
    boolean isEditable(Ad ad);

    /**
     * Loads the ad, fetching the specified relationships
     * @return The ads loaded
     */
    Ad load(Long id, Relationship... fetch);

    /**
     * Removes the specified ad
     */
    void remove(Long id);

    /**
     * Saves the specified ad
     */
    Ad save(Ad ad);

    /**
     * Search the existing ads based on the AdQuery object
     * @return a list of ads
     */
    List<Ad> search(AdQuery queryParameters);

    /**
     * Validates the specified ad
     * @throws ValidationException if validation fails.
     */
    void validate(Ad ad) throws ValidationException;
}
