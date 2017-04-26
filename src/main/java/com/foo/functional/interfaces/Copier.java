package com.foo.functional.interfaces;

import java.util.List;

public class Copier {

    public static void makeCopies(Copy<String> copyLambda, List<String> items) {
        items.stream().forEach(item -> System.out.println(copyLambda.copy(item)));
    }
}
