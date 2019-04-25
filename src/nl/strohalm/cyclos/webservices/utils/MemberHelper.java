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
package nl.strohalm.cyclos.webservices.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import nl.strohalm.cyclos.entities.Relationship;
import nl.strohalm.cyclos.entities.access.Channel;
import nl.strohalm.cyclos.entities.access.ChannelPrincipal;
import nl.strohalm.cyclos.entities.access.MemberUser;
import nl.strohalm.cyclos.entities.access.PrincipalType;
import nl.strohalm.cyclos.entities.customization.fields.MemberCustomField;
import nl.strohalm.cyclos.entities.customization.fields.MemberCustomFieldValue;
import nl.strohalm.cyclos.entities.exceptions.EntityNotFoundException;
import nl.strohalm.cyclos.entities.groups.GroupFilter;
import nl.strohalm.cyclos.entities.groups.MemberGroup;
import nl.strohalm.cyclos.entities.members.Element;
import nl.strohalm.cyclos.entities.members.FullTextMemberQuery;
import nl.strohalm.cyclos.entities.members.Member;
import nl.strohalm.cyclos.entities.members.MemberQuery;
import nl.strohalm.cyclos.entities.services.ServiceClient;
import nl.strohalm.cyclos.services.access.AccessServiceLocal;
import nl.strohalm.cyclos.services.customization.MemberCustomFieldServiceLocal;
import nl.strohalm.cyclos.services.elements.ElementServiceLocal;
import nl.strohalm.cyclos.services.groups.GroupServiceLocal;
import nl.strohalm.cyclos.services.permissions.PermissionServiceLocal;
import nl.strohalm.cyclos.services.services.ServiceClientServiceLocal;
import nl.strohalm.cyclos.utils.CustomFieldHelper;
import nl.strohalm.cyclos.utils.EntityHelper;
import nl.strohalm.cyclos.utils.query.Page;
import nl.strohalm.cyclos.webservices.PrincipalParameters;
import nl.strohalm.cyclos.webservices.WebServiceContext;
import nl.strohalm.cyclos.webservices.WebServiceFaultsEnum;
import nl.strohalm.cyclos.webservices.members.AbstractMemberSearchParameters;
import nl.strohalm.cyclos.webservices.members.FullTextMemberSearchParameters;
import nl.strohalm.cyclos.webservices.members.MemberResultPage;
import nl.strohalm.cyclos.webservices.members.MemberSearchParameters;
import nl.strohalm.cyclos.webservices.members.RegisterMemberParameters;
import nl.strohalm.cyclos.webservices.model.FieldValueVO;
import nl.strohalm.cyclos.webservices.model.MemberVO;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

/**
 * Utility class for members
 * @author luis
 */
public class MemberHelper {

    private QueryHelper                   queryHelper;
    private ImageHelper                   imageHelper;
    private FieldHelper                   fieldHelper;
    private ElementServiceLocal           elementServiceLocal;
    private ServiceClientServiceLocal     serviceClientServiceLocal;
    private MemberCustomFieldServiceLocal memberCustomFieldServiceLocal;
    private PermissionServiceLocal        permissionService;
    private GroupServiceLocal             groupServiceLocal;
    private ChannelHelper                 channelHelper;
    private AccessServiceLocal            accessServiceLocal;

    /**
     * Throws an invalid-channel fault if the current client's channel is not enabled for the given member
     */
    public void checkChannelEnabledForMember(final Member member) {
        if (!isChannelEnabledForMember(member)) {
            throw WebServiceHelper.fault(WebServiceFaultsEnum.INVALID_CHANNEL);
        }
    }

    /**
     * Returns whether the current client's channel is enabled for the given member
     */
    public boolean isChannelEnabledForMember(final Member member) {
        final Channel channel = WebServiceContext.getChannel();
        // If not restricted to a channel, no need to check
        if (channel == null) {
            return true;
        }
        // If the channel restricted member is the same member, no need to check
        final Member restrictedMember = WebServiceContext.getMember();
        if (restrictedMember != null && restrictedMember.equals(member)) {
            return true;
        }
        return accessServiceLocal.isChannelEnabledForMember(channel.getInternalName(), member);
    }

