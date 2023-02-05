// This code counts the number of consonants in a given string.

package excercise.basics;

import java.util.Scanner;

public class Consonants {
    public static void main(String[] args) {

        // Scanner to get input from the user
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string");

        // Read the input string
        String str = input.nextLine();

        // Get the length of the string
        int len = str.length();

        // Initialize a counter for consonants
        int count = 0;

        // Loop through each character in the string
        for (int i = 0; i < len; i++){
            // Convert the character to lowercase
            char c =  Character.toLowerCase(str.charAt(i));

            // If the character is not a, e, i, o, u or a space
            if( c != 'a' &&
                    c != 'e' &&
                    c != 'i' &&
                    c != 'o' &&
                    c != 'u' &&
                    c != ' '
            )   {
                // Increment the counter for sentants
                count++;

            }
        }

        // Print the number of consonants
        System.out.println(count);
    }
}