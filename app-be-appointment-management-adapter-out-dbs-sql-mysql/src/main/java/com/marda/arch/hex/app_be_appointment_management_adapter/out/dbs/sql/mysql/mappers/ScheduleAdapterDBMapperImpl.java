package com.marda.arch.hex.app_be_appointment_management_adapter.out.dbs.sql.mysql.mappers;

import com.marda.arch.hex.app_be_appointment_management_adapter.out.dbs.sql.exceptions.ScheduleAdapterDBException;
import com.marda.arch.hex.app_be_appointment_management_adapter.out.dbs.sql.mysql.entities.ScheduleEntity;
import com.marda.arch.hex.app_be_appointment_management_domain.exceptions.DomainException;
import com.marda.arch.hex.app_be_appointment_management_domain.person.Doctor;
import com.marda.arch.hex.app_be_appointment_management_domain.schedule.Schedule;
import com.marda.arch.hex.app_be_appointment_management_domain.schedule.ScheduleStateEnum;

import java.util.List;

//@Repository
//@Component In confifuration
public class ScheduleAdapterDBMapperImpl implements ScheduleAdapterDBMapper {
    @Override
    public ScheduleEntity toEntity(Schedule schedule) {
        return ScheduleEntity
                .builder()
                .id(schedule.getId())
                .date(schedule.getDate())
                .initialTime(schedule.getInitialTime())
                .finalTime(schedule.getFinalTime())
                .estateSchedule(schedule.getEstateSchedule().getValue())
                //.estateRegister(schedule.getEstate().getValue())
                .build();
    }

    @Override
    public Schedule toDomain(ScheduleEntity scheduleEntity) throws ScheduleAdapterDBException {
        try {
            Schedule schedule = new Schedule(
                    scheduleEntity.getId(),
                    scheduleEntity.getDate(),
                    scheduleEntity.getInitialTime(),
                    scheduleEntity.getFinalTime(),
                    new Doctor(scheduleEntity.getDoctorId()),
                    ScheduleStateEnum.getByValue(scheduleEntity.getEstateSchedule())

            );

            return schedule;
        } catch (DomainException e) {
            throw new ScheduleAdapterDBException(e);
        }

    }

    //@SneakyThrows
    @Override
    public List<Schedule> toDomain(List<ScheduleEntity> scheduleEntityList) throws ScheduleAdapterDBException {
        return scheduleEntityList.stream().map(scheduleEntity -> {
            try {
                return toDomain(scheduleEntity);
            } catch (ScheduleAdapterDBException e) {
                throw new RuntimeException(e);
            }
        }).toList();
    }
}
