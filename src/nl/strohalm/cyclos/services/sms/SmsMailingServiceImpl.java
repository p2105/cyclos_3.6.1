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
package nl.strohalm.cyclos.services.sms;

import java.util.Calendar;
import java.util.List;

import nl.strohalm.cyclos.dao.sms.SmsMailingDAO;
import nl.strohalm.cyclos.entities.customization.fields.MemberCustomField;
import nl.strohalm.cyclos.entities.members.Member;
import nl.strohalm.cyclos.entities.sms.SmsMailing;
import nl.strohalm.cyclos.entities.sms.SmsMailingQuery;
import nl.strohalm.cyclos.scheduling.polling.SmsMailingSendingPollingTask;
import nl.strohalm.cyclos.services.application.ApplicationServiceLocal;
import nl.strohalm.cyclos.services.elements.MemberServiceLocal;
import nl.strohalm.cyclos.services.settings.SettingsServiceLocal;
import nl.strohalm.cyclos.utils.access.LoggedUser;
import nl.strohalm.cyclos.utils.validation.PropertyValidation;
import nl.strohalm.cyclos.utils.validation.ValidationError;
import nl.strohalm.cyclos.utils.validation.ValidationException;
import nl.strohalm.cyclos.utils.validation.Validator;

import org.apache.commons.collections.CollectionUtils;

/**
 * Service implementation for sms mailings
 * 
 * @author luis
 */
public class SmsMailingServiceImpl implements SmsMailingServiceLocal {

    private SmsMailingDAO           smsMailingDao;
    private SettingsServiceLocal    settingsService;
    private MemberServiceLocal      memberService;
    private ApplicationServiceLocal applicationService;

    @Override
    public Member nextMemberToSend(final SmsMailing mailing) {
        return smsMailingDao.nextMemberToSend(mailing);
    }

    @Override
    public SmsMailing nextToSend() {
        SmsMailingQuery query = new SmsMailingQuery();
        query.setUniqueResult();
        query.setFinished(false);
        List<SmsMailing> list = search(query);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public void removeMemberFromPending(final SmsMailing smsMailing, final Member member) {
        smsMailingDao.removeMemberFromPending(smsMailing, member);
    }

    @Override
    public List<SmsMailing> search(final SmsMailingQuery query) {
        return smsMailingDao.search(query);
    }

    @Override
    public SmsMailing send(final SmsMailing smsMailing) {
        return doSend(smsMailing);
    }

    public void setApplicationServiceLocal(final ApplicationServiceLocal applicationService) {
        this.applicationService = applicationService;
    }

    public void setMemberServiceLocal(final MemberServiceLocal memberService) {
        this.memberService = memberService;
    }

    public void setSettingsServiceLocal(final SettingsServiceLocal settingsService) {
        this.settingsService = settingsService;
    }

    public void setSmsMailingDao(final SmsMailingDAO smsMailingDao) {
        this.smsMailingDao = smsMailingDao;
    }

    @Override
    public void validate(final SmsMailing smsMailing, final boolean isMemberRequired) throws ValidationException {
        if (isMemberRequired && CollectionUtils.isNotEmpty(smsMailing.getGroups())) {
            throw new ValidationException();
        }
        getValidator(isMemberRequired).validate(smsMailing);
    }

    private SmsMailing doSend(SmsMailing smsMailing) {
        validate(smsMailing, smsMailing.isSingleMember());
        smsMailing.setBy(LoggedUser.element());
        smsMailing.setDate(Calendar.getInstance());
        smsMailing.setSentSms(0);

        smsMailing = smsMailingDao.insert(smsMailing);

        // Send each SMS
        if (smsMailing.isSingleMember() || !CollectionUtils.isEmpty(smsMailing.getGroups())) {
            final MemberCustomField smsCustomField = settingsService.getSmsCustomField();
            if (smsCustomField == null) {
                throw new IllegalStateException("No custom field was set as SMS field under local settings");
            }
            smsMailingDao.assignUsersToSend(smsMailing, smsCustomField);
        }

        applicationService.awakePollingTaskOnTransactionCommit(SmsMailingSendingPollingTask.class);

        return smsMailing;
    }

    private Validator getValidator(final boolean isMemberRequired) {
        final Validator validator = new Validator("smsMailing");
        validator.property("text").required().maxLength(160);
        if (isMemberRequired) {
            validator.property("member").required().add(new PropertyValidation() {
                private static final long serialVersionUID = -20792899778722444L;

                @Override
                public ValidationError validate(final Object object, final Object property, final Object value) {
                    // Ensure the member has a mobile phone set
                    final Member member = (Member) value;
                    if (member == null) {
                        return null;
                    }

                    final MemberCustomField smsCustomField = settingsService.getSmsCustomField();
                    if (memberService.hasValueForField(member, smsCustomField)) {
                        return null;
                    }

                    return new ValidationError("smsMailing.error.noMobilePhone");
                }
            });
        }

        return validator;
    }
}
