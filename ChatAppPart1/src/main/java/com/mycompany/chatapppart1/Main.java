/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java
 * to edit this template
 */

package com.mycompany.chatapppart1;

import java.util.Scanner;

/**
 * The Main class controls the ChatApp registration and login process.
 * It collects information from the user through keyboard input and
 * uses the Login class to validate the supplied details.
 *
 * @author Student
 */
public class Main {

    /*
     * The main method starts the ChatApp application.
     */
    public static void main(String[] args) {

        // Set up Scanner to receive information entered by the user.
        Scanner input = new Scanner(System.in);

        // Show the registration section to the user.
        System.out.println("=====REGISTRATION=====");

        // Request the user's first name.
        System.out.print("Enter your first name: ");
        String firstName = input.nextLine();

        // Continue requesting the first name until a value is provided.
        while (firstName.trim().isEmpty()) {
            System.out.println("First name cannot be empty.");
            System.out.print("Enter your first name: ");
            firstName = input.nextLine();
        }

        // Request the user's surname.
        System.out.print("Enter your last name: ");
        String lastName = input.nextLine();

        // Prevent the registration process from continuing without a surname.
        while (lastName.trim().isEmpty()) {
            System.out.println("Last name cannot be empty.");
            System.out.print("Enter your last name: ");
            lastName = input.nextLine();
        }

        // Request a username from the user.
        System.out.print("Enter your username: ");
        String username = input.nextLine();

        // Make sure a username has been entered before continuing.
        while (username.trim().isEmpty()) {
            System.out.println("Username cannot be empty.");
            System.out.print("Enter your username: ");
            username = input.nextLine();
        }

        /*
         * Create the Login object using the details collected so far.
         * The password and cellphone number are initially left blank
         * because they will be supplied later.
         */
        Login login = new Login(
                firstName,
                lastName,
                username,
                "",
                ""
        );

        // Validate the username before requesting the password.
        if (!login.checkUserName()) {
            System.out.println(
                    "Username is not correctly formatted; please ensure that your username "
                    + "contains an underscore and is no more than five characters in length."
            );
            return;
        }

        // Request the user's password.
        System.out.print("Enter your password: ");
        String password = input.nextLine();

        // Ensure that the password field is not left blank.
        while (password.trim().isEmpty()) {
            System.out.println("Password cannot be empty.");
            System.out.print("Enter your password: ");
            password = input.nextLine();
        }

        // Save the password in the Login object.
        login.setPassword(password);

        // Validate the password before proceeding with the registration.
        if (!login.checkPasswordComplexity()) {
            System.out.println(
                    "Password is not correctly formatted; please ensure that the password "
                    + "contains at least eight characters, a capital letter, a number, "
                    + "and a special character."
            );
            return;
        }

        // Request the user's cellphone number.
        System.out.print("Enter your cellphone number: ");
        String phoneNumber = input.nextLine();

        // Make sure a cellphone number has been entered.
        while (phoneNumber.trim().isEmpty()) {
            System.out.println("Cellphone number cannot be empty.");
            System.out.print("Enter your cellphone number: ");
            phoneNumber = input.nextLine();
        }

        // Add the cellphone number to the Login object.
        login.setPhoneNumber(phoneNumber);

        // Check the cellphone number before allowing the user to continue.
        if (!login.checkCellPhoneNumber()) {
            System.out.println(
                    "Cellphone number is not correctly formatted; please ensure that the "
                    + "cellphone number starts with +27 and is followed by 9 numbers."
            );
            return;
        }

        /*
         * All registration details have passed validation.
         * Display the messages confirming the successful registration.
         */
        System.out.println();
        System.out.println(login.registerUser());

        // Display the login section.
        System.out.println();
        System.out.println("=====LOGIN=====");

        // Request the username used during registration.
        System.out.print("Enter your username: ");
        String enteredUsername = input.nextLine();

        // Ensure that the login username is not left blank.
        while (enteredUsername.trim().isEmpty()) {
            System.out.println("Username cannot be empty.");
            System.out.print("Enter your username: ");
            enteredUsername = input.nextLine();
        }

        // Check that the entered username matches the registered username.
        if (!enteredUsername.equals(login.getUsername())) {
            System.out.println("Username or password incorrect, please try again.");
            return;
        }

        // Request the password for the login attempt.
        System.out.print("Enter your password: ");
        String enteredPassword = input.nextLine();

        // Prevent the login process from continuing with an empty password.
        while (enteredPassword.trim().isEmpty()) {
            System.out.println("Password cannot be empty.");
            System.out.print("Enter your password: ");
            enteredPassword = input.nextLine();
        }

        // Save the login credentials entered by the user.
        login.setEnteredUsername(enteredUsername);
        login.setEnteredPassword(enteredPassword);

        // Display the result of the login verification.
        System.out.println(login.returnLoginStatus());
    }
}

