package com.foo.functional.interfaces;

import java.util.Arrays;
import java.util.List;

public class CopierTest {

    public static void main(String[] args) {
//        Copy<String> stringCopier = original -> "Copy of " + String.valueOf(original);
//        System.out.println(stringCopier.copy("Real Deal"));
        
        List<String> items = Arrays.asList("Vishal", "Modak");
        
        Copier.makeCopies(c -> "Copy of " + c, items);
    }

}
