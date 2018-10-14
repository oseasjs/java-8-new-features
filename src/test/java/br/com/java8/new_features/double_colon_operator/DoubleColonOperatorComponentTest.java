package br.com.java8.new_features.double_colon_operator;

import br.com.java8.new_features.Java8NewFeaturesApplicationTest;
import br.com.java8.new_features.dtos.PeopleDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

public class DoubleColonOperatorComponentTest extends Java8NewFeaturesApplicationTest {

    @Autowired
    private DoubleColonOperatorComponent doubleColonOperatorComponent;
    private PeopleDto people;

    @Before
    public void init() {
        people = new PeopleDto(1L, "Jonh", LocalDate.now());
    }

    @Test
    public void whenGetPeopleWithId_ThenRetrivedNumberIsExpected() {
        Assert.assertEquals(people.getId(), doubleColonOperatorComponent.getPeopleIdUsingColonOperator(people));
    }

    @Test
    public void whenGetPeopleWithoutId_ThenRetrivedNullIsExpected() {
        people.setId(null);
        Assert.assertEquals(people.getId(), doubleColonOperatorComponent.getPeopleIdUsingColonOperator(people));
    }

    @Test
    public void whenGetPeopleWithName_ThenRetrivedNameIsExpected() {
        Assert.assertEquals(people.getName(), doubleColonOperatorComponent.getPeopleNameUsingColonOperator(people));
    }

    @Test
    public void whenGetPeopleWithoutName_ThenRetrivedNullIsExpected() {
        people.setName(null);
        Assert.assertEquals(people.getName(), doubleColonOperatorComponent.getPeopleNameUsingColonOperator(people));
    }

    @Test
    public void whenGetPeopleWithDate_ThenRetrivedDateIsExpected() {
        Assert.assertEquals(people.getDate(), doubleColonOperatorComponent.getPeopleDateUsingColonOperator(people));
    }

    @Test
    public void whenGetPeopleWithoutDate_ThenRetrivedNullIsExpected() {
        people.setDate(null);
        Assert.assertEquals(people.getDate(), doubleColonOperatorComponent.getPeopleDateUsingColonOperator(people));
    }

}
