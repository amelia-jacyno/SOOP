package classes.class06;

import static helpers.ConsoleHelper.*;
import classes.class06.*;

public class Main {
    public static void main(String[] args) {
        CourseDef[] courses = {
                new CourseDef("Structural and Object Oriented Programming", 4),
                new CourseDef("Physics", 3),
                new CourseDef("Computer System Organisation", 2),
                new CourseDef("Mathematical Analysis", 4),
                new CourseDef("Algebra and Analytical Geometry", 4),
                new CourseDef("Logic for IT specialists", 4),
        };

        println("Print all courses:");
        for (CourseDef course : courses) {
            println(course);
        }
        println();

        println("Change grade of course to 5.0f:");
        println(courses[0]);
        println(courses[0].setGrade(5.0f));
        println(courses[0]);
        println();

        println("Try to change grade of course to 3.75f:");
        println(courses[0]);
        println(courses[0].setGrade(3.75f));
        println(courses[0]);
        println();

        println("Try to create courses with invalid parameters:");
        try {
            new CourseDef("", 1);
        } catch (IllegalArgumentException e) {
            println(e);
        }
        try {
            new CourseDef("asd", 0);
        } catch (IllegalArgumentException e) {
            println(e);
        }
        println();

        println("Create and print a student without courses:");
        StudentExp student = new StudentExp("Adam", "Jacyno", 2001);
        println(student);
        println();

        println("Add all courses to student and print student:");
        for (CourseDef course : courses) {
            student.addCourse(course, course.getGrade());
        }
        println(student);
        println();

        println("Try to add a course with invalid grade to student:");
        println(student.addCourse(new CourseDef("Test", 5), 3.75));
        println();

        println("Try to add a course that was already added student:");
        println(student.addCourse(courses[0], 2.0));
        println();

        println("Get student average grade:");
        println(student.getAverageGrade());
        println();

        println("Try to add more courses than 20:");
        for (int i = 0; i < 20; i++) {
            print(student.addCourse(new CourseDef(Integer.toString(i), 5), 3.5f) + " ");
        }
        println();
        println();

        println("Get student average grade (after multiple courses added):");
        println(student.getAverageGrade());
        println();

        println("Try to create student with illegal parameters");
        try {
            student = new StudentExp(" ", "Jacyno", 2001);
        } catch (IllegalArgumentException e) {
            println(e);
        }
        try {
            student = new StudentExp("Adam", " ", 2001);
        } catch (IllegalArgumentException e) {
            println(e);
        }
        try {
            student = new StudentExp("Adam", "Jacyno", 1939);
        } catch (IllegalArgumentException e) {
            println(e);
        }
    }
}
