package labs;

public class Lab02 {
	
	static void quickSort(int[] arr, int lo, int hi) {
		if (lo < hi) {
			int pivot = arr[hi];
			int i = lo - 1;
			for (int j = lo; j < hi; j++) {
				if (arr[j] <= pivot) {
					i++;
					if (arr[j] < arr[i]) {
						int h = arr[i];
						arr[i] = arr[j];
						arr[j] = h;
					}
				}
			}
			arr[hi] = arr[i + 1];
			arr[i + 1] = pivot;
			quickSort(arr, lo, i);
			quickSort(arr, i + 2, hi);
		}
	}

	static int[] calcDigits(int num) {
		int[] result = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		int digit;
		while (num > 0) {
			digit = num % 10;
			result[digit]++;
			num /= 10;
		}
		return result;
	}

	static void printMaxValue(int[] arr) {
		int maxVal = arr[0];
		for (int num : arr) {
			if (num > maxVal) {
				maxVal = num;
			}
		}
		System.out.println(maxVal);
	}

	static void printMaxValue(int[][] arr) {
		int maxVal = arr[0][0];
		for (int[] a : arr) {
			for (int num : a) {
				if (num > maxVal) {
					maxVal = num;
				}
			}
		}
		System.out.println(maxVal);
	}

	static void printMostCommonDigit(int[] arr) {
		int[] digits = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		for (int num : arr) {
			int[] digitCount = calcDigits(num);
			for (int i = 0; i < 10; i++) {
				digits[i] += digitCount[i];
			}
		}
		int resultDigit = -1;
		int resultCount = 0;
		for (int i = 0; i < 10; i++) {
			if (digits[i] > resultCount) {
				resultCount = digits[i];
				resultDigit = i;
			}
		}
		System.out.println(resultDigit);
	}

	static void printMostCommonDigit(int[][] arr) {
		int[] digits = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		for (int[] a : arr) {
			for (int num : a) {
				int[] digitCount = calcDigits(num);
				for (int i = 0; i < 10; i++) {
					digits[i] += digitCount[i];
				}
			}
		}
		int resultDigit = -1;
		int resultCount = 0;
		for (int i = 0; i < 10; i++) {
			if (digits[i] > resultCount) {
				resultCount = digits[i];
				resultDigit = i;
			}
		}
		System.out.println(resultDigit);
	}

	static void printSorted(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
		for (int num : arr) {
			System.out.println(num);
		}
	}

	static void printSorted(int[][] arr) {
		int len = 0;
		for (int[] a : arr) {
			len += a.length;
		}
		int[] newArr = new int[len];
		int i = 0;
		for (int[] a : arr) {
			for (int num : a) {
				newArr[i] = num;
				i++;
			}
		}
		quickSort(newArr, 0, newArr.length - 1);
		for (int num : newArr) {
			System.out.println(num);
		}
	}

	public static void main(String[] args) {
		int oneDim[] = { 1, 10, 23, 87, 14, 1, 6, 177, 71 };
		int twoDim[][] = { { 1, 2, 12, 2 }, { 87 }, { 7, 12, 14 }, { 1, 8, 9, 8, } };
		printMaxValue(oneDim);
		printMaxValue(twoDim);
		printMostCommonDigit(oneDim);
		printMostCommonDigit(twoDim);
		printSorted(oneDim);
		printSorted(twoDim);
	}
}