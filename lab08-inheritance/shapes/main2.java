import java.util.Scanner;

public class main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("---Rectangle---");
        System.out.println();
        System.out.print("Enter color: ");
        String myColor = in.nextLine();
        System.out.print("Enter width: ");
        double myWidth = in.nextDouble(); in.nextLine();
        System.out.print("Enter height: ");
        double myHeight = in.nextDouble(); in.nextLine();
        Rectangle myRect = new Rectangle(myColor, myWidth, myHeight);

        System.out.println();
        System.out.println("---Square---");
        System.out.println();
        System.out.print("Enter color: ");
        String myColor2 = in.nextLine();
        System.out.print("Enter side: ");
        double mySide = in.nextDouble();
        Square mySquare = new Square(myColor2, mySide, mySide, mySide);

        System.out.println();
        System.out.println("===All Shapes===");
        System.out.println(myRect);
        System.out.println("Area:" + myRect.getArea());
        System.out.println(mySquare);
        System.out.println("Area:" + mySquare.getArea());
    }
}
