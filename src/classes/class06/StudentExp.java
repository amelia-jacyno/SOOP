package classes.class06;

import java.util.ArrayList;

public class StudentExp {
    final String firstName, lastName;
    int birthYear;
    int minBirthYear = 1990;
    int maxBirthYear = 2005;
    int maxCourseCount = 20;
    ArrayList<CourseDef> courses = new ArrayList<>();

    public StudentExp(String firstName, String lastName, int birthYear) throws IllegalArgumentException {
        if (firstName.isBlank()) throw new IllegalArgumentException("firstName can not be blank");
        else this.firstName = firstName;
        if (lastName.isBlank()) throw new IllegalArgumentException("lastName can not be blank");
        else this.lastName = lastName;
        if (birthYear < minBirthYear || birthYear > maxBirthYear)
            throw new IllegalArgumentException("birthYear has to be a number between 1990 and 2005");
        else this.birthYear = birthYear;
    }

    public boolean addCourse(CourseDef course, double grade) {
        float fGrade = (float)grade;
        if (courses.size() < maxCourseCount) {
            boolean unique = true;
            for (CourseDef c : courses) {
                if (c.getId().equals(course.getId())) {
                    unique = false;
                    break;
                }
            }
            if (unique) {
                if (course.setGrade(fGrade)) {
                    courses.add(course);
                    return true;
                }
            }
        }
        return false;
    }

    public float getAverageGrade() {
        float sum = 0;
        for (CourseDef course : courses) {
            sum += course.getGrade();
        }
        return sum / courses.size();
    }

    @Override
    public String toString() {
        String json = "{\n" +
                "   \"firstName\": " + "\"" + firstName + "\",\n" +
                "   \"lastName\": " + "\"" + lastName + "\",\n" +
                "   \"birthYear\": " + birthYear + ",\n" +
                "   \"courses\": [\n";
        for (int i = 0; i < courses.size(); i++) {
            json += courses.get(i).toString().replaceAll("(?m)^", "\t"); // Add tab to each newline
            if (i != courses.size() - 1) {
                json += ",\n";
            }
        }
        json += "]\n}";
        return json;
    }
}
