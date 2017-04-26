package com.foo.functional.interfaces;

@FunctionalInterface
public interface Validation<T> {
    boolean check(T t);
}
