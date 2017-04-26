package com.foo.transformations;

public class Candidate {
    
    private String firstName;
    private String lastName;
    private String address;
    private boolean offerAccepted;
    
    public Candidate(String firstName, String lastName, String address,
            boolean offerAccepted) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.offerAccepted = offerAccepted;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public boolean isOfferAccepted() {
        return offerAccepted;
    }
    
    
}
