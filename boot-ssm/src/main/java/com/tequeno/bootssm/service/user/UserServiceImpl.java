package com.tequeno.bootssm.service.user;

import com.tequeno.bootssm.mapper.sys.RoleInfoMapper;
import com.tequeno.bootssm.mapper.sys.UserInfoMapper;
import com.tequeno.bootssm.mapper.sys.UserPasswordMapper;
import com.tequeno.bootssm.pojo.sys.user.UserInfo;
import com.tequeno.bootssm.pojo.sys.user.UserInfoQuery;
import com.tequeno.bootssm.pojo.sys.user.UserModel;
import com.tequeno.bootssm.pojo.sys.user.UserPassword;
import com.tequeno.bootssm.service.BaseServiceImpl;
import com.tequeno.common.constants.HtZeroOneConstant;
import com.tequeno.common.enums.HtCommonErrorEnum;
import com.tequeno.common.enums.JedisKeyPrefixEnum;
import com.tequeno.common.utils.HtCommonException;
import com.tequeno.utils.HtLocalMethod;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserInfoMapper, UserInfo, UserInfoQuery> implements UserService {

    @Autowired
    private UserPasswordMapper passwordMapper;

    @Autowired
    private RoleInfoMapper roleMapper;

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void addUser(UserModel userModel) {
        // 1.写入用户信息
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(userModel, userInfo);
        userInfo.setEnabled(HtZeroOneConstant.ENABLED);
        super.insertSelective(userInfo);
        // 2.写入加密的密码信息
        UserPassword userPassword = new UserPassword();
        userPassword.setUserId(userInfo.getId());
        userPassword.setEncryptPassword(HtLocalMethod.shiroEncode(userModel.getPassword(), userModel.getUserName()));
        passwordMapper.insertSelective(userPassword);
        // 3.密码写入缓存
        cacheUtil.hset(JedisKeyPrefixEnum.HUSER_PASSWORD.getPrefix(), userInfo.getId().toString(), userPassword.getEncryptPassword());
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void updateUser(UserModel userModel) {
//         1.先执行查询，获取数据库或缓存中的用户信息
        UserInfo userInDb = Optional.ofNullable(super.selectByPrimaryKey(userModel.getId(), JedisKeyPrefixEnum.USER))
                .orElseThrow(() -> new HtCommonException(HtCommonErrorEnum.OBEJCT_NOT_FETCHED));
//         2.根据id更新用户信息，并删除缓存
        userModel.setPassword(null);
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(userModel, userInfo);
        userInfo.setId(userInDb.getId());
        super.updateSelective(userInDb.getId(), userInfo, JedisKeyPrefixEnum.USER);
//         3.根据用户名删除缓存
        cacheUtil.del(JedisKeyPrefixEnum.USER.assemblyKey(userInDb.getUserName()));
//        4.发送消息级联更新用户信息
//        cacheUtil.sendMsg("chanel:userName", userInDb.getUserName() + ":" + userInfo.getUserName());
//        if (!StringUtils.equals(userInfo.getUserName(), userInDb.getUserName())) {
//            mapper.syncUpdateName(userInfo.getUserName(), userInDb.getUserName());
//        }
    }

    @Override
    public UserInfo selectByUsername(String userName) {
        final String key = JedisKeyPrefixEnum.USER.assemblyKey(userName);
        Object o = Optional.ofNullable(cacheUtil.get(key)).orElseGet(() -> {
            UserInfo userInfo = mapper.selectByUsername(userName);
            cacheUtil.set(key, userInfo);
            return userInfo;
        });
        return (UserInfo) o;
    }

    @Override
    public String selectPasswordByUserId(Long userId) {
        String key = JedisKeyPrefixEnum.HUSER_PASSWORD.getPrefix();
        Object o = Optional.ofNullable(cacheUtil.hget(key, userId.toString())).orElseGet(() -> {
            UserPassword userPassword = passwordMapper.selectByUserId(userId);
            cacheUtil.hset(key, userPassword.getUserId().toString(), userPassword.getEncryptPassword());
            return userPassword.getEncryptPassword();
        });
        return (String) o;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void enableDisableUser(String ids, int enableStatus) {
        if (StringUtils.isBlank(ids)) {
            throw new HtCommonException(HtCommonErrorEnum.PARAMETER_NOT_VALID);
        }
        String[] idsStr = ids.split(",");
        if (ArrayUtils.isEmpty(idsStr)) {
            throw new HtCommonException(HtCommonErrorEnum.PARAMETER_NOT_VALID);
        }
        UserInfo user2Bupdated = new UserInfo();
        user2Bupdated.setEnabled(enableStatus);
//        1.没有查找到用户的id以及状态不一致的都不处理
        Arrays.stream(idsStr)
                .map(id -> this.selectByPrimaryKey(Long.valueOf(id), JedisKeyPrefixEnum.USER))
                .filter(u -> null != u && !u.getEnabled().equals(enableStatus))
                .forEach(u -> {
//         2.根据id更新用户信息，并删除缓存
                    user2Bupdated.setId(u.getId());
                    this.updateSelective(u.getId(), user2Bupdated, JedisKeyPrefixEnum.USER);
//         3.根据用户名删除缓存
                    cacheUtil.del(JedisKeyPrefixEnum.USER.assemblyKey(u.getUserName()));
                });
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void deleteUser(String ids) {
        if (StringUtils.isBlank(ids)) {
            throw new HtCommonException(HtCommonErrorEnum.PARAMETER_NOT_VALID);
        }
        String[] idsStr = ids.split(",");
        if (ArrayUtils.isEmpty(idsStr)) {
            throw new HtCommonException(HtCommonErrorEnum.PARAMETER_NOT_VALID);
        }
        // 没有查找到用户的id不处理
        Arrays.stream(idsStr)
                .map(id -> this.selectByPrimaryKey(Long.valueOf(id), JedisKeyPrefixEnum.USER))
                .filter(Objects::nonNull)
                .forEach(u -> {
//                    1.删除用户与以用户id为key的缓存
                    this.deleteByPrimaryKey(u.getId(), JedisKeyPrefixEnum.USER);
//                    2.删除用户名为key的缓存
                    cacheUtil.del(JedisKeyPrefixEnum.USER.assemblyKey(u.getUserName()));
//                    3.删除用户用户密码信息
                    passwordMapper.deleteByUserId(u.getId());
//                    4.删除用户密码缓存
                    cacheUtil.hdel(JedisKeyPrefixEnum.HUSER_PASSWORD.getPrefix(), u.getId().toString());
//                    5.删除用户角色关联信息,不会直接删除角色信息
                    roleMapper.deleteUserRole(u.getId(), null, null);
//                    6.删除用户权限缓存
                    cacheUtil.del(JedisKeyPrefixEnum.HUSER_RES.assemblyKey(u.getUserName()));
                });
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void bindPhoneOrEmail(String userName, Consumer<UserInfo> c) {
        UserInfo userInfoDb = this.selectByUsername(userName);
        UserInfo user2BeUpdated = new UserInfo();
        user2BeUpdated.setId(userInfoDb.getId());
        c.accept(user2BeUpdated);
        updateSelective(user2BeUpdated.getId(), user2BeUpdated, JedisKeyPrefixEnum.USER);
        cacheUtil.del(JedisKeyPrefixEnum.USER.assemblyKey(userName));
    }
}