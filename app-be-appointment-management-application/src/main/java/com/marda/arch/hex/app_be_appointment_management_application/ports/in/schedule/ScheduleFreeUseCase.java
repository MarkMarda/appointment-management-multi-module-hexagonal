package com.marda.arch.hex.app_be_appointment_management_application.ports.in.schedule;

import com.marda.arch.hex.app_be_appointment_management_application.exceptions.ScheduleApplicationException;

public interface ScheduleFreeUseCase {
    void free(Long id) throws ScheduleApplicationException;
}
