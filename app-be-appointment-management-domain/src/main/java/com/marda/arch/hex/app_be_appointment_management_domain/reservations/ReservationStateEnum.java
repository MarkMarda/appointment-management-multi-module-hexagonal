package com.marda.arch.hex.app_be_appointment_management_domain.reservations;

public enum ReservationStateEnum {
    PENDING(1, "Pending"),
    CONFIRMED(2, "Confirmed"),
    RESCHEDULED(3, "Rescheduled"),
    CANCELLED(4, "Cancelled"),
    ATTENDED(5, "Attended");

    private Integer value;
    private String description;

    ReservationStateEnum(Integer value, String description) {
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
