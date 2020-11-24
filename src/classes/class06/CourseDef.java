package classes.class06;

import static helpers.ArrayHelper.*;

public class CourseDef {
    private static final float[] acceptableGrades = {2.0f, 2.5f, 3.0f, 3.5f, 4.0f, 4.5f, 5.0f};
    private static final float defaultGrade = 2f;
    private static final int minPoints = 1;
    private static final int maxPoints = 10;
    private final String id;
    private final int number;
    private float grade;

    public CourseDef(String id, int number) throws IllegalArgumentException{
        if (id.isBlank()) throw new IllegalArgumentException("id can not be blank");
        else this.id = id;
        if (number < minPoints || number > maxPoints) throw new IllegalArgumentException("number has to be between 1 and 10");
        else this.number = number;
        grade = defaultGrade;
    }

    private boolean isGradeAcceptable(float grade) {
        return isInArray(grade, acceptableGrades);
    }

    public boolean setGrade(float grade) {
        if (isGradeAcceptable(grade)) {
            this.grade = grade;
            return true;
        }
        return false;
    }

    public String getId() {
        return id;
    }

    public float getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "{\n" +
                "   \"id\": \"" + id + "\",\n" +
                "   \"number\": " + number + ",\n" +
                "   \"grade\": " + grade + "\n}";
    }
}
