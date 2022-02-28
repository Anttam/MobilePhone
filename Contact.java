package com.company;


// simple class to store contact info
public class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String number) {
        this.name = name;
        this.phoneNumber = number;
    }

    public static Contact createContact(String name, String number){
        return new Contact(name,number);
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return phoneNumber;
    }
}