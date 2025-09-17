/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ProjectPart1;
import java.util.Scanner;
/**
 *
 * @author RC_Student_lab
 */
public class ProjectPart1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
    
     
        // Create Scanner for user input
        Scanner scan = new Scanner(System.in);

        // Display a welcoming message
        System.out.println("****************************************");
        System.out.println("Welcome to the Awesome Login System!");
        System.out.println("We're thrilled to have you here! Let's get started.");
        System.out.println("****************************************");

        try {
            // Step 1: User Registration
            System.out.println("\nFirst, let's register your account.");
            Registration register = new Registration();
            register.userInput(scan); // Collect user details

            // Step 2: User Login
            System.out.println("\nGreat job, " + register.getName() + "! Now, let's log you in.");
            Login login = new Login(register);
            boolean isLoggedIn = login.log();

            // Step 3: Provide feedback based on login result
            if (isLoggedIn) {
                System.out.println("\nYou're successfully logged in! Enjoy your day, " + register.getName() + "!");
            } else {
                System.out.println("\nSorry, login didn't work out this time. Please try again later!");
            }

        } catch (Exception e) {
            System.out.println("\nOops! Something went wrong: " + e.getMessage());
            System.out.println("Please try restarting the application.");
        } finally {
            scan.close(); // Close Scanner to prevent resource leak
        }

        // Closing message
        System.out.println("\nThank you for using our system! You're awesome! 😊");
    }
}
    
    

