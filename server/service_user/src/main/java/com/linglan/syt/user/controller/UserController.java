package com.linglan.syt.user.controller;

import com.linglan.syt.common.result.Response;
import com.linglan.syt.common.utils.AuthContextHolder;
import com.linglan.syt.model.user.UserInfo;
import com.linglan.syt.user.service.UserInfoService;
import com.linglan.syt.vo.user.LoginVo;
import com.linglan.syt.vo.user.UserAuthVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

    //用户认证接口
    @PostMapping("auth/userAuth")
    public Response userAuth(@RequestBody UserAuthVo userAuthVo, HttpServletRequest request) {
        //传递两个参数，第一个参数用户id，第二个参数认证数据vo对象
        userInfoService.userAuth(AuthContextHolder.getUserId(request),userAuthVo);
        return Response.success();
    }

    //获取用户id信息接口
    @GetMapping("auth/getUserInfo")
    public Response getUserInfo(HttpServletRequest request) {
        Long userId = AuthContextHolder.getUserId(request);
        UserInfo userInfo = userInfoService.getById(userId);
        return Response.success(userInfo);
    }
}
