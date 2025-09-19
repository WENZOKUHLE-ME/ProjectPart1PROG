package ProjectPart1;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class RegistrationLoginTest {

    private Registration registration = new Registration();

    
    @Test
    public void testValidUsername() {
        // Wenzokuhle: Valid username contains underscore and <= 5 characters
        assertTrue(registration.checkUsername("We_nz"));
    }

    @Test
    public void testUsernameWithoutUnderscore() {
        // Wenzokuhle: Invalid username missing underscore
        assertFalse(registration.checkUsername("Wenzokuhle"));
    }

    @Test
    public void testUsernameTooLong() {
        // Wenzokuhle: Invalid username longer than 5 characters
        assertFalse(registration.checkUsername("We_nz123"));
    }

    // -------------------- Password Tests --------------------
    @Test
    public void testValidPassword() {
        // Wenzokuhle: Valid password contains uppercase, digit, special char
        assertTrue(registration.checkPassword("Wenzo@123"));
    }

    @Test
    public void testPasswordTooShort() {
        // Wenzokuhle: Invalid password less than 8 characters
        assertFalse(registration.checkPassword("Wen@12"));
    }

    @Test
    public void testPasswordWithoutDigit() {
        // Wenzokuhle: Invalid password missing digit
        assertFalse(registration.checkPassword("Wenzokuhle@"));
    }

    @Test
    public void testPasswordWithoutUpperCase() {
        // Wenzokuhle: Invalid password missing uppercase letter
        assertFalse(registration.checkPassword("wenzo@123"));
    }

    @Test
    public void testPasswordWithoutSpecialCharacter() {
        // Wenzokuhle: Invalid password missing special character
        assertFalse(registration.checkPassword("Wenzo1234"));
    }

    // -------------------- Cellphone Number Tests --------------------
    @Test
    public void testValidCellphoneNumber() {
        // Wenzokuhle: Valid cellphone number with +27 and 12 digits
        assertTrue(registration.checkCellphoneNumber("+27683753842"));
    }

    @Test
    public void testCellphoneWithoutCountryCode() {
        // Wenzokuhle: Invalid cellphone missing +27
        assertFalse(registration.checkCellphoneNumber("0683753842"));
    }

    @Test
    public void testCellphoneWrongLength() {
        // Wenzokuhle: Invalid cellphone less than 12 digits
        assertFalse(registration.checkCellphoneNumber("+276837538"));
    }

    // Login Tests 
    @Test
    public void testValidLogin() {
        // Set registration details
        registration.userInputForTest("Wenzokuhle", "Manganyi", "We_nz", "Wenzo@123", "+27683753842");

        Login login = new Login(registration);

        // Wenzokuhle: Valid login
        assertTrue(login.testLogin("We_nz", "Wenzo@123"));
    }

    @Test
    public void testInvalidLogin() {
        // Set registration details
        registration.userInputForTest("Wenzokuhle", "Manganyi", "We_nz", "Wenzo@123", "+27683753842");

        Login login = new Login(registration);

        // Wenzokuhle: Invalid login with wrong username/password
        assertFalse(login.testLogin("wrongUser", "wrongPass"));
    }
}
