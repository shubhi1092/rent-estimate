package com.startup.model;

public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
    private String address;
    private RentRange estimatedRent;
    private RentRange expectedRent;

    public User(String firstName, String lastName, String emailAddress, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public RentRange getEstimatedRent() {
        return estimatedRent;
    }

    public void setEstimatedRent(RentRange estimatedRent) {
        this.estimatedRent = estimatedRent;
    }

    public RentRange getExpectedRent() {
        return expectedRent;
    }

    public void setExpectedRent(RentRange expectedRent) {
        this.expectedRent = expectedRent;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }
}
