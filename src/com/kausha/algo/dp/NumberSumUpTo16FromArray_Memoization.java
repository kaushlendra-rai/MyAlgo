package com.kausha.algo.dp;

import java.util.HashMap;
import java.util.Map;

// Dynamic Programming - Find Sets Of Numbers That Add Up To 16
// We need to find the count of sets of numbers that sum up to say '16'.
public class NumberSumUpTo16FromArray_Memoization {

	public static void main(String[] args) {
		int[] nums = new int[] {2, 4, 6, 10}; // Expected answer: 2 for :: {2, 4, 10} & {6, 10}
		int sum = 16;

		System.out.println(CountSetOfNumsToSum(nums, sum));
	}

	// Assuming sorted array numbers.
	private static int CountSetOfNumsToSum(int[] nums, int sum) {
		if(sum < nums[0] )
			return 0;
		
		return findCountForSum(nums, sum, nums.length-1, new HashMap<String, Integer>());
	}

	// Here we cache the number of ways a given value could be computed from a given index.
	// This helps in saving the repetitive computations for same number over multiple reciursions.
	private static int findCountForSum(int[] nums, int sum, int index, Map<String, Integer> mem) {
		String key = sum + ":" + index;
		// Return the value if present in the cache.
		if(mem.get(key) != null)
			return mem.get(key);
		
		if (sum == 0)
			return 1;
		int count = 0;
		if(index<0 || (index == 0 && nums[0] < sum))
			return 0;
		// The current number is larger than required sum. Hence ignore current index and 
		// check the sum with rest of the numbers

		else if(sum < nums[index])
			count= findCountForSum(nums, sum, index-1, mem);
		else
			// In on case we include the current number for teh sub set & in the other we ignore it.
			count = findCountForSum(nums, sum-nums[index], index-1, mem) +
					findCountForSum(nums, sum, index-1, mem);
		
		mem.put(key, count);
		
		return count;
	}
}