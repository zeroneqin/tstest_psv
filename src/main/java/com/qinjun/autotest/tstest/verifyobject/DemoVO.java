package com.qinjun.autotest.tstest.verifyobject;

import com.qinjun.autotest.tstest.pojoobject.res.DemoRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class DemoVO {
    private final static Logger logger = LoggerFactory.getLogger(DemoVO.class);

    public static void verify(DemoRes demoRes, Integer expectUserId, Integer expectId)  {
        Integer userId=demoRes.getUserId();
        Integer id = demoRes.getId();

        if (expectUserId!=null) {
            Assert.assertEquals(userId,expectUserId);
        }

        if (expectId!=null) {
            Assert.assertEquals(id,expectId);
        }
    }
}