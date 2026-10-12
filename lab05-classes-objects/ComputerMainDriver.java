import java.util.Scanner;

public class ComputerMainDriver {
    public static void main(String[] args) {
        Computer computer1 = new Computer("ali", 4020.50, 2.4, 13, 128);
        Computer computer2 = new Computer();
        Computer computer3 = new Computer("Omar", 10000.25, 4.6, 5, 256);

        System.out.println(computer1.toString());
        System.out.println(computer2.toString());
        System.out.println(computer3.toString());

        System.out.println("Enter Computer 2 information (name price speed age memory size): ");
        Scanner input = new Scanner(System.in);
        String c2_name = input.next();
        double c2_cost = input.nextDouble();
        double c2_cpuSpeed = input.nextDouble();
        int c2_age = input.nextInt();
        int c2_memorySize = input.nextInt();

        computer2.setAll(c2_name, c2_cost, c2_cpuSpeed, c2_age, c2_memorySize);
        System.out.println(computer2.toString());
        System.out.println("The age of Omar's computer in seconds is " + computer3.ageInSeconds());
    }
}
