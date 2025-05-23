package assignment2.suggestedsolutions;

import java.util.Collection;
import java.util.List;

public class Vehicle {

	private static final Collection<Character> invalidLetters = List.of('Æ', 'Ø', 'Å');

	private char fuelType;
	private char vehicleType;
	private String registrationNumber;

	public Vehicle(char vehicleType, char fuelType, String registrationNumber) {
		Vehicle.validateFuelAndVehicleTypes(fuelType, vehicleType);
		this.fuelType = fuelType;
		this.vehicleType = vehicleType;
		this.setRegistrationNumber(registrationNumber);
	}

	public String getRegistrationNumber() {
		return this.registrationNumber;
	}

	public char getFuelType() {
		return this.fuelType;
	}

	public char getVehicleType() {
		return this.vehicleType;
	}

	public void setRegistrationNumber(String regNr) {
		this.validateRegistrationNumber(regNr);
		this.registrationNumber = regNr;
	}

	private static void validateVehicleType(char vehicleType) {
		if (vehicleType != 'C' && vehicleType != 'M') {
			throw new IllegalArgumentException(
					"vehicleType must be either 'C' or 'M', but was '" + vehicleType + "'");
		}
	}

	private static void validateFuelType(char fuelType) {
		Collection<Character> validFuels = List.of('D', 'G', 'E', 'H');

		if (!validFuels.contains(fuelType)) {
			throw new IllegalArgumentException(
					"Valid fuels are 'D', 'G', 'E' and 'H', not: " + fuelType);
		}
	}

	private static void validateFuelAndVehicleTypes(char fuel, char vehicleType) {
		Vehicle.validateFuelType(fuel);
		Vehicle.validateVehicleType(vehicleType);

		if (fuel == 'H' && vehicleType == 'M') {
			throw new IllegalArgumentException(
					"Fuel can not be hydrogen (H) when vehicle type is motorcycle (M)");
		}
	}

	private void validateRegistrationNumber(String regNr) {
		if (regNr == null) {
			throw new IllegalArgumentException("Registration number cannot be null");
		}

		String regLetters = regNr.substring(0, 2);
		String regDigits = regNr.substring(2);
		this.checkValidLetters(regLetters);
		this.checkValidDigits(regDigits);
	}

	private void checkValidDigits(String regDigits) {
		if (this.vehicleType == 'C' && regDigits.length() != 5) {
			throw new IllegalArgumentException(
					"Cars should have a registration number with 5 digits");
		}
		if (this.vehicleType == 'M' && regDigits.length() != 4) {
			throw new IllegalArgumentException(
					"Motorcycles should have a registration number with 4 digits");
		}

		for (char c : regDigits.toCharArray()) {
			if (!Character.isDigit(c)) {
				throw new IllegalArgumentException(regDigits + " should be digits");
			}
		}
	}

	private void checkValidLetters(String regLetters) {
		if (!(Character.isUpperCase(regLetters.charAt(0))
				&& Character.isUpperCase(regLetters.charAt(1)))) {
			throw new IllegalArgumentException(
					"Registration numbers should be uppercase but was: " + regLetters);
		}
		if (Vehicle.invalidLetters.contains(regLetters.charAt(0))
				|| Vehicle.invalidLetters.contains(regLetters.charAt(1))) {
			throw new IllegalArgumentException(
					"Letters should not be 'Æ', 'Ø' or 'Å', but was: " + regLetters);
		}
		if (this.fuelType == 'E' && !(regLetters.equals("EL") || regLetters.equals("EK"))) {
			throw new IllegalArgumentException(
					"For electrical vehicles the letters should be EL or EK but was :"
							+ regLetters);
		}
		if (this.fuelType == 'H' && !(regLetters.equals("HY"))) {
			throw new IllegalArgumentException(
					"For hydrogen vehicles the letters should be HY :" + regLetters);
		}
		if ((this.fuelType == 'D' || this.fuelType == 'G') && (regLetters.equals("EL")
				|| regLetters.equals("EK") || regLetters.equals("HY"))) {
			throw new IllegalArgumentException(
					"Diesel and petrol vehicles should not have letters EL, EK or HY, but was: "
							+ regLetters);
		}
	}

	@Override
	public String toString() {
		return String.format("Vehicle [fuelType=%s, vehicleType=%s, registrationNumber=%s]",
				this.fuelType, this.vehicleType, this.registrationNumber);
	}
}
