package helpers;

import java.util.ArrayList;

import static helpers.ArrayHelper.arrayToString;

public class ConsoleHelper {

    public static void print(Object var) {
        System.out.print(var);
    }

    public static void println(Object var) {
        System.out.println(var);
    }

    public static void println() {
        System.out.println();
    }

    public static void printArr(Object[] arr) {
        println(arrayToString(arr));
    }
}
