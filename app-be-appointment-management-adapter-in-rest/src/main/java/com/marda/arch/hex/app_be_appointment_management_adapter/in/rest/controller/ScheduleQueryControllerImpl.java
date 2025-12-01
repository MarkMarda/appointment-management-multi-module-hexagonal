package com.marda.arch.hex.app_be_appointment_management_adapter.in.rest.controller;

import com.marda.arch.hex.app_be_appointment_management_adapter.in.rest.dtos.ScheduleDto;
import com.marda.arch.hex.app_be_appointment_management_adapter.in.rest.mappers.ScheduleAdapterRestMapper;
import com.marda.arch.hex.app_be_appointment_management_application.exceptions.ScheduleApplicationException;
import com.marda.arch.hex.app_be_appointment_management_application.ports.in.schedule.ScheduleQueryFindByIdUseCase;
import com.marda.arch.hex.app_be_appointment_management_application.ports.in.schedule.ScheduleQueryFindBySpecialityUseCase;
import com.marda.arch.hex.app_be_appointment_management_domain.schedule.Schedule;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

// Is commented beacause we have ScheduleQueryRestAdapter.
//@RestController //It should be commented but Spring need it
public class ScheduleQueryControllerImpl extends GenericControllerImpl implements ScheduleQueryRestController {
    private final ScheduleQueryFindByIdUseCase scheduleQueryFindByIdUseCase;
    private final ScheduleQueryFindBySpecialityUseCase scheduleQueryFindBySpecialityUseCase;

    private final ScheduleAdapterRestMapper scheduleAdapterRestMapper;

    public ScheduleQueryControllerImpl(ScheduleQueryFindByIdUseCase scheduleQueryFindByIdUseCase, ScheduleQueryFindBySpecialityUseCase scheduleQueryFindBySpecialityUseCase, ScheduleAdapterRestMapper scheduleAdapterRestMapper) {
        this.scheduleQueryFindByIdUseCase = scheduleQueryFindByIdUseCase;
        this.scheduleQueryFindBySpecialityUseCase = scheduleQueryFindBySpecialityUseCase;
        this.scheduleAdapterRestMapper = scheduleAdapterRestMapper;
    }


    @Override
    public ResponseEntity<ScheduleDto> findById(Long id) throws ScheduleApplicationException {
        Optional<Schedule> scheduleOpt = scheduleQueryFindByIdUseCase.findById(id);

        if (scheduleOpt.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(scheduleAdapterRestMapper.toDto(scheduleOpt.get()));
    }

    @Override
    public ResponseEntity<List<ScheduleDto>> findBySpecialityId(Long specialityId) throws ScheduleApplicationException {
        List<Schedule> scheduleList = scheduleQueryFindBySpecialityUseCase.findBySpeciality(specialityId);

        if (scheduleList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(scheduleAdapterRestMapper.toDto(scheduleList));
    }
}
