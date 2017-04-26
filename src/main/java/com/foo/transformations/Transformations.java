package com.foo.transformations;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.apache.commons.collections4.Transformer;

public class Transformations {

    public static void main(String[] args) {
        Candidate[] candidates = {
                new Candidate("George", "Washington", "Chicago", true),
                new Candidate("Serena", "Williams", "Miami", true),
                new Candidate("Usain", "Bolt", "Jamaica", false),
        };
        List<Employee> employees = new ArrayList<>();
        for (Candidate candidate : candidates) {
            if (candidate.isOfferAccepted()) {
                long employeeId = new Random().nextLong();
                String username = candidate.getFirstName().toLowerCase().charAt(0) + candidate.getLastName().toLowerCase();
                Employee e = new Employee(employeeId, candidate.getFirstName(), candidate.getLastName(), username);
                employees.add(e);
            }
        }
        System.out.println(employees.toString());
        
        List<Candidate> candidatesList = asList(candidates);
        employees = candidatesList.stream()
                            .filter(candidate -> candidate.isOfferAccepted())
                            .map(candidate -> 
                                    new Employee(new Random().nextLong(), candidate.getFirstName(), candidate.getLastName(), 
                                            candidate.getFirstName().toLowerCase().charAt(0) + candidate.getLastName().toLowerCase())
                            )
                            .collect(Collectors.toList());
        System.out.println(employees.toString());
        Transformer<Candidate, Employee> transformer = new CandidateTransformer();
//        CollectionUtils.transform(candidatesList, transformer);
        
        employees = candidatesList.stream()
                                        .filter(candidate -> candidate.isOfferAccepted())
                                        .map(candidate -> new CandidateTransformer().transform(candidate))
                                        .collect(Collectors.toList());
        System.out.println(employees.toString());
    }

}
