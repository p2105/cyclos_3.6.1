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
package nl.strohalm.cyclos.webservices.members;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.jws.WebService;

import nl.strohalm.cyclos.entities.Relationship;
import nl.strohalm.cyclos.entities.access.Channel;
import nl.strohalm.cyclos.entities.access.MemberUser;
import nl.strohalm.cyclos.entities.access.PrincipalType;
import nl.strohalm.cyclos.entities.access.User;
import nl.strohalm.cyclos.entities.customization.fields.MemberCustomField;
import nl.strohalm.cyclos.entities.customization.fields.MemberCustomFieldValue;
import nl.strohalm.cyclos.entities.exceptions.EntityNotFoundException;
import nl.strohalm.cyclos.entities.groups.Group.Status;
import nl.strohalm.cyclos.entities.groups.MemberGroup;
import nl.strohalm.cyclos.entities.members.Element;
import nl.strohalm.cyclos.entities.members.Member;
import nl.strohalm.cyclos.entities.members.PendingMember;
import nl.strohalm.cyclos.entities.members.RegisteredMember;
import nl.strohalm.cyclos.entities.services.ServiceClient;
import nl.strohalm.cyclos.exceptions.PermissionDeniedException;
import nl.strohalm.cyclos.services.customization.MemberCustomFieldServiceLocal;
import nl.strohalm.cyclos.services.elements.ElementServiceLocal;
import nl.strohalm.cyclos.utils.CustomFieldHelper;
import nl.strohalm.cyclos.utils.RelationshipHelper;
import nl.strohalm.cyclos.utils.validation.ValidationException;
import nl.strohalm.cyclos.webservices.WebServiceContext;
import nl.strohalm.cyclos.webservices.model.GroupVO;
import nl.strohalm.cyclos.webservices.model.MemberVO;
import nl.strohalm.cyclos.webservices.model.RegistrationFieldValueVO;
import nl.strohalm.cyclos.webservices.utils.ChannelHelper;
import nl.strohalm.cyclos.webservices.utils.GroupHelper;
import nl.strohalm.cyclos.webservices.utils.MemberHelper;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.lang.StringUtils;

/**
 * Web service implementation
 * @author luis
 */
@WebService(name = "members", serviceName = "members")
public class MemberWebServiceImpl implements MemberWebService {

    private static final Relationship[]   FETCH = { Element.Relationships.USER, Element.Relationships.GROUP, Member.Relationships.IMAGES, Member.Relationships.CUSTOM_VALUES };
    private ElementServiceLocal           elementServiceLocal;
    private MemberCustomFieldServiceLocal memberCustomFieldServiceLocal;
    private MemberHelper                  memberHelper;
    private GroupHelper                   groupHelper;
    private ChannelHelper                 channelHelper;

