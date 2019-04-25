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
package nl.strohalm.cyclos.http;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import nl.strohalm.cyclos.utils.ReadableByteArrayOutputStream;

import org.apache.commons.io.IOUtils;

/**
 * A response wrapper which prevents flushing the buffer until really needed
 * 
 * @author luis
 */
public class ForcedBufferResponse extends HttpServletResponseWrapper {

    private static class DelegatingServletOutputStream extends ServletOutputStream {

        private OutputStream out;

        private DelegatingServletOutputStream(final OutputStream out) {
            this.out = out;
        }

        @Override
        public void close() throws IOException {
            out.close();
        }

        @Override
        public void flush() throws IOException {
            out.flush();
        }

        @Override
        public void write(final byte[] b) throws IOException {
            out.write(b);
        }

        @Override
        public void write(final byte[] b, final int off, final int len) throws IOException {
            out.write(b, off, len);
        }

        @Override
        public void write(final int b) throws IOException {
            out.write(b);
        }
    }

    private ReadableByteArrayOutputStream out;
    private ServletOutputStream           servletOutputStream;
    private StringWriter                  writer;
    private PrintWriter                   printWriter;
    private HttpServletResponse           wrapped;

    public ForcedBufferResponse(final HttpServletResponse response) {
        super(response);
        wrapped = response;
    }

    public void doFlushBuffer() throws IOException {
        if (writer != null) {
            wrapped.getWriter().write(writer.toString());
        } else if (out != null) {
            IOUtils.copy(out.getInputStream(), wrapped.getOutputStream());
        }
        wrapped.flushBuffer();
    }

    @Override
    public void flushBuffer() throws IOException {
        // no-op
    }

    @Override
    public int getBufferSize() {
        return Integer.MAX_VALUE;
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        if (out == null) {
            if (writer != null) {
                throw new IllegalStateException("The getWriter() was already invoked for this response");
            }
            out = new ReadableByteArrayOutputStream(1024);
            servletOutputStream = new DelegatingServletOutputStream(out);
        }
        return servletOutputStream;
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        if (writer == null) {
            if (out != null) {
                throw new IllegalStateException("The getOutputStream() was already invoked for this response");
            }
            writer = new StringWriter(1024);
            printWriter = new PrintWriter(writer);
        }
        return printWriter;
    }

    @Override
    public void setBufferSize(final int size) {
        // No-op
    }

}
