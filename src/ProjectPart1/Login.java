package ProjectPart1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Scanner;
/**
 *
 * @author RC_Student_lab
 */
public class Login {
    private Registration register;

    // Constructor
    public Login(Registration register) {
        if (register == null) {
            throw new IllegalArgumentException("Registration object cannot be null");
        }
        this.register = register;
    }

    // Method to handle login process
    public boolean log() {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Enter Username:");
            String loginUsername = scan.nextLine().trim();

            System.out.println("Enter Password:");
            String loginPassword = scan.nextLine().trim();

            // Validate input
            if (loginUsername.isEmpty() || loginPassword.isEmpty()) {
                System.out.println("Username or password cannot be empty.");
                return false;
            }

            // Check credentials
            return checkUserDetails(loginUsername, loginPassword);
        } finally {
            scan.close(); // Close Scanner to prevent resource leak
        }
    }

    // Method to verify username and password
    public boolean checkUserDetails(String username, String password) {
        if (username == null || password == null) {
            System.out.println("Invalid input: Username or password is null.");
            return false;
        }

        // Assuming Registration has getter methods instead of public fields
        if (username.equals(register.getUsername()) && password.equals(register.getPassword())) {
            System.out.println("Welcome, " + register.getName() + "!");
            return true;
        } else {
            System.out.println("Login failed: Incorrect username or password.");
            return false;
        }
    }
}


