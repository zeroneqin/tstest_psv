package com.qinjun.autotest.tstest.cases;

import com.qinjun.autotest.tstest.base.BaseCase;
import com.qinjun.autotest.tstest.po.req.DemoReq;
import com.qinjun.autotest.tstest.po.res.DemoRes;
import com.qinjun.autotest.tstest.so.DemoSO;
import com.qinjun.autotest.tstest.vo.DemoVO;
import org.testng.annotations.Test;

public class DemoCase extends BaseCase {

    @Test
    public void test() {
        DemoReq demoReq = new DemoReq();
        demoReq.setName("TestName");

        DemoRes demoRes = DemoSO.sendRequest(url, demoReq);

        DemoVO.verify(demoRes,1,1);
    }
}