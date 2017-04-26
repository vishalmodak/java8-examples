package com.foo.defaultmethods;

public interface Computer extends Product {
    public String getBrand();
    
    @Override
    default void name() {
        System.out.println(getBrand() + " Computer");
    }
}


class MacBook implements Computer {
    String brand;
    
    public MacBook(String brand) {
        this.brand = brand;
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getBrand() {
        return this.brand;
    }
}