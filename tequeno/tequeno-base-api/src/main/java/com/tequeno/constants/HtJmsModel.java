package com.tequeno.constants;

import java.io.Serializable;

public class HtJmsModel implements Serializable {

    private String code;

    private String msg;

    private Object data;

    private Integer timeLevel;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getTimeLevel() {
        return timeLevel;
    }

    public void setTimeLevel(Integer timeLevel) {
        this.timeLevel = timeLevel;
    }

    @Override
    public String toString() {
        return code + msg + data;
    }
}