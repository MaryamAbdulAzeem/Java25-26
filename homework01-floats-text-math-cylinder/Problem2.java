import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        System.out.print("Enter a sentence with at least 6 words and ending with '!': ");
        Scanner input = new Scanner(System.in); // creating an input stream
        String text = input.nextLine();

        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                count++;
            }
        }

        if ((count < 5) || (!text.endsWith("!"))) { // checks the validity of the input
            System.out.println("Invalid input. Make sure it has at least 6 words and ends with '!'. ");
            return;
        }

        System.out.print("Enter k (k > 5) to reverse the k-th word: ");
        int k = input.nextInt();

        int kStartIndex = -1; // The occurence of a space indicates the beginning of a new word, so the starting index is initialised to -1 so that if k=1, it will take that as the first word.
        int kEndIndex = -1;
        int wordCount = 1;

        for (int i = 0; i < text.length(); i++) {
            if (wordCount == k && kStartIndex == -1) {
                kStartIndex = i;
            }
            if (wordCount == k && (text.charAt(i) == ' ' || text.charAt(i) == '!')) {
                kEndIndex = i - 1;
                break;
            }
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }

        String reversedText = ""; // loop to reverse the text at the kth word
        for (int i = kEndIndex; i >= kStartIndex; i--) {
            reversedText += text.charAt(i);
        }

        String modifiedText = "";
        for (int i = 0; i < text.length(); i++) {
            if (i == kStartIndex) {
                modifiedText += reversedText;
                i = kEndIndex;
                continue;
            } else if (text.charAt(i) == ' ') { // ignores spaces
                continue;
            } else if (text.charAt(i) == '!') { // replaces ! with $
                modifiedText += "$";
                continue;
            } else {
                modifiedText += text.charAt(i);
            }
        }

        String finalText = "";
        for (int i = 0; i < modifiedText.length(); i++) {
            char letter = modifiedText.charAt(i);
            String temp = "" + letter;
            if (temp.equals(temp.toUpperCase())) {
                finalText += temp.toLowerCase();
            } else if (temp.equals(temp.toLowerCase())) {
                finalText += temp.toUpperCase();
            } else {
                finalText += temp;
            }
        }

        System.out.println("Modified message: " + finalText);
        System.out.println();

        System.out.println("=== Part B: Math Calculations ===");
        System.out.println();

        int choice;
        do {
            System.out.print("Choose an operation:\n1.Addition (+)\n2.Subtraction (-)\n3.Multiplication (*)\n4.Division (/)\n5.Absolute value (abs)\n6.Power (^)\n7.Rounding (round to decimals)\n0.Exit\n");
            choice = input.nextInt();

            if (choice == 0) {
                System.out.print("Program exited.");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter first number: ");
                    int number1 = input.nextInt();
                    System.out.print("Enter second number: ");
                    int number2 = input.nextInt();
                    float result = number1 + number2;
                    System.out.printf("Result = %.1f\n", result);
                    break;
                case 2:
                    System.out.print("Enter first number: ");
                    int subnumber1 = input.nextInt();
                    System.out.print("Enter second number: ");
                    int subnumber2 = input.nextInt();
                    float subresult = subnumber1 - subnumber2;
                    System.out.printf("Result = %.1f\n", subresult);
                    break;
                case 3:
                    System.out.print("Enter first number: ");
                    int mulnumber1 = input.nextInt();
                    System.out.print("Enter second number: ");
                    int mulnumber2 = input.nextInt();
                    float mulresult = mulnumber1 * mulnumber2;
                    System.out.printf("Result = %.1f\n", mulresult);
                    break;
                case 4:
                    System.out.print("Enter first number: ");
                    float divnumber1 = input.nextFloat();
                    System.out.print("Enter second number: ");
                    float divnumber2 = input.nextFloat();
                    float divresult = divnumber1 / divnumber2;
                    System.out.printf("Result = %.1f\n", divresult);
                    break;
                case 5:
                    System.out.print("Enter the number: ");
                    int absNum = input.nextInt();
                    System.out.printf("Result = %.1f\n", (float) Math.abs(absNum));
                    break;
                case 6:
                    System.out.print("Enter the number: ");
                    int pownumber = input.nextInt();
                    System.out.print("Enter the power to which you want to raise the number: ");
                    int power = input.nextInt();
                    double presult = Math.pow(pownumber, power);
                    System.out.printf("Result = %.1f\n", presult);
                    break;
                case 7:
                    System.out.print("Enter the number you want to round: ");
                    double rnum = input.nextDouble();
                    System.out.print("Enter the number of decimal places to round to: ");
                    int dec = input.nextInt();
                    double rounded_result = Math.round(rnum * Math.pow(10, dec)) / Math.pow(10, dec);
                    System.out.printf("Result = %." + dec + "f\n", rounded_result);
                    break;
            }

            System.out.print("Do you want to do another calculation? (y/n): ");
            char answer = input.next().toLowerCase().charAt(0);
            if (answer == 'n') {
                System.out.println("Program ended.");
                break;
            }
        } while (choice != 0);
    }
}
