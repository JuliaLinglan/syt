package com.linglan.syt.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.linglan.syt.model.user.UserInfo;
import com.linglan.syt.user.mapper.UserInfoMapper;
import com.linglan.syt.user.service.UserInfoService;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
        implements UserInfoService {
}
