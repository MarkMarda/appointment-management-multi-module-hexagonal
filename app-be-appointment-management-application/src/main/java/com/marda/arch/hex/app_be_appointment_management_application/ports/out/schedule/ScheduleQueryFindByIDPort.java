package com.marda.arch.hex.app_be_appointment_management_application.ports.out.schedule;

import com.marda.arch.hex.app_be_appointment_management_application.exceptions.ScheduleApplicationException;
import com.marda.arch.hex.app_be_appointment_management_domain.schedule.Schedule;

import java.util.Optional;

public interface ScheduleQueryFindByIDPort {
    Optional<Schedule> findById(Long id) throws ScheduleApplicationException;
}
