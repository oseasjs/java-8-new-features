package br.com.java8.new_features.predicate;

import br.com.java8.new_features.dtos.PeopleDto;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@Component
public class PredicateComponent {

    private List<PeopleDto> peopleDtoList;

    @PostConstruct
    public void init() {
        peopleDtoList = Arrays.asList(
                new PeopleDto(1L, "John", LocalDate.now()),
                new PeopleDto(2L, "Mary", LocalDate.now()),
                new PeopleDto(3L, "Peter", LocalDate.now()));
    }

    public PeopleDto getPeopleDtoById(List<PeopleDto> peopleDtoList, Long id) {
        return filterByPredicate(p -> p.getId().equals(id));
    }

    public PeopleDto getPeopleDtoByName(List<PeopleDto> peopleDtoList, String name) {
        return filterByPredicate(p -> p.getName().equals(name));
    }

    public PeopleDto getFirstPeopleDtoByNameContains(List<PeopleDto> peopleDtoList, String partialName) {
        return filterByPredicate(p -> p.getName().toLowerCase().contains(partialName.toLowerCase()));
    }

    public PeopleDto getPeopleDtoByDate(List<PeopleDto> peopleDtoList, LocalDate date) {
        return filterByPredicate(p -> p.getDate().atStartOfDay().equals(date.atStartOfDay()));
    }

    public PeopleDto getPeopleDtoByIdAndName(List<PeopleDto> peopleDtoList, Long id, String name) {
        return filterByPredicate(p -> p.getId().equals(id) && p.getName().equals(name));
    }

    public PeopleDto getPeopleDtoByIdAndDate(List<PeopleDto> peopleDtoList, Long id, LocalDate date) {
        return filterByPredicate(p -> p.getId().equals(id) && p.getDate().equals(date));
    }

    public PeopleDto getPeopleDtoByNameAndDate(List<PeopleDto> peopleDtoList, String name, LocalDate date) {
        return filterByPredicate(p -> p.getName().equals(name) && p.getDate().equals(date));
    }

    public PeopleDto getPeopleDtoByIdAndNameAndDate(List<PeopleDto> peopleDtoList,
                                                    Long id, String name, LocalDate date) {
        return filterByPredicate(p -> p.getId().equals(id) &&
                p.getName().equals(name) && p.getDate().equals(date));
    }

    private PeopleDto filterByPredicate(Predicate<PeopleDto> predicate) {
        return peopleDtoList.stream()
                .filter(predicate)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Not Found"));
    }

}