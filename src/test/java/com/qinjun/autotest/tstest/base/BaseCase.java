package com.qinjun.autotest.tstest.base;

import com.qinjun.autotest.tstest.test.TestResult;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BaseCase extends BaseSuite {
    private final static Logger logger = LoggerFactory.getLogger(BaseCase.class);

    public BaseCase() {

    }

    @BeforeClass
    public void setup() {

    }


    @Test
    public void baseTest() {
        TestResult result = TestResult.PASS;
        logger.info("==========[Start Case]==========");
        logger.info("==========[Send Request]==========");

        result = send();
        logger.info("==========[Send End]==========");
        if (result == TestResult.PASS) {
            logger.info("==========[Wait]==========");
            result = wait(result);
            logger.info("==========[Wait End]==========");
        }

        if (result== TestResult.PASS) {
            logger.info("==========[Verify]==========");
            result = verify(result);
            logger.info("==========[Verify End]==========");
        }

        if (result == TestResult.FAIL) {
            logger.info("==========[End Case:FAIL]==========");
            String failedMsg = result.getResult();
            if (StringUtils.isEmpty(failedMsg)) {
                logger.error(failedMsg);
            }
        }
        else if (result == TestResult.SKIP) {
            logger.warn("==========[End Case:SKIP]==========");
            throw new SkipException("Skip the case");
        }
        else {
            logger.info("==========[End Case:PASS]==========");
        }
    }
}