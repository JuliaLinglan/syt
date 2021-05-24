package com.linglan.syt.hosp.service;

import com.linglan.syt.model.hosp.Department;
import com.linglan.syt.vo.hosp.DepartmentQueryVo;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface DepartmentService {

    void save(Map<String, Object> paramMap);

    Page<Department> findPageDepartment(int page, int limit, DepartmentQueryVo departmentQueryVo);

    void remove(String hoscode, String depcode);
}
