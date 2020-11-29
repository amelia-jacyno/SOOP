package playground.multithreading;

import static playground.multithreading.Factorial.*;

public class Controller {
    public static void main(String[] args) {
        int n = 100000;
        int threads = 16;
        System.out.println("Time to calculate " + n + "!");
        System.out.println("1 thread: " + time(() -> factorial(n)) + " seconds");
        System.out.println(threads + " threads: " + time(() -> factorial(n, 16)) + " seconds");
    }

    public static float time(Action action) {
        long start = System.nanoTime();
        action.run();
        return (System.nanoTime() - start) / 1000000000F;
    }
}
