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

import static nl.strohalm.cyclos.entities.ads.Ad.Status.ACTIVE;

import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import nl.strohalm.cyclos.entities.Relationship;
import nl.strohalm.cyclos.entities.ads.AbstractAdQuery;
import nl.strohalm.cyclos.entities.ads.Ad;
import nl.strohalm.cyclos.entities.ads.Ad.Status;
import nl.strohalm.cyclos.entities.ads.AdCategoryWithCounterQuery;
import nl.strohalm.cyclos.entities.ads.AdCategoryWithCounterVO;
import nl.strohalm.cyclos.entities.ads.AdQuery;
import nl.strohalm.cyclos.entities.ads.FullTextAdQuery;
import nl.strohalm.cyclos.entities.exceptions.DaoException;
import nl.strohalm.cyclos.entities.groups.MemberGroup;
import nl.strohalm.cyclos.entities.members.Element;
import nl.strohalm.cyclos.entities.members.Member;
import nl.strohalm.cyclos.exceptions.PermissionDeniedException;
import nl.strohalm.cyclos.services.BaseServiceSecurity;
import nl.strohalm.cyclos.utils.EntityHelper;
import nl.strohalm.cyclos.utils.access.LoggedUser;
import nl.strohalm.cyclos.utils.access.PermissionHelper;
import nl.strohalm.cyclos.utils.validation.ValidationException;

import org.apache.commons.collections.CollectionUtils;

/**
 * Security implementation for {@link AdService}
 * 
 * @author luis
 */
public class AdServiceSecurity extends BaseServiceSecurity implements AdService {

    private AdServiceLocal adService;

    @Override
    public List<Ad> fullTextSearch(final FullTextAdQuery query) throws DaoException {
        if (!applyQueryRestrictions(query)) {
            return Collections.emptyList();
        }
        return adService.fullTextSearch(query);
    }

    @Override
    public List<AdCategoryWithCounterVO> getCategoriesWithCounters(final AdCategoryWithCounterQuery query) {
        Collection<MemberGroup> visibleGroups = adService.visibleGroupsForAds();
        if (CollectionUtils.isEmpty(visibleGroups)) {
            return Collections.emptyList();
        }
        query.setGroupIds(EntityHelper.toIds(visibleGroups));
        return adService.getCategoriesWithCounters(query);
    }

    @Override
    public Map<Status, Integer> getNumberOfAds(final Calendar date, final Member member) {
        checkCanViewAdsOf(member);
        return adService.getNumberOfAds(null, member);
    }

    @Override
    public boolean isEditable(final Ad ad) {
        return adService.isEditable(ad);
    }

    @Override
    public Ad load(final Long id, final Relationship... fetch) {
        Ad ad = adService.load(id, fetch);
        checkCanViewAdsOf(ad.getOwner());
        return ad;
    }

    @Override
    public void remove(final Long id) {
        Ad ad = adService.load(id);
        checkManagemenent(ad);
        adService.remove(id);
    }

    @Override
    public Ad save(final Ad ad) {
        checkManagemenent(ad);
        return adService.save(ad);
    }

    @Override
    public List<Ad> search(final AdQuery query) {
        if (!applyQueryRestrictions(query)) {
            return Collections.emptyList();
        }
        return adService.search(query);
    }

    public void setAdServiceLocal(final AdServiceLocal adService) {
        this.adService = adService;
    }

    @Override
    public void validate(final Ad ad) throws ValidationException {
        // No permission check is needed for validate
        adService.validate(ad);
    }

    private boolean applyQueryRestrictions(final AbstractAdQuery query) {
        Collection<MemberGroup> visibleGroups = adService.visibleGroupsForAds();
        if (CollectionUtils.isEmpty(visibleGroups)) {
            return false;
        }
        query.setGroups(PermissionHelper.checkSelection(visibleGroups, query.getGroups()));
        Member owner = fetchService.fetch(query.getOwner(), Element.Relationships.GROUP);
        if (owner != null && !visibleGroups.contains(owner.getGroup())) {
            return false;
        }
        if (owner != null && !permissionService.manages(owner)) {
            // Non-managers can only see active ads
            query.setStatus(ACTIVE);
        }
        return true;
    }

    private void checkCanViewAdsOf(Member member) {
        member = fetchService.fetch(member, Element.Relationships.GROUP);
        if (LoggedUser.element().equals(member)) {
            // The ad owner is allowed to see his own ads
            return;
        }
        if (!adService.visibleGroupsForAds().contains(member.getGroup())) {
            throw new PermissionDeniedException();
        }
    }

    private void checkManagemenent(final Ad ad) {
        if (!adService.isEditable(ad)) {
            throw new PermissionDeniedException();
        }
    }

}
