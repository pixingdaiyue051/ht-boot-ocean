package com.tequeno.client.service.user;

import com.tequeno.client.entity.UmUserInfo;
import com.tequeno.client.mapper.UmUserInfoMapper;
import com.tequeno.client.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserInfoServiceImpl extends BaseServiceImpl<UmUserInfoMapper, UmUserInfo> implements UserInfoService {
}
