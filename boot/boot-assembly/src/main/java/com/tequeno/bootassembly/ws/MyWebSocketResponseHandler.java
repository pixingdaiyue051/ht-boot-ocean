package com.tequeno.bootassembly.ws;

public class MyWebSocketResponseHandler {

    public static MyWebSocketResponse success(MyWebSocketCodeEnum myWebSocketCodeEnum) {
        MyWebSocketResponse response = new MyWebSocketResponse();
        response.setSuccess(true);
        response.setCode(myWebSocketCodeEnum.getCode());
        response.setMsg(myWebSocketCodeEnum.getDesc());
        return response;
    }

    public static MyWebSocketResponse success(MyWebSocketCodeEnum myWebSocketCodeEnum, String msg) {
        MyWebSocketResponse response = success(myWebSocketCodeEnum);
        response.setMsg(msg);
        return response;
    }

    public static MyWebSocketResponse success(MyWebSocketCodeEnum myWebSocketCodeEnum, Object data) {
        MyWebSocketResponse response = success(myWebSocketCodeEnum);
        response.setData(data);
        return response;
    }

    public static MyWebSocketResponse success(MyWebSocketCodeEnum myWebSocketCodeEnum, String msg, Object data) {
        MyWebSocketResponse response = success(myWebSocketCodeEnum);
        response.setMsg(msg);
        response.setData(data);
        return response;
    }

    public static MyWebSocketResponse success() {
        return success(MyWebSocketCodeEnum.SUCCESS);
    }

    public static MyWebSocketResponse success(String msg) {
        return success(MyWebSocketCodeEnum.SUCCESS, msg);
    }

    public static MyWebSocketResponse success(Object data) {
        return success(MyWebSocketCodeEnum.SUCCESS, data);
    }

    public static MyWebSocketResponse success(String msg, Object data) {
        return success(MyWebSocketCodeEnum.SUCCESS, msg, data);
    }

    public static MyWebSocketResponse fail(MyWebSocketCodeEnum myWebSocketCodeEnum) {
        MyWebSocketResponse response = new MyWebSocketResponse();
        response.setSuccess(false);
        response.setCode(myWebSocketCodeEnum.getCode());
        response.setMsg(myWebSocketCodeEnum.getDesc());
        return response;
    }

    public static MyWebSocketResponse fail() {
        return fail(MyWebSocketCodeEnum.FAIL);
    }

    public static MyWebSocketResponse fail(String msg) {
        MyWebSocketResponse response = fail();
        response.setMsg(msg);
        return response;
    }

    public static MyWebSocketResponse fail(MyWebSocketCodeEnum myWebSocketCodeEnum, String msg) {
        MyWebSocketResponse response = fail(myWebSocketCodeEnum);
        response.setMsg(msg);
        return response;
    }
}
