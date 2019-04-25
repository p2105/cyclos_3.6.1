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
package nl.strohalm.cyclos.services.customization;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import nl.strohalm.cyclos.dao.customizations.CustomFieldDAO;
import nl.strohalm.cyclos.dao.customizations.CustomFieldPossibleValueDAO;
import nl.strohalm.cyclos.dao.customizations.CustomFieldValueDAO;
import nl.strohalm.cyclos.entities.Relationship;
import nl.strohalm.cyclos.entities.customization.fields.CustomField;
import nl.strohalm.cyclos.entities.customization.fields.CustomFieldPossibleValue;
import nl.strohalm.cyclos.entities.customization.fields.CustomFieldValue;
import nl.strohalm.cyclos.entities.customization.fields.MemberCustomField;
import nl.strohalm.cyclos.entities.customization.fields.MemberCustomFieldValue;
import nl.strohalm.cyclos.entities.customization.fields.Validation;
import nl.strohalm.cyclos.entities.exceptions.EntityNotFoundException;
import nl.strohalm.cyclos.entities.services.ServiceClient;
import nl.strohalm.cyclos.services.fetch.FetchServiceLocal;
import nl.strohalm.cyclos.services.settings.SettingsServiceLocal;
import nl.strohalm.cyclos.utils.CustomFieldHelper;
import nl.strohalm.cyclos.utils.CustomFieldsContainer;
import nl.strohalm.cyclos.utils.CustomObjectHandler;
import nl.strohalm.cyclos.utils.PropertyHelper;
import nl.strohalm.cyclos.utils.RangeConstraint;
import nl.strohalm.cyclos.utils.RelationshipHelper;
import nl.strohalm.cyclos.utils.StringHelper;
import nl.strohalm.cyclos.utils.access.LoggedUser;
import nl.strohalm.cyclos.utils.cache.Cache;
import nl.strohalm.cyclos.utils.cache.CacheCallback;
import nl.strohalm.cyclos.utils.cache.CacheManager;
import nl.strohalm.cyclos.utils.conversion.CalendarConverter;
import nl.strohalm.cyclos.utils.conversion.ConversionException;
import nl.strohalm.cyclos.utils.conversion.IdConverter;
import nl.strohalm.cyclos.utils.conversion.NumberConverter;
import nl.strohalm.cyclos.utils.validation.InvalidError;
import nl.strohalm.cyclos.utils.validation.LengthValidation;
import nl.strohalm.cyclos.utils.validation.PropertyValidation;
import nl.strohalm.cyclos.utils.validation.UniqueError;
import nl.strohalm.cyclos.utils.validation.ValidationError;
import nl.strohalm.cyclos.utils.validation.ValidationException;
import nl.strohalm.cyclos.utils.validation.Validator;
import nl.strohalm.cyclos.utils.validation.Validator.Property;
import nl.strohalm.cyclos.utils.validation.Validator.PropertyRetrieveStrategy;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.support.PropertyComparator;

/**
 * Base implementation for custom field services
 * @author luis
 */
public abstract class BaseCustomFieldServiceImpl<CF extends CustomField> implements BaseCustomFieldServiceLocal<CF> {

    /**
     * Validator for decimal fields
     * 
     * @author luis
     */
    public final class BigDecimalValidator implements PropertyValidation {
        private static final long serialVersionUID = -7933981104151866154L;

        @Override
        public ValidationError validate(final Object object, final Object property, final Object value) {
            final String str = (String) value;
            final NumberConverter<BigDecimal> numberConverter = settingsService.getLocalSettings().getNumberConverter();
            try {
                numberConverter.valueOf(str);
                return null;
            } catch (final ConversionException e) {
                return new InvalidError();
            }
        }
    }

    /**
     * Retrieving strategy for validating properties
     * @author luis
     */
    public static class CustomFieldRetrievingStrategy implements PropertyRetrieveStrategy {

