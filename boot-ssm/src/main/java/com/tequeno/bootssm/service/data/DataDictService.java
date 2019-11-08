package com.tequeno.bootssm.service.data;

import com.tequeno.bootssm.pojo.sys.data.DataDictionary;
import com.tequeno.bootssm.pojo.sys.data.DataDictionaryQuery;
import com.tequeno.bootssm.service.BaseService;

import java.util.Map;

public interface DataDictService extends BaseService<DataDictionary, DataDictionaryQuery> {

    Map<String, DataDictionary> selectDictByTypeCode(String typeCode);

    DataDictionary selectDictByValueCode(String typeCode, String valueCode);
}