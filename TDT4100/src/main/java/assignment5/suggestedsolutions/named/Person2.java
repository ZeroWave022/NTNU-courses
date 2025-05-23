package assignment5.suggestedsolutions.named;

public class Person2 implements Named {

	private String fullName;

	public Person2(String fullName) {
		this.setFullName(fullName);
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		if (fullName == null) {
			throw new IllegalArgumentException("Full name cannot be null");
		}
		if (fullName.split(" ").length != 2) {
			throw new IllegalArgumentException("Full name must contain exactly one space");
		}

		this.fullName = fullName;
	}

	public String getGivenName() {
		return this.fullName.split(" ")[0];
	}

	public void setGivenName(String givenName) {
		if (givenName == null) {
			throw new IllegalArgumentException("Given name cannot be null");
		}
		if (givenName.isEmpty() || givenName.contains(" ")) {
			throw new IllegalArgumentException("Given name cannot be empty or contain space");
		}

		this.fullName = String.format("%s %s", givenName, this.getFamilyName());
	}

	public String getFamilyName() {
		return this.fullName.split(" ")[1];
	}

	public void setFamilyName(String familyName) {
		if (familyName == null) {
			throw new IllegalArgumentException("Family name cannot be null");
		}
		if (familyName.isEmpty() || familyName.contains(" ")) {
			throw new IllegalArgumentException("Family name cannot be empty or contain space");
		}

		this.fullName = String.format("%s %s", this.getGivenName(), familyName);
	}

	@Override
	public String toString() {
		return String.format("[Person2 fullName=%s]", this.fullName);
	}
}
