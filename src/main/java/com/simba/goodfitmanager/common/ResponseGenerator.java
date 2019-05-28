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

    public static <T> Response<T> genUserNeedAuthoritiesReponse() {
        Response response = new Response();
        response.setCode(ResponseCode.RESPONSE_CODE_BAD_REQUEST);
        response.setStatus(ResponseStatus.USER_NEED_AUTHORITIES.getStatus());
        response.setMsg(ResponseStatus.USER_NEED_AUTHORITIES.getDesc());
        return response;
    }

    public static <T> Response<T> genUserLoginFailedReponse() {
        Response response = new Response();
        response.setCode(ResponseCode.RESPONSE_CODE_SUCCESS);
        response.setStatus(ResponseStatus.USER_LOGIN_FAILED.getStatus());
        response.setMsg(ResponseStatus.USER_LOGIN_FAILED.getDesc());
        return response;
    }

    public static <T> Response<T> genUserLoginSuccessReponse(Object result) {
        Response response = new Response();
        response.setCode(ResponseCode.RESPONSE_CODE_SUCCESS);
        response.setStatus(ResponseStatus.USER_LOGIN_SUCCESS.getStatus());
        response.setMsg(ResponseStatus.USER_LOGIN_SUCCESS.getDesc());
        response.setResult(result);
        return response;
    }

    public static <T> Response<T> genUserNoAccessReponse() {
        Response response = new Response();
        response.setCode(ResponseCode.RESPONSE_CODE_BAD_REQUEST);
        response.setStatus(ResponseStatus.USER_NO_ACCESS.getStatus());
        response.setMsg(ResponseStatus.USER_NO_ACCESS.getDesc());
        return response;
    }

    public static <T> Response<T> genUserLogoutSuccessReponse() {
        Response response = new Response();
        response.setCode(ResponseCode.RESPONSE_CODE_BAD_REQUEST);
        response.setStatus(ResponseStatus.USER_LOGOUT_SUCCESS.getStatus());
        response.setMsg(ResponseStatus.USER_LOGOUT_SUCCESS.getDesc());
        return response;
    }

    public static <T> Response<T> genTokenIsBlacklistReponse() {
        Response response = new Response();
        response.setCode(ResponseCode.RESPONSE_CODE_BAD_REQUEST);
        response.setStatus(ResponseStatus.TOKEN_IS_BLACKLIST.getStatus());
        response.setMsg(ResponseStatus.TOKEN_IS_BLACKLIST.getDesc());
        return response;
    }

    public static <T> Response<T> genLoginIsOverdueReponse() {
        Response response = new Response();
        response.setCode(ResponseCode.RESPONSE_CODE_BAD_REQUEST);
        response.setStatus(ResponseStatus.LOGIN_IS_OVERDUE.getStatus());
        response.setMsg(ResponseStatus.LOGIN_IS_OVERDUE.getDesc());
        return response;
    }

}
