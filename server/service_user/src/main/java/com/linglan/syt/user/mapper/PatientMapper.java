package com.linglan.syt.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.linglan.syt.model.user.Patient;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PatientMapper extends BaseMapper<Patient> {
}
