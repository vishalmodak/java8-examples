package com.foo.defaultmethods;

public class DefaultTest {

    public static void main(String[] args) {
        Pen pen = new Pen("Hero");
        pen.name();
        
        Bag bag = new Bag("Coach");
        bag.name();
        
        MacBook mbp = new MacBook("Apple");
        mbp.name();
        
        Suitcase s = new Suitcase("Tourister");
        System.out.println(s.getName());
        s.name();
        
    }

}
