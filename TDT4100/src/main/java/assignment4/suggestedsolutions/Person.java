package assignment4.suggestedsolutions;

import java.util.ArrayList;
import java.util.List;

public class Person {

	private static final char FEMALE_GENDER = 'F';
	private static final char MALE_GENDER = 'M';

	private final char gender;
	private final List<Person> children = new ArrayList<>();
	private final String name;
	private Person father;
	private Person mother;

	public Person(String name, char gender) {
		if (gender != Person.MALE_GENDER && gender != Person.FEMALE_GENDER) {
			throw new IllegalArgumentException(gender + " is not a valid gender");
		}
		if (name == null) {
			throw new IllegalArgumentException("Name cannot be null");
		}

		this.name = name;
		this.gender = gender;
	}

	public char getGender() {
		return this.gender;
	}

	public String getName() {
		return this.name;
	}

	/*
	 * Below is a complete encapsulation of the mother, father and children fields,
	 * that ensures
	 * consistent values
	 */

	public int getChildCount() {
		return this.children.size();
	}

	public Person getChild(int i) {
		if (i < 0 || i >= this.children.size()) {
			throw new IllegalArgumentException(
					"Index " + i + " out of bounds for children of size " + this.children.size());
		}

		return this.children.get(i);
	}

	public void addChild(Person child) {
		// only add if necessary
		if (this.children.contains(child)) {
			return;
		}
		if (child == null) {
			throw new IllegalArgumentException("Child cannot be null");
		}
		if (child.isAncestorOf(this)) {
			throw new IllegalArgumentException("A person cannot be its own ancestor");
		}

		this.children.add(child);

		if (this.gender == FEMALE_GENDER) {
			child.setMother(this);
		} else if (this.gender == MALE_GENDER) {
			child.setFather(this);
		}
	}

	public void removeChild(Person child) {
		// only remove if necessary
		if (!this.children.contains(child)) {
			return;
		}

		this.children.remove(child);

		// clear mother or father of child
		if (child.getFather() == this) {
			child.setFather(null);
		} else if (child.getMother() == this) {
			child.setMother(null);
		}
	}

	public Person getMother() {
		return this.mother;
	}

	private static void validateGender(Person person, char gender) {
		if (person != null && person.getGender() != gender) {
			throw new IllegalArgumentException(
					"The gender is " + person.getGender() + " but should have been " + gender);
		}
	}

	private static void validateNotSelfParent(Person person, Person parent) {
		if (person == parent) {
			throw new IllegalArgumentException("A person cannot be its own parent");
		}
	}

	public void setMother(Person mother) {
		Person.validateGender(mother, FEMALE_GENDER);
		Person.validateNotSelfParent(this, mother);

		if (mother == this.mother) {
			return;
		}

		// detach from previous mother, if needed
		if (this.mother != null) {
			this.mother.removeChild(this);
		}

		this.mother = mother;

		// attach to new mother, if needed
		if (this.mother != null) {
			this.mother.addChild(this);
		}
	}

	public Person getFather() {
		return this.father;
	}

	public void setFather(Person father) {
		Person.validateGender(father, MALE_GENDER);
		Person.validateNotSelfParent(this, father);

		if (father == this.father) {
			return;
		}

		// detach from previous father, if needed
		if (this.father != null) {
			this.father.removeChild(this);
		}

		this.father = father;

		// attach to new father, if needed
		if (this.father != null) {
			this.father.addChild(this);
		}
	}

	private static boolean isAncestorOf(Person ancestor, Person person) {
		if (person == null || ancestor == null) {
			return false;
		}
		if (ancestor == person) {
			return true;
		}
		return Person.isAncestorOf(ancestor, person.getFather())
				|| Person.isAncestorOf(ancestor, person.getMother());
	}

	private boolean isAncestorOf(Person person) {
		return Person.isAncestorOf(this, person.getFather())
				|| Person.isAncestorOf(this, person.getMother());
	}
}
