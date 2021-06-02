package com.linglan.syt.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.linglan.syt.model.user.Patient;

import java.util.List;

public interface PatientService extends IService<Patient> {
    Patient getPatientId(Long id);

    List<Patient> findAllUserId(Long userId);
}