        private static final long serialVersionUID = 8667919404137289046L;
        private final CustomField field;

        public CustomFieldRetrievingStrategy(final CustomField field) {
            this.field = field;
        }

        @Override
        public Object description(final Object object, final String name) {
            return field;
        }

        @Override
        @SuppressWarnings("unchecked")
        public Object get(final Object object) {
            final Collection<? extends CustomFieldValue> values = (Collection<? extends CustomFieldValue>) PropertyHelper.get(object, "customValues");
            final CustomFieldValue fieldValue = CustomFieldHelper.findByField(field, values);
            return fieldValue == null ? null : fieldValue.getValue();
        }

        @SuppressWarnings("unchecked")
        public void set(final Object object, final Object value) {
            final Collection<? extends CustomFieldValue> values = (Collection<? extends CustomFieldValue>) PropertyHelper.get(object, "customValues");
            final CustomFieldValue fieldValue = CustomFieldHelper.findByField(field, values);
            if (fieldValue != null) {
                if (value instanceof CustomFieldPossibleValue) {
                    fieldValue.setPossibleValue((CustomFieldPossibleValue) value);
                } else {
                    fieldValue.setStringValue(ObjectUtils.toString(value, null));
                }
            }
        }
    }

    /**
     * Validator for date fields
     * 
     * @author luis
     */
    public class DateValidator implements PropertyValidation {
        private static final long serialVersionUID = 5145399976834903999L;

        @Override
        public ValidationError validate(final Object object, final Object property, final Object value) {
            final String str = (String) value;
            final CalendarConverter dateConverter = settingsService.getLocalSettings().getRawDateConverter();
            try {
                final Calendar date = dateConverter.valueOf(str);
                if (date != null) {
                    final int year = date.get(Calendar.YEAR);
                    if (year < 1900 || year > 2100) {
                        return new InvalidError();
                    }
                }
                return null;
            } catch (final ConversionException e) {
                return new InvalidError();
            }
        }
    }

    /**
     * Validator for enumerated fields
     * 
     * @author luis
     */
    public class EnumeratedValidator implements PropertyValidation {
        private static final long serialVersionUID = 5145399976834903999L;

        @Override
        public ValidationError validate(final Object object, final Object property, final Object value) {
            final String str = (String) value;
            if (StringUtils.isEmpty(str)) {
                return null;
            }
            final CustomField field = (CustomField) property;
            CustomFieldPossibleValue possibleValue = null;
            try {
                boolean byValue = true;
                if (StringUtils.isNumeric(str)) {
                    try {
                        possibleValue = customFieldPossibleValueDao.load(new Long(str));
                        if (field.equals(possibleValue.getField())) {
                            byValue = false;
                        }
                    } catch (final EntityNotFoundException e) {
                        // Not found - try by value
                    }
                }
                if (byValue) {
                    // Try by value
                    possibleValue = customFieldPossibleValueDao.load(field.getId(), str);
                }
                // Value exists - return no error
                return null;
            } catch (final EntityNotFoundException e) {
                possibleValue = null;
            }
            // Return error if not found
            return possibleValue == null ? new InvalidError() : null;
        }
    }

    /**
     * Validator for integer fields
     * 
     * @author luis
     */
    public class IntegerValidator implements PropertyValidation {
        private static final long serialVersionUID = 5145399976834903999L;

        @Override
        public ValidationError validate(final Object object, final Object property, final Object value) {
            final String str = (String) value;
            if (StringUtils.isNotEmpty(str) && !StringUtils.isNumeric(str)) {
                return new InvalidError();
            }
            return null;
        }
    }

    /**
     * Validates a java identifier
     * @author Jefferson Magno
     */
    public class JavaIdentifierValidation implements PropertyValidation {
        private static final long serialVersionUID = 259170291118675512L;

