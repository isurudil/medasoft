package com.medasoft.util;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by isurud on 4/23/14.
 */
public class RestClient {

    private static final Logger LOGGER = Logger.getLogger(RestClient.class);

    public String post(String url,HashMap parameterMap){

        String output = null;
        HttpClient client = new HttpClient();
        PostMethod mPost = new PostMethod(url);
        Iterator iterator = parameterMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            mPost.addParameter(entry.getKey().toString(),entry.getValue().toString());
        }
        Header mtHeader = new Header();
        mtHeader.setName("content-type");
        mtHeader.setValue("application/x-www-form-urlencoded");
        mtHeader.setName("accept");
        mtHeader.setValue("application/text");
        mPost.addRequestHeader(mtHeader);
        try {
            client.executeMethod(mPost);
            output = mPost.getResponseBodyAsString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOGGER.debug("Received Response : " + output);
        mPost.releaseConnection();
        return output;
    }
}
