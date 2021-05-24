package com.linglan.syt.hosp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.linglan.syt.model.hosp.HospitalSet;

public interface HospitalSetService extends IService<HospitalSet> {


    String getSignKey(String hoscode);
}
