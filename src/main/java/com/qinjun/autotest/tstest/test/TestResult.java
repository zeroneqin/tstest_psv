package com.qinjun.autotest.tstest.test;

import java.util.List;

public enum TestResult {
    PASS("Test passed"), FAIL("Test failed"), SKIP("Test skipped");

    ThreadLocal<String> result;
    ThreadLocal<List<String>> resultInfoList;

    private TestResult(final String result) {
        this.result = new ThreadLocal<String>() {
            protected String initalValue() {
                return result;
            }
        };
    }


    public ThreadLocal<String> getResult() {
        return result;
    }

    public void setResult(ThreadLocal<String> result) {
        this.result = result;
    }

    public ThreadLocal<List<String>> getResultInfoList() {
        return resultInfoList;
    }

    public void setResultInfoList(ThreadLocal<List<String>> resultInfoList) {
        this.resultInfoList = resultInfoList;
    }
}