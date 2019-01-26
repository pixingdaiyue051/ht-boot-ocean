package com.tequeno.common.utils;

import com.tequeno.common.enums.ResultCodeMsgEnum;

public class ResultBinderUtil {

    public static ResultBinder success(ResultCodeMsgEnum resultCodeMsgEnum, Object data) {
        ResultBinder binder = new ResultBinder();
        binder.setSuccess(true);
        binder.setCode(resultCodeMsgEnum.getCode());
        binder.setMsg(resultCodeMsgEnum.getMsg());
        binder.setData(data);
        return binder;
    }

    public static ResultBinder success(Object data) {
        return success(ResultCodeMsgEnum.SUCCESS, data);
    }

    public static ResultBinder success() {
        return success(null);
    }

    public static ResultBinder fail(ResultCodeMsgEnum resultCodeMsgEnum) {
        ResultBinder binder = new ResultBinder();
        binder.setSuccess(false);
        binder.setCode(resultCodeMsgEnum.getCode());
        binder.setMsg(resultCodeMsgEnum.getMsg());
        return binder;
    }

    public static ResultBinder fail() {
        return fail(ResultCodeMsgEnum.FAIL);
    }

}
