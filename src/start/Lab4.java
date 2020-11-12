package start;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Lab4 {

	static Scanner input = new Scanner(System.in);
	
	public static void printIntArray(int[] arr) {
		System.out.print("{");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i != arr.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.print("}");
	}

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

	public static int getMinimalElement(int[] arr) {
		int min = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		return min;
	}

	public static int[] getMinimalElements(int[] arr) {
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

	public static int[] getGreaterThan(int[] arr, int limit) {
		ArrayList<Integer> greaterArrList = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > limit) {
				greaterArrList.add(arr[i]);
			}
		}
		int[] greaterArr = new int[greaterArrList.size()];
		for (int i = 0; i < greaterArrList.size(); i++) {
			greaterArr[i] = greaterArrList.get(i);
		}
		return greaterArr;
	}

	public static int[] getRange(int[] arr, int lowerLimit, int upperLimit) {
		ArrayList<Integer> rangeArrList = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= lowerLimit && arr[i] <= upperLimit) {
				rangeArrList.add(arr[i]);
			}
		}
		int[] rangeArr = new int[rangeArrList.size()];
		for (int i = 0; i < rangeArrList.size(); i++) {
			rangeArr[i] = rangeArrList.get(i);
		}
		return rangeArr;
	}

	public static int elementCount(int[] arr, int target) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target) {
				count++;
			}
		}
		return count;
	}

	// result contains elements that are in exactlty one array
	public static int[] uniqueElements(int[] arr1, int[] arr2) {
		ArrayList<Integer> uniqueArrList = new ArrayList<Integer>();
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				if (arr2[j] == arr1[i]) {
					break;
				}
				else if (j == arr2.length - 1) {
					uniqueArrList.add(arr1[i]);
				}
			}
		}
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr1.length; j++) {
				if (arr2[j] == arr1[i]) {
					break;
				}
				else if (j == arr1.length - 1) {
					uniqueArrList.add(arr2[i]);
				}
			}
		}
		int[] uniqueArr = new int[uniqueArrList.size()];
		for (int i = 0; i < uniqueArr.length; i++) {
			uniqueArr[i] = uniqueArrList.get(i);
		}
		return uniqueArr;
	}

	// result contains elements that are in both arrays
	public static int[] commonElements(int[] arr1, int[] arr2) {
		ArrayList<Integer> commonArrList = new ArrayList<Integer>();
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				if (arr2[j] == arr1[i] && !commonArrList.contains(arr1[i])) {
					commonArrList.add(arr1[i]);
					break;
				}
			}
		}
		int[] commonArr = new int[commonArrList.size()];
		for (int i = 0; i < commonArr.length; i++) {
			commonArr[i] = commonArrList.get(i);
		}
		return commonArr;
	}

	public static void fillWith(int[] inOutArr, int fillValue) {
		for (int i = 0; i < inOutArr.length; i++) {
			inOutArr[i] = fillValue;
		}
	}

	// reverse elements on spot
	public static void reverseMe(int[] inOutArr) {
		for (int i = 0; i < inOutArr.length / 2; i++) {
			int temp = inOutArr[i];
			inOutArr[i] = inOutArr[inOutArr.length-i];
			inOutArr[inOutArr.length-i] = temp;
		}
	}

	// return an array with elements in reversed order
	public static int[] returnReversed(int[] inArr) {
		int[] arr = new int[inArr.length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = inArr[arr.length-i];
		}
		return arr;
	}

	// …
	public static void showArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				System.out.print("{");
			}
			System.out.print(arr[i]);
			if (i != arr.length-1) {
				System.out.print(", ");
			} else {
				System.out.print("}\n");
			}
		}
	}

	// return an array with minimal values from each row
	public static int[] getMinimals(int[][] inArr) {
		int[] arr = new int[inArr.length];
		for (int i = 0; i < inArr.length; i++) {
			int min = inArr[i][0];
			for (int j = 0; j < inArr[i].length; j++) {
				if (inArr[i][j] < min) {
					min = inArr[i][j];
				}
				if (j == inArr[i].length-1) {
					arr[i] = min;
				}
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		
		// TESTS
		
		int[] arr = {1, 2, 3, 4, 5};
		showArr(arr);
	}
}
