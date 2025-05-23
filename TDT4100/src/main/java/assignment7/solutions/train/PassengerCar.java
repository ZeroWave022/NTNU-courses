package assignment7.solutions.train;

/**
 * One of two different types of train cars, both specialized versions for
 * different purposes. A
 * {@code PassengerCar} represents a passenger car that transports passengers.
 * 
 * @see TrainCar
 * @see CargoCar
 */
public class PassengerCar extends TrainCar {

    private int passengerCount;

    /**
     * Constructor for the passenger car.
     * 
     * @param deadWeight     the weight of an empty passenger car
     * @param passengerCount the number of passengers in the passenger car
     * @throws IllegalArgumentException if either deadWeight or passengerCount is
     *                                  negative
     * 
     * @see PassengerCarTest#testWeight()
     */
    public PassengerCar(int deadWeight, int passengerCount) {
        super(deadWeight);
        this.passengerCount = passengerCount;
    }

    /**
     * @return the number of passengers in the passenger car
     * 
     * @see PassengerCarTest#testWeight()
     */
    public int getPassengerCount() {
        return this.passengerCount;
    }

    /**
     * @param passengerCount the number of passengers in the passenger car
     * @throws IllegalArgumentException if passengerCount is negative
     * 
     * @see PassengerCarTest#testWeight()
     */
    public void setPassengerCount(int passengerCount) {
        if (passengerCount < 0)
            throw new IllegalArgumentException("Passenger count cannot be negative.");
        this.passengerCount = passengerCount;
    }

    @Override
    public int getTotalWeight() {
        // To calculate the total weight of the passenger car, you can assume that an
        // average passenger weighs 80 kg
        return this.getDeadWeight() + this.passengerCount * 80;
    }

    @Override
    public String toString() {
        return String.format("PassengerCar | Dead weight: %d | Passengers: %d | Total weight: %d",
                this.getDeadWeight(), this.passengerCount, this.getTotalWeight());
    }
}
