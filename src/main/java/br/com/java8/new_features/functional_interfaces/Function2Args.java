package br.com.java8.new_features.functional_interfaces;

@FunctionalInterface
public interface Function2Args<T, U, V> {
    public V apply(T t, U u);
}
