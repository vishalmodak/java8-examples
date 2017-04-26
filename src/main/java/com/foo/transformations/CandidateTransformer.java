package com.foo.transformations;

import java.util.Random;

import org.apache.commons.collections4.Transformer;

public class CandidateTransformer implements Transformer<Candidate, Employee> {
    
    public CandidateTransformer() { }
    
    @Override
    public Employee transform(Candidate candidate) {
        if (candidate.isOfferAccepted()) {
            long employeeId = new Random().nextLong();
            String username = candidate.getFirstName().toLowerCase().charAt(0) + candidate.getLastName().toLowerCase();
            return new Employee(employeeId, candidate.getFirstName(), candidate.getLastName(), username);
        }
        return null;
    }
}
