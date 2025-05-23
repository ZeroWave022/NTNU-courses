package assignment7.suggestedsolutions.abstractaccount;

public class DebitAccount extends AbstractAccount {

	@Override
	protected void internalWithdraw(double amount) {
		if (amount > this.balance) {
			throw new IllegalArgumentException("Not enough funds");
		}

		this.balance -= amount;
	}
}
