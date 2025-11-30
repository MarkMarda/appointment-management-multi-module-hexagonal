package com.marda.arch.hex.app_be_appointment_management_domain.schedule;

import java.util.Arrays;

public enum ScheduleStateEnum {
    AVAILABLE(1, "Available"),
    RESERVED(2, "Reserved"),
    LOCKED(3, "Locked"),
    ;

    private Integer value;
    private String description;

    ScheduleStateEnum(Integer value, String description) {
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

    public static ScheduleStateEnum getByValue(Integer value) {
        return Arrays.stream(ScheduleStateEnum.values())
                .filter(type -> type.getValue().equals(value))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Value not valid"));
    }
}
