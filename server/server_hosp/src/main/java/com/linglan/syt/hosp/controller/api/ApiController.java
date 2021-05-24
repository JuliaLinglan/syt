package com.linglan.syt.hosp.controller.api;

import com.linglan.syt.common.exception.BusinessException;
import com.linglan.syt.common.helper.HttpRequestHelper;
import com.linglan.syt.common.result.MsgCode;
import com.linglan.syt.common.result.Response;
import com.linglan.syt.common.utils.MD5;
import com.linglan.syt.hosp.service.DepartmentService;
import com.linglan.syt.hosp.service.HospitalService;
import com.linglan.syt.hosp.service.HospitalSetService;
import com.linglan.syt.hosp.service.ScheduleService;
import com.linglan.syt.model.hosp.Department;
import com.linglan.syt.model.hosp.Hospital;
import com.linglan.syt.model.hosp.Schedule;
import com.linglan.syt.vo.hosp.DepartmentQueryVo;
import com.linglan.syt.vo.hosp.ScheduleQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.StringUtils;
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

    @Autowired
    private HospitalSetService hospitalSetService;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    private ScheduleService scheduleService;

    //删除排班
    @PostMapping("schedule/remove")
    public Response remove(HttpServletRequest request) {
        //获取传递过来科室信息
        Map<String, String[]> requestMap = request.getParameterMap();
        Map<String, Object> paramMap = HttpRequestHelper.switchMap(requestMap);
        //获取医院编号和排班编号
        String hoscode = (String)paramMap.get("hoscode");
        String hosScheduleId = (String)paramMap.get("hosScheduleId");

        //TODO 签名校验

        scheduleService.remove(hoscode,hosScheduleId);
        return Response.success();
    }

    //查询排班接口
    @PostMapping("schedule/list")
    public Response findSchedule(HttpServletRequest request) {
        //获取传递过来科室信息
        Map<String, String[]> requestMap = request.getParameterMap();
        Map<String, Object> paramMap = HttpRequestHelper.switchMap(requestMap);

        //医院编号
        String hoscode = (String) paramMap.get("hoscode");

        //科室编号
        String depcode = (String) paramMap.get("depcode");
        //当前页 和 每页记录数
        int page = StringUtils.isEmpty(paramMap.get("page")) ? 1 : Integer.parseInt((String) paramMap.get("page"));
        int limit = StringUtils.isEmpty(paramMap.get("limit")) ? 1 : Integer.parseInt((String) paramMap.get("limit"));
        //TODO 签名校验

        ScheduleQueryVo scheduleQueryVo = new ScheduleQueryVo();
        scheduleQueryVo.setHoscode(hoscode);
        scheduleQueryVo.setDepcode(depcode);
        //调用service方法
        Page<Schedule> pageModel = scheduleService.findPageSchedule(page, limit, scheduleQueryVo);
        return Response.success(pageModel);
    }

    //上传排班接口
    @PostMapping("saveSchedule")
    public Response saveSchedule(HttpServletRequest request) {
        //获取传递过来科室信息
        Map<String, String[]> requestMap = request.getParameterMap();
        Map<String, Object> paramMap = HttpRequestHelper.switchMap(requestMap);

        //TODO 签名校验
        scheduleService.save(paramMap);
        return Response.success();
    }

    //删除科室接口
    @PostMapping("department/remove")
    public Response removeDepartment(HttpServletRequest request) {
        //获取传递过来科室信息
        Map<String, String[]> requestMap = request.getParameterMap();
        Map<String, Object> paramMap = HttpRequestHelper.switchMap(requestMap);
        //医院编号 和 科室编号
        String hoscode = (String) paramMap.get("hoscode");
        String depcode = (String) paramMap.get("depcode");
        //TODO 签名校验
        departmentService.remove(hoscode, depcode);
        return Response.success();
    }

    //查询科室接口
    @PostMapping("department/list")
    public Response findDepartment(HttpServletRequest request) {
        //获取传递过来科室信息
        Map<String, String[]> requestMap = request.getParameterMap();
        Map<String, Object> paramMap = HttpRequestHelper.switchMap(requestMap);

        //医院编号
        String hoscode = (String) paramMap.get("hoscode");
        //当前页 和 每页记录数
        int page = StringUtils.isEmpty(paramMap.get("page")) ? 1 : Integer.parseInt((String) paramMap.get("page"));
        int limit = StringUtils.isEmpty(paramMap.get("limit")) ? 1 : Integer.parseInt((String) paramMap.get("limit"));
        //TODO 签名校验

        DepartmentQueryVo departmentQueryVo = new DepartmentQueryVo();
        departmentQueryVo.setHoscode(hoscode);
        //调用service方法
        Page<Department> pageModel = departmentService.findPageDepartment(page, limit, departmentQueryVo);
        return Response.success(pageModel);
    }

    //上传科室接口
    @PostMapping("saveDepartment")
    public Response saveDepartment(HttpServletRequest request) {
        //获取传递过来科室信息
        Map<String, String[]> requestMap = request.getParameterMap();
        Map<String, Object> paramMap = HttpRequestHelper.switchMap(requestMap);

        //获取医院编号
        String hoscode = (String) paramMap.get("hoscode");
        //1 获取医院系统传递过来的签名,签名进行MD5加密
        String hospSign = (String) paramMap.get("sign");

        //2 根据传递过来医院编码，查询数据库，查询签名
        String signKey = hospitalSetService.getSignKey(hoscode);

        //3 把数据库查询签名进行MD5加密
        String signKeyMd5 = MD5.encrypt(signKey);

        //4 判断签名是否一致
        if (!hospSign.equals(signKeyMd5)) {
            throw new BusinessException(MsgCode.SIGN_ERROR);
        }

        //调用service的方法
        departmentService.save(paramMap);
        return Response.success();
    }

    //查询医院
    @PostMapping("hospital/show")
    public Response getHospital(HttpServletRequest request) {
        //获取传递过来医院信息
        Map<String, String[]> requestMap = request.getParameterMap();
        Map<String, Object> paramMap = HttpRequestHelper.switchMap(requestMap);
        //获取医院编号
        String hoscode = (String) paramMap.get("hoscode");
        //1 获取医院系统传递过来的签名,签名进行MD5加密
        String hospSign = (String) paramMap.get("sign");

        //2 根据传递过来医院编码，查询数据库，查询签名
        String signKey = hospitalSetService.getSignKey(hoscode);

        //3 把数据库查询签名进行MD5加密
        String signKeyMd5 = MD5.encrypt(signKey);

        //4 判断签名是否一致
        if (!hospSign.equals(signKeyMd5)) {
            throw new BusinessException(MsgCode.SIGN_ERROR);
        }

        //调用service方法实现根据医院编号查询
        Hospital hospital = hospitalService.getByHoscode(hoscode);
        return Response.success(hospital);
    }

    //上传医院接口
    @PostMapping("saveHospital")
    public Response saveHosp(HttpServletRequest request) {
        //获取传递过来医院信息
        Map<String, String[]> requestMap = request.getParameterMap();
        Map<String, Object> paramMap = HttpRequestHelper.switchMap(requestMap);
        //1 获取医院系统传递过来的签名,签名进行MD5加密
        String hospSign = (String) paramMap.get("sign");

        //2 根据传递过来医院编码，查询数据库，查询签名
        String hoscode = (String) paramMap.get("hoscode");
        String signKey = hospitalSetService.getSignKey(hoscode);

        //3 把数据库查询签名进行MD5加密
        String signKeyMd5 = MD5.encrypt(signKey);

        //4 判断签名是否一致
        if (!hospSign.equals(signKeyMd5)) {
            throw new BusinessException(MsgCode.SIGN_ERROR);
        }

        //传输过程中“+”转换为了“ ”，因此我们要转换回来
        String logoData = (String) paramMap.get("logoData");
        logoData = logoData.replaceAll(" ", "+");
        paramMap.put("logoData", logoData);

        //调用service的方法
        hospitalService.save(paramMap);
        return Response.success();

    }
}
