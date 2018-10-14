package br.com.java8.new_features.default_methods_interface;

import br.com.java8.new_features.enums.PeopleMovimentStatusEnum;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DefaultMethodsInterfaceComponent {

    private DefaultMethodsInterface defaultMethodsInterface;

    @PostConstruct
    public void init() {
        defaultMethodsInterface = new DefaultMethodsInterface() {
            @Override
            public PeopleMovimentStatusEnum moveRun() {
                return PeopleMovimentStatusEnum.RUNNING;
            }
        };
    }

    public PeopleMovimentStatusEnum moveStop() {
        return defaultMethodsInterface.moveStop();
    }

    public PeopleMovimentStatusEnum moveWalk() {
        return defaultMethodsInterface.moveWalk();
    }

    public PeopleMovimentStatusEnum moveWalkOverloadedToFastWalking() {

        DefaultMethodsInterface defaultMethodsInterfaceWalkOverloaded = new DefaultMethodsInterface() {
            @Override
            public PeopleMovimentStatusEnum moveWalk() {
                return PeopleMovimentStatusEnum.FAST_WALKING;
            }
            @Override
            public PeopleMovimentStatusEnum moveRun() {
                return PeopleMovimentStatusEnum.RUNNING;
            }
        };

        return defaultMethodsInterfaceWalkOverloaded.moveWalk();

    }

    public PeopleMovimentStatusEnum moveRun() {
        return defaultMethodsInterface.moveRun();
    }

}
