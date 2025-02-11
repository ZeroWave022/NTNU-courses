package assignment2;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Person {
    private String name;
    private String email;
    private Date birthday;
    private char gender;
    private String SSN;

    private static final String[] countryTlds = {
            "ad", "ae", "af", "ag", "ai", "al", "am", "ao", "aq", "ar", "as", "at", "au", "aw", "ax", "az", "ba", "bb",
            "bd", "be", "bf", "bg", "bh", "bi", "bj", "bl", "bm", "bn", "bo", "bq", "br", "bs", "bt", "bv", "bw", "by",
            "bz", "ca", "cc", "cd", "cf", "cg", "ch", "ci", "ck", "cl", "cm", "cn", "co", "cr", "cu", "cv", "cw", "cx",
            "cy", "cz", "de", "dj", "dk", "dm", "do", "dz", "ec", "ee", "eg", "eh", "er", "es", "et", "fi", "fj", "fk",
            "fm", "fo", "fr", "ga", "gb", "gd", "ge", "gf", "gg", "gh", "gi", "gl", "gm", "gn", "gp", "gq", "gr", "gs",
            "gt", "gu", "gw", "gy", "hk", "hm", "hn", "hr", "ht", "hu", "id", "ie", "il", "im", "in", "io", "iq", "ir",
            "is", "it", "je", "jm", "jo", "jp", "ke", "kg", "kh", "ki", "km", "kn", "kp", "kr", "kw", "ky", "kz", "la",
            "lb", "lc", "li", "lk", "lr", "ls", "lt", "lu", "lv", "ly", "ma", "mc", "md", "me", "mf", "mg", "mh", "mk",
            "ml", "mm", "mn", "mo", "mp", "mq", "mr", "ms", "mt", "mu", "mv", "mw", "mx", "my", "mz", "na", "nc", "ne",
            "nf", "ng", "ni", "nl", "no", "np", "nr", "nu", "nz", "om", "pa", "pe", "pf", "pg", "ph", "pk", "pl", "pm",
            "pn", "pr", "ps", "pt", "pw", "py", "qa", "re", "ro", "rs", "ru", "rw", "sa", "sb", "sc", "sd", "se", "sg",
            "sh", "si", "sj", "sk", "sl", "sm", "sn", "so", "sr", "ss", "st", "sv", "sx", "sy", "sz", "tc", "td", "tf",
            "tg", "th", "tj", "tk", "tl", "tm", "tn", "to", "tr", "tt", "tv", "tw", "tz", "ua", "ug", "um", "us", "uy",
            "uz", "va", "vc", "ve", "vg", "vi", "vn", "vu", "wf", "ws", "ye", "yt", "za", "zm", "zw"
    };

    private static final List<List<Integer>> controlNumMultiFactor = List.of(List.of(3, 7, 6, 1, 8, 9, 4, 5, 2),
            List.of(5, 4, 3, 2, 7, 6, 5, 4, 3, 2));

    public Person() {
    }

    public Person(String name, String email, Date birthday, char gender) {
        this.validateName(name, false);

        // Name must be set as soon as possible,
        // because it is required to validate the email.
        this.name = name;

        this.validateEmail(email);
        this.validateBirthday(birthday);
        this.validateGender(gender);

        this.email = email;
        this.birthday = birthday;
        this.gender = gender;
    }

    public boolean validateName(String name) {
        return this.validateName(name, true);
    }

    public boolean validateName(String name, boolean throwException) {
        String[] names = name.split(" ");
        if (names.length != 2) {
            if (throwException)
                throw new IllegalArgumentException(
                        "Person name is invalid: The full name must consist of two words separated by a space.");
            return false;
        }

        String first = names[0], last = names[1];

        if (first.length() < 2 || last.length() < 2) {
            if (throwException)
                throw new IllegalArgumentException(
                        "Person name is invalid: Each name must be at least two characters.");
            return false;
        }

        if (!first.matches("[a-zA-ZæøåÆØÅ-]+") || !last.matches("[a-zA-ZæøåÆØÅ-]+")) {
            if (throwException)
                throw new IllegalArgumentException("Person name is invalid: Illegal characters used.");
            return false;
        }
        return true;
    }

    public boolean validateEmail(String email) {
        return this.validateEmail(email, true);
    }

    public boolean validateEmail(String email, boolean throwException) {
        boolean validTld = false;
        email = email.toLowerCase();

        for (String tld : countryTlds) {
            if (email.endsWith(String.format(".%s", tld))) {
                validTld = true;
                break;
            }
        }

        if (!validTld)
            throw new IllegalArgumentException("Person email is invalid: The top-level domain is invalid.");

        String[] names = name.toLowerCase().split(" ");
        String first = names[0], last = names[1];

        if (!email.startsWith(String.format("%s.%s@", first, last)))
            throw new IllegalArgumentException(
                    "Person email is invalid: The email does not belong to this person. Expected email: firstName.lastName@domain.tld.");

        return true;
    }

    public boolean validateBirthday(Date birthday) {
        return this.validateBirthday(birthday, true);
    }

    public boolean validateBirthday(Date birthday, boolean throwException) {
        if (birthday.getTime() > new Date().getTime()) {
            if (throwException)
                throw new IllegalArgumentException("Person birthday is invalid: Must be before today's date.");
            return false;
        }
        return true;
    }

    public boolean validateGender(char gender) {
        return this.validateGender(gender, true);
    }

    public boolean validateGender(char gender, boolean throwException) {
        if (!List.of('M', 'F', '\0').contains(gender)) {
            if (throwException)
                throw new IllegalArgumentException("Person gender is invalid: Must be 'M', 'F', or '\\0'.");
            return false;
        }
        return true;
    }

    private String calculateControlNums(String SSN) {
        int weightedSum1 = 0, weightedSum2 = 0;
        for (int i = 0; i < controlNumMultiFactor.get(0).size(); i++) {
            weightedSum1 += Character.getNumericValue(SSN.charAt(i)) * controlNumMultiFactor.get(0).get(i);
        }

        for (int i = 0; i < controlNumMultiFactor.get(1).size(); i++) {
            weightedSum2 += Character.getNumericValue(SSN.charAt(i)) * controlNumMultiFactor.get(1).get(i);
        }

        int num1 = 11 - (weightedSum1 % 11), num2 = 11 - (weightedSum2 % 11);

        if (num1 == 11)
            num1 = 0;

        if (num2 == 11)
            num1 = 0;

        return String.valueOf(num1) + String.valueOf(num2);
    }

    public boolean validateSSN(String SSN) {
        return this.validateSSN(SSN, true);
    }

    public boolean validateSSN(String SSN, boolean throwException) {
        if (this.gender == '\u0000' || this.birthday.equals(null)) {
            if (throwException)
                throw new IllegalStateException("Gender and birthday must be set before setting the SSN.");
            return false;
        }

        if (SSN.charAt(8) % 2 == 0 && this.gender == 'M' || SSN.charAt(8) % 2 != 0 && this.gender == 'F') {
            if (throwException)
                throw new IllegalArgumentException("The ninth number must be even for women and odd for men.");
            return false;
        }

        Calendar birthdayCal = Calendar.getInstance();
        birthdayCal.setTime(this.birthday);

        String day = String.valueOf(birthdayCal.get(Calendar.DAY_OF_MONTH));
        if (Integer.parseInt(day) < 10) {
            day = "0" + day;
        }

        String month = String.valueOf(birthdayCal.get(Calendar.MONTH) + 1);
        if (Integer.parseInt(month) < 10) {
            month = "0" + month;
        }

        String year = String.valueOf(birthdayCal.get(Calendar.YEAR)).substring(2);

        String SSNBirthday = day + month + year;
        String controlNums = this.calculateControlNums(SSN);

        if (!SSN.startsWith(SSNBirthday) || !SSN.endsWith(controlNums)) {
            if (throwException)
                throw new IllegalArgumentException("The SSN birthday or control numbers are incorrect!");
            return false;
        }

        return true;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public char getGender() {
        return gender;
    }

    public String getSSN() {
        return SSN;
    }

    public void setName(String name) throws IllegalArgumentException {
        this.validateName(name);
        this.name = name;
    }

    public void setEmail(String email) {
        this.validateEmail(email);
        this.email = email;
    }

    public void setBirthday(Date birthday) {
        this.validateBirthday(birthday);
        this.birthday = birthday;
    }

    public void setGender(char gender) {
        this.validateGender(gender);
        this.gender = gender;
    }

    public void setSSN(String SSN) {
        this.validateSSN(SSN);
        this.SSN = SSN;
    }
}
