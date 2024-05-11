package com.hcl.hackathon.constant;

public enum Status {
    SUCCESS("Success"),
    FAIL("Fail");

    private final String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
