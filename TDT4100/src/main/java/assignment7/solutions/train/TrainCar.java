package assignment7.solutions.train;

/**
 * The class {@code TrainCar} represents a simple and general train car.
 */
public class TrainCar {

    private int deadWeight;

    /**
     * Constructor for a train car.
     * 
     * @param deadWeight the weight of an empty train car
     * @throws IllegalArgumentException if deadWeight is negative
     * 
     * @see TrainCarTest#testDeadWeight()
     */
    public TrainCar(int deadWeight) {
        if (deadWeight < 0)
            throw new IllegalArgumentException("Dead weight of train car cannot be negative.");
        this.deadWeight = deadWeight;
    }

    /**
     * @param deadWeight the weight of an empty train car. In other words, the
     *                   weight of only the
     *                   carriage, without passengers and cargo
     * @throws IllegalArgumentException if deadWeight is negative
     * 
     * @see TrainCarTest#testDeadWeight()
     */
    public void setDeadWeight(int deadWeight) {
        if (deadWeight < 0)
            throw new IllegalArgumentException("Dead weight of train car cannot be negative.");

        this.deadWeight = deadWeight;
    }

    /**
     * @return the weight of an empty train car. In other words, the weight of only
     *         the carriage,
     *         without passengers and cargo
     * 
     * @see TrainCarTest#testDeadWeight()
     */
    public int getDeadWeight() {
        return this.deadWeight;
    }

    /**
     * @return the total weight of the train car. Note that this method should also
     *         be callable on
     *         subclasses and still return the total weight of the train car
     *         (keyword:
     *         redefinition).
     * 
     * @see TrainCarTest#testDeadWeight()
     */
    public int getTotalWeight() {
        return this.deadWeight;
    }

    /**
     * @return a string representation of the train car. The string should contain
     *         the type of the
     *         train car and the total weight of the train car. For
     *         {@link PassengerCar}, the number
     *         of passengers should also be included. For {@link CargoCar}, the
     *         weight of the cargo
     *         should also be included.
     */
    @Override
    public String toString() {
        return String.format("TrainCar | Dead weight: %d", this.deadWeight);
    }
}
