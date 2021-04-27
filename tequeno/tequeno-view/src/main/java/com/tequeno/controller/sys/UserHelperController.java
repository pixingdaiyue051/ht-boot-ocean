package com.tequeno.controller.sys;

import com.tequeno.anno.HtPermissionAnno;
import com.tequeno.anno.HtRepeatedSubmitAnno;
import com.tequeno.config.RedisUtil;
import com.tequeno.constants.HtCommonRegPattern;
import com.tequeno.constants.HtResultBinder;
import com.tequeno.constants.HtZeroOneConstant;
import com.tequeno.enums.HtCommonErrorEnum;
import com.tequeno.enums.HtUserErrorEnum;
import com.tequeno.enums.HtUserResEnum;
import com.tequeno.enums.JedisKeyPrefixEnum;
import com.tequeno.pojo.sys.user.UserInfo;
import com.tequeno.service.user.UserService;
import com.tequeno.utils.HtCommonException;
import com.tequeno.utils.HtResultInfoWrapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Optional;
import java.util.function.Consumer;

@RestController
@RequestMapping("user")
public class UserHelperController {

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private UserService userService;

    /**
     * 启用禁用用户
     *
     * @param ids    用户id逗号分隔
     * @param enable 默认false禁用,true启用
     * @return
     */
    @RequestMapping("disable")
    @HtPermissionAnno(HtUserResEnum.RES_USER_ENABLE)
    @HtRepeatedSubmitAnno
    public HtResultBinder disable(@RequestParam("ids") String ids, @RequestParam(value = "enable", required = false) boolean enable) {
        userService.enableDisableUser(ids, enable ? HtZeroOneConstant.ENABLED : HtZeroOneConstant.DISABLED);
        return HtResultInfoWrapper.success();
    }

    /**
     * 注销账号，物理删除用户，谨慎使用
     *
     * @param ids 用户id逗号分隔
     * @return
     */
    @RequestMapping("delete")
    @HtPermissionAnno(HtUserResEnum.RES_USER_DELETE)
    @HtRepeatedSubmitAnno
    public HtResultBinder delete(@RequestParam("ids") String ids) {
        userService.deleteUser(ids);
        return HtResultInfoWrapper.success();
    }

    /**
     * 绑定手机号，绑定后可以使用手机号登录
     *
     * @param userName 用户名
     * @param tel      手机号
     * @param otp      获取到的验证码
     * @return
     */
    @RequestMapping("bind/phone")
    @HtPermissionAnno(HtUserResEnum.RES_USER_BIND)
    @HtRepeatedSubmitAnno
    public HtResultBinder bindPhone(@RequestParam("userName") String userName,
                                    @RequestParam("tel") String tel,
                                    @RequestParam("otp") String otp) {
        boolean matched = tel.matches(HtCommonRegPattern.REG_PHONE);
        if (!matched) {
            return HtResultInfoWrapper.fail(HtUserErrorEnum.PHONE_NOT_MATCHED);
        }
        return innerBind(userName, otp, tel, u -> u.setPhoneNum(tel));
    }

    /**
     * 解绑手机号
     *
     * @param userName
     * @param tel
     * @param otp
     * @return
     */
    @RequestMapping("unbind/phone")
    @HtPermissionAnno(HtUserResEnum.RES_USER_BIND)
    @HtRepeatedSubmitAnno
    public HtResultBinder unbindPhone(@RequestParam("userName") String userName,
                                      @RequestParam("tel") String tel,
                                      @RequestParam("otp") String otp) {
        boolean matched = tel.matches(HtCommonRegPattern.REG_PHONE);
        if (!matched) {
            return HtResultInfoWrapper.fail(HtUserErrorEnum.PHONE_NOT_MATCHED);
        }
        return innerBind(userName, otp, tel, u -> u.setPhoneNum(""));
    }

    /**
     * 绑定邮箱，绑定后可以使用邮箱登录
     *
     * @param userName 用户名
     * @param email    邮箱地址
     * @param otp      获取到的验证码
     * @return
     */
    @RequestMapping("bind/email")
    @HtPermissionAnno(HtUserResEnum.RES_USER_BIND)
    @HtRepeatedSubmitAnno
    public HtResultBinder bindEmail(@RequestParam("userName") String userName,
                                    @RequestParam("email") String email,
                                    @RequestParam("otp") String otp) {
        boolean matched = email.matches(HtCommonRegPattern.REG_MAIL);
        if (!matched) {
            return HtResultInfoWrapper.fail(HtUserErrorEnum.MAIL_NOT_MATCHED);
        }
        return innerBind(userName, otp, email, u -> u.setEmail(email));
    }

    /**
     * 解绑邮箱
     *
     * @param userName
     * @param email
     * @param otp
     * @return
     */
    @RequestMapping("unbind/email")
    @HtPermissionAnno(HtUserResEnum.RES_USER_BIND)
    @HtRepeatedSubmitAnno
    public HtResultBinder unbindEmail(@RequestParam("userName") String userName,
                                      @RequestParam("email") String email,
                                      @RequestParam("otp") String otp) {
        boolean matched = email.matches(HtCommonRegPattern.REG_MAIL);
        if (!matched) {
            return HtResultInfoWrapper.fail(HtUserErrorEnum.MAIL_NOT_MATCHED);
        }
        return innerBind(userName, otp, email, u -> u.setEmail(""));
    }

    private HtResultBinder innerBind(String userName, String otp, String hkey, Consumer<UserInfo> c) {
        String key = JedisKeyPrefixEnum.OTP.getPrefix();
        return Optional.ofNullable(redisUtil.hget(key, hkey))
                .map(o -> {
                    if (!otp.equals(o)) {
                        throw new HtCommonException(HtCommonErrorEnum.WRONG_OTP);
                    }
                    userService.bindPhoneOrEmail(userName, c);
                    redisUtil.hdel(key, hkey);
                    return HtResultInfoWrapper.success();
                })
                .orElseThrow(() -> new HtCommonException(HtCommonErrorEnum.OTP_NULL_OR_EXPIRED));
    }
}
