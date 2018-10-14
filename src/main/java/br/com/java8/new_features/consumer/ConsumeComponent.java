package br.com.java8.new_features.consumer;

import br.com.java8.new_features.dtos.PeopleDto;
import br.com.java8.new_features.enums.PeopleMovimentStatusEnum;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/*
The consumer accepts a single argument by calling its accept (args) method
and does not return any value making it a void method.
*/

@Component
public class ConsumeComponent {

    private List<PeopleDto> peopleDtoList;

    public void init() {
        peopleDtoList = Arrays.asList(
                new PeopleDto(1L, "John", LocalDate.now()),
                new PeopleDto(2L, "Mary", LocalDate.now()),
                new PeopleDto(3L, "Peter", LocalDate.now()));
    }

    public PeopleMovimentStatusEnum stopMoviment(PeopleDto peopleDto) {
        Optional.ofNullable(peopleDto).ifPresent(ConsumeComponent::stop);
        return peopleDto.getMovimentStatusEnum();
    }

    public PeopleMovimentStatusEnum walkMoviment(PeopleDto peopleDto) {
        Optional.ofNullable(peopleDto).ifPresent(ConsumeComponent::walk);
        return peopleDto.getMovimentStatusEnum();
    }

    public PeopleMovimentStatusEnum runMoviment(PeopleDto peopleDto) {
        Optional.ofNullable(peopleDto).ifPresent(ConsumeComponent::run);
        return peopleDto.getMovimentStatusEnum();
    }

    public void forceAllPeopleToStop(List<PeopleDto> peopleDtoList) {
        peopleDtoList.stream().forEach(ConsumeComponent::stop);
    }

    public void forceAllPeopleToWalk(List<PeopleDto> peopleDtoList) {
        peopleDtoList.stream().forEach(ConsumeComponent::walk);
    }

    public void forceAllPeopleToRun(List<PeopleDto> peopleDtoList) {
        peopleDtoList.stream().forEach(ConsumeComponent::run);
    }

    private static void stop(PeopleDto peopleDto) {
        peopleDto.setMovimentStatusEnum(PeopleMovimentStatusEnum.STOPPED);
        peopleDto.setLastMovimentDate(LocalDate.now());
    }

    private static void walk(PeopleDto peopleDto) {
        peopleDto.setMovimentStatusEnum(PeopleMovimentStatusEnum.WALKING);
        peopleDto.setLastMovimentDate(LocalDate.now());
    }

    private static void run(PeopleDto peopleDto) {
        peopleDto.setMovimentStatusEnum(PeopleMovimentStatusEnum.RUNNING);
        peopleDto.setLastMovimentDate(LocalDate.now());
    }

}