package assignment7.suggestedsolutions.savingsaccount;

public class ForeldreSpar extends SavingsAccount {

	private final int withdrawLimit;
	private int withdrawCount = 0;

	public ForeldreSpar(double interest, int withdrawLimit) {
		super(interest);
		this.withdrawLimit = withdrawLimit;
	}

	public void withdraw(double amount) {
		if (this.withdrawCount >= this.withdrawLimit) {
			throw new IllegalStateException(
					"Cannot withdraw more than the permitted number of times, " + this.withdrawLimit
							+ ", per year.");
		}

		super.withdraw(amount);
		this.withdrawCount++;
	}

	public void endYearUpdate() {
		super.endYearUpdate();
		this.withdrawCount = 0;
	}

	public int getRemainingWithdrawals() {
		return this.withdrawLimit - this.withdrawCount;
	}
}
