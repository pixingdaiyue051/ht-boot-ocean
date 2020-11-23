package com.tequeno.bootssm.service.res;

import com.tequeno.bootssm.pojo.sys.res.ResourceInfo;
import com.tequeno.bootssm.pojo.sys.res.UserRoleResQuery;
import com.tequeno.bootssm.pojo.sys.res.ViewUserRoleRes;
import com.tequeno.bootssm.service.BaseService;

public interface ResourceService extends BaseService<ResourceInfo, UserRoleResQuery> {

    ResourceInfo selectResByResCode(String resCode);

    ViewUserRoleRes selectUserRes(String userName, String resCode);
}