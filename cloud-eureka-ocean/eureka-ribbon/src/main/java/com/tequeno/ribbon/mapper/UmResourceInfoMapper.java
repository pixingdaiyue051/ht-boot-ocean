package com.tequeno.ribbon.mapper;

import com.tequeno.ribbon.entity.UmResourceInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface UmResourceInfoMapper extends Mapper<UmResourceInfo> {

    List<UmResourceInfo> selectAllByCondition(Map<String, Object> map);
}