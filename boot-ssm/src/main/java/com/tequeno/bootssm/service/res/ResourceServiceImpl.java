package com.tequeno.bootssm.service.res;

import com.tequeno.bootssm.mapper.sys.ResourceInfoMapper;
import com.tequeno.bootssm.pojo.sys.res.ResourceInfo;
import com.tequeno.bootssm.pojo.sys.res.UserRoleResQuery;
import com.tequeno.bootssm.pojo.sys.res.ViewUserRoleRes;
import com.tequeno.bootssm.service.BaseServiceImpl;
import com.tequeno.common.constants.HtZeroOneConstant;
import com.tequeno.common.enums.JedisKeyPrefixEnum;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResourceServiceImpl extends BaseServiceImpl<ResourceInfoMapper, ResourceInfo, UserRoleResQuery> implements ResourceService {

    @Override
    public ResourceInfo selectResByResCode(String resCode) {
        String resKey = JedisKeyPrefixEnum.HRES.getPrefix();
        Object resObj = redisUtil.hget(resKey, resCode);
        resObj = Optional.ofNullable(resObj).orElseGet(() -> {
            UserRoleResQuery resQuery = new UserRoleResQuery();
            resQuery.setResCode(resCode);
            List<ResourceInfo> resourceInfos = mapper.selectAllByCondition(resQuery);
            if (CollectionUtils.isNotEmpty(resourceInfos)) {
                ResourceInfo resourceInfo = resourceInfos.get(HtZeroOneConstant.ZERO_I);
                redisUtil.hset(resKey, resCode, resourceInfo);
                return resourceInfo;
            }
            return null;
        });
        return (ResourceInfo) resObj;
    }

    @Override
    public ViewUserRoleRes selectUserRes(String userName, String resCode) {
        String userResKey = JedisKeyPrefixEnum.HUSER_RES.assemblyKey(userName);
        Object userResObj = redisUtil.hget(userResKey, resCode);
        userResObj = Optional.ofNullable(userResObj).orElseGet(() -> {
            String resKey = JedisKeyPrefixEnum.HRES.getPrefix();
            Object resObj = redisUtil.hget(resKey, resCode);
            return Optional.ofNullable(resObj).map(resObjProxy -> {
                redisUtil.hset(resKey, resCode, resObjProxy);
                return resObjProxy;
            }).orElseGet(() -> {
                UserRoleResQuery query = new UserRoleResQuery();
                query.setUserName(userName);
                query.setResCode(resCode);
                List<ViewUserRoleRes> userResList = mapper.selectUserRes(query);
                if (CollectionUtils.isNotEmpty(userResList)) {
                    ViewUserRoleRes result = userResList.get(HtZeroOneConstant.ZERO_I);
                    redisUtil.hset(resKey, resCode, result);
                    redisUtil.hset(userResKey, resCode, result);
                    return result;
                }
                return null;
            });
        });
        return (ViewUserRoleRes) userResObj;
    }
}