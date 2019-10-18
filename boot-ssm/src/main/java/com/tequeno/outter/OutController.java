package com.tequeno.outter;

import com.tequeno.common.constants.HtCommonRegPattern;
import com.tequeno.common.constants.HtPropertyConstant;
import com.tequeno.common.constants.ResultBinder;
import com.tequeno.common.enums.HtUserErrorEnum;
import com.tequeno.common.enums.JedisKeyPrefixEnum;
import com.tequeno.common.temail.EmailRespone;
import com.tequeno.common.temail.EmailUtil;
import com.tequeno.common.temail.EmailWrapper;
import com.tequeno.common.utils.HtCommonMethodUtil;
import com.tequeno.common.utils.HtResultInfoWrapper;
import com.tequeno.config.cache.JedisCacheUtil;
import com.tequeno.config.handler.HtRepeatedSubmitAnno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("outter")
public class OutController {

    @Autowired
    private JedisCacheUtil cacheUtil;

    @RequestMapping("success")
    public ResultBinder success() {
        return HtResultInfoWrapper.success(HtUserErrorEnum.LOGINED_AREADY);
    }

    @RequestMapping("fail")
    public ResultBinder fail() {
        return HtResultInfoWrapper.fail(HtUserErrorEnum.NOT_LOGINED);
    }

    @RequestMapping("otp/phone/{tel}")
    @HtRepeatedSubmitAnno
    public ResultBinder getOtpPhone(@PathVariable("tel") String tel) {
        boolean matched = tel.matches(HtCommonRegPattern.REG_PHONE);
        if (!matched) {
            return HtResultInfoWrapper.fail(HtUserErrorEnum.PHONE_NOT_MATCHED);
        }
        Object o = actualGetOtp(tel);
        return HtResultInfoWrapper.success(o);
    }

    @RequestMapping("otp/email/{email}")
    @HtRepeatedSubmitAnno
    public ResultBinder getOtpEmail(@PathVariable("email") String email) {
        boolean matched = email.matches(HtCommonRegPattern.REG_MAIL);
        if (!matched) {
            return HtResultInfoWrapper.fail(HtUserErrorEnum.MAIL_NOT_MATCHED);
        }
        String o = actualGetOtp(email);
        EmailWrapper emailWrapper = new EmailWrapper();
        emailWrapper.setSubject("test");
        emailWrapper.setToEmail(email);
        emailWrapper.setEmailMsg(o);
        EmailRespone emailRespone = EmailUtil.send(emailWrapper);
        return HtResultInfoWrapper.success(emailRespone.getMsg());
    }

    private String actualGetOtp(String hkey) {
        String key = JedisKeyPrefixEnum.HUSER_OTP.getPrefix();
        String otpCode = HtCommonMethodUtil.getNonceStr(HtPropertyConstant.OTP_LENGTH);
        cacheUtil.hset(key, hkey, otpCode, HtPropertyConstant.OTP_EXPIRED);
        return otpCode;
    }
}