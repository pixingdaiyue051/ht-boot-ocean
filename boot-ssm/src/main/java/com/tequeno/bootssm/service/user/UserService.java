package com.tequeno.bootssm.service.user;

import com.tequeno.bootssm.pojo.sys.user.UserInfo;
import com.tequeno.bootssm.pojo.sys.user.UserInfoQuery;
import com.tequeno.bootssm.pojo.sys.user.UserModel;
import com.tequeno.bootssm.service.BaseService;

public interface UserService extends BaseService<UserInfo, UserInfoQuery> {

    void addOneUser(UserModel userModel);

    void updateOneUser(UserModel userModel);
}