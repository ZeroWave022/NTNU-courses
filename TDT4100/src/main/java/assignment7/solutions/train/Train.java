package assignment7.solutions.train;

import java.util.ArrayList;
import java.util.List;

/**
 * The class {@code Train} represents a train that consists of one or more train
 * cars.
 * 
 * @see TrainCar
 * @see CargoCar
 * @see PassengerCar
 */
public class Train {

    private List<TrainCar> cars = new ArrayList<>();

    /**
     * @param trainCar the train car to check for
     * @return {@code true} if the train contains the train car, {@code false}
     *         otherwise
     * 
     * @see TrainTest#testAddCarToTrain()
     */
    public boolean contains(TrainCar trainCar) {
        return this.cars.contains(trainCar);
    }

    /**
     * Adds a train car to the train.
     * 
     * @param trainCar the train car to add
     * @throws IllegalArgumentException if the train car is {@code null}
     * 
     * @see TrainTest#testAddCarToTrain()
     */
    public void addTrainCar(TrainCar trainCar) {
        if (trainCar == null)
            throw new IllegalArgumentException("Train car cannot be null");
        if (!this.cars.contains(trainCar))
            this.cars.add(trainCar);
    }

    /**
     * @return the sum of the total weight of all the train cars in the train. There
     *         is no need to
     *         take the weight of the locomotive into account
     * 
     * @see TrainTest#testTotalTrainWeight()
     */
    public int getTotalWeight() {
        return this.cars.stream().mapToInt(c -> c.getTotalWeight()).sum();
    }

    /**
     * @return similar to {@link PassengerCar#getPassengerCount()}, but for the
     *         entire train
     * 
     * @see TrainTest#testPassengerCount()
     */
    public int getPassengerCount() {
        return this.cars.stream().filter(c -> c instanceof PassengerCar)
                .mapToInt(c -> ((PassengerCar) c).getPassengerCount()).sum();
    }

    /**
     * @return similar to {@link CargoCar#getCargoWeight()}, but for the entire
     *         train
     * 
     * @see TrainTest#testCargoWeight()
     */
    public int getCargoWeight() {
        return this.cars.stream().filter(c -> c instanceof CargoCar)
                .mapToInt(c -> ((CargoCar) c).getCargoWeight()).sum();
    }

    /**
     * @return a string representation of the train. The string should consist of
     *         the
     *         {@link #toString()}s of all train cars in the train
     */
    @Override
    public String toString() {
        return "CargoCar | Total cars: " + this.cars.size()
                + "\nConsists of:\n"
                + String.join("\n", this.cars.stream().map(c -> c.toString()).toList());
    }

    public static void main(String[] args) {
        Train train = new Train();
        train.addTrainCar(new TrainCar(1250));
        System.out.println(train);
    }
}
