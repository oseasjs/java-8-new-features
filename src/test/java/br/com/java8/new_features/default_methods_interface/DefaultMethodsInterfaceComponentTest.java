package br.com.java8.new_features.default_methods_interface;

import br.com.java8.new_features.Java8NewFeaturesApplicationTest;
import br.com.java8.new_features.enums.PeopleMovimentStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DefaultMethodsInterfaceComponentTest extends Java8NewFeaturesApplicationTest {

    @Autowired
    private DefaultMethodsInterfaceComponent defaultMethodsInterfaceComponent;

    @Test
    public void whenMoveStopImplementedAsDefaultMethod_ThenRetrivedStopIsExpected() {
        Assert.assertEquals(PeopleMovimentStatusEnum.STOPPED, defaultMethodsInterfaceComponent.moveStop());
    }

    @Test
    public void whenMoveWalkOverloadedOnConcreteClass_ThenRetrivedFaslWalkingIsExpected() {
        Assert.assertEquals(PeopleMovimentStatusEnum.FAST_WALKING,
                defaultMethodsInterfaceComponent.moveWalkOverloadedToFastWalking());
    }

    @Test
    public void whenMoveWalkImplementedAsDefaultMethod_ThenRetrivedWalkIsExpected() {
        Assert.assertEquals(PeopleMovimentStatusEnum.WALKING, defaultMethodsInterfaceComponent.moveWalk());
    }

    @Test
    public void whenMoveRunImplementedByConcretedClass_ThenRetrivedRunIsExpected() {
        Assert.assertEquals(PeopleMovimentStatusEnum.RUNNING, defaultMethodsInterfaceComponent.moveRun());
    }

}
