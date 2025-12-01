package com.marda.arch.hex.app_be_appointment_management_adapter.in.rest.adapters;

import com.marda.arch.hex.app_be_appointment_management_adapter.in.rest.controller.ScheduleQueryRestController;
import com.marda.arch.hex.app_be_appointment_management_adapter.in.rest.dtos.ScheduleDto;
import com.marda.arch.hex.app_be_appointment_management_application.exceptions.ScheduleApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class ScheduleQueryRestAdapter implements ScheduleQueryRestController {
    private final ScheduleQueryFacade scheduleQueryFacade;

    public ScheduleQueryRestAdapter(ScheduleQueryFacade scheduleQueryFacade) {
        this.scheduleQueryFacade = scheduleQueryFacade;
    }


    @Override
    public ResponseEntity<ScheduleDto> findById(Long id) throws ScheduleApplicationException {
        return scheduleQueryFacade.findById(id);
    }

    @Override
    public ResponseEntity<List<ScheduleDto>> findBySpecialityId(Long specialityId) throws ScheduleApplicationException {
        return scheduleQueryFacade.findBySpecialityId(specialityId);
    }
}
