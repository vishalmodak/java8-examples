package com.foo.builder;

import java.util.function.Function;

public class Person {
    private String firstName;
    private String lastName;
    private int weight;
    
    private Person(String firstName, String lastName, int weight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.weight = weight;
    }
    
    public static FirstNameBuilder person() {
        return firstName -> lastName -> weight -> new Person(firstName, lastName, weight);
    }
    
    public static Function<String, Function<String, Function<Integer, Person>>> person2() {
        return firstName -> lastName -> weight -> new Person(firstName, lastName, weight);
    }
    
    public static FirstNameBuilder build() {
        return new FirstNameBuilder() {
            @Override
            public LastNameBuilder firstName(String firstName) {
                return new LastNameBuilder() {
                    @Override
                    public WeightBuilder lastName(String lastName) {
                        return new WeightBuilder() {
                            @Override
                            public Person weight(int weight) {
                                return new Person(firstName, lastName, weight);
                            }
                        };
                    }
                };
            }
        };
    }

    
    interface FirstNameBuilder {
        LastNameBuilder firstName(String firstName);
    }
    interface LastNameBuilder {
        WeightBuilder lastName(String lastName);
    }
    interface WeightBuilder {
        Person weight(int height);
    }

    @Override
    public String toString() {
        return "Person [firstName=" + firstName + ", lastName=" + lastName
                + ", weight=" + weight + "]";
    }
    
}
