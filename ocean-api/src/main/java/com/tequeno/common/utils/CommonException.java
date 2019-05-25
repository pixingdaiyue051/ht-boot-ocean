package com.tequeno.common.utils;

import com.tequeno.common.enums.CommonCodeMsgInterface;

public class CommonException extends RuntimeException {

    private CommonCodeMsgInterface commonCodeMsgInterface;

    public CommonException(CommonCodeMsgInterface commonCodeMsgInterface) {
        super();
        this.commonCodeMsgInterface = commonCodeMsgInterface;
    }

    public CommonException(CommonCodeMsgInterface commonCodeMsgInterface, String msg) {
        super();
        this.commonCodeMsgInterface = commonCodeMsgInterface;
        this.commonCodeMsgInterface.setMsg(msg);
    }

    public CommonCodeMsgInterface getCommonCodeMsgInterface() {
        return commonCodeMsgInterface;
    }
}
