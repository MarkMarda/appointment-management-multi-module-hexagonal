package com.marda.arch.hex.app_be_appointment_management_adapter.out.dbs.sql.mysql.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "tbl_schedule")
@Entity(name = "ScheduleEntity")
public class ScheduleEntity extends GenericEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id", nullable = false)
    private Long id;

    @Column(name = "schedule_initial", nullable = false)
    private LocalDateTime initialTime;

    @Column(name = "schedule_final", nullable = false)
    private LocalDateTime finalTime;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @NotNull(message = "Doctor Id is required")
    @Column(name = "doctor_id", nullable = false)
    private Long doctorId;

    @NotNull(message = "Speciality Id is required")
    @Column(name = "speciality_id", nullable = false)
    private Long specialityId;

    @Column(name = "state_schedule", nullable = false)
    private Integer estateSchedule;
}
