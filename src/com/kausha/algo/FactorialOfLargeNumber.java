package com.kausha.algo;

import java.math.BigDecimal;

public class FactorialOfLargeNumber {
	public static void main(String[] args) {
		try{
			System.out.println(factorial(100));
			System.out.println(factorial2(100));
		//factorial(10000);
		}catch(Throwable t){
			t.printStackTrace();
		}
	}

	private static String factorial(int num) {
		if (num<1) {
			return "Not a valid number";
		}
		
		int[] factorial = new int[60000];
		for(int i=0; i< factorial.length; i++)
			factorial[i] = -1;
		factorial[factorial.length-1] = 1;
		
		for(int i=2; i<= num; i++) {
			factorial(factorial, i);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i= 0; i < factorial.length;i++) {
			if(factorial[i] >=0)
				sb.append(factorial[i]);
		}
		
		return sb.toString();
	}
	
	private static void factorial(int[] factorial, int number) {
		int carry = 0;
		for(int i= factorial.length-1; i >=0; i--) {
			if(factorial[i] >= 0) {
				int temp = factorial[i] * number + carry;
				factorial[i] = temp % 10;
				carry = temp / 10;
			}else {
				// This is the case when we have exhausted all numbers and are left only with multi-digit carry.
				// We need to handle them at appropriate indexes.
				factorial[i] = carry%10;
				carry = carry/10;
				
				if(carry == 0)
					break;
			}
		}
	}
	
	public static BigDecimal factorial2(int num){
		BigDecimal factorial  = BigDecimal.ONE;
		
		for(int i=2; i <= num; i++)
			factorial = factorial.multiply(BigDecimal.valueOf(i));
		return factorial;
	}
}