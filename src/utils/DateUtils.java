package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public static LocalDate parse(String date){
        return LocalDate.parse(date, formatter);
    }

    public static String toString(LocalDate localDate){
        return localDate.format(formatter);
    }
}
