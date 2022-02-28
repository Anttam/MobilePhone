package com.company;

import java.util.Scanner;

public class Main {
    // creating a scanner for input and initializing phone
    private static Scanner scanner = new Scanner(System.in);
    private static Phone phone = new Phone("404 404 3322");

    public static void main(String[] args) {
    // boolean to exit program and startup methods
        boolean quit = false;
        startPhone();
        printActions();
    //loop to continue to accept input
        while (!quit) {
            System.out.println("\n Enter action: (6 to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();
    //switch statement to run corresponding method to input
            switch (action) {
                case 0:
                    System.out.println("shutting down...");
                    scanner.close();
                    quit = true;
                    break;
                case 1:
                    phone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
            }
        }
    }
    //Main methods

    //description methods
    private static void startPhone() {
        System.out.println("Starting phone...");
    }

    private static void printActions() {
        System.out.println("\n Available actions: \npress");
        System.out.println("0 - to shutdown\n"
                + "1 - to print contacts\n"
                + "2 - to add a new contact\n"
                + "3 - to update an existing contact\n"
                + "4 - to remove a contact\n"
                + "5 - query if an existing contact exists\n"
                + "6 - to print a list of available actions");
        System.out.println("Choose your action");
    }
    // input methods
    private static Contact contactInput(){
        String name = enterName();
        System.out.println("enter contact number ");
        String number = scanner.nextLine();
        return  Contact.createContact(name, number);
    }

    private static String enterName(){
        System.out.println("enter contact name: ");
        return scanner.nextLine();
    }

    // action methods
    private static void addNewContact() {
        Contact newContact = contactInput();
        if (phone.addNewContact(newContact)) {
            System.out.println("new contact added: Name = " + newContact.getName() + " Number = " + newContact.getNumber());
        } else {
            System.out.println("Cannot add, " + newContact.getName() + " already on file.");
        }
    }
    private static void updateContact() {
        String name = enterName();
        Contact oldContact = phone.queryContact(name);
        if (oldContact == null) {
            System.out.println("contact not found.");
            return;
        }
        Contact newContact = contactInput();
        if (phone.updateContact(oldContact, newContact)) {
            System.out.println("Successfully updated record");
        } else {
            System.out.println("Error updating record");
        }
    }
    private static void removeContact() {
        String name = enterName();
        Contact oldContact = phone.queryContact(name);
        if (oldContact == null) {
            System.out.println("contact not found.");
            return;
        }
        if (phone.removeContact(oldContact)) {
            System.out.println("contact removed");
        } else {
            System.out.println("error removing contact");
        }
    }
    private static void queryContact() {
        String name = enterName();
        Contact oldContact = phone.queryContact(name);
        if (oldContact == null) {
            System.out.println("contact not found.");
            return;
        }
        System.out.println("Name: "+oldContact.getName()+ " Number: "+oldContact.getNumber());
    }

}


