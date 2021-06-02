package com.linglan.syt.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.linglan.syt.model.user.UserInfo;
import com.linglan.syt.vo.user.LoginVo;
import com.linglan.syt.vo.user.UserAuthVo;

import java.util.Map;

public interface UserInfoService extends IService<UserInfo> {
    Map<String, Object> loginUser(LoginVo loginVo);

    UserInfo selectWxInfoOpenId(String openid);

    void userAuth(Long userId, UserAuthVo userAuthVo);
}
