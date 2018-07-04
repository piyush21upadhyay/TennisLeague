/*
 * GZIPResponseStream.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.filter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

/**
 * Wraps Response Stream for GZipFilter
 */
public class GZIPResponseStream extends ServletOutputStream
{
    // abstraction of the output stream used for compression
    protected OutputStream bufferedOutput = null;

    // state keeping variable for if close() has been called
    protected boolean closed = false;

    // reference to original response
    protected HttpServletResponse response = null;

    // reference to the output stream to the client's browser
    protected ServletOutputStream output = null;

    // default size of the in-memory buffer
    private int bufferSize = 50000;

    public GZIPResponseStream(HttpServletResponse resp) throws IOException
    {
        super();
        this.closed = false;
        this.response = resp;
        this.output = resp.getOutputStream();
        this.bufferedOutput = new ByteArrayOutputStream();
    }

    @Override
    public void close() throws IOException
    {
        // verify the stream is yet to be closed
        if (this.closed)
        {
            throw new IOException("This output stream has already been closed"); //$NON-NLS-1$
        }

        // if we buffered everything in memory, gzip it
        if (this.bufferedOutput instanceof ByteArrayOutputStream)
        {
            // get the content
            ByteArrayOutputStream baos = (ByteArrayOutputStream) this.bufferedOutput;

            // prepare a gzip stream
            ByteArrayOutputStream compressedContent = new ByteArrayOutputStream();
            GZIPOutputStream gzipstream = new GZIPOutputStream(compressedContent);
            byte[] bytes = baos.toByteArray();
            gzipstream.write(bytes);
            gzipstream.finish();

            // get the compressed content
            byte[] compressedBytes = compressedContent.toByteArray();

            // set appropriate HTTP headers
            this.response.setContentLength(compressedBytes.length);
            this.response.addHeader("Content-Encoding", "gzip"); //$NON-NLS-1$ //$NON-NLS-2$
            this.output.write(compressedBytes);
            this.output.flush();
            this.output.close();
            this.closed = true;
        }
        // if things were not buffered in memory, finish the GZIP stream and
        // response
        else if (this.bufferedOutput instanceof GZIPOutputStream)
        {
            // cast to appropriate type
            GZIPOutputStream gzipstream = (GZIPOutputStream) this.bufferedOutput;

            // finish the compression
            gzipstream.finish();

            // finish the response
            this.output.flush();
            this.output.close();
            this.closed = true;
        }
    }

    @Override
    public void flush() throws IOException
    {
        if (this.closed)
        {
            throw new IOException("Cannot flush a closed output stream"); //$NON-NLS-1$
        }

        this.bufferedOutput.flush();
    }

    @Override
    public void write(int b) throws IOException
    {
        if (this.closed)
        {
            throw new IOException("Cannot write to a closed output stream"); //$NON-NLS-1$
        }

        // make sure we aren't over the buffer's limit
        checkBufferSize(1);

        // write the byte to the temporary output
        this.bufferedOutput.write((byte) b);
    }

    private void checkBufferSize(int length) throws IOException
    {
        // check if we are buffering too large of a file
        if (this.bufferedOutput instanceof ByteArrayOutputStream)
        {
            ByteArrayOutputStream baos = (ByteArrayOutputStream) this.bufferedOutput;

            if ((baos.size() + length) > this.bufferSize)
            {
                // files too large to keep in memory are sent to the client
                // without Content-Length specified
                this.response.addHeader("Content-Encoding", "gzip"); //$NON-NLS-1$ //$NON-NLS-2$

                // get existing bytes
                byte[] bytes = baos.toByteArray();

                // make new gzip stream using the response output stream
                GZIPOutputStream gzipstream = new GZIPOutputStream(this.output);
                gzipstream.write(bytes);

                // we are no longer buffering, send content via gzipstream
                this.bufferedOutput = gzipstream;
            }
        }
    }

    @Override
    public void write(byte[] b) throws IOException
    {
        write(b, 0, b.length);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException
    {

        if (this.closed)
        {
            throw new IOException("Cannot write to a closed output stream"); //$NON-NLS-1$
        }

        // make sure we aren't over the buffer's limit
        checkBufferSize(len);

        // write the content to the buffer
        this.bufferedOutput.write(b, off, len);
    }

    public boolean closed()
    {
        return (this.closed);
    }

    public void reset()
    {
        // noop
    }
}
