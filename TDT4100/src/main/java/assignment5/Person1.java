package assignment5;

import java.util.List;

public class Person1 implements Named {
    private String givenName;
    private String familyName;

    public Person1(String givenName, String familyName) {
        this.givenName = givenName;
        this.familyName = familyName;
    }

    @Override
    public String getGivenName() {
        return givenName;
    }

    @Override
    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    @Override
    public String getFamilyName() {
        return familyName;
    }

    @Override
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    @Override
    public String getFullName() {
        return String.format("%s %s", this.givenName, this.familyName);
    }

    @Override
    public void setFullName(String name) {
        List<String> fullName = List.of(name.split(" "));
        // Assuming only one given name and a variable number of family names
        this.givenName = fullName.get(0);
        this.familyName = String.join(" ", fullName.subList(1, fullName.size()));
    }
}
