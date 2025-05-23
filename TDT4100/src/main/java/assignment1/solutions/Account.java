package assignment1.solutions;

public class Account {
    public double balance;
    public double interestRate;

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
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
        this.interestRate = interestRate;
    }
}
