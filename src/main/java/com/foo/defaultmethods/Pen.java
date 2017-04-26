package com.foo.defaultmethods;

public class Pen implements Product {
    String name;
    
    public Pen(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
    
}
