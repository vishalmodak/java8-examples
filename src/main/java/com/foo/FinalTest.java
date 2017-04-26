package com.foo;

public class FinalTest {

    public static void main(String[] args) {
        String name = "john";
//        name = "Jane";
        Runnable r = () -> System.out.println("Hello " + name);
        r.run();
    }

}
