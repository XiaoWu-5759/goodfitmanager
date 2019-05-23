package com.simba.goodfitmanager.common;

/**
 * 响应结果生成工具
 */
public class ResponseGenerator {

    public static <T> Response<T> genSucessReponse() {
        Response response = new Response();
        response.setCode(ResponseCode.RESPONSE_CODE_SUCCESS);
        response.setStatus(ResponseStatus.SUCCESS.getStatus());
        response.setMsg(ResponseStatus.SUCCESS.getDesc());
        return response;
    }

    public static <T> Response<T> genSucessReponse(Object result) {
        Response response = new Response();
        response.setCode(ResponseCode.RESPONSE_CODE_SUCCESS);
        response.setStatus(ResponseStatus.SUCCESS.getStatus());
        response.setMsg(ResponseStatus.SUCCESS.getDesc());
        response.setResult(result);
        return response;
    }

    public static <T> Response<T> genSucessReponse(String msg) {
        Response response = new Response();
        response.setCode(ResponseCode.RESPONSE_CODE_SUCCESS);
        response.setStatus(ResponseStatus.SUCCESS.getStatus());
        response.setMsg(msg);
        return response;
    }

    public static <T> Response<T> genSucessReponse(Object result,String msg) {
        Response response = new Response();
        response.setCode(ResponseCode.RESPONSE_CODE_SUCCESS);
        response.setStatus(ResponseStatus.SUCCESS.getStatus());
        response.setMsg(msg);
        response.setResult(result);
        return response;
    }

    public static <T> Response<T> genErrorReponse(){
        Response response = new Response();
        response.setCode(ResponseCode.RESPONSE_CODE_SUCCESS);
        response.setStatus(ResponseStatus.ERROR.getStatus());
        response.setMsg(ResponseStatus.ERROR.getDesc());
        return response;
    }

    public static <T> Response<T> genErrorReponse(String msg) {
        Response response = new Response();
        response.setCode(ResponseCode.RESPONSE_CODE_SUCCESS);
        response.setStatus(ResponseStatus.ERROR.getStatus());
        response.setMsg(msg);
        return response;
    }

    public static <T> Response<T> genNotFoundReponse() {
        Response response = new Response();
        response.setCode(ResponseCode.RESPONSE_CODE_NOT_FOUND);
        response.setStatus(ResponseStatus.NOT_FOUND.getStatus());
        response.setMsg(ResponseStatus.NOT_FOUND.getDesc());
        return response;
    }

    public static <T> Response<T> genServerErrorReponse() {
        Response response = new Response();
        response.setCode(ResponseCode.RESPONSE_CODE_SERVER_ERROR);
        response.setStatus(ResponseStatus.SERVER_ERROR.getStatus());
        response.setMsg(ResponseStatus.SERVER_ERROR.getDesc());
        return response;
    }

    public static <T> Response<T> genIllegalArgumentReponse() {
        Response response = new Response();
        response.setCode(ResponseCode.RESPONSE_CODE_BAD_REQUEST);
        response.setStatus(ResponseStatus.ILLEGAL_ARGUMENT.getStatus());
        response.setMsg(ResponseStatus.ILLEGAL_ARGUMENT.getDesc());
        return response;
    }

}
