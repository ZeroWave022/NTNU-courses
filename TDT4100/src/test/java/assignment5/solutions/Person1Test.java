package assignment5.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Person1Test {

	private Person1 person1;
	private String h;
	private String t;

	@BeforeEach
	public void setUp() {
		h = "Hallvard";
		t = "Trætteberg";
		person1 = new Person1(h, t);
	}

	private static void testName(Person1 person, String givenName, String lastName) {
		assertEquals(givenName, person.getGivenName());
		assertEquals(lastName, person.getFamilyName());
		assertEquals(String.format("%s %s", givenName, lastName), person.getFullName());
	}

	@Test
	@DisplayName("Sjekk at konstruktøren gir personen riktig navn")
	public void testConstructor() {
		Person1Test.testName(person1, h, t);
	}

	@Test
	@DisplayName("Sjekk at setGivenName() gir riktig navn")
	public void testSetGivenName() {
		String j = "Jens";
		person1.setGivenName(j);
		Person1Test.testName(person1, j, t);
	}

	@Test
	@DisplayName("Sjekk at setFamilyName() gir riktig navn")
	public void testSetFamilyName() {
		String o = "Olsen";
		person1.setFamilyName(o);
		Person1Test.testName(person1, h, o);
	}

	@Test
	@DisplayName("Sjekk at setFullName() gir riktig navn")
	public void testSetFullName() {
		String l = "Lisa";
		String e = "Eriksen";
		String fullName = l + " " + e;
		person1.setFullName(fullName);
		Person1Test.testName(person1, l, e);
	}
}
