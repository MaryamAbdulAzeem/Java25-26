import java.lang.*;
import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        System.out.print("Enter three double numbers: ");
        Scanner input = new Scanner(System.in);
        double num1 = input.nextDouble();
        double num2 = input.nextDouble();
        double num3 = input.nextDouble();

        double rNum1 = Math.round(num1 * 1000.0) / (1000.0); // rounds to the 3 decimal place format
        double rNum2 = Math.round(num2 * 1000.0) / (1000.0);
        double rNum3 = Math.round(num3 * 1000.0) / (1000.0);

        if ((rNum2 == rNum1) && (rNum3 == rNum1)) { // To check if the values of the numbers are the same after rounding.
            System.out.println("All three numbers are the same when rounded to three decimal places.");
        } else {
            System.out.println("The numbers are different when rounded to three decimal places.");
        }

        double ans1;
        double ans2;
        double ans3;

        if (num1 > num2) {
            ans1 = num1 - num2;
        } else {
            ans1 = num2 - num1;
        }

        if (num2 > num3) {
            ans2 = num2 - num3;
        } else {
            ans2 = num3 - num2;
        }

        if (num3 > num1) {
            ans3 = num3 - num1;
        } else {
            ans3 = num1 - num3;
        }

        if (ans1 < 0.001 && ans2 < 0.001 && ans3 < 0.001) {
            System.out.println("The difference between the numbers is less than 0.001.");
        } else {
            System.out.println("The difference between the numbers is greater than 0.001.");
        }
    }
}
