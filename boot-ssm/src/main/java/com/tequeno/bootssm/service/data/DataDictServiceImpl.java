package com.tequeno.bootssm.service.data;

import com.tequeno.bootssm.mapper.sys.DataDictionaryMapper;
import com.tequeno.bootssm.pojo.sys.data.DataDictionary;
import com.tequeno.bootssm.pojo.sys.data.DataDictionaryQuery;
import com.tequeno.bootssm.service.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class DataDictServiceImpl extends BaseServiceImpl<DataDictionaryMapper, DataDictionary, DataDictionaryQuery> implements DataDictService {
}