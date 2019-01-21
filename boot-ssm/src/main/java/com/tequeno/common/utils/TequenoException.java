package com.tequeno.common.utils;

import com.tequeno.common.enums.ResultCodeMsgEnum;

public class TequenoException extends RuntimeException {

    private ResultCodeMsgEnum resultCodeMsgEnum;

    public TequenoException(ResultCodeMsgEnum resultCodeMsgEnum) {
        super(resultCodeMsgEnum.getMsg());
        this.resultCodeMsgEnum = resultCodeMsgEnum;
    }

    public ResultCodeMsgEnum getResultCodeMsgEnum() {
        return resultCodeMsgEnum;
    }

    public void setResultCodeMsgEnum(ResultCodeMsgEnum resultCodeMsgEnum) {
        this.resultCodeMsgEnum = resultCodeMsgEnum;
    }
}
