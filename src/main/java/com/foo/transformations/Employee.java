package com.foo.transformations;

public class Employee {
    
    private long employeeId;
    private String firstName;
    private String lastName;
    private String username;
    
    public Employee(long employeeId, String firstName, String lastName,
            String username) {
        super();
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
    }

    @Override
    public String toString() {
        return "Employee [employeeId=" + employeeId + ", firstName=" + firstName
                + ", lastName=" + lastName + ", username=" + username + "]";
    }

    
}
