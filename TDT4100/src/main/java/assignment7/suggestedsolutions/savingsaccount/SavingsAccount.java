package assignment7.suggestedsolutions.savingsaccount;

public class SavingsAccount implements Account {

	private final double interest;
	private double balance = 0.0;

	public SavingsAccount(double interest) {
		this.interest = interest;
	}

	public void deposit(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Can only deposit positive monetary amount");
		}

		this.balance += amount;
	}

	public void withdraw(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Can only withdraw positive monetary amount");
		}
		if (balance < amount) {
			throw new IllegalStateException("Insufficient funds for withdrawal");
		}

		this.balance -= amount;
	}

	public double getBalance() {
		return this.balance;
	}

	public void endYearUpdate() {
		this.balance *= 1.0 + this.interest;
	}
}
