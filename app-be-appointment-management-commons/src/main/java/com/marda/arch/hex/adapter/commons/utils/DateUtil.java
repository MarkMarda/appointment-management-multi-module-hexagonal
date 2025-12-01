package com.marda.arch.hex.adapter.commons.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    private final static String DATE_FORMAT = "dd/MM/yyyy";
    private final static String DATE_TIME = "HH:mm";

    public static String dateStr(LocalDate date) {
        DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        return date.format(customFormatter);
    }

    public static String timeStr(LocalDateTime time) {
        DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern(DATE_TIME);
        return time.format(customFormatter);
    }
}
