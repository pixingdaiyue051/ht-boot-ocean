package com.tequeno.service.data;

import com.tequeno.pojo.sys.data.DataDictionary;
import com.tequeno.pojo.sys.data.DataDictionaryQuery;
import com.tequeno.service.BaseService;

import java.util.Map;

public interface DataDictService extends BaseService<DataDictionary, DataDictionaryQuery> {

    Map<String, DataDictionary> selectDictByTypeCode(String typeCode);

    DataDictionary selectDictByValueCode(String typeCode, String valueCode);
}