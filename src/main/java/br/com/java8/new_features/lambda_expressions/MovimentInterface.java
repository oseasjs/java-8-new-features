package br.com.java8.new_features.lambda_expressions;

import br.com.java8.new_features.dtos.PeopleDto;

import java.util.Optional;

public interface MovimentInterface {

    abstract void startMoviment(PeopleDto peopleDto);

}
