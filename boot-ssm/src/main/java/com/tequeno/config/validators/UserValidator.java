package com.tequeno.config.validators;

import com.tequeno.bootssm.pojo.sys.user.UserModel;
import com.tequeno.common.constants.HtCommonRegPattern;
import com.tequeno.common.enums.HtCommonErrorEnum;
import com.tequeno.common.enums.HtUserErrorEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {
        if (null == o) {
            errors.reject(HtCommonErrorEnum.PARAMETER_NOT_EMPTY.getMsg());
            return;
        }
        boolean isRightModel = o instanceof UserModel;
        if (!isRightModel) {
            errors.reject(HtCommonErrorEnum.PARAMETER_NOT_MATCHED.getMsg());
            return;
        }
        UserModel userModel = (UserModel) o;
        if (StringUtils.isBlank(userModel.getUserName())) {
            errors.reject(HtUserErrorEnum.USERNAME_NOT_EMPTY.getMsg());
        }
        if (StringUtils.isBlank(userModel.getTrueName())) {
            errors.reject(HtUserErrorEnum.TRUENAME_NOT_EMPTY.getMsg());
        }
        if (StringUtils.isBlank(userModel.getPassword())) {
            errors.reject(HtUserErrorEnum.PASSWORD_NOT_EMPTY.getMsg());
        }
        if (StringUtils.isNotBlank(userModel.getPhoneNum())) {
            if (!Pattern.matches(HtCommonRegPattern.REG_PHONE, userModel.getPhoneNum())) {
                errors.reject(HtUserErrorEnum.PHONE_NOT_MATCHED.getMsg());
            }
        }
        if (StringUtils.isNotBlank(userModel.getEmail())) {
            if (!Pattern.matches(HtCommonRegPattern.REG_MAIL, userModel.getEmail())) {
                errors.reject(HtUserErrorEnum.MAIL_NOT_MATCHED.getMsg());
            }
        }
    }

    public void updateValidate(Object o, Errors errors) {
        if (null == o) {
            errors.reject(HtCommonErrorEnum.PARAMETER_NOT_EMPTY.getMsg());
            return;
        }
        boolean isRightModel = o instanceof UserModel;
        if (!isRightModel) {
            errors.reject(HtCommonErrorEnum.PARAMETER_NOT_MATCHED.getMsg());
            return;
        }
        UserModel userModel = (UserModel) o;
        if (null == userModel.getId()) {
            errors.reject(HtUserErrorEnum.ID_NOT_MATCHED.getMsg());
        }
        if (null != userModel.getUserName()) {
            errors.reject(HtUserErrorEnum.USERNAME_CANNOT_MODIFY.getMsg());
        }
        if (StringUtils.isNotBlank(userModel.getPhoneNum())) {
            if (!Pattern.matches(HtCommonRegPattern.REG_PHONE, userModel.getPhoneNum())) {
                errors.reject(HtUserErrorEnum.PHONE_NOT_MATCHED.getMsg());
            }
        }
        if (StringUtils.isNotBlank(userModel.getEmail())) {
            if (!Pattern.matches(HtCommonRegPattern.REG_MAIL, userModel.getEmail())) {
                errors.reject(HtUserErrorEnum.MAIL_NOT_MATCHED.getMsg());
            }
        }
    }

    public void bindValidate(Object o, Errors errors) {
        if (null == o) {
            errors.reject(HtCommonErrorEnum.PARAMETER_NOT_EMPTY.getMsg());
            return;
        }
        boolean isRightModel = o instanceof UserModel;
        if (!isRightModel) {
            errors.reject(HtCommonErrorEnum.PARAMETER_NOT_MATCHED.getMsg());
            return;
        }
        UserModel userModel = (UserModel) o;
        if (StringUtils.isBlank(userModel.getUserName())) {
            errors.reject(HtUserErrorEnum.USERNAME_NOT_EMPTY.getMsg());
        }
        if (StringUtils.isBlank(userModel.getOpt())) {
            errors.reject(HtCommonErrorEnum.OPT_NOT_EMPTY.getMsg());
        }
        boolean phoneNotBlank = StringUtils.isNotBlank(userModel.getPhoneNum());
        boolean emailNotBlank = StringUtils.isNotBlank(userModel.getEmail());
        if (phoneNotBlank && emailNotBlank) {
            errors.reject(HtUserErrorEnum.BIND_ERROR_1.getMsg());
            return;
        }
        if(!phoneNotBlank && !emailNotBlank){
            errors.reject(HtUserErrorEnum.BIND_ERROR_2.getMsg());
            return;
        }
        if(phoneNotBlank) {
            if (!Pattern.matches(HtCommonRegPattern.REG_PHONE, userModel.getPhoneNum())) {
                errors.reject(HtUserErrorEnum.PHONE_NOT_MATCHED.getMsg());
            }
        }
        if (emailNotBlank) {
            if (!Pattern.matches(HtCommonRegPattern.REG_MAIL, userModel.getEmail())) {
                errors.reject(HtUserErrorEnum.MAIL_NOT_MATCHED.getMsg());
            }
        }
    }
}