package com.marda.arch.hex.app_be_appointment_management_domain.person;

import com.marda.arch.hex.app_be_appointment_management_domain.exceptions.DomainException;

public class Doctor extends Person {
    private DoctorStateEnum doctorState;

    public Doctor(Long id) throws DomainException {
        super(id);
    }

    public DoctorStateEnum getDoctorState() {
        return doctorState;
    }
}
