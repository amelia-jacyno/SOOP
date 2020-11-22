package classes.class06;

import java.lang.reflect.Array;
import java.security.InvalidParameterException;
import java.util.ArrayList;

public class StudentExp {
    final String firstName, lastName;
    int birthYear;
    ArrayList<CourseDef> courses = new ArrayList<>();

    public StudentExp(String firstName, String lastName, int birthYear) throws IllegalArgumentException {
        if (firstName.isBlank()) throw new IllegalArgumentException("firstName can not be blank");
        else this.firstName = firstName;
        if (lastName.isBlank()) throw new IllegalArgumentException("lastName can not be blank");
        else this.lastName = lastName;
        if (birthYear < 1990 || birthYear > 2005)
            throw new IllegalArgumentException("birthYear has to be a number between 1990 and 2005");
        else this.birthYear = birthYear;
    }

    public boolean addCourse(CourseDef course, double grade) {
        float fGrade = (float)grade;
        if (courses.size() < 20 && CourseDef.isGradeAcceptable(fGrade)) {
            boolean unique = true;
            for (int i = 0; i < courses.size(); i++) {
                if (courses.get(i).getId().equals(course.getId())) unique = false;
            }
            if (unique) {
                courses.add(course);
                return true;
            }
        }
        return false;
    }

    public float getAverageGrade() {
        float sum = 0;
        for (int i = 0; i < courses.size(); i++) {
            sum += courses.get(i).getGrade();
        }
        return sum / courses.size();
    }

    @Override
    public String toString() {
        String json = "{\n" +
                "\"firstName\": " + "\"" + firstName + "\",\n" +
                "\"lastName\": " + "\"" + lastName + "\",\n" +
                "\"birthYear\": " + birthYear + ",\n" +
                "\"courses\": [\n";
        for (int i = 0; i < courses.size(); i++) {
            json += courses.get(i);
            if (i != courses.size() - 1) {
                json += ",\n";
            }
        }
        json += "]}";
        return json;
    }
}
