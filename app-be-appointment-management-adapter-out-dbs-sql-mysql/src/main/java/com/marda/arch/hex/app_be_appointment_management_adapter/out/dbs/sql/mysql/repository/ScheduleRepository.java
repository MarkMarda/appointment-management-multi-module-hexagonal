package com.marda.arch.hex.app_be_appointment_management_adapter.out.dbs.sql.mysql.repository;

import com.marda.arch.hex.app_be_appointment_management_adapter.out.dbs.sql.mysql.entities.ScheduleEntity;
import com.marda.arch.hex.app_be_appointment_management_adapter.out.dbs.sql.mysql.repository.base.GenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends GenericRepository<ScheduleEntity, Long> {
    // JPQL
    @Query(value = "select se from ScheduleEntity se where se.specialityId=:specialityId and se.estateRegister=1")
    List<ScheduleEntity> findBySpeciality(@Param("specialityId") Long specialityId);
    // SQL
    // Projections
    // ...
}

