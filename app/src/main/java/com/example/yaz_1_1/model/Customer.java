package com.example.yaz_1_1.model;

public class Customer {
    int CustomerID;
    String FirstName;
    String LastName;
    String Address;

    public Customer(int customerID, String firstName, String lastName, String address) {
        CustomerID = customerID;
        FirstName = firstName;
        LastName = lastName;
        Address = address;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
