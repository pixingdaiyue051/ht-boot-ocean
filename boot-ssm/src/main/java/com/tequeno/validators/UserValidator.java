package com.tequeno.validators;

import com.tequeno.bootssm.pojo.sys.user.UserModel;
import com.tequeno.common.constants.HtCommonRegPattern;
import com.tequeno.common.enums.HtCommonErrorEnum;
import com.tequeno.common.enums.HtUserErrorEnum;
import com.tequeno.common.utils.HtCommonException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {
        try {
            if (null == o) {
                throw new HtCommonException(HtCommonErrorEnum.PARAMETER_NOT_EMPTY);
            }
            boolean isRightModel = o instanceof UserModel;
            if (!isRightModel) {
                throw new HtCommonException(HtCommonErrorEnum.PARAMETER_NOT_MATCHED);
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
        } catch (Exception e) {
            if (e instanceof HtCommonException) {
                errors.reject(e.getMessage());
            } else {
                errors.reject(HtCommonErrorEnum.SYSTEM_ERROR.getMsg());
            }
        }
        if (errors.hasErrors()) {
            List<ObjectError> allErrors = errors.getAllErrors();
            String errMsg = allErrors.stream().map(e -> e.getCode()).collect(Collectors.joining(","));
            throw new HtCommonException(HtCommonErrorEnum.COMBINE_ERROR.setMsgBindReturn(errMsg));
        }
    }

    public void updateValidate(Object o, Errors errors) {
        try {
            if (null == o) {
                throw new HtCommonException(HtCommonErrorEnum.PARAMETER_NOT_EMPTY);
            }
            boolean isRightModel = o instanceof UserModel;
            if (!isRightModel) {
                throw new HtCommonException(HtCommonErrorEnum.PARAMETER_NOT_MATCHED);
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
        } catch (Exception e) {
            if (e instanceof HtCommonException) {
                errors.reject(e.getMessage());
            } else {
                errors.reject(HtCommonErrorEnum.SYSTEM_ERROR.getMsg());
            }
        }
        if (errors.hasErrors()) {
            List<ObjectError> allErrors = errors.getAllErrors();
            String errMsg = allErrors.stream().map(e -> e.getCode()).collect(Collectors.joining(","));
            throw new HtCommonException(HtCommonErrorEnum.COMBINE_ERROR.setMsgBindReturn(errMsg));
        }
    }

    public void bindValidate(Object o, Errors errors) {
        try {
            if (null == o) {
                throw new HtCommonException(HtCommonErrorEnum.PARAMETER_NOT_EMPTY);
            }
            boolean isRightModel = o instanceof UserModel;
            if (!isRightModel) {
                throw new HtCommonException(HtCommonErrorEnum.PARAMETER_NOT_MATCHED);
            }
            UserModel userModel = (UserModel) o;
            if (StringUtils.isBlank(userModel.getUserName())) {
                errors.reject(HtUserErrorEnum.USERNAME_NOT_EMPTY.getMsg());
            }
            if (StringUtils.isBlank(userModel.getOtp())) {
                errors.reject(HtCommonErrorEnum.OTP_NOT_EMPTY.getMsg());
            }
            boolean phoneNotBlank = StringUtils.isNotBlank(userModel.getPhoneNum());
            boolean emailNotBlank = StringUtils.isNotBlank(userModel.getEmail());
            if (phoneNotBlank && emailNotBlank) {
                errors.reject(HtUserErrorEnum.BIND_ERROR_1.getMsg());
                return;
            }
            if (!phoneNotBlank && !emailNotBlank) {
                errors.reject(HtUserErrorEnum.BIND_ERROR_2.getMsg());
                return;
            }
            if (phoneNotBlank) {
                if (!Pattern.matches(HtCommonRegPattern.REG_PHONE, userModel.getPhoneNum())) {
                    errors.reject(HtUserErrorEnum.PHONE_NOT_MATCHED.getMsg());
                }
            }
            if (emailNotBlank) {
                if (!Pattern.matches(HtCommonRegPattern.REG_MAIL, userModel.getEmail())) {
                    errors.reject(HtUserErrorEnum.MAIL_NOT_MATCHED.getMsg());
                }
            }
        } catch (Exception e) {
            if (e instanceof HtCommonException) {
                errors.reject(e.getMessage());
            } else {
                errors.reject(HtCommonErrorEnum.SYSTEM_ERROR.getMsg());
            }
        }
        if (errors.hasErrors()) {
            List<ObjectError> allErrors = errors.getAllErrors();
            String errMsg = allErrors.stream().map(e -> e.getCode()).collect(Collectors.joining(","));
            throw new HtCommonException(HtCommonErrorEnum.COMBINE_ERROR.setMsgBindReturn(errMsg));
        }
    }
}