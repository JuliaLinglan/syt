package com.linglan.syt.user.controller;

import com.linglan.syt.common.result.Response;
import com.linglan.syt.user.service.UserInfoService;
import com.linglan.syt.vo.user.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    UserInfoService userInfoService;

    //用户手机号登录接口
    @PostMapping("login")
    public Response login(@RequestBody LoginVo loginVo) {
        Map<String,Object> info = userInfoService.loginUser(loginVo);
        return Response.success(info);
    }
}
