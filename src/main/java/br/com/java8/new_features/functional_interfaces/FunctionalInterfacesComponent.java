package br.com.java8.new_features.functional_interfaces;

import org.springframework.stereotype.Component;

@Component
public class FunctionalInterfacesComponent {

    private static Function2Args<Integer, Integer, Integer> funcMultiply = (value1, value2) -> value1 * value2;

    public Integer multiplyWithCustomizedFunction(Integer value1, Integer value2) {
        Integer result = funcMultiply.apply(value1, value2);
        System.out.println(value1 + " * " + value2 + " = " + result);
        return result;
    }

}