    /**
     * Loads a member using the given principal, according to the current channel
     */
    public Member loadByPrincipal(PrincipalType principalType, final String principal, final Relationship... relationships) {
        if (StringUtils.isNotEmpty(principal)) {
            final Channel channel = WebServiceContext.getChannel();
            if (channel != null) {
                if (principalType == null) {
                    principalType = channel.getDefaultPrincipalType();
                } else if (!channel.getPrincipalTypes().contains(principalType)) {
                    return null;
                }
            }
            Member member;
            if (ArrayUtils.isNotEmpty(relationships)) {
                Relationship[] tmp = new Relationship[relationships.length + 2];
                tmp[0] = Element.Relationships.USER;
                tmp[1] = Element.Relationships.GROUP;
                System.arraycopy(relationships, 0, tmp, 2, relationships.length);
                member = elementServiceLocal.loadByPrincipal(principalType, principal, tmp);
            } else {
                member = elementServiceLocal.loadByPrincipal(principalType, principal, Element.Relationships.USER, Element.Relationships.GROUP);
            }

            if (!permissionService.relatesTo(member)) {
                throw new EntityNotFoundException(Member.class);
            }
            return member;
        }
        return null;
    }

    /**
     * Loads a member using the given principal, according to the current channel
     */
    public Member loadByPrincipal(final String principalType, final String principal, final Relationship... relationships) {
        final PrincipalType type = channelHelper.resolvePrincipalType(principalType);
        return loadByPrincipal(type, principal, relationships);
    }

    /**
     * Checks the {@link ServiceClient#getMember()}. If restricted to a member, returns it, ignoring the received id. Otherwise, loads the member with
     * the given principal
     */
    public Member resolveMember(final PrincipalParameters params) {
        if (params == null) {
            return null;
        }
        return resolveMember(params.getPrincipalType(), params.getPrincipal());
    }

    /**
     * Checks the {@link ServiceClient#getMember()}. If restricted to a member, returns it, ignoring the received id. Otherwise, loads the member with
     * the given principal
     */
    public Member resolveMember(final PrincipalType principalType, final String principal) {
        final Member member = WebServiceContext.getMember();
        if (member == null) {
            if (StringUtils.isEmpty(principal)) {
                return null;
            }
            return loadByPrincipal(principalType, principal);
        } else {
            return member;
        }
    }

    /**
     * Checks the {@link ServiceClient#getMember()}. If restricted to a member, returns it, ignoring the received id. Otherwise, loads the member with
     * the given principal
     */
    public Member resolveMember(final String principalType, final String principal) {
        final PrincipalType type = channelHelper.resolvePrincipalType(principalType);
        return resolveMember(type, principal);
    }

    /**
     * Invokes resolveMember(String), returning it's user, or null
     */
    public MemberUser resolveUser(final PrincipalType principalType, final String principal) {
        final Member member = resolveMember(principalType, principal);
        return member == null ? null : member.getMemberUser();
    }

    public void setAccessServiceLocal(final AccessServiceLocal accessService) {
        accessServiceLocal = accessService;
    }

    public void setChannelHelper(final ChannelHelper channelHelper) {
        this.channelHelper = channelHelper;
    }

    public void setElementServiceLocal(final ElementServiceLocal elementService) {
        elementServiceLocal = elementService;
    }

    public void setFieldHelper(final FieldHelper fieldHelper) {
        this.fieldHelper = fieldHelper;
    }

    public void setGroupServiceLocal(final GroupServiceLocal groupService) {
        groupServiceLocal = groupService;
    }

    public void setImageHelper(final ImageHelper imageHelper) {
        this.imageHelper = imageHelper;
    }

