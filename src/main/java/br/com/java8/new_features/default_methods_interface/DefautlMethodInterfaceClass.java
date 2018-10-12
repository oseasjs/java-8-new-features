package br.com.java8.new_features.default_methods_interface;

import jdk.nashorn.internal.runtime.options.Option;

public class DefautlMethodInterfaceClass implements DefaultMethodInterface {

    public void method1() {
        System.out.println("DefautlMethodInterfaceClass.method1()");
    }

    public void method3() {
        System.out.println("DefautlMethodInterfaceClass.method3()");
    }

    public static void main(String[] args) {
        DefautlMethodInterfaceClass obj = new DefautlMethodInterfaceClass();
        obj.method1();
        obj.method2();
        obj.method3();
    }

}
