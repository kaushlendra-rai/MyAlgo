package com.kausha.algo;

import java.math.BigDecimal;

public class FactorialOfLargeNumber {
	public static void main(String[] args) {
		try{
		factorial(10000);
		//System.out.println(factorial2(15000));
		}catch(Throwable t){
			t.printStackTrace();
		}
	}
	
	public static void factorial(int num){
		// This variable is used to keep track of actual digits of factorial in the result array.
		// Alternatively, we could have also tried keeping all numbers of result as '-1' and check before every addition if the number is negative.
		// If negative, add +1 to it to balance the -1. However it would add an unnecessary extra computation just to find end of actual number of factorial.
		int factorialDigits  = 1;
		
		int[] result = new int[60000];
		
		result[0] = 1;
		
		for(int i=2; i <= num; i++) {
			factorialDigits = calcFactorial(i, result, factorialDigits);
		}
		
		for(int i=factorialDigits; i >0 ; i--)
			System.out.print(result[i-1]);
		System.out.println();
	}
	
	/**
	 * DO the multiplication old ways as we used to do it on paper.
	 * Maintaining numbers from right to left instead of left to right to make computation easier to visualize.
	 * @param i
	 * @param result
	 * @param factorialDigits
	 * @return
	 */
	private static int calcFactorial(int i, int[] result, int factorialDigits) {
		int carry = 0;
		
		for(int j = 0; j <factorialDigits; j++) {
			int subMultiply = result[j] * i + carry;
			result[j] = subMultiply %10;
			
			carry = subMultiply / 10;
		}
		
		// Handle case where carry is left over after multiplication with all digits have been done.
		while(carry !=0) {
			result[factorialDigits++] = carry%10;
			carry = carry/10;
		}
		
		return factorialDigits;
	}

	public static BigDecimal factorial2(int num){
		BigDecimal factorial  = BigDecimal.ONE;
		
		for(int i=2; i <= num; i++)
			factorial = factorial.multiply(BigDecimal.valueOf(i));
		return factorial;
	}
}