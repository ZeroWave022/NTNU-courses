package assignment2.solutions;

import java.util.List;

public class Vehicle {
    private char type;
    private char fuelType;
    private String registrationNumber;

    public Vehicle(char type, char fuelType, String registrationNumber) {
        this.validateType(type);
        this.type = type;
        this.validateFuelType(fuelType);
        this.fuelType = fuelType;
        this.validateRegistrationNumber(registrationNumber);
        this.registrationNumber = registrationNumber;
    }

    public boolean validateType(char type) {
        return this.validateType(type, true);
    }

    public boolean validateType(char type, boolean throwException) {
        if (!List.of('M', 'C').contains(type)) {
            if (throwException)
                throw new IllegalArgumentException(
                        "Vehicle type invalid: Must be either 'C' for car or 'M' for motorcycle.");
            return false;
        }
        return true;
    }

    public boolean validateFuelType(char fuelType) {
        return this.validateFuelType(fuelType, true);
    }

    public boolean validateFuelType(char fuelType, boolean throwException) {
        if (!List.of('H', 'E', 'D', 'G').contains(fuelType)) {
            if (throwException)
                throw new IllegalArgumentException(
                        "Vehicle fuel type invalid: Must be one of the following: 'H', 'E', 'D', 'G'.");
            return false;
        }

        if (fuelType == 'H' && this.type != 'C') {
            if (throwException) {
                throw new IllegalArgumentException("Vehicle fuel type invalid: Only cars may run on hydrogen.");
            }
            return false;
        }
        return true;
    }

    public boolean validateRegistrationNumber(String registrationNumber) {
        return this.validateRegistrationNumber(registrationNumber, true);
    }

    public boolean validateRegistrationNumber(String registrationNumber, boolean throwException) {
        String chars = registrationNumber.substring(0, 2);
        String nums = registrationNumber.substring(2);

        if (!chars.matches("[A-Z]{2}") || !nums.matches("[0-9]+")) {
            if (throwException)
                throw new IllegalArgumentException(
                        "Vehicle registration number invalid: Must start be in the format AB12345");
            return false;
        }

        // Check for wrong digit count.
        if (nums.length() < 4 || nums.length() > 5) {
            if (throwException)
                throw new IllegalArgumentException(
                        "Vehicle registration number invalid: Must be between 4 and 5 numbers long.");
            return false;
        }

        // Check if a non-electric vehicle uses EL or EK
        if (List.of("EL", "EK").contains(chars) && this.fuelType != 'E') {
            if (throwException)
                throw new IllegalArgumentException(
                        "Vehicle registration number invalid: Only electric vehicles can have the \"EL\" or \"EK\" registration characters.");
            return false;
        }

        // Ensure that hydrogen vehicles use HY, and that non-hydrogen vehicles do not.
        if (this.fuelType == 'H') {
            if (!chars.equals("HY")) {
                if (throwException)
                    throw new IllegalArgumentException(
                            "Vehicle registration number invalid: Hydrogen vehicles must have the \"HY\" registration characters.");
                return false;
            }
        } else {
            if (chars.equals("HY")) {
                if (throwException)
                    throw new IllegalArgumentException(
                            "Vehicle registration number invalid: Only hydrogen vehicles can have the \"HY\" registration characters.");
                return false;
            }
        }

        // Ensure electric vehicles use EL or EK.
        if (!List.of("EL", "EK").contains(chars) && this.fuelType == 'E') {
            if (throwException)
                throw new IllegalArgumentException(
                        "Vehicle registration number invalid: Electric vehicles must have the \"EL\" or \"EK\" registration characters.");
            return false;
        }

        // Ensure fossil fuel vehicles do not use EL, EK or HY.
        if (List.of("EL", "EK", "HY").contains(chars) && List.of('D', 'G').contains(this.type)) {
            if (throwException)
                throw new IllegalArgumentException(
                        "Vehicle registration number invalid: Fossil fuel vehicles cannot use the \"EL\", \"EK\" and \"HY\" registration characters.");
            return false;
        }

        // Cars must have 5 digits.
        if (nums.length() != 5 && this.type == 'C') {
            if (throwException)
                throw new IllegalArgumentException(
                        "Vehicle registration number invalid: Cars must have 5 digits in their registration.");
            return false;
        }

        // Motorcycles must have 4 digits.
        if (nums.length() != 4 && this.type == 'M') {
            if (throwException)
                throw new IllegalArgumentException(
                        "Vehicle registration number invalid: Motorcycles must have 4 digits in their registration.");
            return false;
        }
        return true;
    }

    public char getType() {
        return type;
    }

    public char getFuelType() {
        return fuelType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setType(char type) {
        this.validateType(type);
        this.type = type;
    }

    public void setFuelType(char fuelType) {
        this.validateFuelType(fuelType);
        this.fuelType = fuelType;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.validateRegistrationNumber(registrationNumber);
        this.registrationNumber = registrationNumber;
    }
}
