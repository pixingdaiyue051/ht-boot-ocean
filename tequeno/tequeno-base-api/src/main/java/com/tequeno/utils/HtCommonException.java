package com.tequeno.utils;

import com.tequeno.enums.HtErrorInterface;

public class HtCommonException extends RuntimeException {

    private final static long serialVersionUID = -1864815202498090353L;

    private HtErrorInterface errorImpl;

    public HtCommonException(HtErrorInterface errorImpl) {
        super();
        this.errorImpl = errorImpl;
    }

    public HtErrorInterface getErrorImpl() {
        return errorImpl;
    }
}
