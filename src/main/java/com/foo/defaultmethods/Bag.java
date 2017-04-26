package com.foo.defaultmethods;

public class Bag implements Product {
    String name;
    
    public Bag(String name) {
        this.name = name;
    }
    
    @Override
    public void name() {
        System.out.println("This bag is " + this.name);
    }

    @Override
    public String getName() {
        return this.name;
    }
    
}
