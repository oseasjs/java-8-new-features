package br.com.java8.new_features.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class PeopleDto {
    Long id;
    String name;
    LocalDate date;
}
