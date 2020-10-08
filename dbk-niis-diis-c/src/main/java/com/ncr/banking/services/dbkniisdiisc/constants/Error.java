package com.ncr.banking.services.dbkniisdiisc.constants;

public enum Error {
    // Input validation errors
    MISSING_HOSTID_VALUE("DNDC_10006", "A valid hostid is required"),

    // Security errors

    // Business errors

    // The 21000 - 21999 range is reserved for DIIS errors

    // Internal validation errors
    INTERNAL_VALIDATION_ERROR("DNDC_22001", "Internal validation error."),

    // Generic errors
    UNMAPPED_ERROR("DNDC_90000", "Server cannot handle this request"),
    GENERIC_CLIENT_ERROR("DNDC_99990", "Client error"),
    GENERIC_SERVER_ERROR("DNDC_99999", "Server error.");

    private final String code;
    private final String message;

    Error(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}
