package com.foo.functional.interfaces;

import java.util.stream.Stream;

public class ValidateTest {

    public static void main(String[] args) {
        String name = "richard";
        if(isValid(name, v1 -> v1 != null, 
                             v2 -> v2.length() > 0, 
                             v3 -> Character.isUpperCase(v3.charAt(0)))) {
            System.out.println(name + " is Valid");
        } else {
            System.out.println(name + " is Not Valid");
        }
        
        System.out.println(Stream.of(1, 2, 3, 4, 5).reduce(0, (acc, number) -> acc + number , (acc1, acc2) -> acc1 * acc2 ));

    }
    
    public static boolean isValid(String target, Validation<String>... validators) {
//        return Stream.of(validators).reduce(false, (acc, validator) -> validator.check(target), (acc1, acc2) -> acc1 && acc2); 
        return Stream.of(validators).allMatch(predicate -> predicate.check(target));
    }

}
