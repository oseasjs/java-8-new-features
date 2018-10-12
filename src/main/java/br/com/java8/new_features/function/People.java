package br.com.java8.new_features.function;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class People {
    Long id;
    String name;
    LocalDate date;
}
