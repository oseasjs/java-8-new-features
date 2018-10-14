package br.com.java8.new_features.lambda_expressions;

import br.com.java8.new_features.Java8NewFeaturesApplicationTest;
import br.com.java8.new_features.dtos.PeopleDto;
import br.com.java8.new_features.enums.PeopleMovimentStatusEnum;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

public class LambdaExpressionsComponentTest extends Java8NewFeaturesApplicationTest {

    @Autowired
    private LambdaExpressionsComponent lambdaExpressionsComponent;

    private PeopleDto peopleDto;

    @Before
    public void setup() {
        peopleDto = new PeopleDto(1L, "Jonh", LocalDate.now());
    }

    @Test
    public void whenPeopleStop_ThenRetrivedStatusAndLastDateMovimentIsOk() {
        lambdaExpressionsComponent.stop(peopleDto);
        Assert.assertNotNull(peopleDto.getLastMovimentDate());
        Assert.assertEquals(peopleDto.getMovimentStatusEnum(), PeopleMovimentStatusEnum.STOPPED);
    }

    @Test
    public void whenPeopleWalkMoviment_ThenRetrivedStatusAndLastDateMovimentIsOk() {
        lambdaExpressionsComponent.walk(peopleDto);
        Assert.assertNotNull(peopleDto.getLastMovimentDate());
        Assert.assertEquals(peopleDto.getMovimentStatusEnum(), PeopleMovimentStatusEnum.WALKING);
    }

    @Test
    public void whenPeopleRunMoviment_ThenRetrivedStatusAndLastDateMovimentIsOk() {
        lambdaExpressionsComponent.run(peopleDto);
        Assert.assertNotNull(peopleDto.getLastMovimentDate());
        Assert.assertEquals(peopleDto.getMovimentStatusEnum(), PeopleMovimentStatusEnum.RUNNING);
    }

}
