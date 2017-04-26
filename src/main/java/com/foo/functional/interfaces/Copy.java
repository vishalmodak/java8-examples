package com.foo.functional.interfaces;

@FunctionalInterface
public interface Copy<T> {
    T copy(T t);
}
