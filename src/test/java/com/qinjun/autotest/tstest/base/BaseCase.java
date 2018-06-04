package com.qinjun.autotest.tstest.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseCase extends BaseSuite {
    private final static Logger logger = LoggerFactory.getLogger(BaseCase.class);

    public BaseCase() {
    }

    @BeforeMethod
    public void setup() {
        logger.info("==========[Start Case]==========");
    }


    @AfterMethod
    public void cleanup() {
        logger.info("==========[End Case]==========");
    }
}