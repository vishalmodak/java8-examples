package com.foo.builder;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class MyModel {
    private Map<String, String> map;
    
    private MyModel() { 
        map = new HashMap<>();
    } 

    public void setEntry(String key, String value) {
        map.put(key, value);
    }
    
    @FunctionalInterface
    public interface PersonSetter extends Consumer<MyModel> {}
    
    public static MyModel build(PersonSetter... personSetters) {
        final MyModel person = new MyModel();

        Stream.of(personSetters).forEach(s -> s.accept(person));

        return person;
    }

    @Override
    public String toString() {
        return map.toString();
    }
    
}
