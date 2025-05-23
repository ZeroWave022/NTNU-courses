package assignment7.suggestedsolutions.abstractaccount;

public class CreditAccount extends AbstractAccount {

	private double creditLine;

	public CreditAccount(double creditLine) {
		this.setCreditLine(creditLine);
	}

	@Override
	protected void internalWithdraw(double amount) {
		if (amount >= this.balance + this.creditLine) {
			throw new IllegalArgumentException("Not enough funds");
		}

		this.balance -= amount;
	}

	public double getCreditLine() {
		return this.creditLine;
	}

	public void setCreditLine(double creditLine) {
		if (creditLine < 0) {
			throw new IllegalArgumentException("Credit line cannot be negative");
		}
		if (creditLine < -this.balance) {
			throw new IllegalStateException("New credit line does not cover existing balance");
		}

		this.creditLine = creditLine;
	}
}
