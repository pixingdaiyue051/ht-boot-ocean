package com.tequeno.bootssm.service.data;

import com.tequeno.bootssm.mapper.sys.DataDictionaryMapper;
import com.tequeno.bootssm.pojo.sys.data.DataDictionary;
import com.tequeno.bootssm.pojo.sys.data.DataDictionaryQuery;
import com.tequeno.bootssm.service.BaseServiceImpl;
import com.tequeno.common.constants.HtCommonConstant;
import com.tequeno.common.constants.HtZeroOneConstant;
import com.tequeno.common.enums.JedisKeyPrefixEnum;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DataDictServiceImpl extends BaseServiceImpl<DataDictionaryMapper, DataDictionary, DataDictionaryQuery> implements DataDictService {

    @Override
    public Map<String, DataDictionary> selectDictByTypeCode(String typeCode) {
        if (StringUtils.isBlank(typeCode)) {
            return null;
        }
        Object o = Optional.ofNullable(redisUtil.hmget(typeCode)).orElseGet(() -> {
            DataDictionaryQuery dictQuery = new DataDictionaryQuery();
            dictQuery.setTypeCode(typeCode);
            List<DataDictionary> dictionaryList = mapper.selectAllByCondition(dictQuery);
            if (CollectionUtils.isEmpty(dictionaryList)) {
                return null;
            }
            final String key = JedisKeyPrefixEnum.HDICT.assemblyKey(typeCode);
            dictionaryList.forEach(dict -> redisUtil.hset(key, dict.getValueCode(), dict));
            return redisUtil.hmget(key);
        });
        return (Map<String, DataDictionary>) o;
    }

    @Override
    public DataDictionary selectDictByValueCode(String typeCode, String valueCode) {
        if (StringUtils.isBlank(typeCode) || StringUtils.isBlank(valueCode)) {
            return null;
        }
        Object o = Optional.ofNullable(redisUtil.hget(typeCode, valueCode)).orElseGet(() -> {
            DataDictionaryQuery dictQuery = new DataDictionaryQuery();
            dictQuery.setTypeCode(typeCode);
            dictQuery.setValueCode(valueCode);
            List<DataDictionary> dictionaryList = mapper.selectAllByCondition(dictQuery);
            if (CollectionUtils.isEmpty(dictionaryList)) {
                return null;
            }
            final String key = JedisKeyPrefixEnum.HDICT.assemblyKey(typeCode);
            DataDictionary dataDictionary = dictionaryList.get(HtZeroOneConstant.ZERO_I);
            redisUtil.hset(key, valueCode, dataDictionary);
            return dataDictionary;
        });
        return (DataDictionary) o;
    }
}