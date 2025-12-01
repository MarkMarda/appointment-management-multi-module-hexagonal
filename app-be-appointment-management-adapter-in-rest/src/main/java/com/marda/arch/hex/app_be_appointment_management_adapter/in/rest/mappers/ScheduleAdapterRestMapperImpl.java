package com.marda.arch.hex.app_be_appointment_management_adapter.in.rest.mappers;

import com.marda.arch.hex.app_be_appointment_management_adapter.in.rest.dtos.ScheduleDto;
import com.marda.arch.hex.app_be_appointment_management_domain.schedule.Schedule;

import java.util.List;

import static com.marda.arch.hex.adapter.commons.utils.DateUtil.dateStr;
import static com.marda.arch.hex.adapter.commons.utils.DateUtil.timeStr;


//@Component In configuration
public class ScheduleAdapterRestMapperImpl implements ScheduleAdapterRestMapper {
    @Override
    public ScheduleDto toDto(Schedule schedule) {
        return ScheduleDto
                .builder()
                .id(schedule.getId())
                .date(dateStr(schedule.getDate()))
                .initialTime(timeStr(schedule.getInitialTime()))
                .finalTime(timeStr(schedule.getFinalTime()))
                .doctorId(schedule.getDoctorId().getValue())
                .build();
    }

    @Override
    public List<ScheduleDto> toDto(List<Schedule> scheduleList) {
        return scheduleList.stream().map(this::toDto).toList();
    }
}
