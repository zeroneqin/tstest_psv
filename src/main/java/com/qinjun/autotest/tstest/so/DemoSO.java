package com.qinjun.autotest.tstest.so;


import com.google.gson.Gson;
import com.qinjun.autotest.tstest.po.req.DemoReq;
import com.qinjun.autotest.tstest.po.res.DemoRes;
import com.qinjun.autotest.tstest.util.HttpResponse;
import com.qinjun.autotest.tstest.util.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class DemoSO {
    final private static Logger logger = LoggerFactory.getLogger(DemoSO.class);

    public static HttpResponse sendRequestInner(String baseUrl, DemoReq demoReq) {
        HttpResponse httpResponse = null;
        String fullUrl = baseUrl;

        Map<String, String> queryParams = new HashMap<String, String>();
        String name = demoReq.getName();
        if (name != null) {
            logger.info("Request param, name:" + name);
            queryParams.put("name", name);
        }

        logger.info("full url:" + fullUrl);
        httpResponse = HttpUtil.sendGet(fullUrl, null, queryParams, true);
        return httpResponse;
    }

    public static DemoRes sendRequest(String baseUrl, DemoReq demoReq) {
        DemoRes demoRes = null;
        HttpResponse httpResponse = sendRequestInner(baseUrl,demoReq);
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