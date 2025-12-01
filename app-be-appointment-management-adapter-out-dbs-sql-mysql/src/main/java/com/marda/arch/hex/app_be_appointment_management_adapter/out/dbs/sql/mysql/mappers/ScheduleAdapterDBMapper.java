package com.marda.arch.hex.app_be_appointment_management_adapter.out.dbs.sql.mysql.mappers;

import com.marda.arch.hex.app_be_appointment_management_adapter.out.dbs.sql.exceptions.ScheduleAdapterDBException;
import com.marda.arch.hex.app_be_appointment_management_adapter.out.dbs.sql.mysql.entities.ScheduleEntity;
import com.marda.arch.hex.app_be_appointment_management_domain.schedule.Schedule;

import java.util.List;

public interface ScheduleAdapterDBMapper {
    ScheduleEntity toEntity(Schedule schedule) throws ScheduleAdapterDBException; //Is posible use MapperException o ScheduleAdapterException

    Schedule toDomain(ScheduleEntity scheduleEntity) throws ScheduleAdapterDBException;

    List<Schedule> toDomain(List<ScheduleEntity> scheduleEntityList) throws ScheduleAdapterDBException;
}
