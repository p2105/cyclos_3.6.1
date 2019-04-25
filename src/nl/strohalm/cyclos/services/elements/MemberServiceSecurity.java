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
package nl.strohalm.cyclos.services.elements;

import nl.strohalm.cyclos.access.AdminMemberPermission;
import nl.strohalm.cyclos.access.BrokerPermission;
import nl.strohalm.cyclos.access.MemberPermission;
import nl.strohalm.cyclos.access.OperatorPermission;
import nl.strohalm.cyclos.entities.members.Member;
import nl.strohalm.cyclos.services.BaseServiceSecurity;
import nl.strohalm.cyclos.services.sms.ISmsContext;
import nl.strohalm.cyclos.services.sms.exceptions.SmsContextInitializationException;

/**
 * Service layer for members
 * 
 * @author luis
 */
public class MemberServiceSecurity extends BaseServiceSecurity implements MemberService {

    private MemberServiceLocal memberService;

    @Override
    public ActivitiesVO getActivities(final Member member) {
        if (permissionService.manages(member)) {
            // A managed member
            permissionService.permission(member)
                    .admin(AdminMemberPermission.REPORTS_VIEW)
                    .broker(BrokerPermission.REPORTS_VIEW)
                    .member()
                    .operator(OperatorPermission.REPORTS_VIEW_MEMBER)
                    .check();
        } else {
            // Not managed: must be related to, with separated permissions
            permissionService.checkRelatesTo(member);
            permissionService.permission()
                    .member(MemberPermission.REPORTS_VIEW)
                    .operator(MemberPermission.REPORTS_VIEW)
                    .check();
        }
        return memberService.getActivities(member);
    }

    @Override
    public QuickAccessVO getQuickAccess() {
        return memberService.getQuickAccess();
    }

    @Override
    public ISmsContext getSmsContext(final Member member) throws SmsContextInitializationException {
        // This is only invoked from notification preferences
        permissionService.permission(member)
                .admin(AdminMemberPermission.PREFERENCES_MANAGE_NOTIFICATIONS)
                .broker(BrokerPermission.PREFERENCES_MANAGE_NOTIFICATIONS)
                .member(MemberPermission.PREFERENCES_MANAGE_NOTIFICATIONS)
                .check();
        return memberService.getSmsContext(member);
    }

    @Override
    public MemberStatusVO getStatus() {
        // No permission check, as returns the status for the logged user
        return memberService.getStatus();
    }

    public void setMemberServiceLocal(final MemberServiceLocal memberService) {
        this.memberService = memberService;
    }
}
