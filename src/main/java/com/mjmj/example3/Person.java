package com.mjmj.example3;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Person {

    private Long personId;
    private String fullName;
    private String firstName;
    private String lastName;

    @Override
    public String toString() {
        return "Person{" +
                "personID=" + personId +
                ", fullName='" + fullName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
