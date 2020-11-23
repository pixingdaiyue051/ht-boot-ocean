package com.tequeno.iou.service.res;

import com.tequeno.iou.pojo.sys.res.ResourceInfo;
import com.tequeno.iou.pojo.sys.res.UserRoleResQuery;
import com.tequeno.iou.pojo.sys.res.ViewUserRoleRes;
import com.tequeno.iou.service.BaseService;

public interface ResourceService extends BaseService<ResourceInfo, UserRoleResQuery> {

    ResourceInfo selectResByResCode(String resCode);

    ViewUserRoleRes selectUserRes(String userName, String resCode);
}