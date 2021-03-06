/*
 * Copyright (C) 2012 United States Government as represented by the Administrator of the
 * National Aeronautics and Space Administration.
 * All Rights Reserved.
 */

package gov.nasa.worldwind.retrieve;

import gov.nasa.worldwind.util.Logging;

import java.net.*;
import java.nio.ByteBuffer;

/**
 * @author Tom Gaskins
 * @version $Id: HTTPRetriever.java 733 2012-09-02 17:15:09Z dcollins $
 */
public class HTTPRetriever extends URLRetriever
{
    private int responseCode;
    private String responseMessage;

    public HTTPRetriever(URL url, RetrievalPostProcessor postProcessor)
    {
        super(url, postProcessor);
    }

    public int getResponseCode()
    {
        return this.responseCode;
    }

    public String getResponseMessage()
    {
        return this.responseMessage;
    }

    @Override
    protected ByteBuffer doRead(URLConnection connection) throws Exception
    {
        if (connection == null)
        {
            String msg = Logging.getMessage("nullValue.ConnectionIsNull");
            Logging.error(msg);
            throw new IllegalArgumentException(msg);
        }

        HttpURLConnection htpc = (HttpURLConnection) connection;
        this.responseCode = htpc.getResponseCode();
        this.responseMessage = htpc.getResponseMessage();
        String contentType = connection.getContentType();

        String msg = Logging.getMessage("HTTPRetriever.ResponseInfo", this.responseCode, connection.getContentLength(),
            contentType != null ? contentType : "content type not returned", connection.getURL());
        Logging.verbose(msg);

        if (this.responseCode == HttpURLConnection.HTTP_OK)
            return super.doRead(connection);

        return null;
    }
}
