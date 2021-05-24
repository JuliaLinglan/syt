package com.linglan.syt.hosp.service;

import com.linglan.syt.model.hosp.Schedule;
import com.linglan.syt.vo.hosp.ScheduleQueryVo;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface ScheduleService {

    void save(Map<String, Object> paramMap);

    Page<Schedule> findPageSchedule(int page, int limit, ScheduleQueryVo scheduleQueryVo);

    void remove(String hoscode, String hosScheduleId);
}
