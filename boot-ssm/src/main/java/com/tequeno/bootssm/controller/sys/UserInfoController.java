package com.tequeno.bootssm.controller.sys;

import com.github.pagehelper.PageInfo;
import com.tequeno.bootssm.pojo.sys.user.UserInfo;
import com.tequeno.bootssm.pojo.sys.user.UserInfoQuery;
import com.tequeno.bootssm.pojo.sys.user.UserModel;
import com.tequeno.bootssm.service.user.UserService;
import com.tequeno.common.constants.ResultBinder;
import com.tequeno.common.enums.HtCommonErrorEnum;
import com.tequeno.common.enums.HtUserErrorEnum;
import com.tequeno.common.enums.JedisKeyPrefixEnum;
import com.tequeno.common.utils.HtResultInfoWrapper;
import com.tequeno.config.shiro.HtPermissionAnno;
import com.tequeno.config.validators.UserValidator;
import com.tequeno.enums.HtUserResEnum;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserInfoController {

    private final static Logger logger = LoggerFactory.getLogger(UserInfoController.class);

    @Autowired
    private UserValidator validator;

    @Autowired
    private UserService userService;

    @PostMapping("page")
    @HtPermissionAnno(HtUserResEnum.RES_USER_QUERY)
    public ResultBinder page(@RequestBody UserInfoQuery userQ) {
        userQ.setPageSize(3);
        PageInfo<UserInfo> pager = userService.findPager(userQ);
        System.out.println(pager);
        if (pager.getTotal() > 0) {
            return HtResultInfoWrapper.success(pager);
        }
        return HtResultInfoWrapper.fail();
    }

    @PostMapping("list")
    @HtPermissionAnno(HtUserResEnum.RES_USER_QUERY)
    public ResultBinder list(@RequestBody UserInfoQuery userQ) {
        List<UserInfo> userInfoList = userService.getList(userQ);
        if (CollectionUtils.isEmpty(userInfoList)) {
            return HtResultInfoWrapper.fail(HtUserErrorEnum.USER_NOT_EXIST);
        }
        return HtResultInfoWrapper.success(userInfoList);
    }

    @GetMapping("one/{id}")
    @HtPermissionAnno(value = HtUserResEnum.RES_USER_QUERY)
    public ResultBinder one(@PathVariable String id) {
        UserInfo userInfo = userService.selectByPrimaryKey(id, JedisKeyPrefixEnum.USER);
        return HtResultInfoWrapper.success(userInfo);
    }

    @PostMapping("addOne")
    @HtPermissionAnno(HtUserResEnum.RES_USER_ADD)
    public ResultBinder addOne(@RequestBody UserModel userModel, BindingResult result) {
        validator.validate(userModel, result);
        if (result.hasErrors()) {
            List<ObjectError> allErrors = result.getAllErrors();
            String errors = allErrors.stream().map(e -> e.getCode()).collect(Collectors.joining(","));
            return HtResultInfoWrapper.fail(HtCommonErrorEnum.COMBINE_ERROR.setMsgBindReturn(errors));
        }
        userService.addUser(userModel);
        return HtResultInfoWrapper.success();
    }

    @PostMapping("updateOne")
    @HtPermissionAnno(HtUserResEnum.RES_USER_UPDATE)
    public ResultBinder updateOne(@RequestBody UserModel userModel, BindingResult result) {
        validator.updateValidate(userModel, result);
        if (result.hasErrors()) {
            List<ObjectError> allErrors = result.getAllErrors();
            String errors = allErrors.stream().map(e -> e.getCode()).collect(Collectors.joining(","));
            return HtResultInfoWrapper.fail(HtCommonErrorEnum.COMBINE_ERROR.setMsgBindReturn(errors));
        }
        userService.updateUser(userModel);
        return HtResultInfoWrapper.success();
    }

    @PostMapping("login")
    public ResultBinder login(@RequestParam("userName") String userName, @RequestParam("password") String password) {
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
            Subject user = SecurityUtils.getSubject();
            user.login(token);
        } catch (UnknownAccountException e) {
            logger.error("用户名{}错误，未找到对应用户", userName);
            return HtResultInfoWrapper.fail(HtUserErrorEnum.USERNAME_OR_PASSWORD_ERROR);
        } catch (IncorrectCredentialsException e) {
            logger.error("账号{}的密码{}不正确", userName, password);
            return HtResultInfoWrapper.fail(HtUserErrorEnum.USERNAME_OR_PASSWORD_ERROR);
        } catch (LockedAccountException e) {
            logger.error("账号{}被锁定", userName);
            return HtResultInfoWrapper.fail(HtUserErrorEnum.USER_LOCKED);
        } catch (DisabledAccountException e) {
            logger.error("账号{}被禁用", userName);
            return HtResultInfoWrapper.fail(HtUserErrorEnum.USER_DISABLED);
        } catch (AuthenticationException e) {
            logger.error("{}登录失败", userName, e);
            return HtResultInfoWrapper.fail(HtUserErrorEnum.LOGIN_FAILED);
        }
        return HtResultInfoWrapper.success(HtUserErrorEnum.LOGIN_SUCCESSED);
    }
}