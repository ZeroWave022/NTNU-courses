package assignment4;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private char gender;
    private Person mother;
    private Person father;
    private List<Person> children = new ArrayList<>();

    public Person(String name, char gender) {
        this.validateInputs(name, gender);
        this.name = name;
        this.gender = gender;
    }

    public boolean validateInputs(String name, char gender) {
        return this.validateInputs(name, gender, true);
    }

    public boolean validateInputs(String name, char gender, boolean throwException) {
        if (name.length() == 0) {
            if (throwException)
                throw new IllegalArgumentException("Cannot have empty name.");
            return false;
        }

        if (!List.of('M', 'F').contains(gender)) {
            if (throwException)
                throw new IllegalArgumentException("Invalid gender");
            return false;
        }

        return true;
    }

    public void addChild(Person child) {
        if (!this.children.contains(child))
            this.children.add(child);

        if (this.gender == 'F') {
            if (child.getMother() != this)
                child.setMother(this);
        } else {
            if (child.getFather() != this)
                child.setFather(this);
        }
    }

    public void removeChild(Person child) {
        if (this.children.contains(child)) {
            this.children.remove(child);
        }

        if (this.gender == 'F') {
            if (child.getMother() != null)
                child.setMother(null);
        } else {
            if (child.getFather() != null)
                child.setFather(null);
        }
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    public Person getMother() {
        return mother;
    }

    public Person getFather() {
        return father;
    }

    public List<Person> getChildren() {
        return children;
    }

    public int getChildCount() {
        return children.size();
    }

    public Person getChild(int n) {
        return children.get(n);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMother(Person mother) {
        if (mother == null) {
            if (this.mother.getChildren().contains(this))
                this.mother.removeChild(this);
            this.mother = mother;
            return;
        }

        if (mother.getGender() != 'F')
            throw new IllegalArgumentException("Males cannot be a mother.");

        if (mother == this)
            throw new IllegalArgumentException("You cannot be your own mother.");

        if (this.mother != null) {
            this.mother.removeChild(this);
        }

        this.mother = mother;

        mother.addChild(this);
    }

    public void setFather(Person father) {
        if (father == null) {
            if (this.father.getChildren().contains(this))
                this.father.removeChild(this);
            this.father = father;
            return;
        }

        if (father.getGender() != 'M')
            throw new IllegalArgumentException("Females cannot be a father.");

        if (father == this)
            throw new IllegalArgumentException("You cannot be your own father.");

        if (this.father != null) {
            this.father.removeChild(this);
        }

        this.father = father;

        father.addChild(this);
    }
}
