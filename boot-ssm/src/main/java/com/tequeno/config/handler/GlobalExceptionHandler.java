package com.tequeno.config.handler;

import com.tequeno.common.enums.ResultCodeMsgEnum;
import com.tequeno.common.utils.ResultBinder;
import com.tequeno.common.utils.ResultBinderUtil;
import com.tequeno.common.utils.TequenoException;
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
    public ResultBinder exceptionHandle(HttpServletRequest request, Exception e) {
        logger.warn("访问url={}出错 {}", request.getRequestURI(), e);
        if (e instanceof TequenoException) {
            return ResultBinderUtil.fail(((TequenoException) e).getResultCodeMsgEnum());
        }
        return ResultBinderUtil.fail(ResultCodeMsgEnum.UNKNOW);
    }
}