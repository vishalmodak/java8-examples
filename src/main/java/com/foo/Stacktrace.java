package com.foo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Stacktrace {

    public static void main(String[] args)  {
        List<String> names = Arrays.asList("Joe", "John", "Max", "Alex");
        Stream output = names.stream().map(name -> name.substring(10));
        System.out.println(output.count());
    }

}
