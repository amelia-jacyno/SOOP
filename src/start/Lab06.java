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
        System.out.println();

        System.out.println("Greatest common divisor using iteration:");
        System.out.println(greatestCommonDivisorIter(49, 14));
        System.out.println(greatestCommonDivisorIter(52, 102));
        System.out.println(greatestCommonDivisorIter(5, 5));
        System.out.println(greatestCommonDivisorIter(-5, 0));
        System.out.println();

        System.out.println("Greatest common divisor using recursion:");
        System.out.println(greatestCommonDivisorRecur(49, 14));
        System.out.println(greatestCommonDivisorRecur(52, 102));
        System.out.println(greatestCommonDivisorRecur(5, 5));
        System.out.println(greatestCommonDivisorRecur(-5, 0));
        System.out.println();

        System.out.println("Sum of positive elements using iteration:");
        System.out.println(sumPositiveElementsIter(new int[]{1, 2, 3, 4, -10, 0, 5, -1}));
        System.out.println(sumPositiveElementsIter(new int[]{-1, -2, -3, 0}));
        System.out.println(sumPositiveElementsIter(new int[]{}));
        System.out.println();

        System.out.println("Sum of positive elements using recursion:");
        System.out.println(sumPositiveElementsRecur(new int[]{1, 2, 3, 4, -10, 0, 5, -1}));
        System.out.println(sumPositiveElementsRecur(new int[]{-1, -2, -3, 0}));
        System.out.println(sumPositiveElementsRecur(new int[]{}));
        System.out.println();
    }
}
