package com.tequeno.mapper.sys;

import com.tequeno.pojo.sys.user.UserPassword;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface UserPasswordMapper extends Mapper<UserPassword> {

    UserPassword selectByUserId(@Param("userId") Long userId);

    int deleteByUserId(@Param("userId") Long userId);
}