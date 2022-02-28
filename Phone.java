package com.company;

import java.util.ArrayList;

public class Phone {
    private String myNumber;
    private ArrayList<Contact> myContacts;
    // constructor for a new phone object
    public Phone(String myNumber) {
        this.myNumber = myNumber;
    // initializing a new ArrayList each time a phone object is created
        this.myContacts = new ArrayList<Contact>();
    }
    // action methods
    public boolean addNewContact(Contact contact){
        if(findContact(contact.getName())>= 0){
            System.out.println("Contact is already on file");
            return false;
        }
        myContacts.add(contact);
        return true;
    }
    public boolean updateContact(Contact oldContact, Contact newContact){
        int foundPosition = findContact(oldContact);
        if(foundPosition < 0){
            System.out.println(oldContact.getName()+" was not found.");
            return false;
        }
        this.myContacts.set(foundPosition,newContact);
        System.out.println(oldContact.getName()+" was replaced with "+newContact.getName());
        return true;
    }
    public boolean removeContact(Contact contact){
        int foundPosition = findContact(contact);
        if(foundPosition < 0){
            System.out.println(contact.getName()+" was not found.");
            return false;
        }
        this.myContacts.remove(foundPosition);
        System.out.println(contact.getName()+" was deleted.");
        return true;
    }
    // overloaded method to find a contact with either a name or a Contact object
    private int findContact(Contact contact){
        return this.myContacts.indexOf(contact);
    }
    private int findContact(String contactName){
        for(int i = 0; i < this.myContacts.size();i++){
            Contact contact = this.myContacts.get(i);
            if (contact.getName().equals(contactName)){
                return i;
            }
        }
        return -1;
    }
    // query contact by Contact object for future functionality 
    public String queryContact(Contact contact){
        if (findContact(contact)>=0){
            return contact.getName();
        }
        return null;
    }
    public Contact queryContact(String name){
        int position = findContact(name);
        if(position >= 0){
            return myContacts.get(position);
        }
        return null;
    }
    public void printContacts(){
        System.out.println("Contact List");
        for(int i = 0; i < myContacts.size(); i++){
            System.out.println((i+1) +"."+ myContacts.get(i).getName()+" -> "+ myContacts.get(i).getNumber());
        }
    }
}




