package com.foo;

import java.util.function.BinaryOperator;

public class CheckTest {

    public static void main(String[] args) {

        StringChecker<String> check1 = str -> str != null;
        StringChecker<String> check2 = str -> str.length() > 0;
        StringChecker<String> check3 = str -> Character.isUpperCase(str.charAt(0));


        String message = "Take easy!";
        if (isValid(message, check1, check2, check3)) {
            System.out.println(message + " is valid");
        } else {
            System.out.println(message + " is not valid");
        }

    }

    public static boolean isValid(String message, StringChecker<String>... checkers) {

        for (StringChecker<String> checker : checkers) {
            if (!checker.test(message)) {
                return false;
            }
        }
        return true;
    }

    interface IntegerMath {
        int operation(int a, int b);
    }

    public int operateBinary(int a, int b, IntegerMath op) {
        return op.operation(a, b);
    }

    interface Arithmetic<Integer> {
        boolean test(Integer t);
    }

    public boolean check(int a, Arithmetic check) {
        return check.test(a);
    }
    
    @FunctionalInterface
    interface StringChecker<String> {
        boolean test(String t);
    }

}
