/**
 * This is a simple program to help in calculating the parking fee
 * @version 1.0
 * @author Maryam Abdul Azeem
 */
package Java_Labs.Lab2;
import java.util.*;
public class Parking {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in); //creating an input stream
boolean continueProgram = true;
while (continueProgram) {
System.out.println("Welcome to the Smart Parking System!");
System.out.println("Choose an option:");
System.out.println("1. Calculate Parking Fee");
System.out.println("2. Exit");
System.out.print("Enter your choice (1 or 2): ");
int option = scanner.nextInt();
switch(option) { //switch statement to create a menu for the user to select the desired operation
case 1:
System.out.print("Enter vehicle type: ");
String vehicle = scanner.next();
System.out.print("Enter number of parking hours: ");
int hours = scanner.nextInt();
if (vehicle.equalsIgnoreCase("Car")) {
if (hours == 1) {
System.out.println("Total Parking Fee: 5 AED");
} else if (hours > 1) {
System.out.println("Total Parking Fee: " + (5 + (hours - 1) * 3) + (" AED"));
} else {
System.out.println("Invalid parking duration!");
}
} else if (vehicle.equalsIgnoreCase("Bike")) {
if (hours == 1) {
System.out.println("Total Parking Fee: 3 AED");
} else if (hours > 1) {
System.out.println("Total Parking Fee: " + (3 + (hours - 1) * 2) + " AED");
} else {
System.out.println("Invalid parking duration!");
}
} else if (vehicle.equalsIgnoreCase("Truck")) {
if (hours == 1) {
System.out.println("Total Parking Fee: 10 AED");
} else if (hours > 1) {
System.out.println("Total Parking Fee: " + (10 + (hours - 1) * 7) + " AED");
} else {
System.out.println("Invalid parking duration!");
}
} else {
System.out.println("Invalid vehicle type!");
break;
}
break;
case 2:
continueProgram = false;
System.out.println("Goodbye!");
break;
}
}
}
}
/*

Test cases:
#4: Bike,5 11 AED Pass
#5: Truck,10 24 AED Pass
#6: Bike, 1 3 AED Pass
#7: Truck, 10 73 AED Pass
#8: Car, -2 Invalid Parking Duration!
 */
