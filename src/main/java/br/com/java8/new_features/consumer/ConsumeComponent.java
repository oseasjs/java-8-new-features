package br.com.java8.new_features.consumer;

import br.com.java8.new_features.dtos.PeopleDto;
import br.com.java8.new_features.enums.PeopleMovimentStatusEnum;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

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
        acceptPeopleDtoConsume(ConsumeComponent::stop, peopleDto);
        return peopleDto.getMovimentStatusEnum();

    }

    public PeopleMovimentStatusEnum walkMoviment(PeopleDto peopleDto) {
        acceptPeopleDtoConsume(ConsumeComponent::walk, peopleDto);
        return peopleDto.getMovimentStatusEnum();
    }

    public PeopleMovimentStatusEnum runMoviment(PeopleDto peopleDto) {
        acceptPeopleDtoConsume(ConsumeComponent::run, peopleDto);
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

    private static void acceptPeopleDtoConsume(Consumer<PeopleDto> movePeople, PeopleDto peopleDto) {
        movePeople.accept(peopleDto);
    }

}