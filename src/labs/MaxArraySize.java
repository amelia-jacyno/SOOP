package labs;

import java.util.Scanner;

public class MaxArraySize {
    public static void main(String[] args) {
        final int MAX_RAM = 3076;
        byte[] arr = new byte[MAX_RAM*1000000L > Integer.MAX_VALUE - 2 ? Integer.MAX_VALUE - 2 : MAX_RAM * 1000000];
        System.out.println(arr.length);
        Scanner sc = new Scanner(System.in);
        sc.next();
    }
}
