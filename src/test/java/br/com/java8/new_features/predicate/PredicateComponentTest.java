package br.com.java8.new_features.predicate;

import br.com.java8.new_features.Java8NewFeaturesApplicationTest;
import br.com.java8.new_features.dtos.PeopleDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class PredicateComponentTest extends Java8NewFeaturesApplicationTest {

    @Autowired
    private PredicateComponent predicateComponent;

    private List<PeopleDto> peopleDtoList;

    @Before
    public void init() {
        peopleDtoList = Arrays.asList(
                new PeopleDto(1L, "John", LocalDate.now()),
                new PeopleDto(2L, "Mary", LocalDate.now()),
                new PeopleDto(3L, "Peter", LocalDate.now()));
    }

    @Test
    public void whenGetPeopleDtoById_ThenRetrivedPeopleIsExpected() {
        PeopleDto expected = peopleDtoList.get(0);
        PeopleDto found = predicateComponent.getPeopleDtoById(
                peopleDtoList, Long.valueOf(1));
        Assert.assertEquals(expected, found);
    }

    @Test(expected = Exception.class)
    public void whenGetPeopleDtoByNull_ThenRetrivedPeopleIsExpected() {
        PeopleDto expected = peopleDtoList.get(1);
        PeopleDto found = predicateComponent.getPeopleDtoById(
                peopleDtoList, null);
        Assert.assertEquals(expected, found);
    }

    @Test(expected = Exception.class)
    public void whenGetPeopleDtoByIdNotExists_ThenRetrivedPeopleIsExpected() {
        PeopleDto expected = peopleDtoList.get(0);
        PeopleDto found = predicateComponent.getPeopleDtoById(
                peopleDtoList, Long.valueOf(5));
        Assert.assertEquals(expected, found);
    }

    @Test
    public void whenGetPeopleDtoByName_ThenRetrivedPeopleIsExpected() {
        PeopleDto expected = peopleDtoList.get(0);
        PeopleDto found = predicateComponent.getPeopleDtoByName(
                peopleDtoList, "John");
        Assert.assertEquals(expected, found);
    }

    @Test
    public void whenGetPeopleDtoByNameContains_ThenRetrivedPeopleIsExpected() {
        PeopleDto expected = peopleDtoList.get(1);
        PeopleDto found = predicateComponent.getFirstPeopleDtoByNameContains(
                peopleDtoList, "r");
        Assert.assertEquals(expected, found);
    }

    @Test
    public void whenGetPeopleDtoByDate_ThenRetrivedPeopleIsExpected() {
        PeopleDto expected = peopleDtoList.get(0);
        PeopleDto found = predicateComponent.getPeopleDtoByDate(
                peopleDtoList, LocalDate.now());
        Assert.assertEquals(expected, found);
    }

    @Test
    public void whenGetPeopleDtoByIdAndName_ThenRetrivedPeopleIsExpected() {
        PeopleDto expected = peopleDtoList.get(1);
        PeopleDto found = predicateComponent.getPeopleDtoByIdAndName(
                peopleDtoList, Long.valueOf(2), "Mary");
        Assert.assertEquals(expected, found);
    }

    @Test
    public void whenGetPeopleDtoByIdAndDate_ThenRetrivedPeopleIsExpected() {
        PeopleDto expected = peopleDtoList.get(2);
        PeopleDto found = predicateComponent.getPeopleDtoByIdAndDate(
                peopleDtoList, Long.valueOf(3), LocalDate.now());
        Assert.assertEquals(expected, found);
    }

    @Test
    public void whenGetPeopleDtoByNameAndDate_ThenRetrivedPeopleIsExpected() {
        PeopleDto expected = peopleDtoList.get(2);
        PeopleDto found = predicateComponent.getPeopleDtoByNameAndDate(
                peopleDtoList, "Peter", LocalDate.now());
        Assert.assertEquals(expected, found);
    }

    @Test
    public void whenGetPeopleDtoByIdAndNameAndDate_ThenRetrivedPeopleIsExpected() {
        PeopleDto expected = peopleDtoList.get(1);
        PeopleDto found = predicateComponent.getPeopleDtoByIdAndNameAndDate(
                peopleDtoList,  Long.valueOf(2), "Mary", LocalDate.now());
        Assert.assertEquals(expected, found);
    }

}
