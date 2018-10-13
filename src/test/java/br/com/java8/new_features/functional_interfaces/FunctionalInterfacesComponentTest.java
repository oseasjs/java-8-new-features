package br.com.java8.new_features.functional_interfaces;

import br.com.java8.new_features.Java8NewFeaturesApplicationTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class FunctionalInterfacesComponentTest extends Java8NewFeaturesApplicationTest {

    @Autowired
    private FunctionalInterfacesComponent functionalInterfacesComponent;

    @Test
    public void whenMultiply5And3_ThenRetrivedNumberShouldBe15() {
        Assert.assertEquals(Integer.valueOf(15),
                functionalInterfacesComponent.multiplyWithCustomizedFunction(Integer.valueOf(5), Integer.valueOf(3)));
    }

    @Test(expected = NullPointerException.class)
    public void whenMultiplyNullAnd3_ThenExceptionIsExpected() {
        functionalInterfacesComponent.multiplyWithCustomizedFunction(null, Integer.valueOf(3));
        Assert.fail();
    }

    @Test(expected = NullPointerException.class)
    public void whenMultiply5AndNull_ThenExceptionIsExpected() {
        functionalInterfacesComponent.multiplyWithCustomizedFunction(Integer.valueOf(5), null);
        Assert.fail();
    }

}