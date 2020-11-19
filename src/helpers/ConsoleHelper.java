package helpers;

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

    static void printArr(int[] arr) {
        print("{");
        for (int i = 0; i < arr.length; i++) {
            print(arr[i]);
            if (i != arr.length - 1) {
                print(", ");
            }
        }
        print("}\n");
    }
}
