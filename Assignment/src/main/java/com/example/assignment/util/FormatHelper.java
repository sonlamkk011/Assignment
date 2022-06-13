package com.example.assignment.util;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatHelper {
    public static String formatCurrencyVnd(double price) {
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        return formatter.format(price) + " VND";
    }

    public static String formatDate(LocalDateTime localDateTime, String pattern) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern(pattern);
        String formatDateTime = localDateTime.format(format);
        return formatDateTime;
    }

    public static LocalDateTime convertStringToLocalDateTime(String dateTimeString, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, formatter);
        return dateTime;
    }
}
