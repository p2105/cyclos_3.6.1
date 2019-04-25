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
package nl.strohalm.cyclos.taglibs;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

/**
 * Tag used to layout contents in columns
 * @author luis
 */
public class LayoutTag extends AbstractDynamicAttributesTag {

    private static final long serialVersionUID = -6454157579897906611L;
    private int               columns;
    private int               currentColumn;

    public void breakRow() throws JspException {
        if (currentColumn > 0) {
            final JspWriter out = pageContext.getOut();
            try {
                out.print("</tr><tr>");
            } catch (final IOException e) {
                throw new JspException(e);
            }
            currentColumn = 0;
        }
    }

    @Override
    public int doEndTag() throws JspException {
        final JspWriter out = pageContext.getOut();
        try {
            out.print("</tr></table>");
        } catch (final IOException e) {
            throw new JspException(e);
        } finally {
            release();
        }
        return EVAL_PAGE;
    }

    @Override
    public int doStartTag() throws JspException {
        final JspWriter out = pageContext.getOut();
        try {
            out.print("<table" + attributesForTag() + "><tr>");
        } catch (final IOException e) {
            throw new JspException(e);
        }
        return EVAL_BODY_INCLUDE;
    }

    public void finishCell(final int colspan) throws JspException {
        currentColumn += colspan;
        if (currentColumn >= columns) {
            breakRow();
        }
    }

    public int getColumns() {
        return columns;
    }

    @Override
    public void release() {
        super.release();
        columns = 0;
        currentColumn = 0;
    }

    public void setColumns(final int columns) {
        this.columns = columns;
    }

    @Override
    protected String attributesForTag() {
        final Map<String, String> replacements = new HashMap<String, String>();
        replacements.put("className", "class");
        replacements.put("elementId", "id");
        return super.attributesForTag(replacements);
    }

    @Override
    protected Map<String, Object> defaultAttributes() {
        final Map<String, Object> map = super.defaultAttributes();
        map.put("className", "defaultTable");
        return map;
    }
}
