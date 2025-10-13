/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ProjectPart1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 *
 * @author RC_Student_Lab
 */
public class ProjectPart1Test {
    
    /*public ProjectPart1Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class ProjectPart1.
     */
   /* @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        ProjectPart1.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
    private Registration registration = new Registration();

    
    @org.testng.annotations.Test
    public void testValidUsername() {
        // Wenzokuhle: Valid username contains underscore and <= 5 characters
        assertTrue(registration.checkUsername("We_nz"));
    }

    @org.testng.annotations.Test
    public void testUsernameWithoutUnderscore() {
        // Wenzokuhle: Invalid username missing underscore
        assertFalse(registration.checkUsername("Wenzokuhle"));
    }

    @org.testng.annotations.Test
    public void testUsernameTooLong() {
        // Wenzokuhle: Invalid username longer than 5 characters
        assertFalse(registration.checkUsername("We_nz123"));
    }

    // -------------------- Password Tests --------------------
    @org.testng.annotations.Test
    public void testValidPassword() {
        // Wenzokuhle: Valid password contains uppercase, digit, special char
        assertTrue(registration.checkPassword("Wenzo@123"));
    }

    @org.testng.annotations.Test
    public void testPasswordTooShort() {
        // Wenzokuhle: Invalid password less than 8 characters
        assertFalse(registration.checkPassword("Wen@12"));
    }

    @org.testng.annotations.Test
    public void testPasswordWithoutDigit() {
        // Wenzokuhle: Invalid password missing digit
        assertFalse(registration.checkPassword("Wenzokuhle@"));
    }

    @org.testng.annotations.Test
    public void testPasswordWithoutUpperCase() {
        // Wenzokuhle: Invalid password missing uppercase letter
        assertFalse(registration.checkPassword("wenzo@123"));
    }

    @org.testng.annotations.Test
    public void testPasswordWithoutSpecialCharacter() {
        // Wenzokuhle: Invalid password missing special character
        assertFalse(registration.checkPassword("Wenzo1234"));
    }

    // -------------------- Cellphone Number Tests --------------------
    @org.testng.annotations.Test
    public void testValidCellphoneNumber() {
        // Wenzokuhle: Valid cellphone number with +27 and 12 digits
        assertTrue(registration.checkCellphoneNumber("+27683753842"));
    }

    @org.testng.annotations.Test
    public void testCellphoneWithoutCountryCode() {
        // Wenzokuhle: Invalid cellphone missing +27
        assertFalse(registration.checkCellphoneNumber("0683753842"));
    }

    @org.testng.annotations.Test
    public void testCellphoneWrongLength() {
        // Wenzokuhle: Invalid cellphone less than 12 digits
        assertFalse(registration.checkCellphoneNumber("+276837538"));
    }

    // Login Tests 
   @Test
public void testValidLogin() {
    // Set registration details
    registration.userInputForTest("Wenzokuhle", "Manganyi", "We_nz", "Wenzo@123", "+27683753842");

    Login login = new Login(registration);  // ✅ fixed class name

    // Wenzokuhle: Valid login
    assertTrue(login.testLogin("We_nz", "Wenzo@123"));  // ✅ method should be defined in Login
}

@Test
public void testInvalidLogin() {
    // Set registration details
    registration.userInputForTest("Wenzokuhle", "Manganyi", "We_nz", "Wenzo@123", "+27683753842");

    Login login = new Login(registration);  // ✅ fixed

    // Wenzokuhle: Invalid login
    assertFalse(login.testLogin("wrongUser", "wrongPass"));  // ✅ fixed method name
}

    
}
