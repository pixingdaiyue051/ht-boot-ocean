package com.tequeno.common.utils;

import com.tequeno.common.constants.ResultBinder;
import com.tequeno.common.enums.CommonCatchedEnum;
import com.tequeno.common.enums.CommonCodeMsgInterface;

public class CommonResultUtil {

    public static ResultBinder success(CommonCodeMsgInterface commonCodeMsgInterface, Object data) {
        ResultBinder binder = new ResultBinder();
        binder.setSuccess(true);
        binder.setCode(commonCodeMsgInterface.getCode());
        binder.setMsg(commonCodeMsgInterface.getMsg());
        binder.setData(data);
        return binder;
    }

    public static ResultBinder success(Object data) {
        return success(CommonCatchedEnum.SUCCESS, data);
    }

    public static ResultBinder success() {
        return success(null);
    }

    public static ResultBinder fail(CommonCodeMsgInterface commonCodeMsgInterface, Object data) {
        ResultBinder binder = new ResultBinder();
        binder.setSuccess(false);
        binder.setCode(commonCodeMsgInterface.getCode());
        binder.setMsg(commonCodeMsgInterface.getMsg());
        binder.setData(data);
        return binder;
    }

    public static ResultBinder fail(CommonCodeMsgInterface commonCodeMsgInterface) {
        ResultBinder binder = new ResultBinder();
        binder.setSuccess(false);
        binder.setCode(commonCodeMsgInterface.getCode());
        binder.setMsg(commonCodeMsgInterface.getMsg());
        return binder;
    }

    public static ResultBinder fail() {
        return fail(CommonCatchedEnum.FAIL);
    }
}
