import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // -- BankAccount section --
        System.out.print("Enter account owner name: ");
        String name1 = in.nextLine();
        System.out.print("Enter initial balance: ");
        double bal1 = in.nextDouble(); in.nextLine();

        BankAccount acc = new BankAccount(name1, bal1);

        System.out.println("\nAccount created: " + acc);
        System.out.print("Enter deposit amount: ");
        acc.deposit(in.nextDouble()); in.nextLine();
        System.out.println("After deposit: " + acc);

        // -- SavingsAccount section --=
        System.out.println();
        System.out.println("---Savings Account---");
        System.out.println();
        System.out.print("Enter owner name: ");
        String name2 = in.nextLine();
        System.out.print("Enter initial balance: ");
        double bal2 = in.nextDouble(); in.nextLine();
        System.out.print("Enter profit rate (%): ");
        double pRate = in.nextDouble();

        SavingsAccount sAcc = new SavingsAccount(name2, bal2, pRate);
        sAcc.applyProfit();
        System.out.println("After applying profit: " + sAcc);
    }
}
