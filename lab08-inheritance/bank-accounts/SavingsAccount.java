public class SavingsAccount extends BankAccount {
    double profitRate = 1.0;

    public SavingsAccount(String ownerName, double balance, double profitRate) {
        super(ownerName, balance);
        if (profitRate > 0) {
            this.profitRate = profitRate;
        }
    }

    public void applyProfit() {
        balance = balance + ((balance * profitRate) / 100);
    }

    @Override
    public String toString() {
        return String.format("Savings[%s, $%.2f, rate=%.2f%%]", getOwnerName(), getBalance(), profitRate);
    }
}
