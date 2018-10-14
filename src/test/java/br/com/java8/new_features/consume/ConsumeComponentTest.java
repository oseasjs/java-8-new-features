package br.com.java8.new_features.consume;

import br.com.java8.new_features.Java8NewFeaturesApplicationTest;
import br.com.java8.new_features.consumer.ConsumeComponent;
import br.com.java8.new_features.dtos.PeopleDto;
import br.com.java8.new_features.enums.PeopleMovimentStatusEnum;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class ConsumeComponentTest extends Java8NewFeaturesApplicationTest {

    @Autowired
    private ConsumeComponent consumeComponent;

    private PeopleDto people;
    private List<PeopleDto> peopleDtoList;

    @Before
    public void init() {
        people = new PeopleDto(1L, "Jonh", LocalDate.now());
        peopleDtoList = Arrays.asList(
                new PeopleDto(1L, "John", LocalDate.now()),
                new PeopleDto(2L, "Mary", LocalDate.now()),
                new PeopleDto(3L, "Peter", LocalDate.now()));
    }


    @Test
    public void whenStopMovimentUsingConsume_ThenRetrivedStopIsExpected() {
        Assert.assertEquals(PeopleMovimentStatusEnum.STOPPED, consumeComponent.stopMoviment(people));
    }

    @Test
    public void whenWalkMovimentUsingConsume_ThenRetrivedWalkIsExpected() {
        Assert.assertEquals(PeopleMovimentStatusEnum.WALKING, consumeComponent.walkMoviment(people));
    }

    @Test
    public void whenRunMovimentUsingConsume_ThenRetrivedRunIsExpected() {
        Assert.assertEquals(PeopleMovimentStatusEnum.RUNNING, consumeComponent.runMoviment(people));
    }

    @Test
    public void whenForceAllPeopleToStopUsingConsume_ThenRetrivedRunIsExpected() {

        consumeComponent.forceAllPeopleToStop(peopleDtoList);
        peopleDtoList.stream().forEach(
            (p) -> Assert.assertEquals(PeopleMovimentStatusEnum.STOPPED, p.getMovimentStatusEnum())
        );

    }

    @Test
    public void whenForceAllPeopleToWalkUsingConsume_ThenRetrivedRunIsExpected() {

        consumeComponent.forceAllPeopleToWalk(peopleDtoList);
        peopleDtoList.stream().forEach(
            (p) -> Assert.assertEquals(PeopleMovimentStatusEnum.WALKING, p.getMovimentStatusEnum())
        );

    }

    @Test
    public void whenForceAllPeopleToRunUsingConsume_ThenRetrivedRunIsExpected() {

        consumeComponent.forceAllPeopleToRun(peopleDtoList);
        peopleDtoList.stream().forEach(
            (p) -> Assert.assertEquals(PeopleMovimentStatusEnum.RUNNING, p.getMovimentStatusEnum())
        );

    }

}
