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
		return arr;
	}

	public static int[] appendArrays(int[] a1, int[] a2) {
		int[] arr = new int[a1.length + a2.length];
		for (int i = 0; i < arr.length; i++) {
			if (i < a1.length) {
				arr[i] = a1[i];
			} else {
				arr[i] = a2[i-a1.length];
			}
		}
		return arr;
	}

	public int getMinimalElement(int[] arr) {
		int min = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		return min;
	}

	public int[] getMinimalElements(int[] arr) {
		ArrayList<Integer> minArrList = new ArrayList<Integer>();
		int min = arr[0];
		minArrList.add(min);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
				minArrList.clear();
				minArrList.add(min);
			}
		}
		int[] minArr = new int[minArrList.size()];
		for (int i = 0; i < minArrList.size(); i++) {
			minArr[i] = minArrList.get(i);
		}
		return minArr;
	}

	public int[] getGreaterThan(int[] arr, int limit) {
		ArrayList<Integer> greaterArrList = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > limit) {
				greaterArrList.add(arr[i]);
			}
		}
		int[] minArr = new int[minArrList.size()];
		for (int i = 0; i < minArrList.size(); i++) {
			minArr[i] = minArrList.get(i);
		}
		return minArr;
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
		
		// TESTS
		
		int[] arr1 = readArray(Integer.parseInt(input.nextLine()));
		int[] arr2 = readArray(Integer.parseInt(input.nextLine()));
		int[] arr = appendArrays(arr1, arr2);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
