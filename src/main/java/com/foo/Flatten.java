package com.foo;

import static java.util.Arrays.asList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.foo.transformations.Hotel;
import com.foo.transformations.Review;

public class Flatten {

    public static void main(String[] args) {
        List<Integer> together = Stream.of(asList(1,2), asList(3,4))
                                        .peek(number -> System.out.println(number))
                                        .flatMap(numbers -> numbers.stream())
                                        .collect(toList());
        System.out.println(together);
        
        List<String> chunks = Stream.of("This is - a test", "This is not - a test")
                                    .peek(line -> System.out.println(line))
                                    .flatMap(line -> Stream.of(line.split("-")))
                                    .collect(toList());
        System.out.println(chunks);
        System.out.println("flatmap()...");
        List<String> words = Stream.of("This | is - a test", "This is | not - a test")
                .peek(line -> System.out.println(line))
                .flatMap(line ->  Stream.of(line.split("-")).flatMap(subline -> Stream.of(subline.split(" "))).collect(toList()).stream())
                .collect(toList());
        System.out.println(words);
        
        List<Review> reviews1 = Arrays.asList( 
            new Review("awesome!!", 5.0d), 
            new Review("good!!", 4.5d), 
            new Review("ok", 3.0d), 
            new Review("crap", 2.0d), 
            new Review("crappy", 2.4d), 
            new Review("crappier", 2.7d), 
            new Review("ecstatic!!", 4.2d), 
            new Review("ok may be", 3.5d), 
            new Review("horrible", 1.0d)
        );
        
        List<Review> reviews2 = Arrays.asList( 
                new Review("awesome sauce!!", 5.0d), 
                new Review("awesome!!", 4.5d), 
                new Review("ok", 3.0d), 
                new Review("ok-ier", 3.2d), 
                new Review("crappier", 2.7d), 
                new Review("ecstatic!!", 4.2d), 
                new Review("ok may be", 3.5d), 
                new Review("horrible", 1.0d),
                new Review("disgusting", 0.5d)
            );
        
        Hotel[] hotels = {
                new Hotel(1, "Grand Park", "Tokyo", reviews1),
                new Hotel(2, "Hyatt Regency", "Chicago", reviews2),
        };
        
        Map<Double, Long> results = Stream.of(hotels)
                                          .flatMap(hotel -> ((Hotel) hotel).getReviewsList().stream())
                                          .collect(Collectors.groupingBy(review -> Double.valueOf(Math.round(review.getRating())), Collectors.counting()));
        
        results.entrySet()
               .stream()
               .sorted(Map.Entry.comparingByKey())
               .forEach(entry -> System.out.println(entry.getKey() + "=" + entry.getValue()));
        
        System.out.println(Stream.of(9, 8, 1, 2, 5, 3, 4, 5, 6, 7).sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
        
    }
    
}
