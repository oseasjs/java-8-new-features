package br.com.java8.new_features.supplier;

import br.com.java8.new_features.dtos.PeopleDto;
import br.com.java8.new_features.enums.PeopleMovimentStatusEnum;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Optional;
import java.util.function.Supplier;

/*
The supplier does the opposite of the consumer, so it takes
no arguments but it returns some value by calling its get() method.
*/

@Component
public class SuplierComponent {

    private Supplier<PeopleMovimentStatusEnum> suplierStopedPeople;

    @PostConstruct
    public void init() {
        suplierStopedPeople = SuplierComponent::getStoppedStatus;
    }

    public PeopleMovimentStatusEnum getCurrentPeopleMovimentOrStopped(PeopleDto peopleDto) {
        return Optional.ofNullable(peopleDto.getMovimentStatusEnum()).orElse(suplierStopedPeople.get());
    }

    private static PeopleMovimentStatusEnum getStoppedStatus() {
        return PeopleMovimentStatusEnum.STOPPED;
    }
}