package com.kausha.algo.dp;

public class FibonacciMemozation {
	public static void main(String[] args) {
		int num = 6;
		System.out.println(getFibonacci(num, new int[num+1]));
	}

	private static int getFibonacci(int i, int[] memo) {
		if(memo[i] != 0)
			return memo[i];
		
		int fab = 1;
		if (i > 2){
			fab = getFibonacci(i-2, memo) + getFibonacci(i-1, memo);
			memo[i] = fab;
		}
		
		return fab;
	}
}