package com.marda.arch.hex.app_be_appointment_management_domain.reservations;

import com.marda.arch.hex.app_be_appointment_management_domain.base.GenericDomain;
import com.marda.arch.hex.app_be_appointment_management_domain.exceptions.DomainException;
import com.marda.arch.hex.app_be_appointment_management_domain.schedule.Schedule;
import com.marda.arch.hex.app_be_appointment_management_domain.schedule.ScheduleException;

import java.time.LocalDateTime;
import java.util.Objects;

public class Reservation extends GenericDomain {
    private Long id;
    private Long doctorId;
    private Long specialtyId;
    private Long scheduleId;
    private ReservationStateEnum reservationState = ReservationStateEnum.PENDING;

    private final Integer reSchedulePeriod = 24;

    public Reservation(Long id, Long doctorId, Long specialtyId, Long scheduleId, Schedule schedule) throws DomainException {
        super(id);
        if (!schedule.isAvailable()) throw new DomainException("Schedule not available");
        if (!Objects.equals(schedule.getDoctorId().getValue(), doctorId) ) throw new DomainException("Schedule of another doctor");
        this.id = id;
        this.doctorId = doctorId;
        this.specialtyId = specialtyId;
        this.scheduleId = scheduleId;
        schedule.reservate();
    }

    public void confirm() throws ReservationException {
        if (reservationState != ReservationStateEnum.PENDING && reservationState != ReservationStateEnum.RESCHEDULED) {
            throw new ReservationException("Reservation can not be confirmed");
        }

        reservationState = ReservationStateEnum.CONFIRMED;
    }

    private void cancel(Schedule schedule) throws ScheduleException, ReservationException {
        if (reservationState == ReservationStateEnum.ATTENDED) {
            throw new ReservationException("Reservation can not be canceled");
        }

        reservationState = ReservationStateEnum.CANCELLED;
        schedule.freeSchedule();
    }

    public void reSchedule(Schedule newSchedule) throws ReservationException, ScheduleException {
        if (reservationState == ReservationStateEnum.CANCELLED || reservationState == ReservationStateEnum.ATTENDED) {
            throw new ReservationException("Reservation can not be reScheduled");
        }

        if (!newSchedule.isAvailable()) {
            throw new ScheduleException("New schedule not available");
        }

        LocalDateTime limit = LocalDateTime.now().plusHours(reSchedulePeriod);

        if (limit.isAfter(newSchedule.getInitialTime())) {
            throw new ReservationException("Reschedule is with 24h of anticipation");
        }

        this.scheduleId = newSchedule.getId();
        this.reservationState = ReservationStateEnum.RESCHEDULED;

        newSchedule.reservate();
    }

    @Override
    public boolean valid() throws DomainException {
        return false;
    }
}
