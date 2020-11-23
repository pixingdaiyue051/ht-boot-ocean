package com.tequeno.iou.mapper.sys;

import com.tequeno.iou.pojo.sys.user.UserPassword;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface UserPasswordMapper extends Mapper<UserPassword> {

    UserPassword selectByUserId(@Param("userId") Long userId);

    int deleteByUserId(@Param("userId") Long userId);
}