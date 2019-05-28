package com.simba.goodfitmanager.common;

public enum ResponseStatus {
    SUCCESS(0, "SUCCESS"),
    ERROR(1, "ERROR"),
    NOT_FOUND(404, "NOT_FOUND"),
    SERVER_ERROR(500, "SERVER_ERROR"),
    NEED_LOGIN(10, "NEED_LOGIN"),
    ILLEGAL_ARGUMENT(2, "ILLEGAL_ARGUMENT"),

    // TODO: 中文的情况下可能乱码
    USER_NEED_AUTHORITIES(201,"USER_NEED_AUTHORITIES"),
    USER_LOGIN_FAILED(1,"USER_LOGIN_FAILED"),
    USER_LOGIN_SUCCESS(0,"USER_LOGIN_SUCCESS"),
    USER_NO_ACCESS(204,"用户无权访问"),
    USER_LOGOUT_SUCCESS(205,"USER_LOGOUT_SUCCESS"),
    TOKEN_IS_BLACKLIST(206,"此token为黑名单"),
    LOGIN_IS_OVERDUE(207,"登录已失效");


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
