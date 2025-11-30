package com.marda.arch.hex.app_be_appointment_management_domain.person;

public enum DoctorStateEnum {
    LICENSED(1, "Licensed"),
    NOT_LICENSED(2, "NotLicensed");

    private Integer value;
    private String description;

    DoctorStateEnum(Integer value, String description) {
        this.value = value;
        this.description = description;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
