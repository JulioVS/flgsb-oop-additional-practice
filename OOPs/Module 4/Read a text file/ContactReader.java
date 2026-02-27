// ContactReader.java
// This program reads contact information from a file and displays it in a formatted way

// Step 1: Import necessary packages for file I/O operations
// Hint: You'll need classes from java.io or java.nio.file packages
// You'll also need Scanner for user input
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class ContactReader {
    public static void main(String[] args) {

        // Step 2: Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Step 3: Prompt the user to enter the file name containing contacts
        // Example: "Enter the name of the contacts file:"
        System.out.println("Enter the name of the contacts file: ");
        String fileName = scanner.nextLine();

        // Step 4: Read the file name entered by the user
        System.out.println();
        int count = 0;

        try {
            // Step 5: Create a FileReader or similar object to read the file
            // Hint: You can use FileReader, BufferedReader, or Files class
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            // Step 6: Read the file line by line
            // Hint: Use a loop to process each line
            String line = reader.readLine();

            while (line != null) {

                count++;

                // Step 7: Parse each line to extract name and phone number
                // Hint: Use String methods like split() to separate by colon
                String[] items = line.split(":");

                // Step 8: Display the contact information in a formatted way
                // Example: "Contact: John Doe | Phone: +1-555-123-4567"
                System.out.println("Contact: " + items[0]
                        + " | Phone: " + items[1]);

                line = reader.readLine();

            }

            // Step 9: Close the file reader when done
            reader.close();

        } catch (Exception e) {
            // Step 10: Handle exceptions appropriately
            // Display a user-friendly error message
            System.err.println(e.getMessage());
        }

        scanner.close();

        // Optional Bonus:
        // Step 11: Add a feature to count and display the total number of contacts read
        System.out.println("\nTotal Count: " + count + " Contacts\n");

    }
}
