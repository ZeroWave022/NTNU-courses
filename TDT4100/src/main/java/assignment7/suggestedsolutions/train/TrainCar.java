package assignment7.suggestedsolutions.train;

public class TrainCar {

	private int deadWeight;

	public TrainCar(int deadWeight) {
		this.setDeadWeight(deadWeight);
	}

	protected String getTrainCarType() {
		return "TrainCar";
	}

	public void setDeadWeight(int deadWeight) {
		if (deadWeight < 0) {
			throw new IllegalArgumentException("Dead weight cannot be negative");
		}

		this.deadWeight = deadWeight;
	}

	public int getDeadWeight() {
		return this.deadWeight;
	}

	public int getTotalWeight() {
		return this.deadWeight;
	}

	@Override
	public String toString() {
		return String.format("This is a %s, and it weighs %d kg", this.getTrainCarType(),
				this.getTotalWeight());
	}
}
