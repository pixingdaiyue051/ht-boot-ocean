package com.tequeno.controller.sys;

import com.github.pagehelper.PageInfo;
import com.tequeno.anno.HtPermissionAnno;
import com.tequeno.anno.HtRepeatedSubmitAnno;
import com.tequeno.config.RedisUtil;
import com.tequeno.constants.HtResultBinder;
import com.tequeno.enums.HtUserErrorEnum;
import com.tequeno.enums.HtUserResEnum;
import com.tequeno.enums.JedisKeyPrefixEnum;
import com.tequeno.pojo.sys.user.UserInfo;
import com.tequeno.pojo.sys.user.UserInfoQuery;
import com.tequeno.pojo.sys.user.UserModel;
import com.tequeno.service.user.UserService;
import com.tequeno.utils.HtResultInfoWrapper;
import com.tequeno.validators.UserValidator;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserInfoController {

    private final static Logger logger = LoggerFactory.getLogger(UserInfoController.class);

    @Resource
    private UserValidator validator;

    @Resource
    private UserService userService;

    @Resource
    private RedisUtil redisUtil;

    @RequestMapping("page")
    @HtPermissionAnno(HtUserResEnum.RES_USER_QUERY)
    public HtResultBinder page(HttpServletRequest request, @RequestBody UserInfoQuery userQuery) {
        PageInfo<UserInfo> pager = userService.findPager(userQuery);
        if (null != pager) {
            return HtResultInfoWrapper.success(pager);
        }
        return HtResultInfoWrapper.fail();
    }

    @RequestMapping("list")
    @HtPermissionAnno(value = {HtUserResEnum.RES_USER_QUERY, HtUserResEnum.RES_USER_UPDATE}, logical = HtPermissionAnno.Logical.OR)
    public HtResultBinder list(@RequestBody UserInfoQuery userQuery) {
        List<UserInfo> userInfoList = userService.getList(userQuery);
        if (CollectionUtils.isEmpty(userInfoList)) {
            return HtResultInfoWrapper.fail(HtUserErrorEnum.USER_NOT_EXIST);
        }
        return HtResultInfoWrapper.success(userInfoList);
    }

    @RequestMapping("one/{id}")
    @HtPermissionAnno(value = HtUserResEnum.RES_USER_QUERY)
    public HtResultBinder one(@PathVariable String id) {
        UserInfo userInfo = userService.selectByPrimaryKey(id, JedisKeyPrefixEnum.USER);
        return HtResultInfoWrapper.success(userInfo);
    }

    @RequestMapping("addOne")
    @HtPermissionAnno(HtUserResEnum.RES_USER_ADD)
    @HtRepeatedSubmitAnno
    public HtResultBinder addOne(@RequestBody UserModel userModel, BindingResult result) {
        validator.validate(userModel, result);
        userService.addUser(userModel);
        return HtResultInfoWrapper.success();
    }

    @RequestMapping("updateOne")
    @HtPermissionAnno(HtUserResEnum.RES_USER_UPDATE)
    @HtRepeatedSubmitAnno
    public HtResultBinder updateOne(@RequestBody UserModel userModel, BindingResult result) {
        validator.updateValidate(userModel, result);
        userService.updateUser(userModel);
        return HtResultInfoWrapper.success();
    }

//    shiro 登陆/登出
//    @RequestMapping("login")
//    public HtResultBinder login(HttpServletRequest request,
//                                @RequestParam("userName") String userName,
//                                @RequestParam("password") String password) {
//        try {
//            UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
//            token.setRememberMe(true);
//            Subject subject = SecurityUtils.getSubject();
//            subject.login(token);
//        } catch (UnknownAccountException e) {
//            logger.error("用户名[{}]错误,未找到对应用户", userName);
//            return HtResultInfoWrapper.fail(HtUserErrorEnum.USERNAME_OR_PASSWORD_ERROR);
//        } catch (IncorrectCredentialsException e) {
//            logger.error("账号[{}]的密码[{}]不正确", userName, password);
//            return HtResultInfoWrapper.fail(HtUserErrorEnum.USERNAME_OR_PASSWORD_ERROR);
//        } catch (LockedAccountException e) {
//            logger.error("账号[{}]被锁定", userName);
//            return HtResultInfoWrapper.fail(HtUserErrorEnum.USER_LOCKED);
//        } catch (DisabledAccountException e) {
//            logger.error("账号[{}]被禁用", userName);
//            return HtResultInfoWrapper.fail(HtUserErrorEnum.USER_DISABLED);
//        } catch (AuthenticationException e) {
//            logger.error("[{}]登录失败", userName, e);
//            return HtResultInfoWrapper.fail(HtUserErrorEnum.LOGIN_FAILED);
//        }
//        return HtResultInfoWrapper.success(HtUserErrorEnum.LOGIN_SUCCESSED);
//    }
//
//    @RequestMapping("logout")
//    public HtResultBinder logout() {
//        Subject user = SecurityUtils.getSubject();
//        user.logout();
//        return HtResultInfoWrapper.success(HtUserErrorEnum.LOGOUT);
//    }

//    @RequestMapping("logout")
//    public HtResultBinder logout() {
//        Subject user = SecurityUtils.getSubject();
//        user.logout();
//        return HtResultInfoWrapper.success(HtUserErrorEnum.LOGOUT);
//    }

    //    拦截器 登陆/登出
    @RequestMapping("login")
    public HtResultBinder login(HttpServletRequest request,
                                @RequestParam("userName") String userName,
                                @RequestParam("password") String password) {
        try {
            UserModel userModel = new UserModel();
            userModel.setUserName(userName);
            userModel.setPassword(password);
            String sign = userService.login(userModel);
            return HtResultInfoWrapper.success(HtUserErrorEnum.LOGIN_SUCCESSED, sign);
        } catch (UnknownAccountException e) {
            logger.error("用户名[{}]错误,未找到对应用户", userName);
            return HtResultInfoWrapper.fail(HtUserErrorEnum.USERNAME_OR_PASSWORD_ERROR);
        } catch (IncorrectCredentialsException e) {
            logger.error("账号[{}]的密码[{}]不正确", userName, password);
            return HtResultInfoWrapper.fail(HtUserErrorEnum.USERNAME_OR_PASSWORD_ERROR);
        } catch (LockedAccountException e) {
            logger.error("账号[{}]被锁定", userName);
            return HtResultInfoWrapper.fail(HtUserErrorEnum.USER_LOCKED);
        } catch (DisabledAccountException e) {
            logger.error("账号[{}]被禁用", userName);
            return HtResultInfoWrapper.fail(HtUserErrorEnum.USER_DISABLED);
        } catch (AuthenticationException e) {
            logger.error("[{}]登录失败", userName, e);
            return HtResultInfoWrapper.fail(HtUserErrorEnum.LOGIN_FAILED);
        }
    }

    @RequestMapping("logout")
    public HtResultBinder logout(HttpServletRequest request) {
        String key = JedisKeyPrefixEnum.SIGN.assemblyKey(request.getHeader(JedisKeyPrefixEnum.SIGN.getPrefix()));
        redisUtil.del(key);
        return HtResultInfoWrapper.success(HtUserErrorEnum.LOGOUT);
    }
}