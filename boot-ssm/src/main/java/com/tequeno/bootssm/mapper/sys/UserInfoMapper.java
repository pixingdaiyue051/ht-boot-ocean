package com.tequeno.bootssm.mapper.sys;

import com.tequeno.bootssm.pojo.sys.user.UserInfo;
import com.tequeno.bootssm.pojo.sys.user.UserInfoQuery;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserInfoMapper extends Mapper<UserInfo> {

    List<UserInfo> selectAllByCondition(UserInfoQuery query);
}