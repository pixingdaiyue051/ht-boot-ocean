package com.tequeno.iou.service.data;

import com.tequeno.iou.pojo.sys.data.DataDictionary;
import com.tequeno.iou.pojo.sys.data.DataDictionaryQuery;
import com.tequeno.iou.service.BaseService;

import java.util.Map;

public interface DataDictService extends BaseService<DataDictionary, DataDictionaryQuery> {

    Map<String, DataDictionary> selectDictByTypeCode(String typeCode);

    DataDictionary selectDictByValueCode(String typeCode, String valueCode);
}