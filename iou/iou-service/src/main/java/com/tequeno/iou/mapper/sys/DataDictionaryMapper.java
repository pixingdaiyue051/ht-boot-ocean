package com.tequeno.iou.mapper.sys;

import com.tequeno.iou.pojo.sys.data.DataDictionary;
import com.tequeno.iou.pojo.sys.data.DataDictionaryQuery;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface DataDictionaryMapper extends Mapper<DataDictionary> {

    List<DataDictionary> selectAllByCondition(DataDictionaryQuery query);
}