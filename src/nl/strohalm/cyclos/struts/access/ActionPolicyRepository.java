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
package nl.strohalm.cyclos.struts.access;

import java.util.HashMap;
import java.util.Map;

import nl.strohalm.cyclos.access.AdminAdminPermission;
import nl.strohalm.cyclos.access.AdminMemberPermission;
import nl.strohalm.cyclos.access.AdminSystemPermission;
import nl.strohalm.cyclos.access.BrokerPermission;
import nl.strohalm.cyclos.access.MemberPermission;
import nl.strohalm.cyclos.access.Module;
import nl.strohalm.cyclos.access.OperatorPermission;
import nl.strohalm.cyclos.controls.access.AllowUserLoginAction;
import nl.strohalm.cyclos.controls.access.ChangePasswordAction;
import nl.strohalm.cyclos.controls.access.DisconnectUserAction;
import nl.strohalm.cyclos.controls.access.ListConnectedUsersAction;
import nl.strohalm.cyclos.controls.access.LogoutAction;
import nl.strohalm.cyclos.controls.access.ManagePasswordsAction;
import nl.strohalm.cyclos.controls.access.channels.ManageExternalAccessAction;
import nl.strohalm.cyclos.controls.accounts.accountfees.ListAccountFeeLogAction;
import nl.strohalm.cyclos.controls.accounts.accounttypes.ListAccountTypesAction;
import nl.strohalm.cyclos.controls.accounts.cards.CardDetailsAction;
import nl.strohalm.cyclos.controls.accounts.cards.CreateCardAction;
import nl.strohalm.cyclos.controls.accounts.cards.EditCardTypeAction;
import nl.strohalm.cyclos.controls.accounts.cards.ExportCardsToCsvAction;
import nl.strohalm.cyclos.controls.accounts.cards.ListCardTypeAction;
import nl.strohalm.cyclos.controls.accounts.cards.PrintCardsAction;
import nl.strohalm.cyclos.controls.accounts.cards.RemoveCardTypeAction;
import nl.strohalm.cyclos.controls.accounts.cards.SearchCardsAsBrokerAction;
import nl.strohalm.cyclos.controls.accounts.cards.SearchCardsNormalAction;
import nl.strohalm.cyclos.controls.accounts.cards.UpdateCardAction;
import nl.strohalm.cyclos.controls.accounts.currencies.ListCurrenciesAction;
import nl.strohalm.cyclos.controls.accounts.details.AccountOverviewAction;
import nl.strohalm.cyclos.controls.accounts.details.SearchScheduledPaymentsAction;
import nl.strohalm.cyclos.controls.accounts.details.SearchTransferAuthorizationsAction;
import nl.strohalm.cyclos.controls.accounts.details.TransfersAwaitingAuthorizationAction;
import nl.strohalm.cyclos.controls.accounts.external.ListExternalAccountsAction;
import nl.strohalm.cyclos.controls.accounts.external.OverviewExternalAccountsAction;
import nl.strohalm.cyclos.controls.accounts.guarantees.certifications.SearchCertificationsAction;
import nl.strohalm.cyclos.controls.accounts.guarantees.guarantees.SearchGuaranteesAction;
import nl.strohalm.cyclos.controls.accounts.guarantees.paymentobligations.SearchPaymentObligationsAction;
import nl.strohalm.cyclos.controls.accounts.guarantees.types.ListGuaranteeTypesAction;
import nl.strohalm.cyclos.controls.accounts.pos.AssignPosAction;
import nl.strohalm.cyclos.controls.accounts.pos.EditPosAction;
import nl.strohalm.cyclos.controls.accounts.pos.MemberPosAction;
import nl.strohalm.cyclos.controls.accounts.pos.RemovePosAction;
import nl.strohalm.cyclos.controls.accounts.pos.SearchPosAction;
import nl.strohalm.cyclos.controls.admins.AdminProfileAction;
import nl.strohalm.cyclos.controls.admins.ChangeAdminGroupAction;
import nl.strohalm.cyclos.controls.admins.SearchAdminsAction;
import nl.strohalm.cyclos.controls.admins.mailPreferences.MailPreferencesAction;
import nl.strohalm.cyclos.controls.admintasks.AdministrativeTasksAction;
import nl.strohalm.cyclos.controls.ads.MemberAdsAction;
import nl.strohalm.cyclos.controls.ads.SearchAdsAction;
import nl.strohalm.cyclos.controls.ads.categories.ListAdCategoriesAction;
import nl.strohalm.cyclos.controls.ads.categories.ManageAdCategoriesAction;
import nl.strohalm.cyclos.controls.ads.imports.ImportAdsAction;
import nl.strohalm.cyclos.controls.alerts.ListMemberAlertsAction;
import nl.strohalm.cyclos.controls.alerts.ListSystemAlertsAction;
import nl.strohalm.cyclos.controls.alerts.SearchAlertsAction;
import nl.strohalm.cyclos.controls.alerts.SearchErrorLogAction;
import nl.strohalm.cyclos.controls.alerts.ViewErrorLogAction;
import nl.strohalm.cyclos.controls.channels.ListChannelsAction;
import nl.strohalm.cyclos.controls.customization.documents.EditDynamicDocumentAction;
import nl.strohalm.cyclos.controls.customization.documents.EditMemberDocumentAction;
import nl.strohalm.cyclos.controls.customization.documents.EditStaticDocumentAction;
import nl.strohalm.cyclos.controls.customization.documents.ListDocumentsAction;
import nl.strohalm.cyclos.controls.customization.documents.PreviewDynamicDocumentAction;
import nl.strohalm.cyclos.controls.customization.documents.ViewDynamicDocumentAction;
import nl.strohalm.cyclos.controls.customization.documents.ViewStaticDocumentAsBrokerAction;
import nl.strohalm.cyclos.controls.customization.documents.ViewStaticDocumentNormalAction;
import nl.strohalm.cyclos.controls.customization.fields.ListCustomFieldsAction;
import nl.strohalm.cyclos.controls.customization.files.ListCustomizedFilesAction;
import nl.strohalm.cyclos.controls.customization.images.CustomImagesAction;
import nl.strohalm.cyclos.controls.customization.images.SystemImagesAction;
import nl.strohalm.cyclos.controls.customization.themes.SelectThemeAction;
import nl.strohalm.cyclos.controls.customization.translationMessages.ManageTranslationMessagesAction;
import nl.strohalm.cyclos.controls.customization.translationMessages.SearchTranslationMessagesAction;
import nl.strohalm.cyclos.controls.general.AboutAction;
import nl.strohalm.cyclos.controls.general.ContactUsAction;
import nl.strohalm.cyclos.controls.general.HomeAction;
import nl.strohalm.cyclos.controls.general.ManualAction;
import nl.strohalm.cyclos.controls.groups.ListGroupsAction;
import nl.strohalm.cyclos.controls.groups.groupFilters.ListGroupFiltersAction;
import nl.strohalm.cyclos.controls.invoices.SearchInvoicesAction;
import nl.strohalm.cyclos.controls.invoices.SendInvoiceAction;
import nl.strohalm.cyclos.controls.loangroups.SearchLoanGroupsAction;
import nl.strohalm.cyclos.controls.loans.GrantLoanAction;
import nl.strohalm.cyclos.controls.loans.SearchLoanPaymentsAction;
import nl.strohalm.cyclos.controls.loans.SearchLoansAction;
import nl.strohalm.cyclos.controls.members.BrokerInitialGroupAction;
import nl.strohalm.cyclos.controls.members.ChangeMemberGroupAction;
import nl.strohalm.cyclos.controls.members.MemberProfileAction;
import nl.strohalm.cyclos.controls.members.SearchMembersAction;
import nl.strohalm.cyclos.controls.members.activities.ActivitiesAction;
import nl.strohalm.cyclos.controls.members.adinterests.ListAdInterestsAction;
import nl.strohalm.cyclos.controls.members.agreements.ListRegistrationAgreementsAction;
import nl.strohalm.cyclos.controls.members.brokering.ChangeBrokerAction;
import nl.strohalm.cyclos.controls.members.brokering.DefaultBrokerCommissionsAction;
import nl.strohalm.cyclos.controls.members.brokering.ListBrokerCommissionContractsAction;
import nl.strohalm.cyclos.controls.members.brokering.ListBrokeringsAction;
import nl.strohalm.cyclos.controls.members.brokering.ManageBrokerCommissionsAction;
import nl.strohalm.cyclos.controls.members.brokering.SearchBrokerCommissionContractsAction;
import nl.strohalm.cyclos.controls.members.bulk.MemberBulkActionsAction;
import nl.strohalm.cyclos.controls.members.bulk.MemberBulkGenerateCardAction;
import nl.strohalm.cyclos.controls.members.contacts.AddContactAction;
import nl.strohalm.cyclos.controls.members.contacts.ListContactsAction;
import nl.strohalm.cyclos.controls.members.creditlimit.EditCreditLimitAction;
import nl.strohalm.cyclos.controls.members.documents.SelectDocumentAction;
import nl.strohalm.cyclos.controls.members.imports.ImportMembersAction;
import nl.strohalm.cyclos.controls.members.loangroups.MemberLoanGroupsAction;
import nl.strohalm.cyclos.controls.members.messages.ListMessageCategoriesAction;
import nl.strohalm.cyclos.controls.members.messages.SearchMessagesAction;
import nl.strohalm.cyclos.controls.members.messages.SendMessageAction;
import nl.strohalm.cyclos.controls.members.pending.SearchPendingMembersAction;
import nl.strohalm.cyclos.controls.members.preferences.NotificationPreferenceAction;
import nl.strohalm.cyclos.controls.members.records.ListMemberRecordTypesAction;
import nl.strohalm.cyclos.controls.members.records.SearchMemberRecordsAction;
import nl.strohalm.cyclos.controls.members.references.MemberReferencesAction;
import nl.strohalm.cyclos.controls.members.sms.SearchInfoTextsAction;
import nl.strohalm.cyclos.controls.members.sms.SearchSmsLogsAction;
import nl.strohalm.cyclos.controls.members.sms.SearchSmsMailingsAction;
import nl.strohalm.cyclos.controls.members.sms.SendSmsMailingAction;
import nl.strohalm.cyclos.controls.operators.ChangeOperatorGroupAction;
import nl.strohalm.cyclos.controls.operators.OperatorProfileAction;
import nl.strohalm.cyclos.controls.operators.SearchOperatorsAction;
import nl.strohalm.cyclos.controls.payments.PaymentAction;
import nl.strohalm.cyclos.controls.payments.SelfPaymentAction;
import nl.strohalm.cyclos.controls.payments.conversionsimulation.SimulateConversionAction;
import nl.strohalm.cyclos.controls.payments.request.RequestPaymentAction;
import nl.strohalm.cyclos.controls.reports.CurrentStateReportAction;
import nl.strohalm.cyclos.controls.reports.members.list.MembersListReportAction;
import nl.strohalm.cyclos.controls.reports.members.sms.SmsLogsReportAction;
import nl.strohalm.cyclos.controls.reports.members.transactions.MembersTransactionsReportAction;
import nl.strohalm.cyclos.controls.reports.simulations.SimulationsSelectAction;
import nl.strohalm.cyclos.controls.reports.statistics.StatisticsSelectAction;
import nl.strohalm.cyclos.controls.services.SearchServiceClientsAction;
import nl.strohalm.cyclos.controls.settings.EditAccessSettingsAction;
import nl.strohalm.cyclos.controls.settings.EditAlertSettingsAction;
import nl.strohalm.cyclos.controls.settings.EditLocalSettingsAction;
import nl.strohalm.cyclos.controls.settings.EditLogSettingsAction;
import nl.strohalm.cyclos.controls.settings.EditMailSettingsAction;
import nl.strohalm.cyclos.controls.settings.EditMailTranslationAction;
import nl.strohalm.cyclos.controls.settings.ListMessageSettingsAction;
import nl.strohalm.cyclos.controls.settings.ManageSettingsAction;
import nl.strohalm.cyclos.entities.groups.Group;
import nl.strohalm.cyclos.entities.members.Element;
import nl.strohalm.cyclos.struts.access.policies.AccountOverviewActionPolicy;
import nl.strohalm.cyclos.struts.access.policies.ActivitiesActionPolicy;
import nl.strohalm.cyclos.struts.access.policies.ListBrokerCommissionContractsActionPolicy;
import nl.strohalm.cyclos.struts.access.policies.ListContactsActionPolicy;
import nl.strohalm.cyclos.struts.access.policies.ManagePasswordsActionPolicy;
import nl.strohalm.cyclos.struts.access.policies.MemberAdsActionPolicy;
import nl.strohalm.cyclos.struts.access.policies.MemberLoanGroupsActionPolicy;
import nl.strohalm.cyclos.struts.access.policies.MemberPosActionPolicy;
import nl.strohalm.cyclos.struts.access.policies.MemberReferencesActionPolicy;
import nl.strohalm.cyclos.struts.access.policies.PaymentActionPolicy;
import nl.strohalm.cyclos.struts.access.policies.SendInvoiceActionPolicy;
import nl.strohalm.cyclos.struts.access.policies.SendMessageActionPolicy;
import nl.strohalm.cyclos.struts.access.policies.utils.AllGrantedActionPolicy;
import nl.strohalm.cyclos.struts.access.policies.utils.ElementActionPolicy;
import nl.strohalm.cyclos.struts.access.policies.utils.GroupActionPolicy;
import nl.strohalm.cyclos.struts.access.policies.utils.ModuleActionPolicy;
import nl.strohalm.cyclos.struts.access.policies.utils.OrActionPolicy;
import nl.strohalm.cyclos.struts.access.policies.utils.PermissionActionPolicy;

