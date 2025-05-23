package assignment7.suggestedsolutions.train;

import java.util.ArrayList;
import java.util.Collection;

public class Train {

	private final Collection<TrainCar> trainCars = new ArrayList<>();

	public boolean contains(TrainCar trainCar) {
		return this.trainCars.contains(trainCar);
	}

	public void addTrainCar(TrainCar trainCar) {
		if (trainCar == null) {
			throw new IllegalArgumentException("Train car cannot be null");
		}

		this.trainCars.add(trainCar);
	}

	public int getTotalWeight() {
		return this.trainCars.parallelStream().mapToInt(TrainCar::getTotalWeight).sum();
	}

	public int getPassengerCount() {
		// The call to map could be avoided as in getCargoWeight below
		return this.trainCars.parallelStream().filter(trainCar -> trainCar instanceof PassengerCar)
				.map(trainCar -> (PassengerCar) trainCar).mapToInt(PassengerCar::getPassengerCount)
				.sum();
	}

	public int getCargoWeight() {
		return this.trainCars.parallelStream().filter(trainCar -> trainCar instanceof CargoCar)
				.mapToInt(trainCar -> ((CargoCar) trainCar).getCargoWeight()).sum();
	}

	@Override
	public String toString() {
		String output = "";

		for (TrainCar car : this.trainCars) {
			output += car.toString() + "\n";
		}

		return output;
	}

	public static void main(String[] args) {
		Train train = new Train();

		train.addTrainCar(new PassengerCar(1500, 75));
		train.addTrainCar(new CargoCar(2000, 5000));

		System.out.println(train);
	}
}
