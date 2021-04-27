package com.tequeno.service.user;

import com.tequeno.constants.HtZeroOneConstant;
import com.tequeno.enums.HtCommonErrorEnum;
import com.tequeno.enums.JedisKeyPrefixEnum;
import com.tequeno.mapper.sys.RoleInfoMapper;
import com.tequeno.mapper.sys.UserInfoMapper;
import com.tequeno.mapper.sys.UserPasswordMapper;
import com.tequeno.pojo.sys.user.UserInfo;
import com.tequeno.pojo.sys.user.UserInfoQuery;
import com.tequeno.pojo.sys.user.UserModel;
import com.tequeno.pojo.sys.user.UserPassword;
import com.tequeno.service.BaseServiceImpl;
import com.tequeno.utils.HtCommonException;
import com.tequeno.utils.HtCommonMethodUtil;
import com.tequeno.utils.HtEncoderUtil;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserInfoMapper, UserInfo, UserInfoQuery> implements UserService {

    @Resource
    private UserPasswordMapper passwordMapper;

    @Resource
    private RoleInfoMapper roleMapper;

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void addUser(UserModel userModel) {
        // 1.写入用户信息
        userModel.setEnabled(HtZeroOneConstant.ENABLED);
        userModel.setPassword(HtEncoderUtil.sha256Encode(userModel.getPassword(), userModel.getUserName()));
        super.insertSelective(userModel);
        // 2.写入加密的密码信息
        UserPassword userPassword = new UserPassword();
        userPassword.setUserId(userModel.getId());
        userPassword.setEncryptPassword(userModel.getPassword());
        passwordMapper.insertSelective(userPassword);
        // 3.密码写入缓存
        redisUtil.hset(JedisKeyPrefixEnum.HUSER_PASSWORD.getPrefix(), userModel.getId().toString(), userPassword.getEncryptPassword());
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void updateUser(UserModel userModel) {
//         1.先执行查询，获取数据库或缓存中的用户信息
        UserInfo userInDb = super.selectByPrimaryKey(userModel.getId(), JedisKeyPrefixEnum.USER);
//         2.根据id更新用户信息，并删除缓存
        userModel.setId(userInDb.getId());
        super.updateSelective(userInDb.getId(), userModel, JedisKeyPrefixEnum.USER);
//         3.根据用户名删除缓存
        redisUtil.del(JedisKeyPrefixEnum.USER.assemblyKey(userInDb.getUserName()));
//        4.发送消息级联更新用户信息
//        redisUtil.sendMsg("chanel:userName", userInDb.getUserName() + ":" + userInfo.getUserName());
//        if (!StringUtils.equals(userInfo.getUserName(), userInDb.getUserName())) {
//            mapper.syncUpdateName(userInfo.getUserName(), userInDb.getUserName());
//        }
    }

    @Override
    public UserInfo selectByUsername(String userName) {
        final String key = JedisKeyPrefixEnum.USER.assemblyKey(userName);
        Object obj = redisUtil.get(key);
        if (null != obj) {
            return (UserInfo) obj;
        }
        UserInfo userInfo = mapper.selectByUsername(userName);
        if (null != userInfo) {
            redisUtil.set(key, userInfo);
            return userInfo;
        }
        throw new HtCommonException(HtCommonErrorEnum.OBJECT_NOT_FETCHED);
    }

    @Override
    public String selectPasswordByUserId(Long userId) {
        String key = JedisKeyPrefixEnum.HUSER_PASSWORD.getPrefix();
        Object o = Optional.ofNullable(redisUtil.hget(key, userId.toString())).orElseGet(() -> {
            UserPassword userPassword = passwordMapper.selectByUserId(userId);
            redisUtil.hset(key, userPassword.getUserId().toString(), userPassword.getEncryptPassword());
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
        UserInfo user2update = new UserInfo();
        user2update.setEnabled(enableStatus);
//        1.没有查找到用户的id以及状态不一致的都不处理
        Arrays.stream(idsStr)
                .map(id -> this.selectByPrimaryKey(Long.valueOf(id), JedisKeyPrefixEnum.USER))
                .filter(u -> null != u && !u.getEnabled().equals(enableStatus))
                .forEach(u -> {
//         2.根据id更新用户信息，并删除缓存
                    user2update.setId(u.getId());
                    super.updateSelective(u.getId(), user2update, JedisKeyPrefixEnum.USER);
//         3.根据用户名删除缓存
                    redisUtil.del(JedisKeyPrefixEnum.USER.assemblyKey(u.getUserName()));
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
                    super.deleteByPrimaryKey(u.getId(), JedisKeyPrefixEnum.USER);
//                    2.删除用户名为key的缓存
                    redisUtil.del(JedisKeyPrefixEnum.USER.assemblyKey(u.getUserName()));
//                    3.删除用户用户密码信息
                    passwordMapper.deleteByUserId(u.getId());
//                    4.删除用户密码缓存
                    redisUtil.hdel(JedisKeyPrefixEnum.HUSER_PASSWORD.getPrefix(), u.getId().toString());
//                    5.删除用户角色关联信息,不会直接删除角色信息
                    roleMapper.deleteUserRole(u.getId(), null, null);
//                    6.删除用户权限缓存
                    redisUtil.del(JedisKeyPrefixEnum.HUSER_RES.assemblyKey(u.getUserName()));
                });
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void bindPhoneOrEmail(String userName, Consumer<UserInfo> c) {
        UserInfo userInfoDb = this.selectByUsername(userName);
        UserInfo user2update = new UserInfo();
        user2update.setId(userInfoDb.getId());
        c.accept(user2update);
        super.updateSelective(user2update.getId(), user2update, JedisKeyPrefixEnum.USER);
        redisUtil.del(JedisKeyPrefixEnum.USER.assemblyKey(userName));
    }

    @Override
    public String login(UserModel userModel) {
        UserInfo userInfo = this.selectByUsername(userModel.getUserName());
        String password = this.selectPasswordByUserId(userInfo.getId());
        if (userModel.getPassword().equals(password)) {
            String sign = HtEncoderUtil.sha256Encode(password, HtCommonMethodUtil.getDefaultRandomStr());
            redisUtil.set(JedisKeyPrefixEnum.SIGN.assemblyKey(sign), userInfo.getId());
            return sign;
        }
        throw new HtCommonException(HtCommonErrorEnum.FAIL);
    }
}