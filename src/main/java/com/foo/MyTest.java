package com.foo;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MyTest {

    public static void main(String[] args) {
//        String x = "Vishal";
//        String y = "Modak";
//        int i =1;
//        int j = 2;
//        BinaryOperator<Integer> add = (x,y) -> x + y;
//        System.out.println(add.apply(i, j));

        List<String> names = Arrays.asList("VIshal", "Max", "Alex");
//        Iterator<String> itr = names.iterator();
//        while (itr.hasNext()) {
//            System.out.println(itr.next());
//        }
        
//        names.forEach(System.out::println);
        
//        List<Character> list = Stream.of('a', 'b', 'c', '1', '2', 'd')
//                .filter(Character::isDigit)
//                .map(Character::toUpperCase));
//        System.out.println(list);
        
        List<Stream<Integer>> together = Stream.of(asList(1,2), asList(3,4))
                .peek(number -> System.out.println(number))
                .map(numbers -> numbers.stream())
                .collect(toList());
        System.out.println(together);


    }
    

}
