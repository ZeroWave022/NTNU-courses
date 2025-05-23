package assignment7.solutions.savingsaccount;

public class ForeldreSpar extends SavingsAccount {
    private int maxWithdrawalsPerYear;
    private int withdrawals;

    public ForeldreSpar(double interestRate, int maxWithdrawalsPerYear) {
        super(interestRate);
        this.maxWithdrawalsPerYear = maxWithdrawalsPerYear;
    }

    @Override
    public void withdraw(double amount) {
        this.verifyWithdraw(amount);
        if (withdrawals >= maxWithdrawalsPerYear)
            throw new IllegalStateException(
                    "Cannot withdraw more than " + maxWithdrawalsPerYear + " times per year from this account.");
        this.withdrawals += 1;
        super.withdraw(amount);
    }

    @Override
    public void endYearUpdate() {
        super.endYearUpdate();
        this.withdrawals = 0;
    }

    public int getRemainingWithdrawals() {
        return this.maxWithdrawalsPerYear - this.withdrawals;
    }
}
