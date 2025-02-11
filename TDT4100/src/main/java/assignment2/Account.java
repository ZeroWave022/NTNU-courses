package assignment2;

public class Account {
    private double balance;
    private double interestRate;

    public Account(double balance, double interestRate) {
        this.validateBalance(balance);
        this.validateInterestRate(interestRate);
        this.balance = balance;
        this.interestRate = interestRate;
    }

    private void validateBalance(double balance) throws IllegalArgumentException {
        if (balance < 0)
            throw new IllegalArgumentException("Sorry, being in debt is not allowed! Balance must be positive.");
    }

    private void validateInterestRate(double interestRate) throws IllegalArgumentException {
        if (interestRate < 0)
            throw new IllegalArgumentException("Sorry, getting scammed by a negative interest rate is not allowed!");
    }

    public void deposit(double amount) throws IllegalArgumentException {
        if (amount < 0)
            throw new IllegalArgumentException("Cannot deposit a negative amount!");
        this.balance += amount;
    }

    public void withdraw(double amount) throws IllegalArgumentException {
        if (amount < 0)
            throw new IllegalArgumentException("Cannot withdraw a negative amount!");
        if (this.balance - amount < 0)
            throw new IllegalArgumentException("Cannot withdraw more than the available balance!");

        this.balance -= amount;
    }

    public void addInterest() {
        this.balance += this.balance * this.interestRate / 100;
    }

    public double getBalance() {
        return balance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.validateInterestRate(interestRate);
        this.interestRate = interestRate;
    }
}