        @Override
        public ValidationError validate(final Object object, final Object property, final Object value) {
            final String string = (String) value;
            if (StringUtils.isNotEmpty(string) && !StringHelper.isValidJavaIdentifier(string)) {
                return new InvalidError();
            }
            return null;
        }
    }

    /**
     * Validates the parent field
     * @author luis
     */
    public final class ParentValidator implements PropertyValidation {

        private static final long serialVersionUID = -6383825246336857857L;

        @Override
        @SuppressWarnings("unchecked")
        public ValidationError validate(final Object object, final Object property, final Object value) {
            final CF field = (CF) object;
            final CustomField parent = (CustomField) value;
            if (parent != null) {
                final List<CF> possibleParents = listPossibleParentFields(field);
                if (!possibleParents.contains(parent)) {
                    return new InvalidError();
                }
            }
            return null;
        }

    }

    /**
     * A cache key for possible values. Cannot use the id itself to differentiate it from the field id
     * 
     * @author luis
     */
    public static class PossibleValueKey implements Serializable {
        private static final long serialVersionUID = 6220627534414217532L;
        private final long        id;

        public PossibleValueKey(final long id) {
            this.id = id;
        }

        @Override
        public boolean equals(final Object obj) {
            if (!(obj instanceof PossibleValueKey)) {
                return false;
            }
            PossibleValueKey key = (PossibleValueKey) obj;
            return id == key.id;
        }

        @Override
        public int hashCode() {
            return (int) id;
        }

    }

    /**
     * Validator to ensure the internal name is unique
     * 
     * @author luis
     */
    public class UniqueCustomFieldInternalNameValidation implements PropertyValidation {
        private static final long serialVersionUID = 1L;

        @Override
        public ValidationError validate(final Object object, final Object property, final Object value) {
            final CustomField field = (CustomField) object;

            if (field.getInternalName() == null || field.getInternalName().equals("")) {
                return null;
            }

            return customFieldDao.isInternalNameUsed(field) ? new UniqueError(field.getInternalName()) : null;
        }
    }

    /**
     * Validates an unique field value
     * @author luis
     */
    public class UniqueFieldValueValidation implements PropertyValidation {
        private static final long serialVersionUID = 6222393116036296454L;

        @Override
        public ValidationError validate(final Object object, final Object data, final Object value) {
            if (!(object instanceof CustomFieldsContainer<?, ?>)) {
                return null;
            }
            final CustomField field = (CustomField) data;
            final String string = (String) value;
            if (StringUtils.isNotEmpty(string)) {
                // Build a field value
                CustomFieldValue fieldValue;
                try {
                    fieldValue = field.getNature().getValueType().newInstance();
                } catch (final Exception e) {
                    throw new RuntimeException(e);
                }
                fieldValue.setField(field);
                fieldValue.setOwner(object);
                fieldValue.setStringValue(string);

                // Check uniqueness
                if (customFieldValueDao.valueExists(fieldValue)) {
                    return new UniqueError(fieldValue.getStringValue());
                }
            }
            return null;
        }
    }

    private Validator                     possibleValueNavigator;

    protected static final String         ALL_KEY = "_ALL_";

    protected static final List<String>   EXCLUDED_PROPERTIES_FOR_DEPENDENT_FIELDS;

    static {
        final List<String> excluded = new ArrayList<String>();
        excluded.add("class");
        excluded.add("id");
        excluded.add("name");
        excluded.add("internalName");
        excluded.add("parent");
        excluded.add("description");
        excluded.add("allSelectedLabel");
        excluded.add("type");
        excluded.add("control");
        excluded.add("size");
        excluded.add("description");
        excluded.add("possibleValues");
        excluded.add("children");
        EXCLUDED_PROPERTIES_FOR_DEPENDENT_FIELDS = Collections.unmodifiableList(excluded);
    }