    @Override
    @SuppressWarnings("unchecked")
    public MemberResultPage fullTextSearch(final FullTextMemberSearchParameters params) {
        if (params == null) {
            return null;
        }

        final List<Member> members = (List<Member>) elementServiceLocal.fullTextSearch(memberHelper.toFullTextQuery(params));
        return memberHelper.toResultPage(params, members);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<GroupVO> listManagedGroups() {
        final ServiceClient client = WebServiceContext.getClient();
        final List<GroupVO> groups = new ArrayList<GroupVO>();
        for (final MemberGroup group : client.getManageGroups()) {
            groups.add(groupHelper.toVO(group));
        }
        Collections.sort(groups, new BeanComparator("name"));
        return groups;
    }

    @Override
    public MemberVO load(final long id) {
        try {
            final Element element = elementServiceLocal.load(id, FETCH);
            if (element instanceof Member) {
                Member member = (Member) element;
                if (!member.isActive() || member.getGroup().getStatus() == Status.REMOVED) {
                    throw new EntityNotFoundException();
                }
                final List<MemberCustomField> allFields = memberCustomFieldServiceLocal.list();
                final List<MemberCustomField> fields = CustomFieldHelper.onlyForGroup(allFields, (MemberGroup) element.getGroup());
                return memberHelper.toVO(member, fields, true);
            }
        } catch (final PermissionDeniedException e) {
        } catch (final EntityNotFoundException e) {
        }
        return null;
    }

    @Override
    public MemberVO loadByUsername(final String username) {
        try {
            final User user = elementServiceLocal.loadUser(username, RelationshipHelper.nested(User.Relationships.ELEMENT, Element.Relationships.GROUP), RelationshipHelper.nested(User.Relationships.ELEMENT, Member.Relationships.CUSTOM_VALUES), RelationshipHelper.nested(User.Relationships.ELEMENT, Member.Relationships.IMAGES));
            if (user instanceof MemberUser) {
                final Member member = ((MemberUser) user).getMember();
                final List<MemberCustomField> allFields = memberCustomFieldServiceLocal.list();
                final List<MemberCustomField> fields = CustomFieldHelper.onlyForGroup(allFields, member.getMemberGroup());
                return memberHelper.toVO(member, fields, true);
            }
        } catch (final PermissionDeniedException e) {
        } catch (final EntityNotFoundException e) {
        }
        return null;
    }

    @Override
    public MemberRegistrationResult registerMember(final RegisterMemberParameters params) {
        if (params == null) {
            throw new IllegalArgumentException();
        }

        // When the generic 'credentials' is passed in, we need to either set the login password or pin
        final String credentials = params.getCredentials();
        if (StringUtils.isNotEmpty(credentials)) {
            params.setLoginPassword(null);
            params.setPin(null);

            final Channel channel = WebServiceContext.getChannel();
            if (channel != null) {
                switch (channel.getCredentials()) {
                    case DEFAULT:
                    case LOGIN_PASSWORD:
                        params.setLoginPassword(credentials);
                        break;
                    case PIN:
                        params.setPin(credentials);
                        break;
                }
            }
        }

        final Member member = memberHelper.toMember(params);
        member.getUser().setPassword(params.getLoginPassword());
        if (StringUtils.isNotEmpty(params.getPin())) {
            member.getMemberUser().setPin(params.getPin());
        }

        // Register the member
        final RegisteredMember registered = elementServiceLocal.registerMemberByWebService(WebServiceContext.getClient(), member, WebServiceContext.getRequest().getRemoteAddr());
        final MemberRegistrationResult result = new MemberRegistrationResult();
        if (registered instanceof PendingMember) {
            result.setAwaitingEmailValidation(true);
        } else {
            result.setId(registered.getId());
            result.setUsername(registered.getUsername());
        }
        return result;
    }

    @Override
    @SuppressWarnings("unchecked")
    public MemberResultPage search(final MemberSearchParameters params) {
        if (params == null) {
            return null;
        }

        final List<Member> members = (List<Member>) elementServiceLocal.search(memberHelper.toQuery(params));
        return memberHelper.toResultPage(params, members);
    }

    public void setChannelHelper(final ChannelHelper channelHelper) {
        this.channelHelper = channelHelper;
    }

    public void setElementServiceLocal(final ElementServiceLocal elementService) {
        elementServiceLocal = elementService;
    }

    public void setGroupHelper(final GroupHelper groupHelper) {
        this.groupHelper = groupHelper;
    }

    public void setMemberCustomFieldServiceLocal(final MemberCustomFieldServiceLocal memberCustomFieldService) {
        memberCustomFieldServiceLocal = memberCustomFieldService;
    }

    public void setMemberHelper(final MemberHelper memberHelper) {
        this.memberHelper = memberHelper;
    }

    @Override
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void updateMember(final UpdateMemberParameters params) {
        final Long id = params == null || params.getId() == null || params.getId().intValue() <= 0 ? null : params.getId();
        final String principal = params == null || StringUtils.isEmpty(params.getPrincipal()) ? null : params.getPrincipal();
        Member member;
        if (id != null) {
            // Load by id, if passed
            try {
                member = elementServiceLocal.load(id, FETCH);
            } catch (final Exception e) {
                throw new EntityNotFoundException(Member.class);
            }
        } else if (principal != null) {
            // Load by principal, if passed
            final PrincipalType principalType = channelHelper.resolvePrincipalType(params.getPrincipalType());
            member = elementServiceLocal.loadByPrincipal(principalType, params.getPrincipal(), FETCH);
        } else {
            // No identification was passed
            throw new IllegalArgumentException();
        }
        member = (Member) member.clone();
        // Update regular fields
        if (StringUtils.isNotEmpty(params.getName())) {
            member.setName(params.getName());
        }
        if (StringUtils.isNotEmpty(params.getEmail())) {
            member.setEmail(params.getEmail());
        }
        // Get the available custom fields
        List<MemberCustomField> customFields = memberCustomFieldServiceLocal.list();
        customFields = CustomFieldHelper.onlyForGroup(customFields, member.getMemberGroup());
        final Collection<MemberCustomFieldValue> customValues = new ArrayList(member.getCustomValues());
        member.setCustomValues(customValues);
        final List<RegistrationFieldValueVO> fields = params.getFields();
        if (fields != null) {
            for (final RegistrationFieldValueVO vo : fields) {
                final String fieldName = vo.getField();
                final MemberCustomField field = CustomFieldHelper.findByInternalName(customFields, fieldName);
                if (field == null) {
                    throw new ValidationException();
                }
                MemberCustomFieldValue value = CustomFieldHelper.findByField(field, customValues);
                if (value == null) {
                    // No value for this field yet
                    value = new MemberCustomFieldValue();
                    value.setMember(member);
                    value.setField(field);
                    customValues.add(value);
                }
                value.setValue(vo.getValue());
                value.setHidden(vo.isHidden());
            }
        }
        elementServiceLocal.changeMemberProfileByWebService(WebServiceContext.getClient(), member);
    }
}
