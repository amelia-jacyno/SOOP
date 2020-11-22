package classes.class06;

import static helpers.ArrayHelper.*;

public class CourseDef {
    final float[] acceptableGrades = {2.0f, 2.5f, 3.0f, 3.5f, 4.0f, 4.5f, 5.0f};
    final String id;
    final int number;
    float grade;

    public CourseDef(String id, int number) {
        if (id.isBlank()) this.id = "NULL";
        else this.id = id;
        if (number < 1 || number > 10) this.number = 0;
        else this.number = number;
        grade = 2.0f;
    }

    public CourseDef(String id, int number, float grade) {
        this.id = id;
        this.number = number;
        this.grade = grade;
    }

    public boolean setGrade(float grade) {
        if (isInArray(grade, acceptableGrades)) {
            this.grade = grade;
            return true;
        }
        return false;
    }

    public String getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public float getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "{\"id\": \"" + id + "\", \"number\": " + number + ", \"grade\":" + grade;
    }
}
