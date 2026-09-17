/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java
 * to edit this template
 */

package com.mycompany.chatapppart1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The LoginTest class contains JUnit 5 test cases for the Login class.
 * These tests check whether the registration and login methods
 * produce the expected results for valid and invalid information.
 *
 * @author Student
 */
public class LoginTest {

    /**
     * Tests the checkUserName() method with a valid username.
     * The username contains an underscore and is within the required length.
     */
    @Test
    public void testValidUserName() {

        // Create a Login object with valid registration details.
        Login login = new Login(
                "Kyle",
                "Ngqeza",
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976"
        );

        // Check that the valid username is accepted.
        assertTrue(login.checkUserName());
    }

    /**
     * Tests the checkPasswordComplexity() method with a valid password.
     * The password includes an uppercase letter, a number and special characters.
     */
    @Test
    public void testValidPasswordComplexity() {

        // Create a Login object containing a valid password.
        Login login = new Login(
                "Kyle",
                "Ngqeza",
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976"
        );

        // Verify that the password satisfies the complexity requirements.
        assertTrue(login.checkPasswordComplexity());
    }

    /**
     * Tests the checkCellPhoneNumber() method with a valid cellphone number.
     * The number uses the required South African international format.
     */
    @Test
    public void testValidCellPhoneNumber() {

        // Create a Login object with a valid cellphone number.
        Login login = new Login(
                "Kyle",
                "Ngqeza",
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976"
        );

        // Confirm that the cellphone number is accepted.
        assertTrue(login.checkCellPhoneNumber());
    }

    /**
     * Tests the registerUser() method using valid registration details.
     * The method should return the expected success messages.
     */
    @Test
    public void testRegisterUser() {

        // Create a Login object with valid registration information.
        Login login = new Login(
                "Kyle",
                "Ngqeza",
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976"
        );

        // Store the result returned by the registration method.
        String result = login.registerUser();

        // Compare the returned result with the expected messages.
        assertEquals(
                """
                Username successfully captured.
                Password successfully captured.
                Cell phone number successfully added.
                """,
                result
        );
    }

    /**
     * Tests the loginUser() method using the correct login credentials.
     * The method should confirm that the user has logged in successfully.
     */
    @Test
    public void testLoginUser() {

        // Create a Login object with registered user information.
        Login login = new Login(
                "Kyle",
                "Ngqeza",
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976"
        );

        // Enter the username used for the login attempt.
        login.setEnteredUsername("kyl_1");

        // Enter the password used for the login attempt.
        login.setEnteredPassword("Ch&&sec@ke99!");

        // Confirm that the login attempt is successful.
        assertTrue(login.loginUser());
    }

    /**
     * Tests the returnLoginStatus() method after a successful login.
     * The method should return the appropriate welcome message.
     */
    @Test
    public void testReturnLoginStatus() {

        // Create a Login object using valid user information.
        Login login = new Login(
                "Kyle",
                "Ngqeza",
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976"
        );

        // Set the correct username and password for the login attempt.
        login.setEnteredUsername("kyl_1");
        login.setEnteredPassword("Ch&&sec@ke99!");

        // Check that the correct welcome message is returned.
        assertEquals(
                "Welcome Kyle Ngqeza, it is great to see you again.",
                login.returnLoginStatus()
        );
    }

    /**
     * Tests the checkUserName() method with an invalid username.
     * The username does not contain the required underscore.
     */
    @Test
    public void testInvalidUserName() {

        // Create a Login object containing an invalid username.
        Login login = new Login(
                "Kyle",
                "Ngqeza",
                "kyle!!!!!!!",
                "Ch&&sec@ke99!",
                "+27838968976"
        );

        // Confirm that the invalid username is rejected.
        assertFalse(login.checkUserName());
    }

    /**
     * Tests the checkPasswordComplexity() method with an invalid password.
     * The password does not meet the required complexity rules.
     */
    @Test
    public void testInvalidPasswordComplexity() {

        // Create a Login object containing an invalid password.
        Login login = new Login(
                "Kyle",
                "Ngqeza",
                "kyl_1",
                "password",
                "+27838968976"
        );

        // Confirm that the invalid password is rejected.
        assertFalse(login.checkPasswordComplexity());
    }

    /**
     * Tests the checkCellPhoneNumber() method with an invalid number.
     * The cellphone number does not follow the required format.
     */
    @Test
    public void testInvalidPhoneNumber() {

        // Create a Login object containing an invalid cellphone number.
        Login login = new Login(
                "Kyle",
                "Ngqeza",
                "kyl_1",
                "Ch&&sec@ke99!",
                "08966553"
        );

        // Confirm that the invalid cellphone number is rejected.
        assertFalse(login.checkCellPhoneNumber());
    }
}

