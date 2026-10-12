/**
 * Lab 3 - Exercise 2: Pentagon Area Calculator
 * Calculates the total area of a number of regular pentagons
 * from their side lengths, rounded to two decimal places.
 * @version 1.0
 * @author Maryam Abdul Azeem
 */
import java.util.Scanner;

public class PentagonArea {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of pentagons: ");
        int num = input.nextInt();

        double length;
        double area;
        double totalArea = 0;

        for (int i = 0; i < num; i++) {
            System.out.print("Enter the side length of pentagon " + (i + 1) + ": ");
            length = input.nextDouble();

            // Area = (1/4) * sqrt(5 * (5 + 2 * sqrt(5))) * a^2
            area = 0.25 * Math.sqrt(5 * (5 + 2 * Math.sqrt(5))) * Math.pow(length, 2);
            totalArea += area;
        }

        System.out.printf("The total area of the pentagons is: %.2f%n", totalArea);
        input.close();
    }
}
