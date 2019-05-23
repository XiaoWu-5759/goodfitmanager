package com.simba.goodfitmanager.common;

import java.io.Serializable;


public class Response<T> implements Serializable {  //序列化
    private int code;
    private int status;
    private String msg;
    private T result;

    public Response() {
    }

    public Response(int code, int status, String msg, T result) {
        this.code = code;
        this.status = status;
        this.msg = msg;
        this.result = result;
    }

    public Response(T result) {
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Response{" +
                "code=" + code +
                ", status=" + status +
                ", msg='" + msg + '\'' +
                ", result=" + result +
                '}';
    }
}
