package com.tequeno.utils;

import com.tequeno.constants.HtResultBinder;
import com.tequeno.enums.HtCommonErrorEnum;
import com.tequeno.enums.HtErrorInterface;

public class HtResultInfoWrapper {

    public static HtResultBinder success(HtErrorInterface errorImpl, Object data) {
        HtResultBinder binder = success(errorImpl);
        binder.setData(data);
        return binder;
    }

    public static HtResultBinder success(HtErrorInterface errorImpl) {
        HtResultBinder binder = new HtResultBinder();
        binder.setSuccess(true);
        binder.setCode(errorImpl.getCode());
        binder.setMsg(errorImpl.getMsg());
        return binder;
    }

    public static HtResultBinder success(Object data) {
        return success(HtCommonErrorEnum.SUCCESS, data);
    }

    public static HtResultBinder success() {
        return success(HtCommonErrorEnum.SUCCESS);
    }

    public static HtResultBinder fail(HtErrorInterface errorImpl) {
        HtResultBinder binder = new HtResultBinder();
        binder.setSuccess(false);
        binder.setCode(errorImpl.getCode());
        binder.setMsg(errorImpl.getMsg());
        return binder;
    }

    public static HtResultBinder fail(String errorMsg) {
        HtResultBinder binder = fail();
        binder.setMsg(errorMsg);
        return binder;
    }

    public static HtResultBinder fail() {
        return fail(HtCommonErrorEnum.FAIL);
    }
}
