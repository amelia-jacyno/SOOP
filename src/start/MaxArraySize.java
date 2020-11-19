package start;

import java.util.Scanner;

public class MaxArraySize {
    public static void main(String[] args) {
        final int MAX_RAM = 8192;
        int[] arr = new int[MAX_RAM/8*1000000];
        System.out.println(arr.length);
        Scanner sc = new Scanner(System.in);
        sc.next();
    }
}
