package com.tequeno.bootssm.controller.user;

import com.github.pagehelper.PageInfo;
import com.tequeno.bootssm.controller.BaseController;
import com.tequeno.bootssm.pojo.sys.user.UserInfo;
import com.tequeno.bootssm.pojo.sys.user.UserInfoQuery;
import com.tequeno.bootssm.pojo.sys.user.UserModel;
import com.tequeno.bootssm.service.user.UserService;
import com.tequeno.common.constants.CommonRegPattern;
import com.tequeno.common.constants.ResultBinder;
import com.tequeno.common.enums.CommonCatchedEnum;
import com.tequeno.common.enums.JedisKeyPrefixEnum;
import com.tequeno.common.utils.CommonException;
import com.tequeno.common.utils.CommonMethodUtil;
import com.tequeno.common.utils.CommonResultUtil;
import com.tequeno.config.validators.UserValidator;
import com.tequeno.enums.BussinessEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserBussinessController extends BaseController {

    @Autowired
    private UserValidator validator;

    @Autowired
    private UserService userService;

    @PostMapping("pageBind")
    public ResultBinder pageBind(UserInfoQuery userQ) {
        userQ.setPageSize(3);
        PageInfo<UserInfo> pager = userService.findPager(userQ);
        System.out.println(pager);
        if (pager.getTotal() > 0) {
            return CommonResultUtil.success(pager);
        }
        return CommonResultUtil.fail();
    }

    @PostMapping("list")
    public ResultBinder list(@RequestBody UserInfoQuery userQ) {
        List<UserInfo> userInfoList = userService.getList(userQ);
        if (CollectionUtils.isEmpty(userInfoList)) {
            return CommonResultUtil.fail(BussinessEnum.USER_NOT_EXIST);
        }
        return CommonResultUtil.success(userInfoList);
    }

    @GetMapping("one/{id}")
    public ResultBinder one(@PathVariable String id) {
        String key = JedisKeyPrefixEnum.USER.assemblyKey(id);
        Object o = cacheUtil.get(key);
        UserInfo userInfo;
        if (null == o) {
            userInfo = userService.selectByPrimaryKey(id);
            if (null == userInfo) {
                throw new CommonException(BussinessEnum.USER_NOT_EXIST);
            }
            cacheUtil.set(key, userInfo);
        } else {
            userInfo = (UserInfo) o;
        }
        return CommonResultUtil.success(userInfo);
    }

    @PostMapping("addOne")
    public ResultBinder addOne(@RequestBody UserModel userModel, BindingResult result) {
        validator.validate(userModel, result);
        if (result.hasErrors()) {
            List<ObjectError> allErrors = result.getAllErrors();
            String errors = allErrors.stream().map(e -> e.getCode()).collect(Collectors.joining(","));
            return CommonResultUtil.fail(CommonCatchedEnum.PARAMETER_NOT_VALID, errors);
        }
        userService.addOneUser(userModel);
        return CommonResultUtil.success(true);
    }

    @PostMapping("updateOne")
    public ResultBinder updateOne(@RequestBody UserModel userModel, BindingResult result) {
        validator.updateValidate(userModel, result);
        if (result.hasErrors()) {
            List<ObjectError> allErrors = result.getAllErrors();
            String errors = allErrors.stream().map(e -> e.getCode()).collect(Collectors.joining(","));
            return CommonResultUtil.fail(CommonCatchedEnum.PARAMETER_NOT_VALID, errors);
        }
        userService.updateOneUser(userModel);
        return CommonResultUtil.success(true);
    }

    @PostMapping("opt")
    public ResultBinder getOpt(@RequestParam("tel") String tel) {
        boolean matched = tel.matches(CommonRegPattern.REG_PHONE);
        if (!matched) {
            return CommonResultUtil.fail(BussinessEnum.PHONE_NOT_MATCHED);
        }
        String key = JedisKeyPrefixEnum.USER.assemblyKey(tel);
        Object o = Optional.ofNullable(cacheUtil.get(key)).orElseGet(() -> {
            String optCode = CommonMethodUtil.getNonceStr(4);
            cacheUtil.set(key, optCode, 30 * 60L);
            return optCode;
        });
        return CommonResultUtil.success(o);
    }
}