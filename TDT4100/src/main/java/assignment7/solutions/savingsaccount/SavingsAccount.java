package assignment7.solutions.savingsaccount;

public class SavingsAccount implements Account {

    protected double balance;
    protected double interestRate;

    public SavingsAccount(double interestRate) {
        if (this.interestRate < 0)
            throw new IllegalStateException("Interest rate must be positive.");
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(double amount) {
        if (amount < 0)
            throw new IllegalArgumentException("Cannot deposit a negative amount.");
        this.balance += amount;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    protected void verifyWithdraw(double amount) {
        if (amount < 0)
            throw new IllegalArgumentException("Cannot withdraw a negative amount.");
        if (this.balance < amount)
            throw new IllegalStateException("Cannot withdraw more than available balance.");
    }

    @Override
    public void withdraw(double amount) {
        this.verifyWithdraw(amount);
        this.balance -= amount;
    }

    public void endYearUpdate() {
        this.balance += this.balance * this.interestRate;
    }
}
