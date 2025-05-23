package assignment7.suggestedsolutions.savingsaccount;

public class BSU extends SavingsAccount {

	private final double depositLimit;
	private double availableBalance = 0.0;

	public BSU(double interest, double depositLimit) {
		super(interest);

		if (depositLimit < 0) {
			throw new IllegalArgumentException("Deposit limit cannot be negative.");
		}

		this.depositLimit = depositLimit;
	}

	public void deposit(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Can only deposit positive monetary amount");
		}
		if (this.availableBalance + amount > this.depositLimit) {
			throw new IllegalStateException(
					"Cannot deposit more than the limit of " + this.depositLimit + " per year");
		}

		super.deposit(amount);
		this.availableBalance += amount;
	}

	public void withdraw(double amount) {
		if (amount > this.availableBalance) {
			throw new IllegalStateException("Insufficient available funds for withdrawal");
		}

		super.withdraw(amount);
		this.availableBalance -= amount;
	}

	public void endYearUpdate() {
		super.endYearUpdate();
		this.availableBalance = 0.0;
	}

	public double getTaxDeduction() {
		return this.availableBalance * 0.2;
	}
}
