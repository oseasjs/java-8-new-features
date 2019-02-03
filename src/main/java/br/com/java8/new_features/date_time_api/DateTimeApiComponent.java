package br.com.java8.new_features.date_time_api;

import org.springframework.stereotype.Component;

import java.time.*;
import java.util.Date;

@Component
public class DateTimeApiComponent {

    public String getCurrentLocalDateAsString() {
        return LocalDate.now().toString();
    }

    public LocalDate getLocalDateFromString(String dateAsString) {
        return LocalDate.parse(dateAsString);
    }

    public LocalDate getLocalDateFromDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public LocalDate getLocalDateFromYearMonthAndDay(Integer year, Integer month, Integer day) {
        return LocalDate.of(year, month, day);
    }

    public LocalDate getLocalDateFromYearMonthOfYearAndDay(Integer year, Month month, Integer day) {
        return LocalDate.of(year, month, day);
    }

    public Integer getLastDayOfMonthFromLocalDate(LocalDate date) {
        return date.lengthOfMonth();
    }

    public LocalDate getLocalDateAfter19700101(long daysAfter19700101) {
        return LocalDate.ofEpochDay(daysAfter19700101);
    }

    public LocalDateTime getLocalDateTimeFromLocalDate(LocalDate date, Integer hour, Integer minute, Integer second) {
        return date.atTime(hour, minute, second);
    }

    public LocalDateTime getLocalDateTimeFromString(String dateTimeAsString) {
        return LocalDateTime.parse(dateTimeAsString);
    }

    public LocalDateTime getLocalDateTimeFromLocalDateAndLocalTime(LocalDate date, LocalTime time) {
        return LocalDateTime.of(date, time);
    }

}
