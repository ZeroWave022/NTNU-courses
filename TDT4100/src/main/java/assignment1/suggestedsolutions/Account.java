package assignment1.suggestedsolutions;

public class Account {

	double balance = 0.0;
	double interestRate = 0.0;

	double getBalance() {
		return this.balance;
	}

	double getInterestRate() {
		return this.interestRate;
	}

	void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	void deposit(double amount) {
		if (amount > 0) {
			this.balance += amount;
		}
	}

	void addInterest() {
		this.deposit(this.balance * this.interestRate / 100.0);
	}

	@Override
	public String toString() {
		return String.format("[Account balance=%f, interestRate=%f]", this.balance,
				this.interestRate);
	}
}
