package com.tequeno.config.handler;

import com.tequeno.common.constants.HtResultBinder;
import com.tequeno.common.enums.HtCommonErrorEnum;
import com.tequeno.common.utils.HtCommonException;
import com.tequeno.common.utils.HtResultInfoWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public HtResultBinder exceptionHandle(HttpServletRequest request, Exception e) {
        logger.warn("访问url:{}时捕获到程序异常", request.getRequestURI(), e);
        if (e instanceof HtCommonException) {
            return HtResultInfoWrapper.fail(((HtCommonException) e).getErrorImpl());
        }
        return HtResultInfoWrapper.fail(HtCommonErrorEnum.SYSTEM_ERROR);
    }
}