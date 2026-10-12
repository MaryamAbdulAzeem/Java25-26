/**
 * Lab 3 - Exercise 1: Access Code Verifier
 * Gives the user three attempts to enter the correct access code
 * before locking the system.
 * @version 1.0
 * @author Maryam Abdul Azeem
 */
import java.util.Scanner;

public class AccessCodeVerifier {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int counter = 0; // number of incorrect attempts

        do {
            System.out.print("Enter access code: ");
            int code = input.nextInt();

            if (code == 2023) {
                System.out.println("Access granted.");
                break;
            } else {
                System.out.println("Incorrect code! Please try again.");
                counter++;

                if (counter == 3) {
                    System.out.println("Access denied! System locked. Please contact security.");
                    break;
                }
            }
        } while (counter > 0);

        input.close();
    }
}
