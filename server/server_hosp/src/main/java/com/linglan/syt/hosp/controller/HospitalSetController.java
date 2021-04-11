package com.linglan.syt.hosp.controller;

import com.linglan.syt.hosp.service.HospitalSetService;
import com.linglan.syt.model.hosp.HospitalSet;
import com.linglan.syt.model.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/hosp/hospitalSet")
public class HospitalSetController {

    @Autowired
    HospitalSetService hospitalSetService;
    //1 查询医院设置表所有信息
//    @ApiOperation(value = "获取所有医院设置")
    @GetMapping("findAll")
    public Response findAllHospitalSet() {
        //调用service的方法
        List<HospitalSet> list = hospitalSetService.list();
        return Response.success(list);
    }
}
