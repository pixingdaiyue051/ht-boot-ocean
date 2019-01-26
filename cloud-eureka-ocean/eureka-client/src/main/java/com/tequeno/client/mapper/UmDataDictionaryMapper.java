package com.tequeno.client.mapper;

import com.tequeno.client.entity.UmDataDictionary;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface UmDataDictionaryMapper extends Mapper<UmDataDictionary> {

    List<UmDataDictionary> selectAllByCondition(Map<String, Object> map);
}