    public void setMemberCustomFieldServiceLocal(final MemberCustomFieldServiceLocal memberCustomFieldService) {
        memberCustomFieldServiceLocal = memberCustomFieldService;
    }

    public void setPermissionServiceLocal(final PermissionServiceLocal permissionService) {
        this.permissionService = permissionService;
    }

    public void setQueryHelper(final QueryHelper queryHelper) {
        this.queryHelper = queryHelper;
    }

    public void setServiceClientServiceLocal(final ServiceClientServiceLocal serviceClientService) {
        serviceClientServiceLocal = serviceClientService;
    }

    public FullTextMemberQuery toFullTextQuery(final FullTextMemberSearchParameters params) {
        if (params == null) {
            return null;
        }
        final FullTextMemberQuery query = new FullTextMemberQuery();
        query.setEnabled(true);
        query.fetch(Element.Relationships.GROUP, Element.Relationships.USER);
        if (params.isShowCustomFields()) {
            query.fetch(Member.Relationships.CUSTOM_VALUES);
        }
        if (params.isShowImages()) {
            query.fetch(Member.Relationships.IMAGES);
        }
        query.setKeywords(params.getKeywords());
        final GroupFilter[] groupFilters = EntityHelper.references(GroupFilter.class, params.getGroupFilterIds());
        if (groupFilters == null || groupFilters.length > 0) {
            query.setGroupFilters(Arrays.asList(groupFilters));
        }
        final MemberGroup[] groups = EntityHelper.references(MemberGroup.class, params.getGroupIds());
        if (groups == null || groups.length > 0) {
            query.setGroups(Arrays.asList(groups));
        }
        queryHelper.fill(params, query);
        query.setWithImagesOnly(params.isWithImagesOnly());
        query.setCustomValues(fieldHelper.toValueCollection(memberCustomFieldServiceLocal.list(), params.getFields()));
        return query;
    }

    public Member toMember(final RegisterMemberParameters params) {
        // Find the group
        MemberGroup group;
        try {
            final ServiceClient client = serviceClientServiceLocal.load(WebServiceContext.getClient().getId(), ServiceClient.Relationships.MANAGE_GROUPS);
            final Set<MemberGroup> manageGroups = client.getManageGroups();
            final Long groupId = params.getGroupId();
            if (groupId == null || groupId.intValue() <= 0) {
                group = manageGroups.iterator().next();
            } else {
                group = groupServiceLocal.load(groupId);
                if (!manageGroups.contains(group)) {
                    throw new Exception();
                }
            }
        } catch (final Exception e) {
            throw new EntityNotFoundException();
        }

        final MemberUser user = new MemberUser();
        user.setUsername(params.getUsername());
        final Member member = new Member();
        member.setGroup(group);
        member.setUser(user);
        member.setName(params.getName());
        member.setEmail(params.getEmail());
        List<MemberCustomField> fields = memberCustomFieldServiceLocal.list();
        fields = CustomFieldHelper.onlyForGroup(fields, group);
        final Collection<MemberCustomFieldValue> fieldValues = fieldHelper.toValueCollection(fields, params.getFields());
        member.setCustomValues(fieldValues);
        return member;
    }

    public MemberQuery toQuery(final MemberSearchParameters params) {
        if (params == null) {
            return null;
        }
        final MemberQuery query = new MemberQuery();
        query.setEnabled(true);
        query.fetch(Element.Relationships.GROUP, Element.Relationships.USER);
        if (params.isShowCustomFields()) {
            query.fetch(Member.Relationships.CUSTOM_VALUES);
        }
        if (params.isShowImages()) {
            query.fetch(Member.Relationships.IMAGES);
        }
        final GroupFilter[] groupFilters = EntityHelper.references(GroupFilter.class, params.getGroupFilterIds());
        if (groupFilters == null || groupFilters.length > 0) {
            query.setGroupFilters(Arrays.asList(groupFilters));
        }
        final MemberGroup[] groups = EntityHelper.references(MemberGroup.class, params.getGroupIds());
        if (groups == null || groups.length > 0) {
            query.setGroups(Arrays.asList(groups));
        }
        query.setUsername(params.getUsername());
        query.setName(params.getName());
        query.setEmail(params.getEmail());
        query.setWithImagesOnly(params.isWithImagesOnly());
        query.setRandomOrder(params.isRandomOrder());
        queryHelper.fill(params, query);
        final List<FieldValueVO> fields = params.getFields();
        if (fields != null && fields.size() > 0) {
            query.setCustomValues(fieldHelper.toValueCollection(memberCustomFieldServiceLocal.list(), fields));
        }
        return query;
    }

