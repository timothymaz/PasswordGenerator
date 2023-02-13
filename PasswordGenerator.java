import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

// Class declaration for PasswordGenerator
public class PasswordGenerator {

    // Constants for the different character sets that can be included in the password
    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*_=+-/";

    // Method to generate a password with the specified length and character sets
    public static String generatePassword(int passwordLength, boolean includeSymbols, boolean includeNumbers, boolean includeCharacters) {
        // StringBuilder to store the set of characters to be used in the password
        StringBuilder allCharacters = new StringBuilder();
        // If the user wants to include characters, add the lowercase and uppercase letters
        if (includeCharacters) {
            allCharacters.append(LOWERCASE_LETTERS).append(UPPERCASE_LETTERS);
        }
        // If the user wants to include numbers, add the numbers
        if (includeNumbers) {
            allCharacters.append(NUMBERS);
        }
        // If the user wants to include symbols, add the symbols
        if (includeSymbols) {
            allCharacters.append(SYMBOLS);
        }

        // SecureRandom to generate random numbers
        Random random = new SecureRandom();
        // StringBuilder to store the generated password
        StringBuilder password = new StringBuilder(passwordLength);

        // Loop to generate the password
        for (int i = 0; i < passwordLength; i++) {
            // Generate a random index into the set of characters
            int randomIndex = random.nextInt(allCharacters.length());
            // Append the character at that index to the password
            password.append(allCharacters.charAt(randomIndex));
        }

        // Return the generated password
        return password.toString();
    }

    // Main method to prompt the user for input and generate the password
    public static void main(String[] args) {
        // Scanner to read input from the user
        Scanner scanner = new Scanner(System.in);
        // Variables to store the user's input
        int passwordLength = 0;
        boolean includeSymbols = false;
        boolean includeNumbers = false;
        boolean includeCharacters = false;

        // Prompt the user for the password length
        System.out.print("Enter password length: ");
        // Read the password length from the user
        if (scanner.hasNextInt()) {
            passwordLength = scanner.nextInt();
        } else {
            // If the input is not an integer, use a default length of 16
            System.out.println("Invalid password length. Using default length of 16.");
            passwordLength = 16;
        }

        // Prompt the user whether they want to include symbols
        System.out.print("Include symbols (y/n)? ");
        // Read the user's response
         if (scanner.hasNext()) {
            includeSymbols = scanner.next().equals("y");
        } else {
            // If the input is not a valid string, print a message and don't include symbols
            System.out.println("Invalid input. Not including symbols.");
        }
        // Prompt the user whether they want to include numbers
        System.out.print("Include numbers (y/n)? ");
        // Read the user's response
         if (scanner.hasNext()) {
           includeNumbers = scanner.next().equals("y");
        } else {
          // If the input is not a valid string, print a message and don't include numbers
           System.out.println("Invalid input. Not including numbers.");
        }

        // Prompt the user whether they want to include characters
        System.out.print("Include characters (y/n)? ");
        // Read the user's response
        if (scanner.hasNext()) {
            includeCharacters = scanner.next().equals("y");
        } else {
             // If the input is not a valid string, print a message and don't include characters
          System.out.println("Invalid input. Not including characters.");
        }

        // create a custom password using the user's inputs
        System.out.println("Generated password: " + generatePassword(passwordLength, includeSymbols, includeNumbers, includeCharacters));
        // Close the scanner to release resources so there is no memory leak
        scanner.close();
    }
}