package com.marda.arch.hex.app_be_appointment_management_adapter.in.rest.controller;

import com.marda.arch.hex.app_be_appointment_management_adapter.in.rest.dtos.ScheduleDto;
import com.marda.arch.hex.app_be_appointment_management_application.exceptions.ScheduleApplicationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static com.marda.arch.hex.app_be_appointment_management_adapter.in.rest.constants.APIConstants.API_SCHEDULE_QUERY;

@RequestMapping(API_SCHEDULE_QUERY)
public interface ScheduleQueryRestController {
    //End-points
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleDto> findById(@PathVariable("id") Long id) throws ScheduleApplicationException;

    @GetMapping("/find-by-speciality/{specialityId}")
    public ResponseEntity<List<ScheduleDto>> findBySpecialityId(@PathVariable("specialityId") Long specialityId) throws ScheduleApplicationException;

    //OpenApi Specification (Swagger Docs)
}
