package com.kausha.algo.dp;

/**
 * Given 3 numbers {1, 3, 5}, we need to tell
the total number of ways we can form a number 'N' 
using the sum of the given three numbers.
(allowing repetitions and different arrangements).
 * @author sinkar
 *
 */
public class CoinChangeCountMemoization {
	static int[] count;
	public static void main(String[] args) {
		count = new int[10];
		System.out.println(countTotalWays(5));
	}

	private static int countTotalWays(int num) {
		if(num <0)
			return 0;
		if(num == 0)
			return 1;
		
		if(count[num] > 0)
			return count[num];
		
		count[num] = countTotalWays(num-1) + countTotalWays(num-3) + countTotalWays(num-5);
		
		return count[num];
	}

}
