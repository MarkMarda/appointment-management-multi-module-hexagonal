package com.marda.arch.hex.app_be_appointment_management_adapter.in.rest.adapters;

import com.marda.arch.hex.app_be_appointment_management_adapter.in.rest.dtos.ScheduleDto;
import com.marda.arch.hex.app_be_appointment_management_adapter.in.rest.mappers.ScheduleAdapterRestMapper;
import com.marda.arch.hex.app_be_appointment_management_application.exceptions.ScheduleApplicationException;
import com.marda.arch.hex.app_be_appointment_management_application.ports.in.schedule.ScheduleQueryFindByIdUseCase;
import com.marda.arch.hex.app_be_appointment_management_application.ports.in.schedule.ScheduleQueryFindBySpecialityUseCase;
import com.marda.arch.hex.app_be_appointment_management_domain.schedule.Schedule;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public class ScheduleQueryFacade {
    private final ScheduleQueryFindByIdUseCase findByIdUseCase;
    private final ScheduleQueryFindBySpecialityUseCase findBySpecialityUseCase;

    private final ScheduleAdapterRestMapper scheduleAdapterRestMapper;


    public ScheduleQueryFacade(
            ScheduleQueryFindByIdUseCase findByIdUseCase,
            ScheduleQueryFindBySpecialityUseCase findBySpecialityUseCase,
            ScheduleAdapterRestMapper scheduleAdapterRestMapper
    ) {
        this.findByIdUseCase = findByIdUseCase;
        this.findBySpecialityUseCase = findBySpecialityUseCase;
        this.scheduleAdapterRestMapper = scheduleAdapterRestMapper;
    }

    public ResponseEntity<ScheduleDto> findById(Long id) throws ScheduleApplicationException {
        Optional<Schedule> scheduleOpt = findByIdUseCase.findById(id);

        if (scheduleOpt.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(scheduleAdapterRestMapper.toDto(scheduleOpt.get()));
    }

    public ResponseEntity<List<ScheduleDto>> findBySpecialityId(Long specialityId) throws ScheduleApplicationException {
        List<Schedule> scheduleList = findBySpecialityUseCase.findBySpeciality(specialityId);

        if (scheduleList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(scheduleAdapterRestMapper.toDto(scheduleList));
    }
}
