package helpers;

public class ArrayHelper {
    public static boolean isInArray(float target, float[] arr) {
        for (Object e : arr) {
            if (e.equals(target)) return true;
        }
        return false;
    }
}
