package com.marda.arch.hex.app_be_appointment_management_application.services;

import com.marda.arch.hex.app_be_appointment_management_application.exceptions.ScheduleApplicationException;
import com.marda.arch.hex.app_be_appointment_management_application.ports.in.schedule.ScheduleFreeUseCase;
import com.marda.arch.hex.app_be_appointment_management_application.ports.out.schedule.ScheduleQueryFindByIDPort;
import com.marda.arch.hex.app_be_appointment_management_application.ports.out.schedule.ScheduleUpdateStatePort;
import com.marda.arch.hex.app_be_appointment_management_domain.schedule.Schedule;
import com.marda.arch.hex.app_be_appointment_management_domain.schedule.ScheduleException;

public class ScheduleManagementService implements ScheduleFreeUseCase {
    private static final String SCHEDULE_MESSAGE_NOT_FOUND = "Schedule not exists";

    private final ScheduleQueryFindByIDPort scheduleQueryFindByIDPort;
    private final ScheduleUpdateStatePort scheduleUpdateStatePort;

    public ScheduleManagementService(ScheduleQueryFindByIDPort scheduleQueryFindByIDPort,
                                     ScheduleUpdateStatePort scheduleUpdateStatePort) {
        this.scheduleQueryFindByIDPort = scheduleQueryFindByIDPort;
        this.scheduleUpdateStatePort = scheduleUpdateStatePort;
    }

    @Override
    public void free(Long id) throws ScheduleApplicationException {
        Schedule schedule = scheduleQueryFindByIDPort.findById(id).orElseThrow(
                () -> new ScheduleApplicationException(SCHEDULE_MESSAGE_NOT_FOUND)
        );

        try {
            schedule.freeSchedule();
        } catch (ScheduleException e) {
            throw new ScheduleApplicationException(e);
        }

        scheduleUpdateStatePort.updateState(id, schedule.getEstateSchedule());
    }
}
