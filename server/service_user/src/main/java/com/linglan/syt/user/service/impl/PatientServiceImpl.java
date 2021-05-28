package com.linglan.syt.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.linglan.syt.model.user.Patient;
import com.linglan.syt.user.mapper.PatientMapper;
import com.linglan.syt.user.service.PatientService;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl extends ServiceImpl<PatientMapper, Patient>
        implements PatientService {
}
