package com.marda.arch.hex.app_be_appointment_management_domain.base;


import com.marda.arch.hex.app_be_appointment_management_domain.exceptions.DomainException;

// All cases that we can find in others domains
public abstract class GenericDomain implements IsValid {
    protected Long id;
    protected EstateEnum estate;

    public GenericDomain(Long id) throws DomainException {
        isValidId(id);
        this.id = id;
    }

    public EstateEnum getEstate() {
        return estate;
    }

    public void setEstate(EstateEnum estate) {
        this.estate = estate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    protected void isValidId(Long id) throws DomainException {
        if (id == null || id <= 0) {
            throw new DomainException(String.format("Id = %d is not valid", id));
        }
    }
}
