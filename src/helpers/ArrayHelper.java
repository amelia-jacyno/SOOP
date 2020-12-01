package helpers;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayHelper {
    public static boolean isInArray(float target, float[] arr) {
        for (Object e : arr) {
            if (e.equals(target)) return true;
        }
        return false;
    }
    public static boolean arrayListEqualsOrderless(ArrayList<Object> arr1, ArrayList<Object> arr2) {
        if (arr1 == null && arr2 == null) return true;
        if (arr1 == null || arr2 == null) return false;
        if (arr1.size() != arr2.size()) return false;
        for (Object o : arr1) {
            boolean elemEquals = false;
            for (Object p : arr2) {
                if (o.equals(p)) {
                    arr2.remove(p);
                    elemEquals = true;
                    break;
                }
            }
            if (!elemEquals) return false;
        }
        return true;
    }
}
