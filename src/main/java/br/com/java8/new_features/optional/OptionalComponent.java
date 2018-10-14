package br.com.java8.new_features.optional;

import br.com.java8.new_features.dtos.PeopleDto;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Component
public class OptionalComponent {

    public String getPeopleAsJson(PeopleDto people) {
        JSONObject json = new JSONObject();
        Optional<PeopleDto> peopleDtoOptional = Optional.ofNullable(people);
        peopleDtoOptional.map(PeopleDto::getId).ifPresent(id -> json.put("id", id));
        peopleDtoOptional.map(PeopleDto::getName).ifPresent(name -> json.put("name", name));
        peopleDtoOptional.map(PeopleDto::getDate).ifPresent(
                date -> json.put("date", DateTimeFormatter.ofPattern("yyyy-MM-dd").format(date)));

        System.out.println(json);
        return json.toString();
    }

}
