package com.kausha.algo.dp;

public class CoinChangeMinimumCoinsDP {

	public static void main(String[] args) {
		int coins[] = {1, 2, 5, 10, 20};
		System.out.println(makeChange(coins, 9));
	}

	private static int makeChange(int[] coins, int value) {
		if(coins == null || coins.length == 0)
			return -1;
		// We use memoization.
		int[] minCoins = new int[value + 1];
		// base-case '0' is 0
		minCoins[0] = 0;
		for(int j=1; j<= value; j++)
			minCoins[j] = Integer.MAX_VALUE;
		
		for(int i=0; i < coins.length; i++) {
			for(int j=1; j<= value; j++) {
				if(j >= coins[i])
					minCoins[j] = Math.min(minCoins[j - coins[i]] + 1, minCoins[j]);
			}
		}
		
		return minCoins[value];
	}
}
