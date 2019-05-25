package com.tequeno.bootssm.mapper.sys;

import com.tequeno.bootssm.pojo.sys.data.DataDictionary;
import com.tequeno.bootssm.pojo.sys.data.DataDictionaryQuery;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface DataDictionaryMapper extends Mapper<DataDictionary> {

    List<DataDictionary> selectAllByCondition(DataDictionaryQuery query);
}