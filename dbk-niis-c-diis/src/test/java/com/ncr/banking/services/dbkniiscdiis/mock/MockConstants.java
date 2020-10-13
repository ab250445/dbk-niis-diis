package com.ncr.banking.services.dbkniiscdiis.mock;

public class MockConstants {
    public static final String TEST_MESSAGE = "UP";
    public static final String HOSTID = "8390022";
    public static final String PIN = "4571";
    public static final String INSTITUTION_ID = "1234";
    public static final String ACCOUNT_ID = "1247437";
    public static final String ACCOUNT_TYPE="0";
    public static final String START_DATE="20201001";
    public static final String END_DATE="20201030";


    // Integration Tests
    public static final String LIVENESS_URL="/actuator/health/liveness";
    public static final String READINESS_URL="/actuator/health/readiness";
    public static final String METRICS_URL="/actuator/metrics";
    public static final String ACTUATOR_URL="/actuator";

}
