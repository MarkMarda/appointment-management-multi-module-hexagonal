package com.marda.arch.hex.app_be_appointment_management_domain.person;

import com.marda.arch.hex.app_be_appointment_management_domain.exceptions.DomainException;

import static java.util.Objects.isNull;

public class DoctorId {
    private Long value;

    public DoctorId(Long value) throws DomainException {
        if (isNull(value) || value <= 0) {
            throw new DomainException(String.format("Doctor id = %d is not valid", value));
        }
        this.value = value;
    }

    public Long getValue() {
        return value;
    }
}
