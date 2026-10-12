import java.util.Scanner;

public class CommonCharacters {
    public static void main(String[] args) {
        System.out.print("Enter the first sentence: ");
        Scanner input = new Scanner(System.in);
        String sent1 = input.nextLine().toLowerCase();

        System.out.print("Enter the second sentence: ");
        String sent2 = input.nextLine().toLowerCase();

        String newSentence = "";
        for (int i = 0; i < sent1.length(); i++) {
            if (sent1.charAt(i) == ' ') {
                newSentence += sent1.charAt(i);
                continue;
            }
            for (int j = 0; j < sent2.length(); j++) {
                if (sent1.charAt(i) == sent2.charAt(j)) {
                    newSentence += sent1.charAt(i);
                    break;
                }
            }
        }
        System.out.println("The new string is: " + newSentence);
    }
}
