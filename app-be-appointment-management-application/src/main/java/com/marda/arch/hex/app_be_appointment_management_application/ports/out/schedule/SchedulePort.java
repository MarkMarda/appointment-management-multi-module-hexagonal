package com.marda.arch.hex.app_be_appointment_management_application.ports.out.schedule;

import com.marda.arch.hex.app_be_appointment_management_application.exceptions.ScheduleApplicationException;
import com.marda.arch.hex.app_be_appointment_management_domain.schedule.Schedule;
import com.marda.arch.hex.app_be_appointment_management_domain.schedule.ScheduleStateEnum;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface SchedulePort {
    List<Schedule> findByDateDoctor(LocalDate date, Long doctorId, ScheduleStateEnum state) throws ScheduleApplicationException;

    List<Schedule> findByDate(LocalDate date, ScheduleStateEnum state) throws ScheduleApplicationException;

    Optional<Schedule> findById(Long id) throws ScheduleApplicationException;

    void save(Schedule schedule) throws ScheduleApplicationException;
}