    public MemberResultPage toResultPage(final AbstractMemberSearchParameters params, final List<Member> members) {
        final MemberResultPage page = new MemberResultPage();
        if (members instanceof Page) {
            final Page<Member> memberPage = (Page<Member>) members;
            page.setCurrentPage(memberPage.getCurrentPage());
            page.setTotalCount(memberPage.getTotalCount());
        }
        final List<MemberCustomField> allFields = memberCustomFieldServiceLocal.list();
        final Map<MemberGroup, List<MemberCustomField>> fieldsByGroup = new HashMap<MemberGroup, List<MemberCustomField>>();
        final List<MemberVO> vos = new ArrayList<MemberVO>();
        for (final Member member : members) {
            final MemberGroup memberGroup = member.getMemberGroup();
            List<MemberCustomField> fields = null;
            if (params.isShowCustomFields()) {
                fields = fieldsByGroup.get(memberGroup);
                if (fields == null) {
                    fields = CustomFieldHelper.onlyForGroup(allFields, memberGroup);
                    fieldsByGroup.put(memberGroup, fields);
                }
            }
            final MemberVO vo = toVO(member, fields, params.isShowImages());
            if (vo != null) {
                vos.add(vo);
            }
        }
        page.setMembers(vos);
        return page;
    }

    /**
     * Converts a member to VO, with minimum details
     */
    public MemberVO toVO(final Member member) {
        return toVO(member, null, false);
    }

    public MemberVO toVO(final Member member, final Collection<MemberCustomField> fields, final Collection<MemberCustomField> requiredFields, final boolean useImages) {
        if (member == null) {
            return null;
        }
        final MemberVO vo = new MemberVO();
        vo.setId(member.getId());
        vo.setName(member.getName());
        vo.setUsername(member.getUsername());
        vo.setEmail(member.getEmail());
        vo.setGroupId(member.getGroup().getId());
        if (fields != null) {
            final Collection<MemberCustomFieldValue> customValues = ((Member) elementServiceLocal.load(member.getId(), Member.Relationships.CUSTOM_VALUES)).getCustomValues();
            vo.setFields(fieldHelper.toList(fields, requiredFields, customValues));
        } else {
            final List<FieldValueVO> empty = Collections.emptyList();
            vo.setFields(empty);
        }
        if (useImages) {
            vo.setImages(imageHelper.toVOs(member.getImages()));
        }
        return vo;
    }

    /**
     * Converts a member to VO
     */
    public MemberVO toVO(final Member member, final List<MemberCustomField> fields, final boolean useImages) {
        Collection<MemberCustomField> requiredFields = null;
        Channel channel = WebServiceContext.getChannel();
        if (channel != null && !CollectionUtils.isEmpty(fields)) {
            // Ensure that any custom fields used as principal for the current channel are returned in the MemberVO
            Collection<ChannelPrincipal> principals = channel.getPrincipals();
            for (ChannelPrincipal principal : principals) {
                MemberCustomField customField = principal.getCustomField();
                if (customField != null && fields.contains(customField)) {
                    if (requiredFields == null) {
                        requiredFields = new HashSet<MemberCustomField>();
                    }
                    requiredFields.add(customField);
                }
            }
        }

        return toVO(member, fields, requiredFields, useImages);
    }
}
