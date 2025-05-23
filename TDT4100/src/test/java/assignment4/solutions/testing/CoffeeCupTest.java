package assignment4.solutions.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CoffeeCupTest {
    @Test
    @DisplayName("Test whether the constructor handles parameters correctly.")
    public void testConstructor() {
        CoffeeCup cup = new CoffeeCup();
        assertEquals(0, cup.getCapacity(), "A cup must by default start with 0 capacity.");
        assertEquals(0, cup.getCurrentVolume(), "A cup must by default start with 0 starting volume");
        new CoffeeCup(5, 5);

        assertThrows(IllegalArgumentException.class, () -> {
            new CoffeeCup(-5, 1);
        }, "A cup cannot be created with negative capacity.");

        assertThrows(IllegalArgumentException.class, () -> {
            new CoffeeCup(1, -5);
        }, "A cup cannot be created with negative starting volume.");
    }

    @Test
    @DisplayName("Test increasing/decreasing current volume and cup capacity.")
    public void testCapacityAndVolume() {
        CoffeeCup cup = new CoffeeCup(100, 50);
        assertEquals(100, cup.getCapacity());
        assertEquals(50, cup.getCurrentVolume());

        cup.drinkCoffee(25);
        assertEquals(100, cup.getCapacity(), "Capacity must remain unchanged after drinking coffee.");
        assertEquals(25, cup.getCurrentVolume(), "Current volume was not reduced correctly.");

        assertThrows(IllegalArgumentException.class, () -> {
            cup.drinkCoffee(30);
        }, "We cannot drink more coffee than we have in the cup!");

        assertThrows(IllegalArgumentException.class, () -> {
            cup.fillCoffee(150);
        }, "We cannot overfill the cup!");

        cup.fillCoffee(50);
        assertEquals(75, cup.getCurrentVolume(), "Current volume wasn't increased correctly.");

        cup.increaseCupSize(100);
        assertEquals(200, cup.getCapacity(), "Cup size wasn't increased correctly.");
    }
}
