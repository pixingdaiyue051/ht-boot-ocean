package com.tequeno.common.enums;

public interface HtErrorInterface {

    /**
     * 获取错误代码
     *
     * @return
     */
    String getCode();

    /**
     * 获取错误信息
     *
     * @return
     */
    String getMsg();

    /**
     * 复用同一个代码设置不同的提示信息
     * 不推荐这样用
     *
     * @param msg           提示信息
     * @return
     */
    HtErrorInterface setMsgBindReturn(String msg);
}