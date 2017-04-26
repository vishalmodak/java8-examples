package com.foo;

import java.util.Optional;

public class OptionalTest {
    
    public static void main(String[] args) {
        String foo = null;
        System.out.println(Optional.ofNullable(foo).isPresent());
        
        Optional optFoo = Optional.ofNullable(foo);
        System.out.println(optFoo.orElse("dummy"));
        System.out.println(optFoo.orElseGet(() -> String.join(" ", "John", "Doe")));
        
        String emptyFoo = "";
        System.out.println(Optional.ofNullable(foo).isPresent());
        
        Optional optEmptyFoo = Optional.ofNullable(foo);
        System.out.println(optEmptyFoo.orElse("dummy"));
        System.out.println(optEmptyFoo.orElseGet(() -> String.join(" ", "John", "Doe")));
    }

}
