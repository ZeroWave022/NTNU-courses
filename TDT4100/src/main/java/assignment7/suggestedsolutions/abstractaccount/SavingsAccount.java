package assignment7.suggestedsolutions.abstractaccount;

public class SavingsAccount extends AbstractAccount {

	private final double fee;
	private int withdrawals;

	public SavingsAccount(int withdrawals, double fee) {
		if (withdrawals < 0) {
			throw new IllegalArgumentException("Withdrawals cannot be negative");
		}
		if (fee < 0.0) {
			throw new IllegalArgumentException("Fee cannot be negative");
		}

		this.withdrawals = withdrawals;
		this.fee = fee;
	}

	@Override
	protected void internalWithdraw(double amount) {
		if (this.withdrawals <= 0) {
			amount += this.fee;
		}

		if (amount > this.balance) {
			throw new IllegalArgumentException("Not enough funds");
		}

		this.withdrawals--;
		this.balance -= amount;
	}
}
