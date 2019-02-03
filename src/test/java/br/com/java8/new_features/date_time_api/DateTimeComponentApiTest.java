package br.com.java8.new_features.date_time_api;

import br.com.java8.new_features.Java8NewFeaturesApplicationTest;
import br.com.java8.new_features.dtos.PeopleDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;

public class DateTimeComponentApiTest extends Java8NewFeaturesApplicationTest {

    @Autowired
    private DateTimeApiComponent dateTimeApiComponent;

    private PeopleDto people;

    @Before
    public void init() {
        people = new PeopleDto(1L, "Jonh", LocalDate.now());
    }

    @Test
    public void whenGetCurrentLocalDateAsString_ThenRetrivedStringIsExpected() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateAsString = sdf.format(new Date());
        Assert.assertEquals(dateAsString,
                dateTimeApiComponent.getCurrentLocalDateAsString());
    }

    @Test
    public void whenGetLocalDateFromString_ThenRetrivedStringIsExpected() throws Exception {
        String dateAsString = "2018-10-15";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(dateAsString);
        Assert.assertEquals(LocalDate.from(
                date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()),
                dateTimeApiComponent.getLocalDateFromString(dateAsString));
    }

    @Test(expected = DateTimeException.class)
    public void whenGetLocalDateFromWrongString_ThenRetrivedExceptionExpected() throws Exception {
        dateTimeApiComponent.getLocalDateFromString("2018-10-15x");
        Assert.fail();
    }

    @Test
    public void whenGetLocalDateFromYearMonthAndDay_ThenRetrivedStringIsExpected() throws Exception {
        String dateAsString = "2018-10-15";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(dateAsString);
        Assert.assertEquals(LocalDate.from(
                date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()),
                dateTimeApiComponent.getLocalDateFromYearMonthAndDay(2018, 10, 15));
    }

    @Test
    public void whenGetLocalDateFromDate_ThenRetrivedStringIsExpected() throws Exception {
        String dateAsString = "2018-10-15";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(dateAsString);
        Assert.assertEquals(LocalDate.parse(dateAsString),
                dateTimeApiComponent.getLocalDateFromDate(date));
    }

    @Test
    public void whenGetLocalDateFromYearMonthValueAndDay_ThenRetrivedStringIsExpected() throws Exception {
        String dateAsString = "2018-10-15";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(dateAsString);
        Assert.assertEquals(LocalDate.from(
                date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()),
                dateTimeApiComponent.getLocalDateFromYearMonthOfYearAndDay(2018, Month.OCTOBER, 15));
    }

    @Test(expected = DateTimeException.class)
    public void whenGetLocalDateFromYearMonthAndDayWithWrongDay_ThenRetrivedExceptionIsExpected() throws Exception {
        dateTimeApiComponent.getLocalDateFromYearMonthAndDay(2018, 10, 32);
        Assert.fail();
    }

    @Test(expected = DateTimeException.class)
    public void whenGetLocalDateFromYearMonthAndDayWithWrongMonth_ThenRetrivedExceptionIsExpected() throws Exception {
        dateTimeApiComponent.getLocalDateFromYearMonthAndDay(2018, 13, 30);
        Assert.fail();
    }

    @Test
    public void whenGetLastDayOfMonthFromLocalDate_ThenRetrivedStringIsExpected() throws Exception {
        String dateAsString = "2018-10-15";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(dateAsString);
        Assert.assertEquals(Integer.valueOf(31),
                dateTimeApiComponent.getLastDayOfMonthFromLocalDate(LocalDate.parse(dateAsString)));
    }

    @Test
    public void whenGetLocalDateAfter19700101_ThenRetrivedStringIsExpected() throws Exception {
        String dateAsString = "1970-04-11";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(dateAsString);
        Assert.assertEquals(LocalDate.parse(dateAsString),
                dateTimeApiComponent.getLocalDateAfter19700101(100));
    }

    @Test
    public void whenGetLocalDateTimeFromLocalDate_ThenRetrivedStringIsExpected() throws Exception {
        String dateAsStringToLocalDateTime = "2018-10-15T";
        String dateAsString = "2018-10-15";
        String time = "22:15:45";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(dateAsString + " " + time);
        Assert.assertEquals(LocalDateTime.parse(dateAsStringToLocalDateTime + time),
                dateTimeApiComponent.getLocalDateTimeFromLocalDate(
                        LocalDate.parse(dateAsString), 22, 15,45));
    }

    @Test
    public void whenGetLocalDateTimeFromString_ThenRetrivedStringIsExpected() throws Exception {
        String dateAsStringToLocalDateTime = "2018-10-15T22:15:45";
        Assert.assertEquals(LocalDateTime.parse(dateAsStringToLocalDateTime),
                dateTimeApiComponent.getLocalDateTimeFromString(dateAsStringToLocalDateTime));
    }

    @Test(expected = DateTimeException.class)
    public void whenGetLocalDateTimeFromWrongString_ThenRetrivedStringIsExpected() throws Exception {
        String dateAsStringToLocalDateTime = "2018-10-15T24:15:45";
        dateTimeApiComponent.getLocalDateTimeFromString(dateAsStringToLocalDateTime);
        Assert.fail();
    }

    @Test
    public void whenGetLocalDateTimeFromLocalDateAndLocalTime_ThenRetrivedStringIsExpected() throws Exception {
        String dateAsStringToLocalDateTime = "2018-10-15T22:15:45";
        LocalDate date = LocalDate.of(2018, 10, 15);
        LocalTime time = LocalTime.of(22, 15, 45);
        Assert.assertEquals(LocalDateTime.parse(dateAsStringToLocalDateTime),
                dateTimeApiComponent.getLocalDateTimeFromLocalDateAndLocalTime(date, time));
    }

}
