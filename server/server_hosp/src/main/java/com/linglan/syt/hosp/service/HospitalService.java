package com.linglan.syt.hosp.service;

import com.linglan.syt.model.hosp.Hospital;

import java.util.Map;

public interface HospitalService {
    void save(Map<String, Object> paramMap);

    Hospital getByHoscode(String hoscode);
}
