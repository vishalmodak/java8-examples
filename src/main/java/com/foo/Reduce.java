package com.foo;

import java.util.Arrays;
import java.util.stream.Stream;

public class Reduce {

    public static void main(String[] args) {
//        int count = Stream.of(1, 2, 3).reduce(0, (acc, element) -> acc + element);
//        System.out.println(count);
//        
//        String text = Stream.of("a", "b", "c").reduce("init-", (acc, element) -> acc + element);
//        System.out.println(text);
//        
//        StringBuilder text2 = Stream.of("a", "b", "c")
//                .reduce(new StringBuilder(), (builder, element) -> {
//                    builder.append(element);
//                    return builder;
//                }, (left, right) -> left.append(right));
//        System.out.println(text2);
//        
//        System.out.println(Stream.of(1, 2, 3)
//                .reduce(0, (acc, element)-> acc * element, (acc, element)-> acc + element)
//         );
//        System.out.println("NonParallel Sum: " + Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
//                .reduce(0, (acc, element)-> acc + element, (acc, element)-> acc + element)
//            );
//        System.out.println("Parallel Sum " + Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).parallel()
//                .reduce(0, (acc, element)-> acc + element, (acc, element)-> acc + element)
//            );
        System.out.println(Stream.of("a", "b", "c", "d", "e", "f", "g").parallel().reduce("x", 
                (left, right) ->  { 
                    System.out.println("AccFn: " + left + "-" + right + " ===" + Thread.currentThread().getName());
                    return left + "-" + right;
                },
                (left, right) -> { 
                    System.out.println("CombFn: "  + left + "|" + right + " ===" + Thread.currentThread().getName());
                    return left + "|" + right;
                }));
        
//        Arrays.asList("a1", "a2", "b1", "c2", "c1")
//        .parallelStream()
//        .filter(s -> {
//            System.out.format("filter: %s [%s]\n",
//                s, Thread.currentThread().getName());
//            return true;
//        })
//        .map(s -> {
//            System.out.format("map: %s [%s]\n",
//                s, Thread.currentThread().getName());
//            return s.toUpperCase();
//        })
//        .forEach(s -> System.out.format("forEach: %s [%s]\n",
//            s, Thread.currentThread().getName()));
    }

}
