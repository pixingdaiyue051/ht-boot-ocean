package com.tequeno.config.handler;

import com.tequeno.common.constants.ResultBinder;
import com.tequeno.common.enums.CommonCatchedEnum;
import com.tequeno.common.utils.CommonException;
import com.tequeno.common.utils.CommonResultUtil;
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
        logger.warn("访问url:{}时捕获到程序异常", request.getRequestURI(), e);
        if (e instanceof CommonException) {
            return CommonResultUtil.fail(((CommonException) e).getCommonCodeMsgInterface());
        }
        return CommonResultUtil.fail(CommonCatchedEnum.SYSTEM_ERROR);
    }
}