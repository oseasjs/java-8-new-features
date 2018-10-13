package br.com.java8.new_features.function;

import br.com.java8.new_features.Java8NewFeaturesApplicationTest;
import br.com.java8.new_features.dtos.PeopleDto;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

public class FunctionComponentTest extends Java8NewFeaturesApplicationTest {

    @Autowired
    private FunctionComponent functionComponent;
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
    public void when5Add3_ThenRetrivedNumberShouldBe8() {
        Assert.assertEquals(Integer.valueOf(8),
                functionComponent.add3(Integer.valueOf(5)));
    }

    @Test(expected = NullPointerException.class)
    public void whenNullAdd3_ThenExceptionIsExpected() {
        Assert.assertEquals(Integer.valueOf(8),
                functionComponent.add3(null));
    }

    @Test
    public void whenMultiply5And3_ThenRetrivedNumberShouldBe15() {
        Assert.assertEquals(Integer.valueOf(15),
                functionComponent.multiplyWithCustomizedFunction(Integer.valueOf(5), Integer.valueOf(3)));
    }

    @Test(expected = NullPointerException.class)
    public void whenMultiplyNullAnd3_ThenExceptionIsExpected() {
        functionComponent.multiplyWithCustomizedFunction(null, Integer.valueOf(3));
        Assert.fail();
    }

    @Test(expected = NullPointerException.class)
    public void whenMultiply5AndNull_ThenExceptionIsExpected() {
        functionComponent.multiplyWithCustomizedFunction(Integer.valueOf(5), null);
        Assert.fail();
    }

    @Test
    public void whenGetPeopleAsJsonUsingSingleFunction_ThenRetrivedJsonIsCorrect() {
        Assert.assertEquals(peopleAsJson.toString(),
                functionComponent.getPeopleAsJsonUsingSimpleFunction(people));
    }

    @Test
    public void whenGetPeopleAsJsonUsingSingleFunctionWithNoId_ThenRetrivedJsonIsCorrect() {
        peopleAsJson.put("id", JSONObject.NULL);
        people.setId(null);
        Assert.assertEquals(peopleAsJson.toString(),
            functionComponent.getPeopleAsJsonUsingSimpleFunction(people));
    }

    @Test
    public void whenGetPeopleAsJsonUsingSingleFunctionWithNameId_ThenRetrivedJsonIsCorrect() {
        peopleAsJson.put("name", JSONObject.NULL);
        people.setName(null);
        Assert.assertEquals(peopleAsJson.toString(),
            functionComponent.getPeopleAsJsonUsingSimpleFunction(people));
    }

    @Test(expected = NullPointerException.class)
    public void whenGetPeopleAsJsonUsingSingleFunctionWithDateId_ThenExceptionIsExpected() {
        peopleAsJson.put("date", JSONObject.NULL);
        people.setDate(null);
        functionComponent.getPeopleAsJsonUsingSimpleFunction(people);
        Assert.fail();
    }

    @Test
    public void whenGetPeopleAsJsonUsingFunctionWithoutOptionalCheck_ThenRetrivedJsonIsCorrect() {
        Assert.assertEquals(peopleAsJson.toString(),
                functionComponent.getPeopleAsJsonUsingFunctionWithoutOptionalCheck(people));
    }

    @Test
    public void whenGetPeopleAsJsonWithNoIdUsingFunctionWithoutOptionalCheck_ThenRetrivedJsonIsCorrect() {
        peopleAsJson.put("id", JSONObject.NULL);
        people.setId(null);
        Assert.assertEquals(peopleAsJson.toString(),
                functionComponent.getPeopleAsJsonUsingFunctionWithoutOptionalCheck(people));
    }

    @Test
    public void whenGetPeopleAsJsonWithNoNameUsingFunctionWithoutOptionalCheck_ThenRetrivedJsonIsCorrect() {
        peopleAsJson.put("name", JSONObject.NULL);
        people.setName(null);
        Assert.assertEquals(peopleAsJson.toString(),
                functionComponent.getPeopleAsJsonUsingFunctionWithoutOptionalCheck(people));
    }

    @Test(expected = NullPointerException.class)
    public void whenGetPeopleAsJsonWithNoDateUsingFunctionWithoutOptionalCheck_ThenRetrivedJsonIsCorrect() {
        peopleAsJson.put("date", JSONObject.NULL);
        people.setDate(null);
        Assert.assertEquals(peopleAsJson.toString(),
                functionComponent.getPeopleAsJsonUsingFunctionWithoutOptionalCheck(people));
        Assert.fail();
    }

    @Test
    public void whenGetPeopleAsJsonUsingFunctionWithOptionalCheck_ThenRetrivedJsonIsCorrect() {
        Assert.assertEquals(peopleAsJson.toString(),
                functionComponent.getPeopleAsJsonUsingFunctionWithOptionalCheck(people));
    }

    @Test
    public void whenGetPeopleAsJsonWithNoIdUsingFunctionWithOptionalCheck_ThenRetrivedJsonIsCorrect() {
        peopleAsJson.put("id", JSONObject.NULL);
        people.setId(null);
        Assert.assertEquals(peopleAsJson.toString(),
                functionComponent.getPeopleAsJsonUsingFunctionWithOptionalCheck(people));
    }

    @Test
    public void whenGetPeopleAsJsonWithNoNameUsingFunctionWithOptionalCheck_ThenRetrivedJsonIsCorrect() {
        peopleAsJson.put("name", JSONObject.NULL);
        people.setName(null);
        Assert.assertEquals(peopleAsJson.toString(),
                functionComponent.getPeopleAsJsonUsingFunctionWithOptionalCheck(people));
    }

    @Test
    public void whenGetPeopleAsJsonWithNoDateUsingFunctionWithOptionalCheck_ThenRetrivedJsonIsCorrect() {
        peopleAsJson.put("date", JSONObject.NULL);
        people.setDate(null);
        Assert.assertEquals(peopleAsJson.toString(),
                functionComponent.getPeopleAsJsonUsingFunctionWithOptionalCheck(people));
    }

}
