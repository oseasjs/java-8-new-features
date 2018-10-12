package br.com.java8.new_features.function;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.function.Function;

@Component
public class FunctionComponent {

    private static Function<Object, Object> funcPutJsonAttribute = obj -> obj != null ? obj : JSONObject.NULL;
    private static Function2<Integer, Integer, Integer> funcMultiply = (value1, value2) -> value1 * value2;

    private static Object getAsString(Optional<Object> value) {
        return value.map(
                v -> {
                    return (v instanceof LocalDate) ? getDateAsString((LocalDate) v) : v;
                }
            ).orElse(JSONObject.NULL);
    }

    private static String getDateAsString(LocalDate date) {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd").format(date);
    }

    private static People getPeople() {
        return new People(Long.valueOf(1), "Jonh", LocalDate.now());
    }

    public Integer add3(Integer value) {
        Function<Integer, Integer> funcSum = i -> i + Integer.valueOf(3);
        Integer result = funcSum.apply(value);
        System.out.println("5 + 3 = " + result);
        return result;
    }

    public Integer multiplyWithCustomizedFunction(Integer value1, Integer value2) {
        Integer result = funcMultiply.apply(value1, value2);
        System.out.println("5 * 8 = " + result);
        return result;
    }

    public String getPeopleAsJsonUsingSimpleFunction(People people) {
        JSONObject json = new JSONObject();
        json.put("id", funcPutJsonAttribute.apply(people.getId()));
        json.put("name", funcPutJsonAttribute.apply(people.getName()));
        json.put("date", funcPutJsonAttribute.apply(getDateAsString(people.getDate())));
        System.out.println(json);
        return json.toString();
    }

    public String getPeopleAsJsonUsingFunctionWithoutOptionalCheck(People people) {
        JSONObject json = new JSONObject();
        json.put("id", funcPutJsonAttribute.apply(people.getId()));
        json.put("name", funcPutJsonAttribute.apply(people.getName()));
        json.put("date", funcPutJsonAttribute.apply(getDateAsString(people.getDate())));
        System.out.println(json);
        return json.toString();
    }

    public String getPeopleAsJsonUsingFunctionWithOptionalCheck(People people) {
        Function<Optional<Object>, Object> funcPutJsonAttribute2 = (_value) ->
                _value.isPresent() ? getAsString(_value) : JSONObject.NULL;
        JSONObject json = new JSONObject();
        json.put("id", funcPutJsonAttribute2.apply(Optional.ofNullable(people.getId())));
        json.put("name", funcPutJsonAttribute2.apply(Optional.ofNullable(people.getName())));
        json.put("date", funcPutJsonAttribute2.apply(Optional.ofNullable(people.getDate())));
        System.out.println(json);
        return json.toString();
    }

    public String getPeopleAsJsonWithOptionalCheck(People people) {
        JSONObject json = new JSONObject();
        json.put("id", getAsString(Optional.ofNullable(people.getId())));
        json.put("name", getAsString(Optional.ofNullable(people.getName())));
        json.put("date", getAsString(Optional.ofNullable(people.getDate())));
        System.out.println(json);
        return json.toString();
    }

}

@FunctionalInterface
interface Function2<T, U, V> {
    public V apply(T t, U u);
}