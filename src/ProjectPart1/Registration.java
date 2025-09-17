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
public class Registration {
    private String name;
    private String surname;
    private String username;
    private String password;
    private String cellphoneNumber;

    public void userInput(Scanner scan) {
        // Prompt user for name
        System.out.println("Please enter your name:");
        name = scan.nextLine();

        // Prompt user for surname
        System.out.println("Please enter your surname:");
        surname = scan.nextLine();

        // Prompt user for username
        do {
            System.out.println("Please enter your username (must contain '_' and be 5 characters or less):");
            username = scan.nextLine();
        } while (!checkUsername(username));

        // Prompt user for password
        do {
            System.out.println("Please enter your password (min 8 chars, must include uppercase, digit, special char):");
            password = scan.nextLine();
        } while (!checkPassword(password));

        // Prompt user for cellphone number
        do {
            System.out.println("Please enter your cellphone number (format: +27xxxxxxxxx, e.g., +27123456789):");
            cellphoneNumber = scan.nextLine();
        } while (!checkCellphoneNumber(cellphoneNumber));
    }

    public boolean checkUsername(String username) {
        // Username must have an underscore and be 5 characters or less
        if (username != null && username.contains("_") && username.length() <= 5) {
            System.out.println("Username successfully captured");
            return true;
        } else {
            System.out.println("Username is invalid. It must contain an underscore and be 5 characters or less.");
            return false;
        }
    }

    public boolean checkPassword(String password) {
        // Check password requirements
        boolean hasMinLength = password != null && password.length() >= 8;
        boolean hasUppercase = password != null && password.matches(".*[A-Z].*");
        boolean hasDigit = password != null && password.matches(".*\\d.*");
        boolean hasSpecialCharacters = password != null && password.matches(".*[!@#$%^&*()_\\-+].*");

        if (hasMinLength && hasUppercase && hasDigit && hasSpecialCharacters) {
            System.out.println("Password successfully captured");
            return true;
        } else {
            System.out.println("Password does not meet requirements: Must be at least 8 characters, include an uppercase letter, a digit, and a special character.");
            return false;
        }
    }

    public boolean checkCellphoneNumber(String cellphoneNumber) {
        // Check cellphone number: must start with +27 and have 9 digits (total length 12)
        if (cellphoneNumber != null && cellphoneNumber.matches("\\+27\\d{9}")) {
            System.out.println("Cellphone number successfully captured");
            return true;
        } else {
            System.out.println("Cellphone number is invalid. It must start with +27 followed by 9 digits (e.g., +27123456789).");
            return false;
        }
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getCellphoneNumber() {
        return cellphoneNumber;
    }
}

    
   
      