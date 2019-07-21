package com.tequeno.common.utils;

import com.tequeno.common.constants.ResultBinder;
import com.tequeno.common.enums.HtErrorInterface;
import com.tequeno.common.enums.HtCommonErrorEnum;

public class HtResultInfoWrapper {

    public static ResultBinder success(HtErrorInterface errorImpl, Object data) {
        ResultBinder binder = success(errorImpl);
        binder.setData(data);
        return binder;
    }

    public static ResultBinder success(HtErrorInterface errorImpl) {
        ResultBinder binder = new ResultBinder();
        binder.setSuccess(true);
        binder.setCode(errorImpl.getCode());
        binder.setMsg(errorImpl.getMsg());
        return binder;
    }

    public static ResultBinder success(Object data) {
        return success(HtCommonErrorEnum.SUCCESS, data);
    }

    public static ResultBinder success() {
        return success(HtCommonErrorEnum.SUCCESS);
    }

    public static ResultBinder fail(HtErrorInterface errorImpl) {
        ResultBinder binder = new ResultBinder();
        binder.setSuccess(false);
        binder.setCode(errorImpl.getCode());
        binder.setMsg(errorImpl.getMsg());
        return binder;
    }

    public static ResultBinder fail() {
        return fail(HtCommonErrorEnum.FAIL);
    }
}
