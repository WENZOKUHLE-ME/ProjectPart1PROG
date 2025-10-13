package ProjectPart1;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.swing.JOptionPane;
import java.util.Scanner;

/**
 *
 * @author RC_Student_lab
 */
public class Login {

    private Registration register;

    public Login(Registration register) {
        if (register == null) {
            throw new IllegalArgumentException("Registration object cannot be null");
        }
        this.register = register;
    }

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

    public boolean checkUserDetails(String username, String password) {
        if (username == null || password == null) {
            System.out.println("Invalid input: Username or password is null.");
            return false;
        }

        // Compare with Registration getters
        if (username.equals(register.getUsername()) && password.equals(register.getPassword())) {
            System.out.println("Welcome, " + register.getName() + "!");
            return true;
        } else {
            System.out.println("Login failed: Incorrect username or password.");
            return false;
        }
    }
// method to enable unit testing

    public boolean testLogin(String username, String password) {
        return checkUserDetails(username, password);
    }

    //the quick chat logic
    public class QuickChat {

        public void startChat() {
            JOptionPane.showMessageDialog(null, "Welcome to QuickChat.");

            int totalMessages = 0;
            String numMessagesStr = JOptionPane.showInputDialog("How many messages would you like to send? ");
            int numMessages = Integer.parseInt(numMessagesStr);

            boolean running = true;
            Message lastMessage = null;

            while (running) {
                String choiceStr = JOptionPane.showInputDialog(
                        "\nPlease select an option:\n"
                        + "1) Send Message\n"
                        + "2) Show Last Sent Message\n"
                        + "3) Quit"
                );

                int choice = Integer.parseInt(choiceStr);

                switch (choice) {
                    case 1:
                        if (totalMessages < numMessages) {
                            Message message = new Message();
                            message.createMessageWithDialog(); //  new method using GUI
                            lastMessage = message;
                            totalMessages++;
                        } else {
                            JOptionPane.showMessageDialog(null, "You’ve reached your message limit.");
                        }
                        break;

                    case 2:
                        if (lastMessage != null) {
                            JOptionPane.showMessageDialog(null, "Last Sent Message:\n" + lastMessage.getMessageContent());
                        } else {
                            JOptionPane.showMessageDialog(null, "No messages sent yet.");
                        }
                        break;

                    case 3:
                        JOptionPane.showMessageDialog(null, "Exiting QuickChat. Goodbye!");
                        running = false;
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
                }
            }

        }
        // Convert the 'createMessage()' method from the Message class into a method inside QuickChat

        public String createMessage() {
            // Prompt the user for input using JOptionPane and return the message
            return JOptionPane.showInputDialog("Enter your message:");

        }
    }
    // Allows test classes to login without Scanner
    /* public boolean testLogin(String username, String password) {
        return checkUserDetails(username, password);
    }*/
}
