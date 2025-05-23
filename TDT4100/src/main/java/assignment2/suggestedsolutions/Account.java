package assignment2.suggestedsolutions;

public class Account {

	private double balance;
	private double interestRate;

	public Account(double balance, double interestRate) {
		Account.checkNonNegative(balance, "Balance");
		this.balance = balance;
		this.setInterestRate(interestRate);
	}

	private static void checkNonNegative(double value, String valueName) {
		if (value < 0.0) {
			throw new IllegalArgumentException(valueName + " cannot be negative: " + value);
		}
	}

	public double getInterestRate() {
		return this.interestRate;
	}

	public void setInterestRate(double interestRate) {
		Account.checkNonNegative(interestRate, "Interest rate");
		this.interestRate = interestRate;
	}

	public double getBalance() {
		return this.balance;
	}

	public void deposit(double amount) {
		Account.checkNonNegative(amount, "Amount");
		this.balance += amount;
	}

	public void withdraw(double amount) {
		Account.checkNonNegative(amount, "Amount");
		double newBalance = this.balance - amount;

		if (newBalance < 0) {
			throw new IllegalArgumentException("The balance cannot become negative: " + newBalance);
		}

		this.balance = newBalance;
	}

	public void addInterest() {
		this.deposit(this.balance * this.interestRate / 100.0);
	}

	@Override
	public String toString() {
		return String.format("[Account balance=%f, interestRate=%f]", this.balance,
				this.interestRate);
	}
}
