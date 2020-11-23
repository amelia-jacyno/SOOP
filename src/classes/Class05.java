package classes;

public class Class05 {
    public static int maxValueIteration(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int a : arr) {
            if (a > max) {
                max = a;
            }
        }
        return max;
    }

    public static int maxValueRecursion(int[] arr, int index) {
        if (index < arr.length) {
            return Math.max(arr[index], maxValueRecursion(arr, index + 1));
        } else if (arr.length != 0) {
            return arr[arr.length - 1];
        } else {
            return Integer.MIN_VALUE;
        }
    }

    public static void greaterThanIteration(int[] arr, int limit) {
        for (int a : arr) {
            if (a > limit) {
                System.out.print(a + " ");
            }
        }
        System.out.println(" (iteration)");
    }

    public static void greaterThanRecursion(int[] arr, int limit, int index) {
        if (index < arr.length) {
            if (arr[index] > limit) {
                System.out.print(arr[index] + " ");
            }
            greaterThanRecursion(arr, limit, index + 1);
        } else {
            System.out.println(" (recursion)");
        }
    }

    public static int totalIteration(int[] arr, int lowerLimit, int upperLimit) {
        int sum = 0;
        for (int a : arr) {
            if (a >= lowerLimit && a <= upperLimit) {
                sum = sum + a;
            }
        }
        return sum;
    }

    public static int totalRecursion(int[] arr, int lowerLimit, int upperLimit, int index) {
        return totalRecursion(arr, lowerLimit, upperLimit, 0, 0);
    }

    public static int totalRecursion(int[] arr, int lowerLimit, int upperLimit, int index, int total) {
        if (index < arr.length) {
            if (arr[index] >= lowerLimit && arr[index] <= upperLimit) {
                return totalRecursion(arr, lowerLimit, upperLimit, index + 1, total + arr[index]);
            } else {
                return totalRecursion(arr, lowerLimit, upperLimit, index + 1, total);
            }
        } else {
            return total;
        }

    }

    public static void printIteration(int[] arr) {
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println(" (iteration)");
    }

    public static void printRecursion(int[] arr, int index) {
        if (index < arr.length) {
            System.out.print(arr[index] + " ");
            printRecursion(arr, index + 1);
        } else {
            System.out.println(" (recursion)");
        }
    }

    public static void printReversedIteration(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[arr.length - 1 - i] + " ");
        }
        System.out.println(" (iteration)");
    }

    public static void printReversedRecursion(int[] arr, int index) {
        if (index < arr.length) {
            printReversedRecursion(arr, index + 1);
            System.out.print(arr[index] + " ");
        }
    }

    public static int occurrencesIteration(int[] arr, int value) {
        int occurrences = 0;
        for (int a : arr) {
            if (a == value) {
                occurrences++;
            }
        }
        return occurrences;
    }

    public static int occurrencesRecursion(int[] arr, int value, int index) {
        return occurrencesRecursion(arr, value, index, 0);
    }

    public static int occurrencesRecursion(int[] arr, int value, int index, int occurrences) {
        if (index < arr.length) {
            if (arr[index] == value) {
                return occurrencesRecursion(arr, value, index + 1, occurrences + 1);
            } else {
                return occurrencesRecursion(arr, value, index + 1, occurrences);
            }
        } else {
            return occurrences;
        }

    }

    public static void main(String[] args) {

        int[] test = {1, 7, 7, 4};

        System.out.println("Max value (iteration): " + maxValueIteration(test));
        System.out.println("max value (recursion): " + maxValueRecursion(test, 0));

        int lim = 2;
        System.out.println("\nElements greater than " + lim + ":");
        greaterThanIteration(test, lim);
        greaterThanRecursion(test, lim, 0);

        int low = 3;
        int high = 5;
        System.out.println("\nSum values between " + low + " and " + high + " equals: ");
        System.out.println(totalIteration(test, low, high) + " (iteration)");
        System.out.println(totalRecursion(test, low, high, 0) + " (recursion)");

        System.out.println("\nPrint array: ");
        printIteration(test);
        printRecursion(test, 0);

        System.out.println("\nPrint reversed array: ");
        printReversedIteration(test);
        printReversedRecursion(test, 0);
        System.out.println(" (recursion)");

        int value = 7;
        System.out.println("\nNumber of occurrences of " + value + ": ");
        System.out.println(occurrencesIteration(test, value) + " (iteration)");
        System.out.println(occurrencesRecursion(test, value, 0) + " (recursion)");

    }

}

