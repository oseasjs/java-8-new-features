package br.com.java8.new_features.default_methods_interface;

public interface DefaultMethodInterface {
    default void method1() {
        System.out.println("ConcreteMethodInterface.method1()");
    }

    default void method2() {
        System.out.println("ConcreteMethodInterface.method2()");
    }

    abstract void method3();
}
