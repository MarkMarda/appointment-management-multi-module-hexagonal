package com.marda.arch.hex.app_be_appointment_management_domain.base;

public enum EstateEnum {
    ACTIVE(1, "Active"),
    DELETED(2, "Deleted"),
    MIGRATED(3, "Migrated");

    private Integer value;
    private String description;

    private EstateEnum(Integer value, String description) {
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
