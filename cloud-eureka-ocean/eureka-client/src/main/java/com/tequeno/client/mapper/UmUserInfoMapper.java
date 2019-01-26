package com.tequeno.client.mapper;

import com.tequeno.client.entity.UmUserInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface UmUserInfoMapper extends Mapper<UmUserInfo> {

    List<UmUserInfo> selectAllByCondition(Map<String, Object> map);
}