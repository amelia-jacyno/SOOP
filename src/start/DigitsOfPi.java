package start;

import java.lang.Math;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class DigitsOfPi {
	
	public static final int ACC = 10000;
	public static final int ITER = 1000;
	
	public static BigDecimal calculateFactorial (int number) {
        BigDecimal factorial = BigDecimal.ONE;
        for (int i = 1; i <= number; i++) {
            factorial = factorial.multiply(new BigDecimal(i));
        }
        return factorial;
    }
	
public static BigDecimal middleAgesCalcPi(long accuracy) {
		
		BigDecimal pi = new BigDecimal("0");
		
		for (double i = 0; i < accuracy; i++) {
			pi = pi.add(BigDecimal.valueOf(Math.pow(-3, -i) / (2*i+1)));
		}
		
		return pi.multiply(BigDecimal.valueOf(Math.sqrt(12)));
	}
	
	public static BigDecimal betterCalcPi(long accuracy) {
		int k1 = 545140134;
		int k2 = 13591409;
		int k3 = 640320;
		int k4 = 100100025;
		int k5 = 327843840;
		int k6 = 53360;
		
		BigDecimal s = new BigDecimal("0");
		for (int i = 0; i < accuracy; i++) {
			BigDecimal numerator = BigDecimal.valueOf(k2 + (i*k1)).multiply(calculateFactorial(6*i));
			BigDecimal denominator = calculateFactorial(i).pow(3).multiply(calculateFactorial(3*i)).
					multiply(BigDecimal.valueOf(8l*k4*k5).pow(i));
			s = s.add(BigDecimal.valueOf(-1).pow(i).multiply(numerator).divide(denominator, ACC, RoundingMode.HALF_EVEN));
		}
		
		return BigDecimal.valueOf(k6).multiply(BigDecimal.valueOf(k3).sqrt(new MathContext(ACC))).divide(s, ACC, RoundingMode.HALF_EVEN);
	}

	public static void main(String[] args) {
		BigDecimal pi = betterCalcPi(ITER);
		System.out.println(pi);
		System.out.println("3.141592653589793238462643383279502884197169399375105820974944592307816406286");
	}

}
