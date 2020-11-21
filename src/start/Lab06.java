package start;

import java.io.File;
import java.util.ArrayList;

import static helpers.ConsoleHelper.*;
import static helpers.FileHelper.*;

public class Lab06 {

    public static final String ROOT = "C:\\Programming\\eclipse\\workspace\\Laboratories\\";

    static long factorialIter(int arg) {
        if (arg < 0) return -1;
        long result = 1;
        for (int i = 2; i <= arg; i++) {
            result *= i;
        }
        return result;
    }

    static long factorialRecur(int arg) {
        if (arg < 0) return -1;
        return factorialRecur(arg, 1);
    }

    static long factorialRecur(int index, int result) {
        if (index == 1 || index == 0) {
            return result;
        }
        return factorialRecur(index - 1, result * index);
    }

    static int greatestCommonDivisorIter(int a, int b) {
        if (a > 0 && b > 0) {
            while(a != b) {
                if (a > b) {
                    a -= b;
                } else {
                    b -= a;
                }
            }
            return a;
        }
        return 0;
    }

    static int greatestCommonDivisorRecur(int a, int b) {
        if (a > 0 && b > 0) {
            if (a == b) return a;
            return a > b ? greatestCommonDivisorRecur(a - b, b) : greatestCommonDivisorRecur(a, b - a);
        }
        return 0;
    }

    static int sumPositiveElementsIter(int[] arr) {
        int sum = 0;
        for (int e : arr) {
            if (e > 0) sum += e;
        }
        return sum;
    }

    static int sumPositiveElementsRecur(int[] arr) {
        return sumPositiveElementsRecur(arr, 0, 0);
    }

    static int sumPositiveElementsRecur(int[] arr, int index, int sum) {
        if (index >= arr.length) return sum;
        if (arr[index] > 0) return sumPositiveElementsRecur(arr, index + 1, sum + arr[index]);
        return sumPositiveElementsRecur(arr, index + 1, sum);
    }

    static int txtLengthInDirOnly(String path) {
        int totalLength = 0;
        File dir = new File(ROOT + path);
        for (File file : dir.listFiles()) {
            String temp = getFileExtension(file);
            if (temp.equals("txt")) {
                totalLength += file.length();
            }
        }
        return totalLength;
    }

    static int txtLengthInDir(String path) {
        int totalLength = 0;
        File dir = new File(ROOT + path.replace(ROOT, ""));
        for (File file : dir.listFiles()) {
            String temp = getFileExtension(file);
            if (file.isDirectory()) {
                totalLength += txtLengthInDir(file.getPath());
            }
            if (temp.equals("txt")) {
                totalLength += file.length();
            }
        }
        return totalLength;
    }

    static int countFilesWithExtension(String path, String extension) {
        int count = 0;
        File dir = new File(ROOT + path.replace(ROOT, ""));
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                count += countFilesWithExtension(file.getPath(), extension);
            } else if (getFileExtension(file).equals(extension)) count++;
        }
        return count;
    }

    static float avgTxtLengthInDir(String path) {
        return (float)txtLengthInDir(path) / countFilesWithExtension(path, "txt");
    }

    public static void main(String[] args) {
        println("Factorials using iteration:");
        println(factorialIter(10));
        println(factorialIter(5));
        println(factorialIter(0));
        println(factorialIter(-1));
        println();

        println("Factorials using recursion:");
        println(factorialRecur(10));
        println(factorialRecur(5));
        println(factorialRecur(0));
        println(factorialRecur(-1));
        println();

        println("Greatest common divisor using iteration:");
        println(greatestCommonDivisorIter(49, 14));
        println(greatestCommonDivisorIter(52, 102));
        println(greatestCommonDivisorIter(5, 5));
        println(greatestCommonDivisorIter(-5, 0));
        println();

        println("Greatest common divisor using recursion:");
        println(greatestCommonDivisorRecur(49, 14));
        println(greatestCommonDivisorRecur(52, 102));
        println(greatestCommonDivisorRecur(5, 5));
        println(greatestCommonDivisorRecur(-5, 0));
        println();

        println("Sum of positive elements using iteration:");
        println(sumPositiveElementsIter(new int[]{1, 2, 3, 4, -10, 0, 5, -1}));
        println(sumPositiveElementsIter(new int[]{-1, -2, -3, 0}));
        println(sumPositiveElementsIter(new int[]{}));
        println();

        println("Sum of positive elements using recursion:");
        println(sumPositiveElementsRecur(new int[]{1, 2, 3, 4, -10, 0, 5, -1}));
        println(sumPositiveElementsRecur(new int[]{-1, -2, -3, 0}));
        println(sumPositiveElementsRecur(new int[]{}));
        println();

        println("Test File functions:");
        println(txtLengthInDirOnly("resources"));
        println(txtLengthInDir("resources"));
        println(avgTxtLengthInDir("resources"));
        println(countFilesWithExtension("resources", "txt"));
        println(countFilesWithExtension("resources", "bat"));
    }
}
