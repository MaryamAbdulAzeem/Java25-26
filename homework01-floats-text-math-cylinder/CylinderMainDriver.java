import java.util.Scanner;

public class CylinderMainDriver {
    public static void main(String[] args) {
        System.out.print("Enter radius: ");
        Scanner input = new Scanner(System.in);
        double r = input.nextDouble();

        System.out.print("Enter height: ");
        double h = input.nextDouble();

        Cylinder myCylinder = new Cylinder(r, h); // Creating an object that will call the constructor

        System.out.print("Enter new radius: ");
        double newR = input.nextDouble();
        myCylinder.setRadius(newR); // updates the value of the radius

        System.out.println("Cylinder Details");
        System.out.println(myCylinder.toString()); // Displays the details of the cylinder
        System.out.printf("Surface Area = %.2f\n", myCylinder.findSA());
        System.out.printf("Volume = %.2f\n", myCylinder.findVol());

        input.close();
    }
}
