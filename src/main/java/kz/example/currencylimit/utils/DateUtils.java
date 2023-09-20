package kz.example.currencylimit.utils;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    private static final String DEFAULT_DATE_FORMAT = "dd-MM-yyyy";

    public static String fromLocalDateTimeToString(LocalDate value) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT);
        return value.format(formatter);
    }
    public static LocalDate formStringToLocalDateTime(String value) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT);
        return LocalDate.parse(value, formatter);
    }
}
