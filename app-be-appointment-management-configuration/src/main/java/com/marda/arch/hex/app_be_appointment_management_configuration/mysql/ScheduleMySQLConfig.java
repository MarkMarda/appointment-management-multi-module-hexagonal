package com.marda.arch.hex.app_be_appointment_management_configuration.mysql;

import com.marda.arch.hex.app_be_appointment_management_adapter.in.rest.adapters.ScheduleQueryFacade;
import com.marda.arch.hex.app_be_appointment_management_adapter.in.rest.adapters.ScheduleQueryRestAdapter;
import com.marda.arch.hex.app_be_appointment_management_adapter.in.rest.mappers.ScheduleAdapterRestMapper;
import com.marda.arch.hex.app_be_appointment_management_adapter.in.rest.mappers.ScheduleAdapterRestMapperImpl;
import com.marda.arch.hex.app_be_appointment_management_adapter.out.dbs.sql.mysql.adapters.ScheduleMySQLDBAdapter;
import com.marda.arch.hex.app_be_appointment_management_adapter.out.dbs.sql.mysql.mappers.ScheduleAdapterDBMapper;
import com.marda.arch.hex.app_be_appointment_management_adapter.out.dbs.sql.mysql.mappers.ScheduleAdapterDBMapperImpl;
import com.marda.arch.hex.app_be_appointment_management_adapter.out.dbs.sql.mysql.repository.ScheduleRepository;
import com.marda.arch.hex.app_be_appointment_management_application.ports.in.schedule.ScheduleQueryFindByIdUseCase;
import com.marda.arch.hex.app_be_appointment_management_application.ports.in.schedule.ScheduleQueryFindBySpecialityUseCase;
import com.marda.arch.hex.app_be_appointment_management_application.ports.out.schedule.ScheduleQueryFindByIDPort;
import com.marda.arch.hex.app_be_appointment_management_application.ports.out.schedule.ScheduleQueryFindBySpecialityPort;
import com.marda.arch.hex.app_be_appointment_management_application.services.ScheduleQueryService;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan("com.marda.arch.hex.app_be_appointment_management_adapter.out.dbs.sql.mysql.entities")
@EnableJpaRepositories(basePackages = "com.marda.arch.hex.app_be_appointment_management_adapter.out.dbs.sql.mysql.repository")
@Configuration
public class ScheduleMySQLConfig {
    // Application - Service
    @Bean
    ScheduleQueryService scheduleQueryService(
            ScheduleQueryFindByIDPort scheduleQueryFindByIDPort,
            ScheduleQueryFindBySpecialityPort scheduleQueryFindBySpecialityPort
    ) {
        return new ScheduleQueryService(scheduleQueryFindByIDPort, scheduleQueryFindBySpecialityPort);
    }

    // Adapters
    // Adapter - DBs - MySQL
    @Bean
    ScheduleMySQLDBAdapter scheduleMySQLDBAdapter(
            ScheduleRepository scheduleRepository,
            ScheduleAdapterDBMapper scheduleAdapterDBMapper
    ) {
        return new ScheduleMySQLDBAdapter(scheduleRepository, scheduleAdapterDBMapper);
    }

    // Adapter - API Rest - Spring MVC
    // Is not mandatory
    /*
    @Bean
    ScheduleQueryController scheduleQueryController(
            ScheduleQueryFindByIdUseCase scheduleQueryFindByIdUseCase,
            ScheduleAdapterRestMapper scheduleAdapterRestMapper
    ) {
        return new ScheduleQueryControllerImpl(scheduleQueryFindByIdUseCase, scheduleAdapterRestMapper);
    }
     */

    @Bean
    ScheduleQueryRestAdapter scheduleQueryRestAdapter(ScheduleQueryFacade scheduleQueryFacade) {
        return new ScheduleQueryRestAdapter(scheduleQueryFacade);
    }

    @Bean
    ScheduleQueryFacade scheduleQueryFacade(
            ScheduleQueryFindByIdUseCase findByIdUseCase,
            ScheduleQueryFindBySpecialityUseCase findBySpecialityUseCase,
            ScheduleAdapterRestMapper scheduleAdapterRestMapper
    ) {
        return new ScheduleQueryFacade(findByIdUseCase, findBySpecialityUseCase, scheduleAdapterRestMapper);
    }

    // Mappers
    @Bean
    ScheduleAdapterDBMapper scheduleAdapterDBMapper() {
        return new ScheduleAdapterDBMapperImpl();
    }

    @Bean
    ScheduleAdapterRestMapper scheduleAdapterRestMapper() {
        return new ScheduleAdapterRestMapperImpl();
    }
}
