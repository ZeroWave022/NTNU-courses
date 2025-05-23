package assignment7.solutions.abstractaccount;

/**
 * A {@code SavingsAccount} can only have a positive balance. In addition, the
 * account has
 * withdrawal restrictions. A {@code SavingsAccount} has {@code x} number of
 * {@code withdrawals}. If
 * you want to withdraw money after all withdrawals have been used up, the
 * balance should be charged
 * a {@code fee}. If the balance is too low to cover the fee, an
 * {@code IllegalArgumentException}
 * should be thrown.
 * 
 * @see AbstractAccount
 */
public class SavingsAccount extends AbstractAccount {

    private int withdrawals;
    private int withdrawalsUsed;
    private double fee;

    /**
     * Initializes a new {@code SavingsAccount} with the specified number of
     * withdrawals and fee.
     * 
     * @param withdrawals the number of withdrawals
     * @param fee         the fee
     * @throws IllegalArgumentException if the number of withdrawals or the fee is
     *                                  negative
     */
    public SavingsAccount(int withdrawals, double fee) {
        this.withdrawals = withdrawals;
        this.fee = fee;
    }

    @Override
    public void withdraw(double amount) {
        if (withdrawalsUsed >= withdrawals) {
            amount += fee;
        }
        if (amount > this.balance)
            throw new IllegalArgumentException("Cannot withdraw more than balance (possibly including fee)");
        this.withdrawalsUsed++;
        super.withdraw(amount);
    }
}
