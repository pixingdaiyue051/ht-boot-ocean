package com.tequeno.bootssm.mapper.sys;

import com.tequeno.bootssm.pojo.sys.res.ResourceInfo;
import com.tequeno.bootssm.pojo.sys.res.ResourceInfoQuery;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ResourceInfoMapper extends Mapper<ResourceInfo> {

    List<ResourceInfo> selectAllByCondition(ResourceInfoQuery query);
}