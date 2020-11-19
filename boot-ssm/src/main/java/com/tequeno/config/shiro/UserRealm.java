package com.tequeno.config.shiro;

import com.tequeno.bootssm.service.user.UserService;
import com.tequeno.common.constants.HtZeroOneConstant;
import com.tequeno.common.enums.JedisKeyPrefixEnum;
import com.tequeno.config.cache.RedisUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 验证用户信息
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = authenticationToken.getPrincipal().toString();
        SimpleAuthenticationInfo authenticationInfo = Optional.ofNullable(userService.selectByUsername(userName))
                .map(u -> {
                    if (HtZeroOneConstant.DISABLED == u.getEnabled()) {
                        throw new DisabledAccountException();
                    }
                    // 设置用户id为key的缓存
                    redisUtil.set(JedisKeyPrefixEnum.USER.assemblyKey(u.getId()), u);
                    String encryptPassword = userService.selectPasswordByUserId(u.getId());
                    SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userName, encryptPassword, getName());
                    // 使用用户名作为盐加密
                    ByteSource salt = ByteSource.Util.bytes(userName);
                    info.setCredentialsSalt(salt);
                    return info;
                }).orElse(null);
        return authenticationInfo;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
}