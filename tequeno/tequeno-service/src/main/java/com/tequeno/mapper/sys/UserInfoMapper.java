package com.tequeno.mapper.sys;

import com.tequeno.pojo.sys.user.UserInfo;
import com.tequeno.pojo.sys.user.UserInfoQuery;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserInfoMapper extends Mapper<UserInfo> {

    List<UserInfo> selectAllByCondition(UserInfoQuery query);

    UserInfo selectByUsername(@Param("userName") String userName);

    void syncUpdateName(@Param("oldTrueName") String oldTrueName, @Param("newTrueName") String newTrueName);
}