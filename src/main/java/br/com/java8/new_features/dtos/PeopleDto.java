package br.com.java8.new_features.dtos;

import br.com.java8.new_features.enums.PeopleMovimentStatusEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class PeopleDto {

    Long id;
    String name;
    LocalDate date;
    @JsonIgnore
    PeopleMovimentStatusEnum movimentStatusEnum = PeopleMovimentStatusEnum.STOPPED;
    @JsonIgnore
    LocalDate lastMovimentDate;

    public PeopleDto(Long id, String name, LocalDate date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

}
