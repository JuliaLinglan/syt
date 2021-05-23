package com.linglan.syt.hosp.controller.api;

import com.linglan.syt.common.helper.HttpRequestHelper;
import com.linglan.syt.common.result.Response;
import com.linglan.syt.hosp.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/api/hosp")
public class ApiController {
    @Autowired
    private HospitalService hospitalService;

    //上传医院接口
    @PostMapping("saveHospital")
    public Response saveHosp(HttpServletRequest request) {
        //获取传递过来医院信息
        Map<String, String[]> requestMap = request.getParameterMap();
        Map<String, Object> paramMap = HttpRequestHelper.switchMap(requestMap);

        //调用service的方法
        hospitalService.save(paramMap);
        return Response.success();

    }
}
