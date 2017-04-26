package com.foo.overloaded;

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}
