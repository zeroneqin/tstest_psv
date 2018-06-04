package com.qinjun.autotest.tstest.test;

public enum TestEnv {
    TEST("Test envrionment"),PREPUB("Prepub envrionment"),ONLINE("Online envrionment");

    String envName;
    private TestEnv(String envName){
        this.envName=envName;
    }

    public String getEnvName() {
        return envName;
    }

    public void setEnvName(String envName) {
        this.envName = envName;
    }
}
