package com.foo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperations {
    public static void main(String[] args) {
        String[] letters = { "a", "b", "c" };
        List<String> capitalLetters = new ArrayList<>();
        for (String letter : letters) {
            capitalLetters.add(letter.toUpperCase());
        }
        System.out.println(capitalLetters);
        
        System.out.println(Stream.of("a", "b", "c")
                                 .map(String::toUpperCase)
                                 .collect(Collectors.toList()));
        
        Character[] characters = { 'a', 'b', 'c', '1', '2', 'd'};
        List<Character> onlyLetters = new ArrayList<>();
        for (Character ch : characters) {
            if (!Character.isDigit(ch)) {
                onlyLetters.add(Character.toUpperCase(ch));
            }
        }
        System.out.println(Stream.of('a', 'b', 'c', '1', '2', 'd')
                .filter(Character::isDigit)
                .map(Character::toUpperCase)
                .collect(Collectors.toList()));
    }
}
