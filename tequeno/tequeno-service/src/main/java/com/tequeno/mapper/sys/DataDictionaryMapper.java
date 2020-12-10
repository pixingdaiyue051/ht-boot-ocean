package com.tequeno.mapper.sys;

import com.tequeno.pojo.sys.data.DataDictionary;
import com.tequeno.pojo.sys.data.DataDictionaryQuery;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface DataDictionaryMapper extends Mapper<DataDictionary> {

    List<DataDictionary> selectAllByCondition(DataDictionaryQuery query);
}