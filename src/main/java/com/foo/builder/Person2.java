package com.foo.builder;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class Person2 {
    private String firstName;
    private String lastName;
    private int weight;
    
    private Person2() { } 

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    @FunctionalInterface
    public interface PersonSetter extends Consumer<Person2> {}
    
    public static Person2 build(PersonSetter... personSetters) {
        final Person2 person = new Person2();

        Stream.of(personSetters).forEach(s -> s.accept(person));

        return person;
    }

    @Override
    public String toString() {
        return "Person [firstName=" + firstName + ", lastName=" + lastName
                + ", weight=" + weight + "]";
    }
    
}
