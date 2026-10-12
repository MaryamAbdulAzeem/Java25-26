import java.util.Scanner;

public class LetterCounter {
    public static void main(String[] args) {
        System.out.print("Enter your sentence: ");
        Scanner input = new Scanner(System.in);
        String sent = input.nextLine().toLowerCase();

        System.out.print("Enter a letter: ");
        String temp = input.nextLine().toLowerCase();
        char letter = temp.charAt(0);

        int count = 0;
        for (int i = 0; i < sent.length(); i++) {
            if (sent.charAt(i) == letter) {
                count++;
            }
        }
        System.out.println("The letter " + letter + " appeared: " + count);

        if (count == 0) {
            System.out.println("The letter " + letter + " did not appear");
        }
    }
}
