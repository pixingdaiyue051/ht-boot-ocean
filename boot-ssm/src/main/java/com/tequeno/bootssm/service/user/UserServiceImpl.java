package com.tequeno.bootssm.service.user;

import com.tequeno.bootssm.mapper.sys.UserInfoMapper;
import com.tequeno.bootssm.mapper.sys.UserPasswordMapper;
import com.tequeno.bootssm.pojo.sys.user.UserInfo;
import com.tequeno.bootssm.pojo.sys.user.UserInfoQuery;
import com.tequeno.bootssm.pojo.sys.user.UserModel;
import com.tequeno.bootssm.pojo.sys.user.UserPassword;
import com.tequeno.bootssm.service.BaseServiceImpl;
import com.tequeno.common.constants.CommonConstants;
import com.tequeno.common.enums.CommonCatchedEnum;
import com.tequeno.common.enums.JedisKeyPrefixEnum;
import com.tequeno.common.utils.CommonException;
import com.tequeno.common.utils.EncoderUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserInfoMapper, UserInfo, UserInfoQuery> implements UserService {

    @Autowired
    private UserPasswordMapper passwordMapper;

    @Override
    @Transactional
    public void addOneUser(UserModel userModel) {
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(userModel, userInfo);
        userInfo.setEnabled(CommonConstants.ENABLE);
        super.insertSelective(userInfo);
        UserPassword userPassword = new UserPassword();
        userPassword.setUserId(userInfo.getId());
        userPassword.setEncryptPassword(EncoderUtil.md5Encode(userModel.getPassword()));
        passwordMapper.insertSelective(userPassword);
    }

    @Override
    @Transactional
    public void updateOneUser(UserModel userModel) {
        UserInfo userInDb = Optional.ofNullable(super.selectByPrimaryKey(userModel.getId()))
                .orElseThrow(() -> new CommonException(CommonCatchedEnum.OBEJCT_NOT_FETCHED));
        userModel.setPassword(null);
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(userModel, userInfo);
        super.updateSelective(userInfo);
        if (!StringUtils.equals(userInfo.getUserName(), userInDb.getUserName())) {
            mapper.syncUpdateName(userInfo.getUserName(), userInDb.getUserName());
        }
        String key = JedisKeyPrefixEnum.USER.assemblyKey(userInfo.getId());
        cacheUtil.del(key);
    }
}