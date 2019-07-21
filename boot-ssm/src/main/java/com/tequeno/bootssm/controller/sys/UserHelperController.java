package com.tequeno.bootssm.controller.sys;

import com.tequeno.bootssm.pojo.sys.user.UserInfo;
import com.tequeno.bootssm.service.user.UserService;
import com.tequeno.common.constants.HtCommonConstant;
import com.tequeno.common.constants.HtCommonRegPattern;
import com.tequeno.common.constants.ResultBinder;
import com.tequeno.common.enums.HtCommonErrorEnum;
import com.tequeno.common.enums.HtUserErrorEnum;
import com.tequeno.common.enums.JedisKeyPrefixEnum;
import com.tequeno.common.utils.HtCommonException;
import com.tequeno.common.utils.HtResultInfoWrapper;
import com.tequeno.config.cache.JedisCacheUtil;
import com.tequeno.config.shiro.HtPermissionAnno;
import com.tequeno.enums.HtUserResEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.function.Consumer;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserHelperController {

    @Autowired
    private JedisCacheUtil cacheUtil;

    @Autowired
    private UserService userService;

    /**
     * 启用禁用用户
     *
     * @param ids    用户id逗号分隔
     * @param enable 默认false禁用,true启用
     * @return
     */
    @PostMapping("disable")
    @HtPermissionAnno(HtUserResEnum.RES_USER_ENABLE)
    public ResultBinder disable(@RequestParam("ids") String ids, @RequestParam(value = "enable", required = false) boolean enable) {
        userService.enableDisableUser(ids, enable ? HtCommonConstant.ENABLE : HtCommonConstant.DISENABLE);
        return HtResultInfoWrapper.success();
    }

    /**
     * 注销账号，物理删除用户，谨慎使用
     *
     * @param ids 用户id逗号分隔
     * @return
     */
    @PostMapping("delete")
    @HtPermissionAnno(HtUserResEnum.RES_USER_DELETE)
    public ResultBinder delete(@RequestParam("ids") String ids) {
        userService.deleteUser(ids);
        return HtResultInfoWrapper.success();
    }

    /**
     * 绑定手机号，绑定后可以使用手机号登录
     *
     * @param userName 用户名
     * @param tel      手机号
     * @param opt      获取到的验证码
     * @return
     */
    @PostMapping("bind/phone")
    @HtPermissionAnno(HtUserResEnum.RES_USER_BIND)
    public ResultBinder bindPhone(@RequestParam("userName") String userName,
                                  @RequestParam("tel") String tel,
                                  @RequestParam("opt") String opt) {
        boolean matched = tel.matches(HtCommonRegPattern.REG_PHONE);
        if (!matched) {
            return HtResultInfoWrapper.fail(HtUserErrorEnum.PHONE_NOT_MATCHED);
        }
        return innerBind(userName, opt, tel, u -> u.setPhoneNum(tel));
    }

    /**
     * 解绑手机号
     *
     * @param userName
     * @param tel
     * @param opt
     * @return
     */
    @PostMapping("unbind/phone")
    @HtPermissionAnno(HtUserResEnum.RES_USER_BIND)
    public ResultBinder unbindPhone(@RequestParam("userName") String userName,
                                    @RequestParam("tel") String tel,
                                    @RequestParam("opt") String opt) {
        boolean matched = tel.matches(HtCommonRegPattern.REG_PHONE);
        if (!matched) {
            return HtResultInfoWrapper.fail(HtUserErrorEnum.PHONE_NOT_MATCHED);
        }
        return innerBind(userName, opt, tel, u -> u.setPhoneNum(""));
    }

    /**
     * 绑定邮箱，绑定后可以使用邮箱登录
     *
     * @param userName 用户名
     * @param email    邮箱地址
     * @param opt      获取到的验证码
     * @return
     */
    @PostMapping("bind/email")
    @HtPermissionAnno(HtUserResEnum.RES_USER_BIND)
    public ResultBinder bindEmail(@RequestParam("userName") String userName,
                                  @RequestParam("email") String email,
                                  @RequestParam("opt") String opt) {
        boolean matched = email.matches(HtCommonRegPattern.REG_MAIL);
        if (!matched) {
            return HtResultInfoWrapper.fail(HtUserErrorEnum.MAIL_NOT_MATCHED);
        }
        return innerBind(userName, opt, email, u -> u.setEmail(email));
    }

    /**
     * 解绑邮箱
     *
     * @param userName
     * @param email
     * @param opt
     * @return
     */
    @PostMapping("unbind/email")
    @HtPermissionAnno(HtUserResEnum.RES_USER_BIND)
    public ResultBinder unbindEmail(@RequestParam("userName") String userName,
                                    @RequestParam("email") String email,
                                    @RequestParam("opt") String opt) {
        boolean matched = email.matches(HtCommonRegPattern.REG_MAIL);
        if (!matched) {
            return HtResultInfoWrapper.fail(HtUserErrorEnum.MAIL_NOT_MATCHED);
        }
        return innerBind(userName, opt, email, u -> u.setEmail(""));
    }

    private ResultBinder innerBind(String userName, String opt, String hkey, Consumer<UserInfo> c) {
        String key = JedisKeyPrefixEnum.HUSER_OPT.getPrefix();
        return Optional.ofNullable(cacheUtil.hget(key, hkey))
                .map(o -> {
                    if (!opt.equals(o)) {
                        throw new HtCommonException(HtCommonErrorEnum.WRONG_OPT);
                    }
                    userService.bindPhoneOrEmail(userName, c);
                    cacheUtil.hdel(key, hkey);
                    return HtResultInfoWrapper.success();
                })
                .orElseThrow(() -> new HtCommonException(HtCommonErrorEnum.OPT_NULL_OR_EXIPRED));
    }
}