package assignment7.suggestedsolutions.abstractaccount;

/**
 * A bank consists of many different types of accounts: credit accounts, debit
 * accounts, savings
 * accounts, etc. Since these have a lot in common, e.g. all have a balance, it
 * is practical to
 * collect as much of the common logic as possible in a superclass, which all
 * can inherit from.
 * However, this superclass is not a type of account in itself, and therefore we
 * make it
 * {@code abstract}, so that it cannot be instantiated. The concrete account
 * classes that inherit
 * from it, must of course be instantiable. The methods defined in the
 * {@code AbstractAccount} class
 * is similar to that of the Account interface in the SavingsAccount task.
 */
public abstract class AbstractAccountDocs {

    // AbstractAccount has a state {@code balance} for the account balance. The
    // balance should
    // either be set to 0.0 by default or in the constructor

    // TODO: Add fields and potentially a constructor here

    /**
     * Decreases the account balance by the specified amount. Note that the rules
     * for withdrawals
     * are different for the classes that implement {@code AbstractAccount}, and
     * must therefore be
     * implemented in each class.
     * 
     * @param amount the amount to withdraw
     * @throws IllegalArgumentException if the amount cannot be withdrawn
     */
    // TODO: Define abstract method {@code void internalWithdraw} here

    /**
     * Increases the account balance by the specified amount.
     * 
     * @param amount the amount to deposit
     * @throws IllegalArgumentException if the amount is not positive
     */
    public void deposit(double amount) {
        // TODO: Implement this method
    }

    /**
     * This method calls the {@link #internalWithdraw()} method, which is
     * implemented in each
     * subclass.
     * 
     * @param amount the amount to withdraw
     * @throws IllegalArgumentException if the amount is not positive
     */
    public void withdraw(double amount) {
        // TODO: Implement this method
    }

    /**
     * @return the current balance of the account
     */
    public double getBalance() {
        // TODO: Implement this method
        return 0.0;
    }
}
