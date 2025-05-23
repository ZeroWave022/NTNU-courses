package assignment7.savingsaccount;

public class BSU extends SavingsAccount {
    private double maxDepositPerYear;
    private double depositThisYear;

    public BSU(double interestRate, double maxDepositPerYear) {
        super(interestRate);
        this.maxDepositPerYear = maxDepositPerYear;
    }

    @Override
    public void deposit(double amount) {
        if (amount + this.depositThisYear > maxDepositPerYear)
            throw new IllegalStateException("Cannot deposit more than yearly max.");
        this.depositThisYear += amount;
        super.deposit(amount);
    }

    @Override
    public void withdraw(double amount) {
        if (this.depositThisYear - amount < 0)
            throw new IllegalStateException("Cannot withdraw more than yearly deposit.");
        this.depositThisYear -= amount;
        super.withdraw(amount);
    }

    @Override
    public void endYearUpdate() {
        this.depositThisYear = 0;
        super.endYearUpdate();
    }

    public double getTaxDeduction() {
        return this.depositThisYear * 0.2;
    }
}
