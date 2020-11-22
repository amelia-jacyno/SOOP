package classes.class06;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public class StudentExp {
    final String firstName, lastName;
    int birthYear;
    ArrayList<CourseDef> courses;

    public StudentExp(String firstName, String lastName, int birthYear) throws IllegalArgumentException {
        if (firstName.isBlank()) throw new IllegalArgumentException("firstName can not be blank");
        else this.firstName = firstName;
        if (lastName.isBlank()) throw new IllegalArgumentException("lastName can not be blank");
        else this.lastName = lastName;
        if (birthYear < 1990 || birthYear > 2005)
            throw new IllegalArgumentException("birthYear has to be a number between 1990 and 2005");
        else this.birthYear = birthYear;
    }
}