import org.apache.struts.action.Action;

public class ActionPolicyRepository {

    private final static Map<String, ActionPolicy> actions;

    static {
        actions = new HashMap<String, ActionPolicy>();
        actions.put(AboutAction.class.getName(), AllGrantedActionPolicy.instance());
        actions.put(AccountOverviewAction.class.getName(), AccountOverviewActionPolicy.instance());
        actions.put(ActivitiesAction.class.getName(), ActivitiesActionPolicy.instance());
        actions.put(AddContactAction.class.getName(), OrActionPolicy.create(ElementActionPolicy.create(Element.Nature.MEMBER), PermissionActionPolicy.create(OperatorPermission.CONTACTS_MANAGE)));
        actions.put(AdminProfileAction.class.getName(), AllGrantedActionPolicy.instance());
        actions.put(AdministrativeTasksAction.class.getName(), ModuleActionPolicy.create(Module.SYSTEM_TASKS));
        actions.put(AllowUserLoginAction.class.getName(), PermissionActionPolicy.create(AdminMemberPermission.ACCESS_ENABLE_LOGIN, AdminAdminPermission.ACCESS_ENABLE_LOGIN, MemberPermission.OPERATORS_MANAGE));
        actions.put(AssignPosAction.class.getName(), PermissionActionPolicy.create(AdminMemberPermission.POS_ASSIGN, BrokerPermission.POS_ASSIGN));
        actions.put(BrokerInitialGroupAction.class.getName(), PermissionActionPolicy.create(BrokerPermission.MEMBERS_REGISTER));
        actions.put(CardDetailsAction.class.getName(), PermissionActionPolicy.create(AdminMemberPermission.CARDS_VIEW, MemberPermission.CARDS_VIEW, BrokerPermission.CARDS_VIEW));
        actions.put(ChangeAdminGroupAction.class.getName(), PermissionActionPolicy.create(AdminAdminPermission.ADMINS_CHANGE_GROUP));
        actions.put(ChangeBrokerAction.class.getName(), PermissionActionPolicy.create(AdminMemberPermission.BROKERINGS_CHANGE_BROKER));
        actions.put(ChangeMemberGroupAction.class.getName(), PermissionActionPolicy.create(AdminMemberPermission.MEMBERS_CHANGE_GROUP));
        actions.put(ChangeOperatorGroupAction.class.getName(), PermissionActionPolicy.create(MemberPermission.OPERATORS_MANAGE));
        actions.put(ChangePasswordAction.class.getName(), AllGrantedActionPolicy.instance());
        actions.put(ContactUsAction.class.getName(), ElementActionPolicy.create(Element.Nature.MEMBER, Element.Nature.OPERATOR));
        actions.put(CreateCardAction.class.getName(), PermissionActionPolicy.create(AdminMemberPermission.CARDS_GENERATE, BrokerPermission.CARDS_GENERATE));
        actions.put(CurrentStateReportAction.class.getName(), PermissionActionPolicy.create(AdminSystemPermission.REPORTS_CURRENT));
        actions.put(CustomImagesAction.class.getName(), PermissionActionPolicy.create(AdminSystemPermission.CUSTOM_IMAGES_VIEW));
        actions.put(DefaultBrokerCommissionsAction.class.getName(), PermissionActionPolicy.create(BrokerPermission.MEMBERS_MANAGE_DEFAULTS));
        actions.put(DisconnectUserAction.class.getName(), PermissionActionPolicy.create(AdminMemberPermission.ACCESS_DISCONNECT, AdminAdminPermission.ACCESS_DISCONNECT, MemberPermission.OPERATORS_MANAGE));
        actions.put(EditAccessSettingsAction.class.getName(), PermissionActionPolicy.create(AdminSystemPermission.SETTINGS_VIEW));
        actions.put(EditAlertSettingsAction.class.getName(), PermissionActionPolicy.create(AdminSystemPermission.SETTINGS_VIEW));
        actions.put(EditCardTypeAction.class.getName(), PermissionActionPolicy.create(AdminSystemPermission.CARD_TYPES_MANAGE, AdminSystemPermission.CARD_TYPES_VIEW));
        actions.put(EditCreditLimitAction.class.getName(), PermissionActionPolicy.create(AdminMemberPermission.ACCOUNTS_CREDIT_LIMIT));
        actions.put(EditDynamicDocumentAction.class.getName(), PermissionActionPolicy.create(AdminMemberPermission.DOCUMENTS_MANAGE_DYNAMIC));
        actions.put(EditLocalSettingsAction.class.getName(), PermissionActionPolicy.create(AdminSystemPermission.SETTINGS_VIEW));
        actions.put(EditLogSettingsAction.class.getName(), PermissionActionPolicy.create(AdminSystemPermission.SETTINGS_VIEW));
        actions.put(EditMailSettingsAction.class.getName(), PermissionActionPolicy.create(AdminSystemPermission.SETTINGS_VIEW));
        actions.put(EditMailTranslationAction.class.getName(), PermissionActionPolicy.create(AdminSystemPermission.TRANSLATION_MANAGE_MAIL_TRANSLATION));
        actions.put(EditMemberDocumentAction.class.getName(), PermissionActionPolicy.create(AdminMemberPermission.DOCUMENTS_MANAGE_MEMBER, BrokerPermission.DOCUMENTS_MANAGE_MEMBER));
        actions.put(EditPosAction.class.getName(), ElementActionPolicy.create(Element.Nature.MEMBER, Element.Nature.ADMIN));
        actions.put(EditStaticDocumentAction.class.getName(), PermissionActionPolicy.create(AdminMemberPermission.DOCUMENTS_MANAGE_STATIC));
        actions.put(ExportCardsToCsvAction.class.getName(), PermissionActionPolicy.create(AdminMemberPermission.CARDS_VIEW));
        actions.put(GrantLoanAction.class.getName(), PermissionActionPolicy.create(AdminMemberPermission.LOANS_GRANT));
        actions.put(HomeAction.class.getName(), AllGrantedActionPolicy.instance());
        actions.put(ImportAdsAction.class.getName(), PermissionActionPolicy.create(AdminMemberPermission.ADS_IMPORT));
        actions.put(ImportMembersAction.class.getName(), PermissionActionPolicy.create(AdminMemberPermission.MEMBERS_IMPORT));
        actions.put(ListAccountFeeLogAction.class.getName(), PermissionActionPolicy.create(AdminSystemPermission.ACCOUNT_FEES_VIEW));
        actions.put(ListAccountTypesAction.class.getName(), PermissionActionPolicy.create(AdminSystemPermission.ACCOUNTS_VIEW));
        actions.put(ListAdCategoriesAction.class.getName(), ModuleActionPolicy.create(Module.SYSTEM_AD_CATEGORIES));
        actions.put(ListAdInterestsAction.class.getName(), PermissionActionPolicy.create(MemberPermission.PREFERENCES_MANAGE_AD_INTERESTS));
        actions.put(ListBrokerCommissionContractsAction.class.getName(), ListBrokerCommissionContractsActionPolicy.instance());
        actions.put(ListBrokeringsAction.class.getName(), OrActionPolicy.create(ElementActionPolicy.create(Element.Nature.MEMBER), PermissionActionPolicy.create(AdminMemberPermission.BROKERINGS_VIEW_MEMBERS)));
        actions.put(ListCardTypeAction.class.getName(), PermissionActionPolicy.create(AdminSystemPermission.CARD_TYPES_VIEW));
        actions.put(ListChannelsAction.class.getName(), PermissionActionPolicy.create(AdminSystemPermission.CHANNELS_VIEW));
        actions.put(ListConnectedUsersAction.class.getName(), PermissionActionPolicy.create(AdminSystemPermission.STATUS_VIEW_CONNECTED_ADMINS, AdminSystemPermission.STATUS_VIEW_CONNECTED_BROKERS, AdminSystemPermission.STATUS_VIEW_CONNECTED_MEMBERS, MemberPermission.OPERATORS_MANAGE));
        actions.put(ListContactsAction.class.getName(), ListContactsActionPolicy.instance());
        actions.put(ListCurrenciesAction.class.getName(), PermissionActionPolicy.create(AdminSystemPermission.CURRENCIES_VIEW));
        actions.put(ListCustomFieldsAction.class.getName(), OrActionPolicy.create(ModuleActionPolicy.create(Module.SYSTEM_CUSTOM_FIELDS), PermissionActionPolicy.create(MemberPermission.OPERATORS_MANAGE)));
        actions.put(ListCustomizedFilesAction.class.getName(), PermissionActionPolicy.create(AdminSystemPermission.CUSTOMIZED_FILES_VIEW));
        actions.put(ListDocumentsAction.class.getName(), PermissionActionPolicy.create(AdminMemberPermission.DOCUMENTS_MANAGE_DYNAMIC, AdminMemberPermission.DOCUMENTS_MANAGE_STATIC));
        actions.put(ListExternalAccountsAction.class.getName(), PermissionActionPolicy.create(AdminSystemPermission.EXTERNAL_ACCOUNTS_VIEW));
        actions.put(ListGroupFiltersAction.class.getName(), PermissionActionPolicy.create(AdminSystemPermission.GROUP_FILTERS_VIEW));
        actions.put(ListGroupsAction.class.getName(), PermissionActionPolicy.create(AdminSystemPermission.ADMIN_GROUPS_VIEW, AdminMemberPermission.GROUPS_VIEW, MemberPermission.OPERATORS_MANAGE));
        actions.put(ListGuaranteeTypesAction.class.getName(), PermissionActionPolicy.create(AdminSystemPermission.GUARANTEE_TYPES_VIEW));
        actions.put(ListMemberAlertsAction.class.getName(), PermissionActionPolicy.create(AdminSystemPermission.ALERTS_VIEW_MEMBER_ALERTS));
        actions.put(ListMemberRecordTypesAction.class.getName(), PermissionActionPolicy.create(AdminSystemPermission.MEMBER_RECORD_TYPES_VIEW));
        actions.put(ListMessageCategoriesAction.class.getName(), PermissionActionPolicy.create(AdminSystemPermission.MESSAGE_CATEGORIES_VIEW));
        actions.put(ListMessageSettingsAction.class.getName(), PermissionActionPolicy.create(AdminSystemPermission.TRANSLATION_MANAGE_NOTIFICATION));
        actions.put(ListRegistrationAgreementsAction.class.getName(), PermissionActionPolicy.create(AdminSystemPermission.REGISTRATION_AGREEMENTS_VIEW));
        actions.put(ListSystemAlertsAction.class.getName(), PermissionActionPolicy.create(AdminSystemPermission.ALERTS_VIEW_SYSTEM_ALERTS));
        actions.put(LogoutAction.class.getName(), AllGrantedActionPolicy.instance());
        actions.put(MailPreferencesAction.class.getName(), GroupActionPolicy.create(Group.Nature.ADMIN));
        actions.put(ManageAdCategoriesAction.class.getName(), PermissionActionPolicy.create(AdminSystemPermission.AD_CATEGORIES_FILE));
        actions.put(ManageBrokerCommissionsAction.class.getName(), PermissionActionPolicy.create(AdminMemberPermission.BROKERINGS_MANAGE_COMMISSIONS));
        actions.put(ManageExternalAccessAction.class.getName(), ElementActionPolicy.create(Element.Nature.MEMBER, Element.Nature.ADMIN));
        actions.put(ManagePasswordsAction.class.getName(), ManagePasswordsActionPolicy.instance());
        actions.put(ManageSettingsAction.class.getName(), PermissionActionPolicy.create(AdminSystemPermission.SETTINGS_FILE));
        actions.put(ManageTranslationMessagesAction.class.getName(), PermissionActionPolicy.create(AdminSystemPermission.TRANSLATION_FILE));
        actions.put(ManualAction.class.getName(), AllGrantedActionPolicy.instance());
        actions.put(MemberAdsAction.class.getName(), MemberAdsActionPolicy.instance());
        actions.put(MemberBulkActionsAction.class.getName(), PermissionActionPolicy.create(AdminMemberPermission.BULK_ACTIONS_CHANGE_GROUP, AdminMemberPermission.BULK_ACTIONS_CHANGE_BROKER));
        actions.put(MemberBulkGenerateCardAction.class.getName(), PermissionActionPolicy.create(AdminMemberPermission.BULK_ACTIONS_GENERATE_CARD));
        actions.put(MemberLoanGroupsAction.class.getName(), MemberLoanGroupsActionPolicy.instance());
        actions.put(MemberPosAction.class.getName(), MemberPosActionPolicy.instance());
        actions.put(MemberProfileAction.class.getName(), AllGrantedActionPolicy.instance());
        actions.put(MemberReferencesAction.class.getName(), MemberReferencesActionPolicy.instance());
        actions.put(MembersListReportAction.class.getName(), PermissionActionPolicy.create(AdminSystemPermission.REPORTS_MEMBER_LIST));
        actions.put(MembersTransactionsReportAction.class.getName(), PermissionActionPolicy.create(AdminSystemPermission.REPORTS_MEMBER_LIST));
        actions.put(NotificationPreferenceAction.class.getName(), PermissionActionPolicy.create(MemberPermission.PREFERENCES_MANAGE_NOTIFICATIONS, AdminMemberPermission.PREFERENCES_MANAGE_NOTIFICATIONS, BrokerPermission.PREFERENCES_MANAGE_NOTIFICATIONS));
        actions.put(OperatorProfileAction.class.getName(), ElementActionPolicy.create(Element.Nature.MEMBER, Element.Nature.OPERATOR));
        actions.put(OverviewExternalAccountsAction.class.getName(), PermissionActionPolicy.create(AdminSystemPermission.EXTERNAL_ACCOUNTS_DETAILS));
        actions.put(PaymentAction.class.getName(), PaymentActionPolicy.instance());
        actions.put(PreviewDynamicDocumentAction.class.getName(), PermissionActionPolicy.create(AdminMemberPermission.DOCUMENTS_MANAGE_DYNAMIC));
        actions.put(PrintCardsAction.class.getName(), PermissionActionPolicy.create(AdminMemberPermission.CARDS_VIEW));
        actions.put(RemoveCardTypeAction.class.getName(), PermissionActionPolicy.create(AdminSystemPermission.CARD_TYPES_MANAGE));
        actions.put(RemovePosAction.class.getName(), PermissionActionPolicy.create(AdminMemberPermission.POS_MANAGE, BrokerPermission.POS_MANAGE));
        actions.put(RequestPaymentAction.class.getName(), PermissionActionPolicy.create(MemberPermission.PAYMENTS_REQUEST, OperatorPermission.PAYMENTS_REQUEST));
        actions.put(SearchAdminsAction.class.getName(), PermissionActionPolicy.create(AdminAdminPermission.ADMINS_VIEW));
        actions.put(SearchAdsAction.class.getName(), OrActionPolicy.create(ModuleActionPolicy.create(Module.ADMIN_MEMBER_ADS), PermissionActionPolicy.create(MemberPermission.ADS_VIEW)));
        actions.put(SearchAlertsAction.class.getName(), PermissionActionPolicy.create(AdminSystemPermission.ALERTS_VIEW_SYSTEM_ALERTS, AdminSystemPermission.ALERTS_VIEW_MEMBER_ALERTS));
        actions.put(SearchBrokerCommissionContractsAction.class.getName(), PermissionActionPolicy.create(BrokerPermission.MEMBERS_MANAGE_CONTRACTS));
        actions.put(SearchCardsAsBrokerAction.class.getName(), PermissionActionPolicy.create(BrokerPermission.CARDS_VIEW));
        actions.put(SearchCardsNormalAction.class.getName(), PermissionActionPolicy.create(AdminMemberPermission.CARDS_VIEW, MemberPermission.CARDS_VIEW));
        actions.put(SearchCertificationsAction.class.getName(), PermissionActionPolicy.create(AdminMemberPermission.GUARANTEES_VIEW_CERTIFICATIONS, MemberPermission.GUARANTEES_ISSUE_CERTIFICATIONS, MemberPermission.GUARANTEES_BUY_WITH_PAYMENT_OBLIGATIONS, OperatorPermission.GUARANTEES_ISSUE_CERTIFICATIONS, OperatorPermission.GUARANTEES_BUY_WITH_PAYMENT_OBLIGATIONS));
        actions.put(SearchErrorLogAction.class.getName(), PermissionActionPolicy.create(AdminSystemPermission.ERROR_LOG_VIEW));
        actions.put(SearchGuaranteesAction.class.getName(), OrActionPolicy.create(ElementActionPolicy.create(Element.Nature.MEMBER, Element.Nature.OPERATOR), PermissionActionPolicy.create(AdminMemberPermission.GUARANTEES_VIEW_GUARANTEES)));
        actions.put(SearchInfoTextsAction.class.getName(), PermissionActionPolicy.create(AdminSystemPermission.INFO_TEXTS_VIEW));
        actions.put(SearchInvoicesAction.class.getName(), PermissionActionPolicy.create(AdminMemberPermission.INVOICES_ACCEPT, AdminMemberPermission.INVOICES_CANCEL, AdminMemberPermission.INVOICES_DENY, MemberPermission.INVOICES_VIEW, OperatorPermission.INVOICES_VIEW));
        actions.put(SearchLoanGroupsAction.class.getName(), PermissionActionPolicy.create(AdminSystemPermission.LOAN_GROUPS_VIEW));
        actions.put(SearchLoanPaymentsAction.class.getName(), PermissionActionPolicy.create(AdminMemberPermission.LOANS_VIEW));
        actions.put(SearchLoansAction.class.getName(), PermissionActionPolicy.create(AdminMemberPermission.LOANS_VIEW, MemberPermission.LOANS_VIEW, OperatorPermission.LOANS_VIEW));
        actions.put(SearchMemberRecordsAction.class.getName(), PermissionActionPolicy.create(AdminMemberPermission.RECORDS_VIEW, BrokerPermission.MEMBER_RECORDS_VIEW));
        actions.put(SearchMembersAction.class.getName(), PermissionActionPolicy.create(AdminMemberPermission.MEMBERS_VIEW, MemberPermission.PROFILE_VIEW));
        actions.put(SearchMessagesAction.class.getName(), PermissionActionPolicy.create(AdminMemberPermission.MESSAGES_VIEW, MemberPermission.MESSAGES_VIEW, OperatorPermission.MESSAGES_VIEW));
        actions.put(SearchOperatorsAction.class.getName(), PermissionActionPolicy.create(MemberPermission.OPERATORS_MANAGE));
        actions.put(SearchPaymentObligationsAction.class.getName(), PermissionActionPolicy.create(AdminMemberPermission.GUARANTEES_VIEW_PAYMENT_OBLIGATIONS, MemberPermission.GUARANTEES_SELL_WITH_PAYMENT_OBLIGATIONS, MemberPermission.GUARANTEES_BUY_WITH_PAYMENT_OBLIGATIONS, OperatorPermission.GUARANTEES_SELL_WITH_PAYMENT_OBLIGATIONS, OperatorPermission.GUARANTEES_BUY_WITH_PAYMENT_OBLIGATIONS));
        actions.put(SearchPendingMembersAction.class.getName(), PermissionActionPolicy.create(AdminMemberPermission.MEMBERS_MANAGE_PENDING, BrokerPermission.MEMBERS_MANAGE_PENDING));
        actions.put(SearchPosAction.class.getName(), PermissionActionPolicy.create(AdminMemberPermission.POS_VIEW, BrokerPermission.POS_VIEW));
        actions.put(SearchScheduledPaymentsAction.class.getName(), PermissionActionPolicy.create(AdminSystemPermission.ACCOUNTS_SCHEDULED_INFORMATION, MemberPermission.ACCOUNT_SCHEDULED_INFORMATION, OperatorPermission.ACCOUNT_SCHEDULED_INFORMATION));
        actions.put(SearchServiceClientsAction.class.getName(), PermissionActionPolicy.create(AdminSystemPermission.SERVICE_CLIENTS_VIEW));
        actions.put(SearchSmsLogsAction.class.getName(), PermissionActionPolicy.create(AdminMemberPermission.SMS_VIEW, BrokerPermission.MEMBER_SMS_VIEW, MemberPermission.SMS_VIEW));
        actions.put(SearchSmsLogsAction.class.getName(), PermissionActionPolicy.create(AdminMemberPermission.SMS_VIEW, MemberPermission.SMS_VIEW));
        actions.put(SearchSmsMailingsAction.class.getName(), PermissionActionPolicy.create(AdminMemberPermission.SMS_MAILINGS_VIEW, BrokerPermission.SMS_MAILINGS_FREE_SMS_MAILINGS, BrokerPermission.SMS_MAILINGS_PAID_SMS_MAILINGS));
        actions.put(SearchTransferAuthorizationsAction.class.getName(), PermissionActionPolicy.create(AdminSystemPermission.PAYMENTS_AUTHORIZE, AdminMemberPermission.PAYMENTS_AUTHORIZE, BrokerPermission.MEMBER_PAYMENTS_AUTHORIZE, MemberPermission.PAYMENTS_AUTHORIZE, OperatorPermission.PAYMENTS_AUTHORIZE));
        actions.put(SearchTranslationMessagesAction.class.getName(), PermissionActionPolicy.create(AdminSystemPermission.TRANSLATION_VIEW));
        actions.put(SelectDocumentAction.class.getName(), ElementActionPolicy.create(Element.Nature.ADMIN, Element.Nature.MEMBER));
        actions.put(SelectThemeAction.class.getName(), ModuleActionPolicy.create(Module.SYSTEM_THEMES));
        actions.put(SelfPaymentAction.class.getName(), PermissionActionPolicy.create(AdminSystemPermission.PAYMENTS_PAYMENT, MemberPermission.PAYMENTS_PAYMENT_TO_SELF, OperatorPermission.PAYMENTS_PAYMENT_TO_SELF, BrokerPermission.MEMBER_PAYMENTS_PAYMENT_AS_MEMBER_TO_SELF));
        actions.put(SendInvoiceAction.class.getName(), SendInvoiceActionPolicy.instance());
        actions.put(SendMessageAction.class.getName(), SendMessageActionPolicy.instance());
        actions.put(SendSmsMailingAction.class.getName(), PermissionActionPolicy.create(AdminMemberPermission.SMS_MAILINGS_FREE_SMS_MAILINGS, AdminMemberPermission.SMS_MAILINGS_PAID_SMS_MAILINGS, BrokerPermission.SMS_MAILINGS_FREE_SMS_MAILINGS, BrokerPermission.SMS_MAILINGS_PAID_SMS_MAILINGS));
        actions.put(SimulationsSelectAction.class.getName(), PermissionActionPolicy.create(AdminSystemPermission.REPORTS_SIMULATIONS));
        actions.put(SmsLogsReportAction.class.getName(), PermissionActionPolicy.create(AdminSystemPermission.REPORTS_SMS_LOGS));
        actions.put(StatisticsSelectAction.class.getName(), PermissionActionPolicy.create(AdminSystemPermission.REPORTS_STATISTICS));
        actions.put(SystemImagesAction.class.getName(), PermissionActionPolicy.create(AdminSystemPermission.CUSTOM_IMAGES_VIEW));
        actions.put(TransfersAwaitingAuthorizationAction.class.getName(), PermissionActionPolicy.create(AdminSystemPermission.PAYMENTS_AUTHORIZE, AdminMemberPermission.PAYMENTS_AUTHORIZE, BrokerPermission.MEMBER_PAYMENTS_AUTHORIZE, MemberPermission.PAYMENTS_AUTHORIZE, OperatorPermission.PAYMENTS_AUTHORIZE));
        actions.put(UpdateCardAction.class.getName(), PermissionActionPolicy.create(AdminMemberPermission.CARDS_VIEW, BrokerPermission.CARDS_VIEW, MemberPermission.CARDS_VIEW));
        actions.put(ViewDynamicDocumentAction.class.getName(), PermissionActionPolicy.create(AdminMemberPermission.DOCUMENTS_DETAILS, MemberPermission.DOCUMENTS_VIEW, BrokerPermission.DOCUMENTS_VIEW));
        actions.put(ViewErrorLogAction.class.getName(), PermissionActionPolicy.create(AdminSystemPermission.ERROR_LOG_VIEW));
        actions.put(ViewStaticDocumentAsBrokerAction.class.getName(), PermissionActionPolicy.create(BrokerPermission.DOCUMENTS_VIEW));
        actions.put(ViewStaticDocumentNormalAction.class.getName(), PermissionActionPolicy.create(AdminMemberPermission.DOCUMENTS_DETAILS, MemberPermission.DOCUMENTS_VIEW));
    }

    public static <T extends Action> ActionPolicy getApplicablePolicy(final String actionClassName) {
        return actions.get(actionClassName);
    }
}