package com.kausha.algo.dp;

// Dynamic Programming - Find Sets Of Numbers That Add Up To 16
// We need to find the count of sets of numbers that sum up to say '16'.
public class NumberSumUpTo16FromArray_Recursion {

	public static void main(String[] args) {
		int[] nums = new int[] {2, 4, 6, 10}; // Expected answer: 2 for :: {2, 4, 10} & {6, 10}
		int sum = 16;

		System.out.println(CountSetOfNumsToSum(nums, sum));
	}

	// Assuming sorted array numbers.
	private static int CountSetOfNumsToSum(int[] nums, int sum) {
		if(sum < nums[0] )
			return 0;
		
		return findCountForSum(nums, sum, nums.length-1);
	}

	private static int findCountForSum(int[] nums, int sum, int index) {
		if (sum == 0)
			return 1;
		if(index<0 || (index == 0 && nums[0] < sum))
			return 0;
		// The current number is larger than required sum. Hence ignore current index and 
		// check the sum with rest of the numbers
		else if(sum < nums[index])
			return findCountForSum(nums, sum, index-1);
		else
			// In on case we include the current number for teh sub set & in the other we ignore it.
			return findCountForSum(nums, sum-nums[index], index-1) +
					findCountForSum(nums, sum, index-1);
	}
}