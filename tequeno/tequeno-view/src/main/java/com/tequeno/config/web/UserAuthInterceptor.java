package com.tequeno.config.web;

import com.tequeno.config.RedisUtil;
import com.tequeno.enums.HtCommonErrorEnum;
import com.tequeno.enums.JedisKeyPrefixEnum;
import com.tequeno.service.user.UserService;
import com.tequeno.utils.HtCommonException;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class UserAuthInterceptor implements HandlerInterceptor {

    @Resource
    private UserService userService;

    @Resource
    private RedisUtil redisUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String key = JedisKeyPrefixEnum.SIGN.assemblyKey(request.getHeader(JedisKeyPrefixEnum.SIGN.getPrefix()));
        if (!redisUtil.hasKey(key)) {
            throw new HtCommonException(HtCommonErrorEnum.SIGN_NOT_FOUND);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }
}
