package com.foo.overloaded;

public class OverloadResolution {

    public static void main(String[] args) {
        Printer printer = new Printer();

        printer.print(text -> "Joe");

        printer.add((x,y) -> x + y);
        
        printer.test((IntPredicate) (x -> true)); //target type of the lambda expression is explicity IntPredicate
        
        printer.print(new HelloFunction() {

            @Override
            public String apply(String t) {
                return t;
            }
            
        });
        
//        BinaryOperator<Long> add = (x, y) -> x + y; 
//        add.apply(1,2);
//        BinaryOperator<Long> addExplicit = (Long x, Long y) -> x + y; 
//        addExplicit.apply(1,2);
    }

}
