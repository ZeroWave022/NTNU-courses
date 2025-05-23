package assignment7.suggestedsolutions.train;

public class CargoCar extends TrainCar {

	private int cargoWeight;

	public CargoCar(int deadWeight, int cargoWeight) {
		super(deadWeight);
		this.setCargoWeight(cargoWeight);
	}

	@Override
	protected String getTrainCarType() {
		return "CargoCar";
	}

	public int getCargoWeight() {
		return this.cargoWeight;
	}

	public void setCargoWeight(int cargoWeight) {
		if (cargoWeight < 0) {
			throw new IllegalArgumentException("Cargo weight cannot be negative");
		}

		this.cargoWeight = cargoWeight;
	}

	@Override
	public int getTotalWeight() {
		return super.getTotalWeight() + this.cargoWeight;
	}

	@Override
	public String toString() {
		return String.format("%s. Its cargo weighs %d kg", super.toString(), this.cargoWeight);
	}
}
