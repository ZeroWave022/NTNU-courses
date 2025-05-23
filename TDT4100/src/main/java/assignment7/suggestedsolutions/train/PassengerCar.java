package assignment7.suggestedsolutions.train;

public class PassengerCar extends TrainCar {

	private static final int passengerWeight = 80;
	private int passengerCount;

	public PassengerCar(int deadWeight, int passengerCount) {
		super(deadWeight);
		this.setPassengerCount(passengerCount);
	}

	@Override
	protected String getTrainCarType() {
		return "PassengerCar";
	}

	public int getPassengerCount() {
		return this.passengerCount;
	}

	public void setPassengerCount(int passengerCount) {
		if (passengerCount < 0) {
			throw new IllegalArgumentException("Passenger count cannot be negative");
		}

		this.passengerCount = passengerCount;
	}

	@Override
	public int getTotalWeight() {
		return super.getTotalWeight() + this.passengerCount * PassengerCar.passengerWeight;
	}

	@Override
	public String toString() {
		return String.format("%s. It contains %d passengers", super.toString(),
				this.passengerCount);
	}
}
