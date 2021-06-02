package com.linglan.syt.user.api;

import com.linglan.syt.common.result.Response;
import com.linglan.syt.common.utils.AuthContextHolder;
import com.linglan.syt.model.user.Patient;
import com.linglan.syt.user.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

//就诊人管理接口
@RestController
@RequestMapping("/api/user/patient")
public class PatientApiController {

    @Autowired
    private PatientService patientService;

    //获取就诊人列表
    @GetMapping("auth/findAll")
    public Response findAll(HttpServletRequest request) {
        //获取当前登录用户id
        Long userId = AuthContextHolder.getUserId(request);
        List<Patient> list = patientService.findAllUserId(userId);
        return Response.success(list);
    }

    //添加就诊人
    @PostMapping("auth/save")
    public Response savePatient(@RequestBody Patient patient, HttpServletRequest request) {
        //获取当前登录用户id
        Long userId = AuthContextHolder.getUserId(request);
        patient.setUserId(userId);
        patientService.save(patient);
        return Response.success();
    }

    //根据id获取就诊人信息
    @GetMapping("auth/get/{id}")
    public Response getPatient(@PathVariable Long id) {
        Patient patient = patientService.getPatientId(id);
        return Response.success(patient);
    }

    //修改就诊人
    @PostMapping("auth/update")
    public Response updatePatient(@RequestBody Patient patient) {
        patientService.updateById(patient);
        return Response.success();
    }

    //删除就诊人
    @DeleteMapping("auth/remove/{id}")
    public Response removePatient(@PathVariable Long id) {
        patientService.removeById(id);
        return Response.success();
    }
//
//    //根据就诊人id获取就诊人信息
//    @GetMapping("inner/get/{id}")
//    public Patient getPatientOrder(@PathVariable Long id) {
//        Patient patient = patientService.getPatientId(id);
//        return patient;
//    }
}
