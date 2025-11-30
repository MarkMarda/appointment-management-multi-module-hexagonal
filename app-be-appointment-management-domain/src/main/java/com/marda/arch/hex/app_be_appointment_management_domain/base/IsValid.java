package com.marda.arch.hex.app_be_appointment_management_domain.base;


import com.marda.arch.hex.app_be_appointment_management_domain.exceptions.DomainException;

@FunctionalInterface
public interface IsValid {
    boolean valid() throws DomainException;
}
