package com.marda.arch.hex.app_be_appointment_management_domain.person;

import com.marda.arch.hex.app_be_appointment_management_domain.base.GenericDomain;
import com.marda.arch.hex.app_be_appointment_management_domain.exceptions.DomainException;

public class Person extends GenericDomain {
    public Person(Long id) throws DomainException {
        super(id);
    }

    @Override
    public boolean valid() throws DomainException {
        return false;
    }
}
