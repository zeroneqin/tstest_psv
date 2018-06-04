package com.qinjun.autotest.tstest.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseSuite {
    private final static Logger logger = LoggerFactory.getLogger(BaseSuite.class);
    protected static String url = null;

    @Parameters({"url"})
    @BeforeSuite
    public void beforeSuite(@Optional("http://jsonplaceholder.typicode.com/posts/1") String url) {
        BaseSuite.url = url;
        logger.info("==========[Start Suite]==========");
    }

    @AfterSuite
    public void afterSuite() {
        logger.info("==========[End Suite]==========");
    }
}