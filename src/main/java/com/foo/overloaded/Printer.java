package com.foo.overloaded;

import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class Printer {
    
    public void print(HelloFunction hello) {
        System.out.println("Hello Function");
    }

    public void print(String string) {
        System.out.println(string);
    }
    
    public void add(BinaryOperator<Integer> add) {
        System.out.println("BinaryOperator");
    }

    public void add(IntegerBiFunction add) {
        System.out.println("IntegerBiFunction");
    }
    
    public void test(Predicate<Integer> predicate) {
        System.out.println("Predicate");
    }
    
    public void test(IntPredicate intPredicate) {
        System.out.println("IntPredicate");
    }
}
