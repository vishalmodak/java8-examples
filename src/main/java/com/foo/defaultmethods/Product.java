package com.foo.defaultmethods;

public interface Product {
    
    public String getName();
    
    default void name() {
        System.out.println(getName());
    }
}

class Suitcase extends Bag {
    
    @Override
    public String getName() {
        return "This suitcase is " + this.name;
    }

    public Suitcase(String name) {
        super(name);
    }
    
}