    protected final Class<CF>             customFieldType;
    protected FetchServiceLocal           fetchService;
    protected SettingsServiceLocal        settingsService;
    protected CustomFieldDAO              customFieldDao;
    protected CustomFieldValueDAO         customFieldValueDao;
    protected CustomFieldPossibleValueDAO customFieldPossibleValueDao;
    private CacheManager                  cacheManager;
    protected final Relationship[]        fetch;
    private Validator                     validator;
    protected CustomObjectHandler         customObjectHandler;

    protected BaseCustomFieldServiceImpl(final Class<CF> customFieldType) {
        this.customFieldType = customFieldType;
        Collection<Relationship> fetch = new ArrayList<Relationship>();
        fetch.addAll(Arrays.asList(CustomField.Relationships.POSSIBLE_VALUES, CustomField.Relationships.CHILDREN, RelationshipHelper.nested(CustomField.Relationships.PARENT, CustomField.Relationships.POSSIBLE_VALUES)));
        fetch.addAll(resolveAdditionalFetch());
        this.fetch = fetch.toArray(new Relationship[fetch.size()]);
    }

    @Override
    public void clearCache() {
        getCache().clear();
    }

    @Override
    public List<CF> listPossibleParentFields(final CF field) {
        if (field == null || (field.isPersistent() && field.getType() != CustomField.Type.ENUMERATED)) {
            return new ArrayList<CF>();
        }
        final List<CF> fields = new ArrayList<CF>(list(field));

        // Remove the field itself, those which are not enumerated and those who already have a parent (don't allow multiple levels)
        for (final Iterator<CF> iterator = fields.iterator(); iterator.hasNext();) {
            final CF current = iterator.next();
            if (field.equals(current) || current.getType() != CustomField.Type.ENUMERATED || current.getControl() != CustomField.Control.SELECT || current.getParent() != null) {
                iterator.remove();
            }
        }
        return fields;
    }

    @Override
    public List<CF> load(final Collection<Long> ids) {
        List<CF> result = new ArrayList<CF>(ids.size());
        for (Long id : ids) {
            result.add(load(id));
        }
        return result;
    }

    @Override
    public CF load(final Long id) {
        return getCache().<CF> get(id, new CacheCallback() {
            @Override
            public Object retrieve() {
                return loadChecked(id);
            }
        });
    }

