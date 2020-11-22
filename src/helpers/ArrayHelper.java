package helpers;

public class ArrayHelper {
    public static boolean isInArray(Object target, Object[] arr) {
        for (Object e : arr) {
            if (e.equals(target)) return true;
        }
        return false;
    }
}
