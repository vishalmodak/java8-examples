package com.foo;

import java.util.function.Predicate;

@FunctionalInterface
interface MyFunction<T> {
    T spit(T t);
}

class LambdaClosure {
    private Integer a=2;
    MyFunction<Integer> p;
    
    public LambdaClosure() {
        p = x -> { System.out.println(a); return a; };
        p.spit(1);
    }
    
}

class LambdaClosure2 {
    private Integer a=3;
    MyFunction<Integer> p;
    
    public LambdaClosure2() {
        p = x -> { System.out.println(a); return a; };
        p.spit(6);
    }
    
    public void runSpit(MyFunction<Integer> p1) {
        p1.spit(5);
    }
}

public class LambdaClosures {
    
    public static void main(String[] args) {
        LambdaClosure lc = new LambdaClosure();
        LambdaClosure2 lc2 = new LambdaClosure2();
        lc2.runSpit(lc.p);
        
        
//        Predicate<Integer> equals = x -> x==0;
//        System.out.println(equals.test(1));
    }

}
