package com.marda.arch.hex.app_be_appointment_management_adapter.in.rest.dtos;

import lombok.Builder;

@Builder
public record ScheduleDto(
        Long id,
        String date,
        String initialTime,
        String finalTime,
        Long doctorId
) {
}
