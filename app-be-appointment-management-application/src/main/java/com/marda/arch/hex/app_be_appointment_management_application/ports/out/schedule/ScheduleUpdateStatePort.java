package com.marda.arch.hex.app_be_appointment_management_application.ports.out.schedule;

import com.marda.arch.hex.app_be_appointment_management_application.exceptions.ScheduleApplicationException;
import com.marda.arch.hex.app_be_appointment_management_domain.schedule.ScheduleStateEnum;

@FunctionalInterface
public interface ScheduleUpdateStatePort {
    void updateState(Long id, ScheduleStateEnum stateEnum) throws ScheduleApplicationException;
}
