package com.marda.arch.hex.app_be_appointment_management_application.ports.out.schedule;

import com.marda.arch.hex.app_be_appointment_management_application.exceptions.ScheduleApplicationException;
import com.marda.arch.hex.app_be_appointment_management_domain.schedule.Schedule;

import java.util.List;

public interface ScheduleQueryFindBySpecialityPort {
    List<Schedule> findBySpeciality(Long specialityId) throws ScheduleApplicationException;
}
