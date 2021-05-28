package com.linglan.syt.hosp.controller.api;

import com.linglan.syt.common.result.Response;
import com.linglan.syt.hosp.service.DepartmentService;
import com.linglan.syt.hosp.service.HospitalService;
import com.linglan.syt.hosp.service.HospitalSetService;
import com.linglan.syt.hosp.service.ScheduleService;
import com.linglan.syt.model.hosp.Hospital;
import com.linglan.syt.vo.hosp.DepartmentVo;
import com.linglan.syt.vo.hosp.HospitalQueryVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/hosp/hospital")
public class HospApiController {

    @Autowired
    private HospitalService hospitalService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private HospitalSetService hospitalSetService;

    @ApiOperation(value = "查询医院列表")
    @GetMapping("findHospList/{page}/{limit}")
    public Response findHospList(@PathVariable Integer page,
                                 @PathVariable Integer limit,
                                 HospitalQueryVo hospitalQueryVo) {
        Page<Hospital> hospitals = hospitalService.selectHospPage(page, limit, hospitalQueryVo);
        return Response.success(hospitals);
    }

    @ApiOperation(value = "根据医院名称查询")
    @GetMapping("findByHosName/{hosname}")
    public Response findByHosName(@PathVariable String hosname) {
        List<Hospital> list = hospitalService.findByHosname(hosname);
        return Response.success(list);
    }


    @ApiOperation(value = "根据医院编号获取科室")
    @GetMapping("department/{hoscode}")
    public Response index(@PathVariable String hoscode) {
        List<DepartmentVo> list = departmentService.findDeptTree(hoscode);
        return Response.success(list);
    }

    @ApiOperation(value = "根据医院编号获取医院预约挂号详情")
    @GetMapping("findHospDetail/{hoscode}")
    public Response item(@PathVariable String hoscode) {
        Map<String, Object> map = hospitalService.item(hoscode);
        return Response.success(map);
    }
}
