package start;

public class Lab06 {

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

    /*
    static int greatestCommonDivisorIter(int a, int b) {

    }

    static int greatestCommonDivisorRecur(int a, int b) {

    }

    static int sumPositiveElementsIter(int[] arr) {

    }

    static int sumPositiveElementsRecur(int[] arr) {

    } */

    public static void main(String[] args) {
        System.out.println("Factorials using iteration:");
        System.out.println(factorialIter(10));
        System.out.println(factorialIter(5));
        System.out.println(factorialIter(0));
        System.out.println(factorialIter(-1));
        System.out.println();

        System.out.println("Factorials using recursion:");
        System.out.println(factorialRecur(10));
        System.out.println(factorialRecur(5));
        System.out.println(factorialRecur(0));
        System.out.println(factorialRecur(-1));
    }
}
