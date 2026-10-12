public class BankAccount {
    double balance = 0.0;
    String ownerName;

    public BankAccount(String ownerName, double balance) { // 2-parameter constructor
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public BankAccount() { // default constructor
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance > 0) {
            this.balance = balance;
        } else {
            balance = 0.0;
        }
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        }
    }

    @Override
    public String toString() {
        return String.format("Account[%s, $%.2f]", ownerName, balance);
    }
}
