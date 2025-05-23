package assignment5.solutions;

import java.util.List;

public class Person2 implements Named {
    private String fullName;

    public Person2(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String getGivenName() {
        return this.fullName.split(" ")[0];
    }

    @Override
    public void setGivenName(String givenName) {
        List<String> names = List.of(this.fullName.split(" "));
        this.fullName = givenName + " " + String.join(" ", names.subList(1, names.size()));
    }

    @Override
    public String getFamilyName() {
        List<String> names = List.of(this.fullName.split(" "));
        return String.join(" ", names.subList(1, names.size()));
    }

    @Override
    public void setFamilyName(String familyName) {
        this.fullName = String.format("%s %s", this.fullName.split(" ")[0], familyName);
    }

    @Override
    public String getFullName() {
        return this.fullName;
    }

    @Override
    public void setFullName(String name) {
        this.fullName = name;
    }
}
