package com.kausha.algo.dp;

import java.util.HashMap;

/**
 * We have unlimited supply of coins of given denominations
 * 1. If the current denomination is 1 then return 1. This is the base case.
2. If current denomination is 20, set next denomination as 10; if current denomination is 10, 
	set next denomination as 5 and if current denomination is 5, set next denomination as 1.
3. Now implement the recurrence relation: 
	numberOfWays(amount, denom) =  numberOfWays(amount - 0*denom, nextDenom) + 
		numberOfWays(amount - 1*denom, nextDenom) + ... + numberOfWays(0, nextDenom) using a while loop.
 * @author sinkar
 *
 */
public class CoinChangeTotalWays {
	public static void main(String[] args) {
		int coins[] = {1, 2, 5, 10, 20};
		System.out.println(makeChange(coins, 7));
	}

	public static long makeChange(int[] coins, int amount){
		return makeChange(coins, amount, 0, new HashMap<String, Long>());
	}

	private static long makeChange(int[] coins, int amount, int index, HashMap<String, Long> hashMap) {
		
		if(amount == 0)
			return 1;
		
		if(index >= coins.length)
			return 0;
		
		int amountWithCoin = 0;
		String amountKey = amount + "_" + index; 
		long ways = 0;
		
		// HashMap being used for memoization
		if(hashMap.containsKey(amountKey))
			return hashMap.get(amountKey);
		
		/**
		 * Loop over a given coin denomination till total sum for that denomination * denominationCount.
		 * Example for amount = 79, coins = {25, 20, 10, 5, 2, 1}
		 * Loop: 25:0 + 79 from other coins  +  25:1 + 79 from other coins  + 25:2 + 79 from other coins  + 25:3 + 79 from other coins 
		 * (We cannot have 4th 25 coin as it exceeds the amount 75)
		 * 
		 */
		
		while(amount >= amountWithCoin){
			int remaining = amount - amountWithCoin;
			ways += makeChange(coins, remaining, index + 1, hashMap);
			amountWithCoin += coins[index];
		}
		
		hashMap.put(amountKey, ways);
		
		return ways;
	}
}