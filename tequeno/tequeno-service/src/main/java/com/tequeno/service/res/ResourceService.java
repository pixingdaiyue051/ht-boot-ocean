package com.tequeno.service.res;

import com.tequeno.pojo.sys.res.ResourceInfo;
import com.tequeno.pojo.sys.res.UserRoleResQuery;
import com.tequeno.pojo.sys.res.ViewUserRoleRes;
import com.tequeno.service.BaseService;

public interface ResourceService extends BaseService<ResourceInfo, UserRoleResQuery> {

    ResourceInfo selectResByResCode(String resCode);

    ViewUserRoleRes selectUserRes(String userName, String resCode);
}