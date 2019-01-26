package com.tequeno.ribbon.mapper;

import com.tequeno.ribbon.entity.UmDataDictionary;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface UmDataDictionaryMapper extends Mapper<UmDataDictionary> {

    List<UmDataDictionary> selectAllByCondition(Map<String, Object> map);
}