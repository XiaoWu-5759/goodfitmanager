package com.simba.goodfitmanager.common;

public enum ResponseStatus {
    SUCCESS(0, "SUCCESS"),
    ERROR(1, "ERROR"),
    NOT_FOUND(404, "NOT_FOUND"),
    SERVER_ERROR(500, "SERVER_ERROR"),
    NEED_LOGIN(10, "NEED_LOGIN"),
    ILLEGAL_ARGUMENT(2, "ILLEGAL_ARGUMENT");


    private final int status;
    private final String desc;

    ResponseStatus(int status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public int getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }
}
