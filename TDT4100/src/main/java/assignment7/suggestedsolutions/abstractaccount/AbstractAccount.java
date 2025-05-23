package assignment7.suggestedsolutions.abstractaccount;

public abstract class AbstractAccount {

	protected double balance = 0.0;

	protected abstract void internalWithdraw(double amount);

	public void deposit(double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("Amount must be positive");
		}

		this.balance += amount;
	}

	public void withdraw(double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("Amount cannot be negative");
		}

		this.internalWithdraw(amount);
	}

	public double getBalance() {
		return this.balance;
	}
}