    @Override
    public CustomFieldPossibleValue loadPossibleValue(final Long id) {
        return getCache().get("_POSSIBLE_VALUE_" + id, new CacheCallback() {
            @Override
            public Object retrieve() {
                return loadCheckedPossibleValue(id);
            }
        });
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<CustomFieldPossibleValue> loadPossibleValues(final Collection<Long> ids) {
        List<CustomFieldPossibleValue> result = new ArrayList<CustomFieldPossibleValue>(ids.size());
        for (Long id : ids) {
            result.add(loadPossibleValue(id));
        }
        Collections.sort(result, new BeanComparator("value"));
        return result;
    }

    @Override
    public int remove(final Long... ids) {
        for (Long id : ids) {
            CustomField field = customFieldDao.load(id);
            if (!customFieldType.isInstance(field)) {
                throw new EntityNotFoundException();
            }
        }
        getCache().clear();
        return customFieldDao.delete(ids);
    }

    @Override
    public int removePossibleValue(final Long... ids) {
        for (Long id : ids) {
            loadCheckedPossibleValue(id);
        }
        getCache().clear();
        return customFieldPossibleValueDao.delete(ids);
    }

    @Override
    public int replacePossibleValues(CustomFieldPossibleValue oldValue, CustomFieldPossibleValue newValue) {
        oldValue = fetchService.fetch(oldValue);
        newValue = fetchService.fetch(newValue);
        if (!oldValue.getField().equals(newValue.getField())) {
            throw new ValidationException();
        }
        return customFieldValueDao.moveValues(oldValue, newValue);
    }

    @Override
    public CF save(CF field) {
        // Special handling for fields with a parent field
        CustomField parent = null;
        if (field.getParent() != null) {
            // When the field has a parent, several settings are copied from it
            parent = fetchService.fetch(field.getParent());
            copyParentProperties(parent, field);
        }
        validate(field);
        if (field.isTransient()) {
            field.setChildren(new ArrayList<CustomField>());

            if (parent == null) {
                int maxOrder = 0;
                for (CF cf : list(field)) {
                    if (cf.getOrder() > maxOrder) {
                        maxOrder = cf.getOrder();
                    }
                }
                // Top level fields: set the order after other fields
                field.setOrder(maxOrder + 1);
            } else {
                parent.getChildren().add(field);
            }

            // Save the field
            field = customFieldDao.insert(field);

            if (parent != null) {
                // Nested fields: position the field just after his parent
                final List<Long> order = new ArrayList<Long>();
                List<CF> allFields = list(field);
                for (int i = 0; i < allFields.size(); i++) {
                    CF cf = allFields.get(i);
                    if (cf.getParent() != null) {
                        continue;
                    }
                    order.add(cf.getId());
                }
                setOrder(order);
            }
        } else {
            // Keep the order
            final CustomField current = customFieldDao.load(field.getId());
            field.setOrder(current.getOrder());

            field = customFieldDao.update(field);

            // Update the dependent properties for child fields
            if (field.getType() == CustomField.Type.ENUMERATED) {
                field = fetchService.reload(field, CustomField.Relationships.CHILDREN);
                for (final CustomField child : field.getChildren()) {
                    copyParentProperties(field, child);
                }
            }
        }
        getCache().clear();
        return field;
    }

    @Override
    public CustomFieldPossibleValue save(CustomFieldPossibleValue possibleValue) throws ValidationException {
        validate(possibleValue);
        try {
            if (possibleValue.isTransient()) {
                possibleValue = customFieldPossibleValueDao.insert(possibleValue);
            } else {
                possibleValue = customFieldPossibleValueDao.update(possibleValue);
            }
            customFieldPossibleValueDao.ensureDefault(possibleValue);
        } finally {
            getCache().clear();
        }
        return possibleValue;
    }

    public void setCacheManager(final CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    public final void setCustomFieldDao(final CustomFieldDAO customFieldDao) {
        this.customFieldDao = customFieldDao;
    }

    public final void setCustomFieldPossibleValueDao(final CustomFieldPossibleValueDAO customFieldPossibleValueDao) {
        this.customFieldPossibleValueDao = customFieldPossibleValueDao;
    }

    public final void setCustomFieldValueDao(final CustomFieldValueDAO customFieldValueDao) {
        this.customFieldValueDao = customFieldValueDao;
    }

    public void setCustomObjectHandler(final CustomObjectHandler customObjectHandler) {
        this.customObjectHandler = customObjectHandler;
    }

    public void setFetchServiceLocal(final FetchServiceLocal fetchService) {
        this.fetchService = fetchService;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void setOrder(final List<Long> ids) {
        int order = 0;
        for (Long id : ids) {
            CF field = loadChecked(id);
            field.setOrder(++order);
            List<CustomField> children = new ArrayList<CustomField>(field.getChildren());
            if (CollectionUtils.isNotEmpty(children)) {
                Collections.sort(children, new PropertyComparator("name", true, true));
                for (CustomField child : children) {
                    child.setOrder(++order);
                }
            }
        }
        getCache().clear();
    }

    public final void setSettingsServiceLocal(final SettingsServiceLocal settingsService) {
        this.settingsService = settingsService;
    }

    @Override
    public void validate(final CF field) {
        getValidator().validate(field);
    }

    @Override
    public void validate(final CustomFieldPossibleValue possibleValue) throws ValidationException {
        getPossibleValueValidator().validate(possibleValue);
    }

    /**
     * May be overridden in order to append any custom validations
     */
    protected void appendValidations(final Validator validator) {
    }

    protected void doSaveValues(final CustomFieldsContainer<?, ?> owner) {
        final Collection<? extends CustomFieldValue> customValues = owner.getCustomValues();
        if (customValues == null || customValues.isEmpty()) {
            return;
        }

        for (final CustomFieldValue value : customValues) {
            // Retrieve the field value
            final CustomField field = fetchService.fetch(value.getField());
            value.setField(field);
            final boolean enumerated = field.getType() == CustomField.Type.ENUMERATED;
            CustomFieldPossibleValue possibleValue = null;
            String stringValue = null;
            if (enumerated) {
                // Load the possible value
                final Long possibleValueId = IdConverter.instance().valueOf(value.getValue());
                boolean tryByValue = possibleValueId == null;
                if (possibleValueId != null) {
                    // Try by id
                    try {
                        possibleValue = customFieldPossibleValueDao.load(possibleValueId);
                    } catch (final EntityNotFoundException e) {
                        tryByValue = true;
                    }
                }
                if (tryByValue && StringUtils.isNotEmpty(value.getValue())) {
                    // Try by field id + value
                    try {
                        possibleValue = customFieldPossibleValueDao.load(field.getId(), value.getValue());
                    } catch (final EntityNotFoundException e) {
                        final ValidationException vex = new ValidationException(field.getInternalName(), new InvalidError());
                        vex.setDisplayNameByProperty(Collections.singletonMap(field.getInternalName(), field.getName()));
                        throw vex;
                    }
                }
            } else {
                if ((field.getType() != CustomField.Type.STRING) || (field.getControl() != CustomField.Control.RICH_EDITOR)) {
                    stringValue = StringHelper.removeMarkupTags(value.getValue());
                } else {
                    stringValue = value.getValue();
                }

                // A String value
                stringValue = StringUtils.trimToNull(stringValue);
                if (StringUtils.isNotEmpty(field.getPattern())) {
                    stringValue = StringHelper.removeMask(field.getPattern(), stringValue);
                }
            }
            // Check if the value exists for the given owner
            try {
                final CustomFieldValue existing = customFieldValueDao.load(field, owner);
                // Exists - just update the value
                existing.setStringValue(stringValue);
                existing.setPossibleValue(possibleValue);
                if (value instanceof MemberCustomFieldValue) {
                    ((MemberCustomFieldValue) existing).setHidden(((MemberCustomFieldValue) value).isHidden());
                }
                customFieldValueDao.update(existing);
            } catch (final EntityNotFoundException e) {
                // Does not exists yet - insert a new value
                value.setOwner(owner);
                value.setStringValue(stringValue);
                value.setPossibleValue(possibleValue);
                if (value.isTransient()) {
                    customFieldValueDao.insert(value);
                } else {
                    customFieldValueDao.update(value);
                }
            }
        }
    }

    protected Cache getCache() {
        return cacheManager.getCache("cyclos.cache.CustomFields." + customFieldType.getSimpleName());
    }

    protected Validator getValueValidator(final Collection<? extends CustomField> fields) {
        final Validator validator = new Validator();

        for (CustomField field : fields) {
            field = fetchService.fetch(field);
            final Property property = validator.property(field.getInternalName(), new CustomFieldRetrievingStrategy(field));
            property.displayName(field.getName());

            switch (field.getType()) {
                case BOOLEAN:
                    property.anyOf("true", "false");
                    break;
                case INTEGER:
                    property.add(new IntegerValidator());
                    break;
                case DATE:
                    property.add(new DateValidator());
                    break;
                case ENUMERATED:
                    property.add(new EnumeratedValidator());
                    break;
                case BIG_DECIMAL:
                    property.add(new BigDecimalValidator());
                    break;
                case URL:
                    property.url();
                    break;
            }

            final Validation validation = field.getValidation();
            if (validation != null) {
                // Check required
                boolean ignoreRequired = false;
                if (field instanceof MemberCustomField) {
                    ServiceClient client = LoggedUser.serviceClient();
                    ignoreRequired = client != null && client.isIgnoreRegistrationValidations();
                }
                if (validation.isRequired() && !ignoreRequired) {
                    property.required();
                }
                // Check length constraint
                final RangeConstraint lengthConstraint = validation.getLengthConstraint();
                if (lengthConstraint != null) {
                    property.add(new LengthValidation(lengthConstraint));
                }
                // Check unique
                if (validation.isUnique()) {
                    property.add(new UniqueFieldValueValidation());
                }
                // Custom validator class
                if (StringUtils.isNotEmpty(validation.getValidatorClass())) {
                    final PropertyValidation validatorClass = customObjectHandler.get(validation.getValidatorClass());
                    property.add(validatorClass);
                }
            }
        }
        return validator;
    }

    /**
     * Should be implemented in order to list all fields like the given one. When fields are not dependent on other entities (like member / ads /
     * admin / loan group) should return all. For others, like member record, should return all fields in the same member record as the given field
     */
    protected abstract List<CF> list(CF field);

    /**
     * Must be implemented in order to resolve additional fetch to be applied before fields are stored on the cache
     */
    protected Collection<? extends Relationship> resolveAdditionalFetch() {
        return Collections.emptySet();
    }

    @SuppressWarnings("unchecked")
    private void copyParentProperties(final CustomField parent, final CustomField child) {
        final PropertyDescriptor[] propertyDescriptors = PropertyUtils.getPropertyDescriptors(parent);
        for (final PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            final String name = propertyDescriptor.getName();
            final boolean isWritable = propertyDescriptor.getWriteMethod() != null;
            final boolean isReadable = propertyDescriptor.getReadMethod() != null;
            if (isReadable && isWritable && !EXCLUDED_PROPERTIES_FOR_DEPENDENT_FIELDS.contains(name)) {
                Object value = PropertyHelper.get(parent, name);
                if (value instanceof Collection) {
                    value = new ArrayList<Object>((Collection<Object>) value);
                }
                PropertyHelper.set(child, name, value);
            }
        }
    }

    private Validator getPossibleValueValidator() {
        if (possibleValueNavigator == null) {
            final Validator validator = new Validator("customField.possibleValue");
            validator.property("field").required();
            validator.property("value").required().maxLength(255);
            possibleValueNavigator = validator;
        }
        return possibleValueNavigator;
    }

    private Validator getValidator() {
        if (validator == null) {
            // We use a separate variable name to avoid concurrency problems with 2 threads modifying the same reference
            Validator val = new Validator("customField");
            val.property("internalName").required().maxLength(50).add(new JavaIdentifierValidation()).add(new UniqueCustomFieldInternalNameValidation());
            val.property("name").required().maxLength(100);
            val.property("type").required();
            val.property("control").required();
            val.property("size").required();
            val.property("parent").add(new ParentValidator());
            val.property("validation.validatorClass").instanceOf(PropertyValidation.class);
            appendValidations(val);
            validator = val;
        }
        return validator;
    }

    /**
     * Loads a field, but only if it is of the expected type. Otherwise, throws an {@link EntityNotFoundException}
     */
    private CF loadChecked(final Long id) {
        CF field = customFieldDao.<CF> load(id, fetch);
        if (!customFieldType.isInstance(field)) {
            throw new EntityNotFoundException();
        }
        return field;
    }

    /**
     * Loads a possible value, fetching both parent and field relationships, but throws an {@link EntityNotFoundException} if the field is not of the
     * expected type
     */
    private CustomFieldPossibleValue loadCheckedPossibleValue(final Long id) {
        CustomFieldPossibleValue possibleValue = customFieldPossibleValueDao.load(id, CustomFieldPossibleValue.Relationships.PARENT, CustomFieldPossibleValue.Relationships.FIELD);
        if (!customFieldType.isInstance(possibleValue.getField())) {
            throw new EntityNotFoundException();
        }
        return possibleValue;
    }

}
