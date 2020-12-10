package com.tequeno.controller.outter;

import com.tequeno.anno.HtRepeatedSubmitAnno;
import com.tequeno.config.cache.RedisUtil;
import com.tequeno.constants.HtCommonRegPattern;
import com.tequeno.constants.HtPropertyConstant;
import com.tequeno.constants.HtResultBinder;
import com.tequeno.enums.HtUserErrorEnum;
import com.tequeno.enums.JedisKeyPrefixEnum;
import com.tequeno.utils.HtCaptchaUtil;
import com.tequeno.utils.HtCommonException;
import com.tequeno.utils.HtResultInfoWrapper;
import org.patchca.service.Captcha;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("outter")
public class OutController {

    private final static Logger logger = LoggerFactory.getLogger(OutController.class);

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("success")
    public HtResultBinder success() {
        return HtResultInfoWrapper.success(HtUserErrorEnum.LOGINED_AREADY);
    }

    @RequestMapping("fail")
    public HtResultBinder fail() {
        return HtResultInfoWrapper.fail(HtUserErrorEnum.NOT_LOGINED);
    }

    @RequestMapping("otp/phone/{tel}")
    @HtRepeatedSubmitAnno(expireTime = HtPropertyConstant.OTP_RETRY)
    public HtResultBinder getOtpPhone(@PathVariable("tel") String tel) {
        boolean matched = tel.matches(HtCommonRegPattern.REG_PHONE);
        if (!matched) {
            return HtResultInfoWrapper.fail(HtUserErrorEnum.PHONE_NOT_MATCHED);
        }
        Object o = actualGetOtp(tel);
        return HtResultInfoWrapper.success(o);
    }

    @RequestMapping("otp/email/{email}")
    @HtRepeatedSubmitAnno(expireTime = HtPropertyConstant.OTP_RETRY)
    public HtResultBinder getOtpEmail(@PathVariable("email") String email) {
        boolean matched = email.matches(HtCommonRegPattern.REG_MAIL);
        if (!matched) {
            return HtResultInfoWrapper.fail(HtUserErrorEnum.MAIL_NOT_MATCHED);
        }
        String o = actualGetOtp(email);
        return HtResultInfoWrapper.success(o);
    }

    @RequestMapping("captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) {
        try {
            Captcha captcha = HtCaptchaUtil.captchaPic();
            response.setDateHeader("Expires", 0);
            response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
            response.addHeader("Cache-Control", "post-check=0, pre-check=0");
            response.setHeader("Pragma", "no-cache");
            response.setContentType("image/jpeg");
            request.getSession().setAttribute(HtPropertyConstant.CAPTCHA, captcha.getChallenge());
            ImageIO.write(captcha.getImage(), HtPropertyConstant.CAPTCHA_TYPE, response.getOutputStream());
        } catch (IOException e) {
            throw new HtCommonException(HtUserErrorEnum.CAPTCHA_GEN_ERROR);
        }

    }

    private String actualGetOtp(String hkey) {
        String key = JedisKeyPrefixEnum.OTP.assemblyKey(hkey);
        String otpCode = HtCaptchaUtil.captchaOtp();
        redisUtil.set(key, otpCode, HtPropertyConstant.OTP_EXPIRED);
        return otpCode;
    }
}