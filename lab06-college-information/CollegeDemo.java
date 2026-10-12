import java.io.*;
import java.util.*;

public class CollegeDemo {
    public static void main(String[] args) {
        College[] cArray = new College[10];
        int i = 0;
        String name;
        int depts;
        int numStds;
        int numF;
        int numOfColleges;

        try {
            Scanner inFile = new Scanner(new FileReader("colleges.txt"));
            while (inFile.hasNext()) {
                name = inFile.next();
                depts = inFile.nextInt();
                numStds = inFile.nextInt();
                numF = inFile.nextInt();
                College myCollege = new College(name, depts, numStds, numF);
                cArray[i] = myCollege;
                i++;
            }
            inFile.close();
            numOfColleges = i;
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found");
        }

        numOfColleges = cArray[0].getnumCols();
        System.out.println("Colleges' information ");
        for (i = 0; i < numOfColleges; i++)
            System.out.println(cArray[i].toString());

        System.out.printf("The average number of students per college is %7.2f\n",
                findAvg(cArray, numOfColleges));
        System.out.println("The college with the highest number of faculty is " +
                getMax(cArray, numOfColleges));
    }

    // returns the average number of students per college
    public static double findAvg(College[] list, int size) {
        double total = 0;
        for (int i = 0; i < size; i++) {
            total += list[i].getnumStds();
        }
        return (total / size);
    }

    // returns the name of the college with the highest number of faculty
    public static String getMax(College[] list, int size) {
        int maxFaculty = list[0].getnumFaculty();
        String maxName = list[0].getName();
        for (int i = 0; i < size; i++) {
            if (list[i].getnumFaculty() > maxFaculty) {
                maxFaculty = list[i].getnumFaculty();
                maxName = list[i].getName();
            }
        }
        return maxName;
    }
}
