package com.tequeno.iou.enums;

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
     * 因为会涉及到对msg的修改，所以只有默认msg为空的才可以使用该方法
     *
     * @param msg 提示信息
     * @return
     */
    HtErrorInterface build(String msg);
}