package start;

import java.lang.Math;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Lab3 {
	
	public static final double PI = 3.141592;
	
	public static int[] concatArrays(int[] arr1, int[] arr2) {
		
		int[] resArr = new int[arr1.length + arr2.length];
		
		for (int i = 0; i < arr1.length; i++) {
			resArr[i] = arr1[i];
		}
		for (int i = 0; i < arr2.length; i++) {
			resArr[i + arr1.length] = arr2[i];
		}
		
		return resArr;
	}
	
	public static double round(double value, int places) {
		
	    BigDecimal bd = BigDecimal.valueOf(value);
	    bd = bd.setScale(places, RoundingMode.DOWN);
	    
	    return bd.doubleValue();
	}
	
	static double calcPi(long accuracy) {
	
		double pi = 1;
		boolean isCorrect = false;
		
		for (double i = 1; i <= accuracy; i++) {
			pi *= ((2*i)*(2*i)) / ((2*i-1)*(2*i+1));
			if (compareToPi(pi*2) && !isCorrect) {
				System.out.println("6 digits using Gregory's method are correct for n = " + (int)i);
				isCorrect = true;
			}
		}
		
		return pi*2;
	}
	
	static double calcPi2(long accuracy) {
		
		double pi = 0;
		boolean isCorrect = false;
		
		for (long i = 0; i <= accuracy; i++) {
			pi += Math.pow(-1, i) / (2*i+1);
			if (compareToPi(pi*4) && !isCorrect) {
				System.out.println("6 digits using Wallis' method are correct for n = " + i);
				isCorrect = true;
			}
		}
		
		return pi*4;
	}
	
	static boolean compareToPi(double pi) {
		
		pi = round(pi, 6);
		
		return PI == pi;
	}

	public static void main(String[] args) {
		
		long acc1 = 5000000;
		int acc2 = 5000000;
		int[] arr1 = {1, 2, 3, 4, 5};
		int[] arr2 = {6, 7, 8};
		
		
		double pi1 = calcPi(acc1);
		double pi2 = calcPi2(acc2);
		System.out.println("PI calculated using Wallis' method: " + pi1);
		System.out.println("PI calculated using Gregory's method: " + pi2);
	
		int[] arr3 = concatArrays(arr1, arr2);
		System.out.println("Concat of test arrays:");
		System.out.print("{");
		for (int i = 0; i < arr3.length; i++) {
			System.out.print(arr3[i]);
			if (i != arr3.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.print("}");
	}

}