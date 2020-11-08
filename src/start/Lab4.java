package start;

import java.util.ArrayList;
import java.util.Scanner;

public class Lab4 {

	static Scanner input = new Scanner(System.in);

	public static int[] readArray(int size) {
		int[] arr = new int[size];
		String str = input.nextLine();
		String[] strArr = str.split("\\s+");
		for (int i = 0; i < size; i++) {
			if (i < strArr.length) {
				arr[i] = Integer.parseInt(strArr[i]);
			} else {
				arr[i] = 0;
			}
		}
		for (int i = 0; i < size; i++) {
			System.out.println(arr[i]);
		}
		return arr;
	}

	public static int[] appendArrays(int[] a1, int[] a2) {
	}

	public int getMinimalElement(int[] inArr) {
	}

	public int[] getMinimalElements(int[] inArr) {
	}

	public int[] getGreaterThan(int[] inArr, int limit) {
	}

	public int[] getRange(int[] inArr, int lowerLimit, int upperLimit) {
	}

	public int elementCount(int[] inArr, int what2Look4) {
	}

	// result contains elements that are in exactlty one array
	public static int[] uniqueElements(int[] a1, int[] a2) {
	}

	// result contains elements that are in both arrays
	public static int[] commonElements(int[] a1, int[] a2) {
	}

	public static void fillWith(int[] inOutArr, int fillValue) {
	}

	// reverse elements on spot
	public static void reverseMe(int[] inOutArr) {
	}

	// return an array with elements in reversed order
	public static int[] returnReversed(int[] inArr) {
	}

	// …
	public static void showArr(int[] arrIn) {
	}

	// return an array with minimal values from each row
	public static int[] getMinimals(int[][] inArr) {
	}

	public static void main(String[] args) {
		readArray(Integer.parseInt(input.nextLine()));
	}
}
