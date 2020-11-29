package playground.multithreading;

import java.math.BigDecimal;

public class Factorial extends Thread {
    private final int id, threads, n;
    private BigDecimal[] result;

    public Factorial(int n, BigDecimal[] result, int id, int threads) {
        this.id = id;
        this.threads = threads;
        this.n = n;
        this.result = result;
        this.start();
    }

    public static BigDecimal factorial(int n, int threads) {
        BigDecimal[] results = new BigDecimal[threads];
        Factorial[] factorials = new Factorial[threads];
        for (int i = 0; i < threads; i++) {
            factorials[i] = new Factorial(n, results, i, threads);
        }

        while (true) {
            boolean isAlive = false;
            for (Factorial f : factorials) {
                if (f.isAlive()) {
                    isAlive = true;
                    break;
                }
            }
            if (!isAlive) break;
        }

        BigDecimal result = new BigDecimal(1);
        for (BigDecimal r : results) {
            result = result.multiply(r);
        }
        return result;
    }

    public static BigDecimal factorial(int n) {
        BigDecimal result = new BigDecimal(1);
        for (int i = 2; i <= n; i ++) {
            BigDecimal temp = new BigDecimal(i);
            result = result.multiply(temp);
        }
        return result;
    }

    public void run() {
        result[id] = new BigDecimal(1);
        for (int i = id + 2; i <= n; i += threads) {
            BigDecimal temp = new BigDecimal(i);
            result[id] = result[id].multiply(temp);
        }
    }
}
