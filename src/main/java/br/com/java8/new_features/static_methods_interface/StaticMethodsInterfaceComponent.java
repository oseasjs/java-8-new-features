package br.com.java8.new_features.static_methods_interface;

import br.com.java8.new_features.enums.PeopleMovimentStatusEnum;
import org.springframework.stereotype.Component;

@Component
public class StaticMethodsInterfaceComponent {

    public PeopleMovimentStatusEnum moveStop() {
        return StaticMethodsInterface.moveStop();
    }

    public PeopleMovimentStatusEnum moveWalk() {
        return StaticMethodsInterface.moveWalk();
    }

    public PeopleMovimentStatusEnum moveRun() {
        return StaticMethodsInterface.moveRun();
    }

}
