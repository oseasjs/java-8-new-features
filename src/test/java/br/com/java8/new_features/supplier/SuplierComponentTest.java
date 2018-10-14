package br.com.java8.new_features.supplier;

import br.com.java8.new_features.Java8NewFeaturesApplicationTest;
import br.com.java8.new_features.dtos.PeopleDto;
import br.com.java8.new_features.enums.PeopleMovimentStatusEnum;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

public class SuplierComponentTest extends Java8NewFeaturesApplicationTest {

    @Autowired
    private SuplierComponent suplierComponent;

    private PeopleDto people;

    @Before
    public void init() {
        people = new PeopleDto(1L, "Jonh", LocalDate.now());
    }

    @Test
    public void whenGetPeopleMovimentStatusStoppedUsingSupplier_ThenRetrivedCurrentIsExpected() {
        people.setMovimentStatusEnum(PeopleMovimentStatusEnum.STOPPED);
        Assert.assertEquals(people.getMovimentStatusEnum(), suplierComponent.getCurrentPeopleMovimentOrStopped(people));
    }

    @Test
    public void whenGetPeopleMovimentStatusNullUsingSupplier_ThenRetrivedStoppedIsExpected() {
        Assert.assertEquals(PeopleMovimentStatusEnum.STOPPED, suplierComponent.getCurrentPeopleMovimentOrStopped(people));
    }

    @Test
    public void whenGetPeopleMovimentStatusWorkingUsingSupplier_ThenRetrivedCurrentIsExpected() {
        people.setMovimentStatusEnum(PeopleMovimentStatusEnum.WALKING);
        Assert.assertEquals(people.getMovimentStatusEnum(), suplierComponent.getCurrentPeopleMovimentOrStopped(people));
    }

    @Test
    public void whenGetPeopleMovimentStatusRunningUsingSupplier_ThenRetrivedCurrentIsExpected() {
        people.setMovimentStatusEnum(PeopleMovimentStatusEnum.RUNNING);
        Assert.assertEquals(people.getMovimentStatusEnum(), suplierComponent.getCurrentPeopleMovimentOrStopped(people));
    }


}
