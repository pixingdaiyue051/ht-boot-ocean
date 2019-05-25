package com.tequeno.bootssm.mapper.sys;

import com.tequeno.bootssm.pojo.sys.user.UserPassword;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface UserPasswordMapper extends Mapper<UserPassword> {

    UserPassword selectByUserId(@Param("userId") Integer userId);
}