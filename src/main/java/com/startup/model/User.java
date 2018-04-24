package com.startup.model;

public class User {
    private long userId;
    private String ipAddress;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
    private String address;
    private RentRange estimatedRent;
    private RentRange expectedRent;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (userId ^ (userId >>> 32));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append("<!DOCTYPE HTML><html lang=\"en\"><title>Test</title" +
                "<body>" +
                "<table>" +
                "<tr>" +
                "<th>UserID</th>" +
                "<th>IP</th>" +
                "<th>Email Address</th>" +
                "<th>Address</th>" +
                "<th>Estimated Rent</th>" +
                "<th>Expected Rent</th>" +
                "</tr>");
        buf.append("<tr>");
        buf.append("<td>");
        buf.append(userId);
        buf.append("</td>");
        buf.append("<td>");
        buf.append(ipAddress);
        buf.append("</td>");
        buf.append("<td>");
        buf.append(emailAddress);
        buf.append("</td>");
        buf.append("<td>");
        buf.append(address);
        buf.append("</td>");
        buf.append("<td>");
        buf.append(estimatedRent);
        buf.append("</td>");
        buf.append("<td>");
        buf.append(expectedRent);
        buf.append("</td>");
        buf.append("</tr>");
        buf.append("</table>" +
                "</body>" +
                "</html>");
        System.out.println(buf.toString());
        return buf.toString();
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
}
