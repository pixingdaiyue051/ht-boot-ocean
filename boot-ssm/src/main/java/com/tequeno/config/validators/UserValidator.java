package com.tequeno.config.validators;

import com.tequeno.bootssm.pojo.sys.user.UserModel;
import com.tequeno.common.constants.CommonRegPattern;
import com.tequeno.common.enums.CommonCatchedEnum;
import com.tequeno.enums.BussinessEnum;
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
            errors.reject(CommonCatchedEnum.PARAMETER_NOT_EMPTY.getMsg());
            return;
        }
        boolean isRightModel = o instanceof UserModel;
        if (!isRightModel) {
            errors.reject(CommonCatchedEnum.PARAMETER_NOT_MATCHED.getMsg());
            return;
        }
        UserModel userModel = (UserModel) o;
        if (StringUtils.isBlank(userModel.getUserName())) {
            errors.reject(BussinessEnum.USERNAME_NOT_EMPTY.getMsg());
        }
        if (StringUtils.isBlank(userModel.getTrueName())) {
            errors.reject(BussinessEnum.TRUENAME_NOT_EMPTY.getMsg());
        }
        if (StringUtils.isBlank(userModel.getPassword())) {
            errors.reject(BussinessEnum.PASSWORD_NOT_EMPTY.getMsg());
        }
        if (StringUtils.isNotBlank(userModel.getPhoneNum())) {
            if (!Pattern.matches(CommonRegPattern.REG_PHONE, userModel.getPhoneNum())) {
                errors.reject(BussinessEnum.PHONE_NOT_MATCHED.getMsg());
            }
        }
        if (StringUtils.isNotBlank(userModel.getEmail())) {
            if (!Pattern.matches(CommonRegPattern.REG_MAIL, userModel.getEmail())) {
                errors.reject(BussinessEnum.MAIL_NOT_MATCHED.getMsg());
            }
        }
    }

    public void updateValidate(Object o, Errors errors) {
        if (null == o) {
            errors.reject(CommonCatchedEnum.PARAMETER_NOT_EMPTY.getMsg());
            return;
        }
        boolean isRightModel = o instanceof UserModel;
        if (!isRightModel) {
            errors.reject(CommonCatchedEnum.PARAMETER_NOT_MATCHED.getMsg());
            return;
        }
        UserModel userModel = (UserModel) o;
        if (null == userModel.getId()) {
            errors.reject(BussinessEnum.ID_NOT_MATCHED.getMsg());
        }
        if (StringUtils.isNotBlank(userModel.getPhoneNum())) {
            if (!Pattern.matches(CommonRegPattern.REG_PHONE, userModel.getPhoneNum())) {
                errors.reject(BussinessEnum.PHONE_NOT_MATCHED.getMsg());
            }
        }
        if (StringUtils.isNotBlank(userModel.getEmail())) {
            if (!Pattern.matches(CommonRegPattern.REG_MAIL, userModel.getEmail())) {
                errors.reject(BussinessEnum.MAIL_NOT_MATCHED.getMsg());
            }
        }
    }
}