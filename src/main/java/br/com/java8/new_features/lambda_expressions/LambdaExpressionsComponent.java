package br.com.java8.new_features.lambda_expressions;

import br.com.java8.new_features.dtos.PeopleDto;
import br.com.java8.new_features.enums.PeopleMovimentStatusEnum;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class LambdaExpressionsComponent {

    public void stop(PeopleDto peopleDto) {
        move(peopleDto, PeopleMovimentStatusEnum.STOPPED);
    }

    public void walk(PeopleDto peopleDto) {
        move(peopleDto, PeopleMovimentStatusEnum.WALKING);
    }

    public void run(PeopleDto peopleDto) {
        move(peopleDto, PeopleMovimentStatusEnum.RUNNING);
    }

    private void move(PeopleDto peopleDto, PeopleMovimentStatusEnum peopleMovimentStatusEnum) {
        MovimentInterface movimentInterface = (p) -> {
            p.setMovimentStatusEnum(peopleMovimentStatusEnum);
            p.setLastMovimentDate(LocalDate.now());
        };
        movimentInterface.startMoviment(peopleDto);
    }

}
