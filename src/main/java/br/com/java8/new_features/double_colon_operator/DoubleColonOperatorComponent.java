package br.com.java8.new_features.double_colon_operator;

import br.com.java8.new_features.dtos.PeopleDto;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Optional;

@Component
public class DoubleColonOperatorComponent {

    private PeopleDto peopleDto;

    @PostConstruct
    public void init() {
        peopleDto = new PeopleDto(1L, "Jonh", LocalDate.now());
    }

    public Long getPeopleIdUsingColonOperator(PeopleDto peopleDto) {
        Optional<PeopleDto> peopleDtoOptional = Optional.ofNullable(peopleDto);
        return peopleDtoOptional.map(PeopleDto::getId).orElse(null);
    }

    public String getPeopleNameUsingColonOperator(PeopleDto peopleDto) {
        Optional<PeopleDto> peopleDtoOptional = Optional.ofNullable(peopleDto);
        return peopleDtoOptional.map(PeopleDto::getName).orElse(null);
    }

    public LocalDate getPeopleDateUsingColonOperator(PeopleDto peopleDto) {
        Optional<PeopleDto> peopleDtoOptional = Optional.ofNullable(peopleDto);
        return peopleDtoOptional.map(PeopleDto::getDate).orElse(null);
    }

}
