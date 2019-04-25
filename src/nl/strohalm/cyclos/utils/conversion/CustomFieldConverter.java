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
package nl.strohalm.cyclos.utils.conversion;

import java.util.Collection;

import nl.strohalm.cyclos.entities.customization.fields.CustomField;
import nl.strohalm.cyclos.entities.customization.fields.CustomFieldPossibleValue;
import nl.strohalm.cyclos.entities.customization.fields.CustomFieldValue;
import nl.strohalm.cyclos.utils.StringHelper;

import org.apache.commons.lang.StringUtils;

/**
 * Converter for custom field value collections
 * @author luis
 */
public class CustomFieldConverter extends FormatOnlyConverter<Collection<? extends CustomFieldValue>> {

    private static final long serialVersionUID = -2712015051659215620L;
    private final CustomField customField;

    public CustomFieldConverter(final CustomField customField) {
        this.customField = customField;
    }

    @Override
    public String toString(final Collection<? extends CustomFieldValue> values) {
        if (values == null || values.isEmpty()) {
            return null;
        }
        CustomFieldValue value = null;
        for (final CustomFieldValue current : values) {
            if (customField.equals(current.getField())) {
                value = current;
                break;
            }
        }
        String fieldValue = null;
        if (value != null) {
            if (customField.getType() == CustomField.Type.ENUMERATED) {
                if (value.getPossibleValue() != null) {
                    fieldValue = value.getPossibleValue().getValue();
                } else {
                    final Collection<CustomFieldPossibleValue> possibleValues = customField.getPossibleValues();
                    for (final CustomFieldPossibleValue possibleValue : possibleValues) {
                        if (String.valueOf(possibleValue.getId()).equals(value.getValue())) {
                            fieldValue = possibleValue.getValue();
                            break;
                        }
                    }
                }
            } else {
                fieldValue = value.getValue();
                if (StringUtils.isNotEmpty(customField.getPattern())) {
                    fieldValue = StringHelper.applyMask(customField.getPattern(), fieldValue);
                }
            }
        }
        return fieldValue;
    }
}
