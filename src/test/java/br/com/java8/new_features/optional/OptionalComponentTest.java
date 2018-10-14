package br.com.java8.new_features.optional;

import br.com.java8.new_features.Java8NewFeaturesApplicationTest;
import br.com.java8.new_features.dtos.PeopleDto;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

public class OptionalComponentTest extends Java8NewFeaturesApplicationTest {

    @Autowired
    private OptionalComponent optionalComponent;
    private PeopleDto people;
    private JSONObject peopleAsJson;

    @Before
    public void init() {
        people = new PeopleDto(1L, "Jonh", LocalDate.now());

        peopleAsJson = new JSONObject();
        peopleAsJson.put("id", people.getId()).
                put("name", people.getName()).
                put("date", people.getDate());
    }

    @Test
    public void whenGetPeopleAsJson_ThenRetrivedJsonIsCorrect() {
        Assert.assertEquals(peopleAsJson.toString(), optionalComponent.getPeopleAsJson(people));
    }

    @Test
    public void whenGetPeopleAsJsonWithoutId_ThenRetrivedJsonIsCorrect() {
        peopleAsJson.remove("id");
        people.setId(null);
        Assert.assertEquals(peopleAsJson.toString(), optionalComponent.getPeopleAsJson(people));
    }

    @Test
    public void whenGetPeopleAsJsonWithoutPeople_ThenRetrivedJsonIsCorrect() {
        peopleAsJson.remove("id");
        peopleAsJson.remove("name");
        peopleAsJson.remove("date");
        people = null;
        Assert.assertEquals(peopleAsJson.toString(), optionalComponent.getPeopleAsJson(people));
    }

    @Test
    public void whenGetPeopleAsJsonWithoutName_ThenRetrivedJsonIsCorrect() {
        peopleAsJson.remove("name");
        people.setName(null);
        Assert.assertEquals(peopleAsJson.toString(), optionalComponent.getPeopleAsJson(people));
    }

    @Test
    public void whenGetPeopleAsJsonWithoutDate_ThenExceptionIsExpected() {
        peopleAsJson.remove("date");
        people.setDate(null);
        Assert.assertEquals(peopleAsJson.toString(), optionalComponent.getPeopleAsJson(people));
    }

}
