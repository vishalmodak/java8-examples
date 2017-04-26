package com.foo.builder;


public class TestBuilder {
    public static void main(String[] args) {
        //step builder
        Person person = Person.person().firstName("vishal").lastName("modak").weight(180);
        System.out.println(person.toString());
//        
        Person2 person2 = Person2.build(p -> p.setFirstName("vishal"), p -> p.setLastName("modak"));
        person2.setFirstName("Max");
        System.out.println(person2.toString());
        
//        Person p = Person.newBuilder().setFirstName("Vishal").done();
//        System.out.println(p.toString());
        
        Person p = Person.person2().apply("Modak").apply("Vishal").apply(150);
        System.out.println(p.toString());
        
        System.out.println(MyModel.build(mm -> mm.setEntry("firstName", "Vishal"),
                      mm -> mm.setEntry("lastName", "Modak")));
    }
}
