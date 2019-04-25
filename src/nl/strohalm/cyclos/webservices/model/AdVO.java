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
package nl.strohalm.cyclos.webservices.model;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * Ad data for web services
 * @author luis
 */
@XmlType(name = "ad")
public class AdVO extends WebServicesEntityVO {
    private static final long   serialVersionUID = -8858953643445522743L;
    private AdCategoryVO        category;
    private String              title;
    private String              description;
    private MemberVO            owner;
    private CurrencyVO          currency;
    private BigDecimal          price;
    private String              formattedPrice;
    private List<FieldValueVO>  fields;
    @XmlTransient
    private Map<String, String> fieldsMap;
    private List<ImageVO>       images;
    private boolean             permanent;
    private Calendar            publicationStart;
    private String              formattedPublicationStart;
    private Calendar            publicationEnd;
    private String              formattedPublicationEnd;
    private boolean             searching;
    private boolean             html;

    public AdCategoryVO getCategory() {
        return category;
    }

    public CurrencyVO getCurrency() {
        return currency;
    }

    public String getDescription() {
        return description;
    }

    public List<FieldValueVO> getFields() {
        return fields;
    }

    public Map<String, String> getFieldsMap() {
        if (fieldsMap == null) {
            if (fields != null) {
                fieldsMap = new HashMap<String, String>();
                for (final FieldValueVO vo : fields) {
                    fieldsMap.put(vo.getField(), vo.getValue());
                }
            } else {
                fieldsMap = Collections.emptyMap();
            }
        }
        return fieldsMap;
    }

    public String getFormattedPrice() {
        return formattedPrice;
    }

    public String getFormattedPublicationEnd() {
        return formattedPublicationEnd;
    }

    public String getFormattedPublicationStart() {
        return formattedPublicationStart;
    }

    public List<ImageVO> getImages() {
        return images;
    }

    public MemberVO getOwner() {
        return owner;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Calendar getPublicationEnd() {
        return publicationEnd;
    }

    public Calendar getPublicationStart() {
        return publicationStart;
    }

    public String getTitle() {
        return title;
    }

    public boolean isHtml() {
        return html;
    }

    public boolean isPermanent() {
        return permanent;
    }

    public boolean isSearching() {
        return searching;
    }

    public void setCategory(final AdCategoryVO category) {
        this.category = category;
    }

    public void setCurrency(final CurrencyVO currency) {
        this.currency = currency;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setFields(final List<FieldValueVO> fields) {
        this.fields = fields;
    }

    public void setFormattedPrice(final String formattedPrice) {
        this.formattedPrice = formattedPrice;
    }

    public void setFormattedPublicationEnd(final String formattedPublicationEnd) {
        this.formattedPublicationEnd = formattedPublicationEnd;
    }

    public void setFormattedPublicationStart(final String formattedPublicationStart) {
        this.formattedPublicationStart = formattedPublicationStart;
    }

    public void setHtml(final boolean html) {
        this.html = html;
    }

    public void setImages(final List<ImageVO> images) {
        this.images = images;
    }

    public void setOwner(final MemberVO owner) {
        this.owner = owner;
    }

    public void setPermanent(final boolean permanent) {
        this.permanent = permanent;
    }

    public void setPrice(final BigDecimal price) {
        this.price = price;
    }

    public void setPublicationEnd(final Calendar publicationEnd) {
        this.publicationEnd = publicationEnd;
    }

    public void setPublicationStart(final Calendar publicationStart) {
        this.publicationStart = publicationStart;
    }

    public void setSearching(final boolean searching) {
        this.searching = searching;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        final StringBuilder buffer = new StringBuilder();
        buffer.append("AdVO[");
        buffer.append("category=" + category.toString() + ", title=" + title + ", description=" + description + ", owner=" + owner.toString() + ", currency=" + currency.toString() + ", price=" + price + ", formattedPrice=" + formattedPrice + ", permanent=" + permanent + ", publicationStart=" + publicationStart + ", formattedPublicationStart=" + formattedPublicationStart + ", publicationEnd=" + publicationEnd + ", formattedPublicationEnd=" + formattedPublicationEnd + ", searching=" + searching + ", html=" + html);

        for (final FieldValueVO vo : fields) {
            buffer.append(", " + vo.toString());
        }

        buffer.append("]");

        return buffer.toString();
    }

}
