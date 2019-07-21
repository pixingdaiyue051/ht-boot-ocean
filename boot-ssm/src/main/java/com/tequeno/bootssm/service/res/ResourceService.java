package com.tequeno.bootssm.service.res;

import com.tequeno.bootssm.pojo.sys.res.ResourceInfo;
import com.tequeno.bootssm.pojo.sys.res.UserRoleResQuery;
import com.tequeno.bootssm.pojo.sys.res.VUserRoleRes;
import com.tequeno.bootssm.service.BaseService;

public interface ResourceService extends BaseService<ResourceInfo, UserRoleResQuery> {

    ResourceInfo selectResByResCode(String resCode);

    VUserRoleRes selectUserRes(String userName, String resCode);
}