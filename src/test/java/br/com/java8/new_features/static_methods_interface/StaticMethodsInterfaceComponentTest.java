package br.com.java8.new_features.static_methods_interface;

import br.com.java8.new_features.Java8NewFeaturesApplicationTest;
import br.com.java8.new_features.default_methods_interface.DefaultMethodsInterfaceComponent;
import br.com.java8.new_features.enums.PeopleMovimentStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class StaticMethodsInterfaceComponentTest extends Java8NewFeaturesApplicationTest {

    @Autowired
    private StaticMethodsInterfaceComponent staticMethodsInterfaceComponent;

    @Test
    public void whenMoveStopImplementedAsStaticMethodOnInterface_ThenRetrivedStopIsExpected() {
        Assert.assertEquals(PeopleMovimentStatusEnum.STOPPED, staticMethodsInterfaceComponent.moveStop());
    }

    @Test
    public void whenMoveWalkImplementedAsStaticMethodOnInterface_ThenRetrivedWalkIsExpected() {
        Assert.assertEquals(PeopleMovimentStatusEnum.WALKING, staticMethodsInterfaceComponent.moveWalk());
    }

    @Test
    public void whenMoveRunImplementedAsStaticMethodOnInterface_ThenRetrivedRunIsExpected() {
        Assert.assertEquals(PeopleMovimentStatusEnum.RUNNING, staticMethodsInterfaceComponent.moveRun());
    }

}
