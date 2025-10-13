/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjectPart1;

import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Message {
     private static int messageCounter = 0;
    private static int totalSentMessages = 0;
     private static int messageLimit;

    private long messageID;
    private String recipient;
    private String messageText;
    private String messageHash;
    private String sendOption;
    
    
    public void setMessageLimit() {
        // Prompt the user to set a message limit at the start
        String limitStr = JOptionPane.showInputDialog("Enter how many messages you want to send:");
        try {
            messageLimit = Integer.parseInt(limitStr);
            if (messageLimit <= 0) {
                JOptionPane.showMessageDialog(null, "Please enter a valid positive number.");
                setMessageLimit(); // Recursive call if invalid
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid number.");
            setMessageLimit(); // Recursive call if invalid
        }
    }
    
    public void createMessageWithDialog() {
      
        
    messageID = generateMessageID();

    recipient = JOptionPane.showInputDialog("Enter recipient number (with + and max 10 digits):");

    if (!checkRecipientCell(recipient)) {
        return;
    }

    messageText = JOptionPane.showInputDialog("Enter your message (max 250 characters):");

    if (messageText.length() > 250) {
        JOptionPane.showMessageDialog(null, "Please enter a message of less than 250 characters.");
        return;
    } else {
        JOptionPane.showMessageDialog(null, "Message ready to send.");
    }

    messageCounter++;
    messageHash = createMessageHash();
    
    JOptionPane.showMessageDialog(null, "Message ID: " + messageID + "\nMessage Hash: " + messageHash);

    String[] options = {"Send Message", "Disregard Message", "Store Message"};
    int option = JOptionPane.showOptionDialog(null,
            "Choose an option:",
            "Send Options",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            options,
            options[0]);

    switch (option) {
        case 0:
            sendOption = "Sent";
            totalSentMessages++;
            JOptionPane.showMessageDialog(null, printMessageDetails());
            break;
        case 1:
            sendOption = "Discarded";
            JOptionPane.showMessageDialog(null, "Message discarded.");
            break;
        case 2:
            sendOption = "Stored";
            storeMessage();
            JOptionPane.showMessageDialog(null, "Message successfully stored.");
            break;
        default:
            JOptionPane.showMessageDialog(null, "Invalid option.");
    }
}


    public boolean checkRecipientCell(String number) {
        if (number.startsWith("+27") && number.length() <= 12) {
            System.out.println("Cell phone number successfully captured.");
            return true;
        } else {
            System.out.println("Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.");
            return false;
        }
    }

    public boolean checkMessageID() {
        return String.valueOf(messageID).length() <= 10;
    }

    public String createMessageHash() {
        String[] words = messageText.split(" ");
        String firstWord = words[0];
        String lastWord = words[words.length - 1];
        return (String.valueOf(messageID).substring(0, 2) + ":" + messageCounter + ":" + firstWord + lastWord).toUpperCase();
    }

    public String printMessageDetails() {
        return "Message ID: " + messageID + "\n"
                + "Message Hash: " + messageHash + "\n"
                + "Recipient: " + recipient + "\n"
                + "Message: " + messageText;
    }

    public static int getTotalSentMessages() {
        return totalSentMessages;
    }

    private long generateMessageID() {
        Random rand = new Random();
        return (long) (Math.random() * 9000000000L) + 1000000000L;
    }

    public void storeMessage() {
        JSONObject messageData = new JSONObject();
        messageData.put("MessageID", messageID);
        messageData.put("Recipient", recipient);
        messageData.put("Message", messageText);
        messageData.put("MessageHash", messageHash);

        JSONArray messageList = new JSONArray();
        messageList.add(messageData);

        try (FileWriter file = new FileWriter("messages.json", true)) {
            file.write(messageList.toJSONString());
        } catch (Exception e) {
            System.out.println("Error saving message: " + e.getMessage());
        }
    }
    
    private String messageContent;

    public void createMessage() {
        this.messageContent = JOptionPane.showInputDialog("Enter your message:");
    }

    public String getMessageContent() {
        return messageContent;
    }
}

