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
        String key = JedisKeyPrefixEnum.HRES.getPrefix();
        Object o = cacheUtil.hget(key, resCode);
        Object orElseGet = Optional.ofNullable(o).orElseGet(() -> {
            UserRoleResQuery resQuery = new UserRoleResQuery();
            resQuery.setResCode(resCode);
            List<ResourceInfo> resourceInfos = mapper.selectAllByCondition(resQuery);
            if (CollectionUtils.isNotEmpty(resourceInfos)) {
                ResourceInfo resourceInfo = resourceInfos.get(HtZeroOneConstant.ZERO_I);
                cacheUtil.hset(key, resCode, resourceInfo);
                return resourceInfo;
            }
            return null;
        });
        return (ResourceInfo) orElseGet;
    }

    @Override
    public ViewUserRoleRes selectUserRes(String userName, String resCode) {
        String key = JedisKeyPrefixEnum.HUSER_RES.assemblyKey(userName);
        Object o = cacheUtil.hget(key, resCode);
        Object orElseGet = Optional.ofNullable(o).orElseGet(() -> {
            UserRoleResQuery query = new UserRoleResQuery();
            query.setUserName(userName);
            query.setResCode(resCode);
            List<ViewUserRoleRes> userResList = mapper.selectUserRes(query);
            if (CollectionUtils.isNotEmpty(userResList)) {
                ViewUserRoleRes result = userResList.get(HtZeroOneConstant.ZERO_I);
                cacheUtil.hset(key, resCode, result);
                return result;
            }
            return null;
        });
        return (ViewUserRoleRes) orElseGet;
    }
}