package assignment5.suggestedsolutions.named;

public class Person1 implements Named {

	private String familyName;
	private String givenName;

	public Person1(String givenName, String familyName) {
		this.setGivenName(givenName);
		this.setFamilyName(familyName);
	}

	public String getGivenName() {
		return this.givenName;
	}

	public void setGivenName(String givenName) {
		if (givenName == null) {
			throw new IllegalArgumentException("Given name cannot be null");
		}
		if (givenName.isEmpty() || givenName.contains(" ")) {
			throw new IllegalArgumentException("Given name cannot be empty or contain space");
		}

		this.givenName = givenName;
	}

	public String getFamilyName() {
		return this.familyName;
	}

	public void setFamilyName(String familyName) {
		if (familyName == null) {
			throw new IllegalArgumentException("Family name cannot be null");
		}
		if (familyName.isEmpty() || familyName.contains(" ")) {
			throw new IllegalArgumentException("Family name cannot be empty or contain space");
		}

		this.familyName = familyName;
	}

	public String getFullName() {
		return String.format("%s %s", this.givenName, this.familyName);
	}

	public void setFullName(String fullName) {
		if (fullName == null) {
			throw new IllegalArgumentException("Full name cannot be null");
		}

		String[] names = fullName.split(" ");

		if (names.length != 2) {
			throw new IllegalArgumentException("Full name must contain exactly one space");
		}

		this.givenName = names[0];
		this.familyName = names[1];
	}

	@Override
	public String toString() {
		return String.format("[Person1 givenName=%s familyName=%s]", this.givenName,
				this.familyName);
	}
}
