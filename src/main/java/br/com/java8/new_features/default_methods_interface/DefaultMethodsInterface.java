package br.com.java8.new_features.default_methods_interface;

import br.com.java8.new_features.enums.PeopleMovimentStatusEnum;

public interface DefaultMethodsInterface {

    default PeopleMovimentStatusEnum moveStop() {
        return PeopleMovimentStatusEnum.STOPPED;
    }

    default PeopleMovimentStatusEnum moveWalk() {
        return PeopleMovimentStatusEnum.WALKING;
    }

    abstract PeopleMovimentStatusEnum moveRun();
}
