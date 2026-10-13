import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;

public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        IPAddress[] ipList = new IPAddress[100]; // creates an array of 100 slots to hold IPAddress objects
        int count = 0;

        System.out.print("Enter an IP Address (-1 to stop): ");
        String myIP = input.next();

        while ((!myIP.equals("-1")) && (count < ipList.length)) { // executes while the input from the user is not -1 and the array has not reached its maximum size (100)
            IPAddress newAddress = new IPAddress(myIP);
            boolean found = false;

            for (int i = 0; i < count; i++) {
                if (ipList[i].equals(newAddress)) { // Checks if the new address entered already exists in the array.
                    found = true;
                    System.out.println("IP address exists. Enter a different one. ");
                    break;
                }
            }

            if (!found) {
                ipList[count] = newAddress;
                count++;
            }

            System.out.print("Enter an IP Address (-1 to stop): ");
            myIP = input.next();
        }

        int option;
        do {
            System.out.print("Select an option:\n1.Search IP \n2.Count IPs starting with a value \n3.Print all IPs \n4.Delete an IP \n5.Print all IPs to a file \n6.Exit \n");
            option = input.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter IP to search: ");
                    String searchIP = input.next();
                    IPAddress target = new IPAddress(searchIP);
                    boolean found = false;

                    for (int i = 0; i < count; i++) {
                        if (ipList[i].equals(target)) {
                            found = true;
                            break;
                        }
                    }

                    if (found) {
                        System.out.println("IP found!");
                    } else {
                        System.out.println("IP not found.");
                    }
                    break;

                case 2:
                    int startVal;
                    int startCount = 0;

                    do {
                        System.out.print("Enter starting value (first part): ");
                        startVal = input.nextInt();
                        if (startVal < 0 || startVal > 255) {
                            System.out.println("Invalid input! Please enter a number between 0 and 255");
                        }
                    } while (startVal < 0 || startVal > 255);

                    for (int i = 0; i < count; i++) {
                        if (Integer.parseInt(ipList[i].getPart1()) == startVal) {
                            startCount++;
                        }
                    }
                    System.out.println("Number of IPs starting with " + startVal + ": " + startCount);
                    break;

                case 3:
                    System.out.println("All IP addresses:");
                    for (int i = 0; i < count; i++) {
                        ipList[i].PrintIP();
                    }
                    break;

                case 4:
                    System.out.println("Enter IP to delete: ");
                    String deleteIP = input.next();
                    IPAddress deleteTarget = new IPAddress(deleteIP);
                    boolean found2 = false;
                    int deleteIndex = -1;

                    for (int i = 0; i < count; i++) {
                        if (ipList[i].equals(deleteTarget)) {
                            found2 = true;
                            deleteIndex = i;
                            break;
                        }
                    }

                    if (found2) {
                        for (int i = deleteIndex; i < count - 1; i++) {
                            ipList[i] = ipList[i + 1];
                        }
                        ipList[count - 1] = null;
                        count--;
                        System.out.println("IP deleted successfully.");
                    } else {
                        System.out.println("IP not found.");
                    }
                    break;

                case 5:
                    System.out.println("Enter the name of the output file: ");
                    String fileName = input.next();

                    try {
                        FileWriter fw = new FileWriter(fileName + ".txt");
                        String fileContent = "";
                        for (int i = 0; i < count; i++) {
                            fileContent += ipList[i].getPart1() + "."
                                    + ipList[i].getPart2() + "."
                                    + ipList[i].getPart3() + "."
                                    + ipList[i].getPart4();
                            fileContent += "\n";
                        }
                        fw.write(fileContent);
                        fw.close();
                        System.out.println("IP address written to the file successfully.");
                    } catch (IOException e) {
                        System.out.println("Error: File Writing");
                    }
                    break;

                case 6:
                    System.out.println("Program exited.");
                    break;
            }
        } while (option != 6);

        System.out.println("Total IP addresses created: " + IPAddress.getTotal());
    }
}
