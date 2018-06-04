package com.qinjun.autotest.tstest.biz.serviceobject;


import com.google.gson.Gson;
import com.qinjun.autotest.tstest.biz.pojoobject.req.DemoReq;
import com.qinjun.autotest.tstest.biz.pojoobject.res.DemoRes;
import com.qinjun.autotest.tstest.util.HttpResponse;
import com.qinjun.autotest.tstest.util.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class DemoSO {
    final private static Logger logger = LoggerFactory.getLogger(DemoSO.class);

    public static final String demoUrl = "/posts/1";

    public static HttpResponse sendRequest(String baseUrl, DemoReq demoReq) {
        HttpResponse httpResponse = null;
        String fullUrl = baseUrl + demoUrl;

        Map<String, String> queryParams = new HashMap<String, String>();
        String name = demoReq.getName();
        if (name != null) {
            logger.info("Request name:" + name);
            queryParams.put("name", name);
        }

        logger.info("full url:" + fullUrl);
        httpResponse = HttpUtil.sendGet(fullUrl, null, queryParams, true);
        return httpResponse;
    }

    public static DemoRes sendRequestWrapper(String baseUrl, DemoReq demoReq) {
        DemoRes demoRes = null;
        HttpResponse httpResponse = sendRequest(baseUrl,demoReq);
        if (httpResponse!=null) {
            if (httpResponse.getStatus()!=200) {
                logger.warn("http status code is not 200");
            }
            String body = httpResponse.getBody();
            Gson gson = new Gson();
            demoRes = gson.fromJson(body,DemoRes.class);
        }
        return demoRes;
    }


}