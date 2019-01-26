package com.tequeno.client.mapper;

import com.tequeno.client.entity.UmCompanyInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface UmCompanyInfoMapper extends Mapper<UmCompanyInfo> {

    List<UmCompanyInfo> selectAllByCondition(Map<String, Object> map);

}