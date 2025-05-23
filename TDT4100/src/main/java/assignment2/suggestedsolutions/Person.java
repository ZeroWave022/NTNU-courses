package assignment2.suggestedsolutions;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

public class Person {

	private static final int[] factors1 = { 3, 7, 6, 1, 8, 9, 4, 5, 2 };
	private static final int[] factors2 = { 5, 4, 3, 2, 7, 6, 5, 4, 3, 2 };
	private static final Collection<Character> validGenders = Set.of('F', 'M', '\0');
	private static final Collection<String> validCTLDs = Set.of("ad", "ae", "af", "ag", "ai", "al",
			"am", "ao", "aq", "ar", "as", "at", "au", "aw", "ax", "az", "ba", "bb", "bd", "be",
			"bf", "bg", "bh", "bi", "bj", "bl", "bm", "bn", "bo", "bq", "br", "bs", "bt", "bv",
			"bw", "by", "bz", "ca", "cc", "cd", "cf", "cg", "ch", "ci", "ck", "cl", "cm", "cn",
			"co", "cr", "cu", "cv", "cw", "cx", "cy", "cz", "de", "dj", "dk", "dm", "do", "dz",
			"ec", "ee", "eg", "eh", "er", "es", "et", "fi", "fj", "fk", "fm", "fo", "fr", "ga",
			"gb", "gd", "ge", "gf", "gg", "gh", "gi", "gl", "gm", "gn", "gp", "gq", "gr", "gs",
			"gt", "gu", "gw", "gy", "hk", "hm", "hn", "hr", "ht", "hu", "id", "ie", "il", "im",
			"in", "io", "iq", "ir", "is", "it", "je", "jm", "jo", "jp", "ke", "kg", "kh", "ki",
			"km", "kn", "kp", "kr", "kw", "ky", "kz", "la", "lb", "lc", "li", "lk", "lr", "ls",
			"lt", "lu", "lv", "ly", "ma", "mc", "md", "me", "mf", "mg", "mh", "mk", "ml", "mm",
			"mn", "mo", "mp", "mq", "mr", "ms", "mt", "mu", "mv", "mw", "mx", "my", "mz", "na",
			"nc", "ne", "nf", "ng", "ni", "nl", "no", "np", "nr", "nu", "nz", "om", "pa", "pe",
			"pf", "pg", "ph", "pk", "pl", "pm", "pn", "pr", "ps", "pt", "pw", "py", "qa", "re",
			"ro", "rs", "ru", "rw", "sa", "sb", "sc", "sd", "se", "sg", "sh", "si", "sj", "sk",
			"sl", "sm", "sn", "so", "sr", "ss", "st", "sv", "sx", "sy", "sz", "tc", "td", "tf",
			"tg", "th", "tj", "tk", "tl", "tm", "tn", "to", "tr", "tt", "tv", "tw", "tz", "ua",
			"ug", "um", "us", "uy", "uz", "va", "vc", "ve", "vg", "vi", "vn", "vu", "wf", "ws",
			"ye", "yt", "za", "zm", "zw");

	private char gender;
	private Date birthday;
	private String email;
	private String firstName; // Could also be solve by only having name as a field
	private String lastName;
	private String ssn;

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		if (birthday == null) {
			throw new IllegalArgumentException("The birthday cannot be null");
		}
		if (birthday.after(new Date())) {
			throw new IllegalArgumentException(birthday + " is in the future");
		}

