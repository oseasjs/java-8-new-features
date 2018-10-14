package br.com.java8.new_features.static_methods_interface;

import br.com.java8.new_features.enums.PeopleMovimentStatusEnum;

public interface StaticMethodsInterface {

    static PeopleMovimentStatusEnum moveStop() {
        return PeopleMovimentStatusEnum.STOPPED;
    }
    static PeopleMovimentStatusEnum moveWalk() {
        return PeopleMovimentStatusEnum.WALKING;
    }
    static PeopleMovimentStatusEnum moveRun() {
        return PeopleMovimentStatusEnum.RUNNING;
    }

}
