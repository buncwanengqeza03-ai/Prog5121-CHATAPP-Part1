/* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * to change this license
 */

package com.mycompany.chatapppart1;

/**
 * The Login class manages the registration details and login
 * processes for the ChatApp application.
 *
 * @author Student
 */
public class Login {

    // Stores the username, password and cellphone number provided during registration.
    private String username;
    private String password;
    private String phoneNumber;

    // Holds the username and password entered when the user attempts to log in.
    private String enteredUsername;
    private String enteredPassword;

    // Keeps the first and last name of the registered user.
    private String firstName;
    private String lastName;

    /*
     * Creates a Login object and assigns the supplied registration
     * details to the corresponding variables.
     */
    public Login(String firstName, String lastName, String username,
                 String password, String phoneNumber) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    /*
     * Updates the password stored for the user.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /*
     * Updates the cellphone number associated with the user.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /*
     * Provides access to the username saved during registration.
     */
    public String getUsername() {
        return username;
    }

    /*
     * Saves the username supplied by the user during login.
     */
    public void setEnteredUsername(String enteredUsername) {
        this.enteredUsername = enteredUsername;
    }

    /*
     * Saves the password supplied by the user during login.
     */
    public void setEnteredPassword(String enteredPassword) {
        this.enteredPassword = enteredPassword;
    }

    /*
     * Validates the username according to the registration requirements.
     * An underscore must be included and the username may contain
     * a maximum of five characters.
     */
    public boolean checkUserName() {

        // Verify both username conditions at the same time.
        return username.contains("_") && username.length() <= 5;
    }

    /*
     * Determines whether the password satisfies the required
     * security conditions.
     *
     * The password must include:
     * - At least eight characters.
     * - One uppercase letter.
     * - One number.
     * - One special character.
     */
    public boolean checkPasswordComplexity() {

        // These variables record whether each required character type is found.
        boolean hasUppercase = false;
        boolean hasNumber = false;
        boolean hasSpecialCharacter = false;

        // Reject passwords that are shorter than the required length.
        if (password.length() < 8) {
            return false;
        }

        // Examine each character to identify the required character types.
        for (int i = 0; i < password.length(); i++) {

            char character = password.charAt(i);

            // Identify an uppercase character.
            if (Character.isUpperCase(character)) {
                hasUppercase = true;
            }

            // Identify a numeric character.
            if (Character.isDigit(character)) {
                hasNumber = true;
            }

            // Identify a character that is neither a letter nor a number.
            if (!Character.isLetterOrDigit(character)) {
                hasSpecialCharacter = true;
            }
        }

        // The password is accepted only when all requirements are satisfied.
        return hasUppercase && hasNumber && hasSpecialCharacter;
    }

    /*
     * Verifies that the cellphone number follows the required
     * South African international format.
     *
     * The number must:
     * - Begin with +27.
     * - Have 12 characters altogether.
     * - Contain digits after the country code.
     */
    public boolean checkCellPhoneNumber() {

        // Confirm that the number has the correct country code and length.
        if (phoneNumber.startsWith("+27")
                && phoneNumber.length() == 12) {

            // Inspect the characters following the +27 country code.
            for (int i = 3; i < phoneNumber.length(); i++) {

                // Reject the number if any remaining character is not a digit.
                if (!Character.isDigit(phoneNumber.charAt(i))) {
                    return false;
                }
            }

            // All cellphone number requirements have been met.
            return true;

        } else {

            // The number failed the initial format checks.
            return false;
        }
    }

    /*
     * Validates the registration information and creates a message
     * showing the result of each individual validation.
     */
    public String registerUser() {

        // Used to combine the results of the registration checks.
        String message = "";

        // Check whether the username meets the required format.
        if (checkUserName()) {
            message += "Username successfully captured.\n";
        } else {
            message += "Username is not correctly formatted; "
                    + "please ensure that your username contains an "
                    + "underscore and is no more than five characters "
                    + "in length.\n";
        }

        // Check whether the password meets the security requirements.
        if (checkPasswordComplexity()) {
            message += "Password successfully captured.\n";
        } else {
            message += "Password is not correctly formatted; "
                    + "please ensure that the password contains at "
                    + "least eight characters, a capital letter, a "
                    + "number, and a special character.\n";
        }

        // Check whether the cellphone number is correctly formatted.
        if (checkCellPhoneNumber()) {
            message += "Cell phone number successfully added.\n";
        } else {
            message += "Cell phone number incorrectly formatted or "
                    + "does not contain international code.\n";
        }

        // Return the combined registration feedback.
        return message;
    }

    /*
     * Compares the login details entered by the user with the
     * username and password saved during registration.
     */
    public boolean loginUser() {

        // Check whether both supplied credentials correspond with the stored details.
        if (enteredUsername.equals(username)
                && enteredPassword.equals(password)) {

            // The username and password are correct.
            return true;

        } else {

            // The supplied credentials do not match the stored details.
            return false;
        }
    }

    /*
     * Provides feedback to the user based on the outcome of the
     * login verification.
     */
    public String returnLoginStatus() {

        // Determine whether the login credentials are valid.
        if (loginUser()) {

            // Display the user's name when authentication is successful.
            return "Welcome " + firstName + " " + lastName
                    + ", it is great to see you again.";

        } else {

            // Inform the user when the login details are incorrect.
            return "Username or password incorrect, please try again.";
        }
    }
}