		this.birthday = birthday;
	}

	public char getGender() {
		return this.gender;
	}

	public void setGender(char gender) {
		if (!Person.validGenders.contains(gender)) {
			throw new IllegalArgumentException("Invalid gender");
		}

		this.gender = gender;
	}

	public String getName() {
		return String.format("%s %s", this.firstName, this.lastName);
	}

	/**
	 * Also see {@link #validateName2}.
	 * 
	 * @param name
	 */
	private static void validateName(String name) {
		if (name == null) {
			throw new IllegalArgumentException("The name cannot be null");
		}

		String[] nameParts = name.split(" ");
		if (nameParts.length != 2) {
			throw new IllegalArgumentException("The name must contain exactly one space");
		}

		for (String namePart : nameParts) {
			if (namePart.length() < 2) {
				throw new IllegalArgumentException(
						"Each part of the name must be at least 2 characters");
			}
			if (Character.isLowerCase(namePart.charAt(0))) {
				throw new IllegalArgumentException(
						"The first letter of each name must be uppercase");
			}
			if (!namePart.substring(1).equals(namePart.substring(1).toLowerCase())) {
				throw new IllegalArgumentException("The rest of the name must be lowercase");
			}

			for (char c : namePart.toCharArray()) {
				if (!Character.isLetter(c)) {
					throw new IllegalArgumentException("The name must only contain letters");
				}
			}
		}
	}

	/**
	 * This version uses regular expressions (RegEx) to validate the name, and does
	 * exactly the same
	 * as {@link #validateName}. Don't worry if you don't understand it: It's just
	 * meant to show how
	 * powerful regular expressions can be.
	 * 
	 * @param name
	 */
	@SuppressWarnings("unused")
	private static void validateName2(String name) {
		if (name == null) {
			throw new IllegalArgumentException("The name cannot be null");
		}
		if (!name.matches("[A-Z][a-z]+ [A-Z][a-z]+")) {
			throw new IllegalArgumentException(
					"The name must be in the format 'Firstname Lastname'");
		}
	}

	public void setName(String name) {
		Person.validateName(name); // Change to validateName2 to use the other validation method

		String[] nameParts = name.split(" ");
		this.firstName = nameParts[0];
		this.lastName = nameParts[1];
	}

	public String getEmail() {
		return this.email;
	}

	private void validateEmail(String email) {
		if (email == null) {
			throw new IllegalArgumentException("The email cannot be null");
		}
		if (!email.equals(email.toLowerCase())) {
			throw new IllegalArgumentException(email + " contains uppercase letters");
		}

		String[] parts = email.split("@");
		if (parts.length != 2) {
			throw new IllegalArgumentException(email + " contained more than one @");
		}

		String[] nameParts = parts[0].split("\\.");
		if (nameParts.length != 2) {
			throw new IllegalArgumentException(
					"The name part should include two names separated with .");
		}
		if (!this.firstName.equalsIgnoreCase(nameParts[0])) {
			throw new IllegalArgumentException("The first name of email (" + nameParts[0]
					+ ") does not match given name (" + this.firstName + ")");
		}
		if (!this.lastName.equalsIgnoreCase(nameParts[1])) {
			throw new IllegalArgumentException("The second name of email (" + nameParts[1]
					+ ") does not match family name (" + this.lastName + ")");
		}

		String[] domainParts = parts[1].split("\\.");
		if (domainParts.length != 2) {
			throw new IllegalArgumentException(
					"The domain part should include two words separated with .");
		}
		if (!Person.validCTLDs.contains(domainParts[1])) {
			throw new IllegalArgumentException(
					"The country code " + domainParts[1] + " is not a valid top level domain");
		}

		for (char c : domainParts[0].toCharArray()) {
			if (!Character.isLetterOrDigit(c)) {
				throw new IllegalArgumentException(
						"The domain name must only contain letters and digits");
			}
		}
	}

	public void setEmail(String email) {
		this.validateEmail(email);
		this.email = email;
	}

	// Social security number: http://no.wikipedia.org/wiki/Fødselsnummer

	private static int computeControlDigit(String digits, int[] factors) {
		int sum = 0;

		for (int i = 0; i < factors.length; i++) {
			sum += Character.getNumericValue(digits.charAt(i)) * factors[i];
		}

		sum = 11 - (sum % 11);
		return sum % 11;
	}

	private void validateSSN(String ssn) {
		if (ssn == null) {
			throw new IllegalArgumentException("The PID cannot be null");
		}
		if (ssn.length() != 11) {
			throw new IllegalArgumentException("The PID must be 11 characters long");
		}

		for (char c : ssn.toCharArray()) {
			if (!Character.isDigit(c)) {
				throw new IllegalArgumentException("The PID must only contain digits");
			}
		}

		if (!ssn.substring(0, 6).equals(new SimpleDateFormat("ddMMyy").format(this.birthday))) {
			throw new IllegalArgumentException("The PID does not match the birthday");
		}

		int parity = Character.getNumericValue(ssn.charAt(8)) % 2;

		if ((this.gender == 'M' && parity == 0) || (this.gender == 'F' && parity == 1)) {
			throw new IllegalArgumentException("The PID does not not match the gender");
		}

		int k1 = Person.computeControlDigit(ssn, factors1);
		int k2 = Person.computeControlDigit(ssn, factors2);

		if (k1 != Character.getNumericValue(ssn.charAt(9))
				|| k2 != Character.getNumericValue(ssn.charAt(10))) {
			throw new IllegalArgumentException("The PID does not match the control digits");
		}
	}

	public String getSSN() {
		return this.ssn;
	}

	public void setSSN(String ssn) {
		this.validateSSN(ssn);
		this.ssn = ssn;
	}

	@Override
	public String toString() {
		return String.format("Person [name=%s, gender=%s, birthday=%s, email=%s, ssn=%s]",
				this.getName(), this.gender, this.birthday, this.email, this.ssn);
	}
}
