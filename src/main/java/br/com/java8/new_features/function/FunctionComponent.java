package br.com.java8.new_features.function;

import br.com.java8.new_features.dtos.PeopleDto;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.function.Function;

@Component
public class FunctionComponent {

    private static Function<Object, Object> funcPutJsonAttribute = obj -> obj != null ? obj : JSONObject.NULL;
    private static Function<LocalDate, Object> funcGetDateAsString = date -> DateTimeFormatter.ofPattern("yyyy-MM-dd").format(date);

    private static Object getAsString(Optional<Object> value) {
        return value.map(v -> {
            return (v instanceof LocalDate) ? funcGetDateAsString.apply((LocalDate) v) : v;
        }).orElse(JSONObject.NULL);
    }

    private static PeopleDto getPeople() {
        return new PeopleDto(Long.valueOf(1), "Jonh", LocalDate.now());
    }

    public Integer add3(Integer value) {
        Function<Integer, Integer> funcSum = i -> i + Integer.valueOf(3);
        Integer result = funcSum.apply(value);
        System.out.println("5 + 3 = " + result);
        return result;
    }

    public String getPeopleAsJsonUsingSimpleFunction(PeopleDto people) {
        JSONObject json = new JSONObject();
        json.put("id", funcPutJsonAttribute.apply(people.getId()));
        json.put("name", funcPutJsonAttribute.apply(people.getName()));
        json.put("date", funcPutJsonAttribute.apply(funcGetDateAsString.apply(people.getDate())));

        System.out.println(json);
        return json.toString();
    }

    public String getPeopleAsJsonUsingFunctionWithoutOptionalCheck(PeopleDto people) {
        JSONObject json = new JSONObject();
        json.put("id", funcPutJsonAttribute.apply(people.getId()));
        json.put("name", funcPutJsonAttribute.apply(people.getName()));
        json.put("date", funcPutJsonAttribute.apply(funcGetDateAsString.apply(people.getDate())));
        System.out.println(json);
        return json.toString();
    }

    public String getPeopleAsJsonUsingFunctionWithOptionalCheck(PeopleDto people) {
        Function<Optional<Object>, Object> funcPutJsonAttribute2 = (_value) ->
                _value.isPresent() ? getAsString(_value) : JSONObject.NULL;
        JSONObject json = new JSONObject();
        json.put("id", funcPutJsonAttribute2.apply(Optional.ofNullable(people.getId())));
        json.put("name", funcPutJsonAttribute2.apply(Optional.ofNullable(people.getName())));
        json.put("date", funcPutJsonAttribute2.apply(Optional.ofNullable(people.getDate())));
        System.out.println(json);
        return json.toString();
    }

    public String getPeopleAsJsonWithOptionalCheck(PeopleDto people) {
        JSONObject json = new JSONObject();
        json.put("id", getAsString(Optional.ofNullable(people.getId())));
        json.put("name", getAsString(Optional.ofNullable(people.getName())));
        json.put("date", getAsString(Optional.ofNullable(people.getDate())));
        System.out.println(json);
        return json.toString();
    }

}