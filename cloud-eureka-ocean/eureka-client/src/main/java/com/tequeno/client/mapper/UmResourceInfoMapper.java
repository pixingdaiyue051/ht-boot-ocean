package com.tequeno.client.mapper;

import com.tequeno.client.entity.UmDataDictionary;
import com.tequeno.client.entity.UmResourceInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface UmResourceInfoMapper extends Mapper<UmResourceInfo> {

    List<UmResourceInfo> selectAllByCondition(Map<String, Object> map);
}