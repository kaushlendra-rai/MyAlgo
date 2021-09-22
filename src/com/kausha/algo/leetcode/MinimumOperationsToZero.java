package com.kausha.algo.leetcode;

// https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
/**
 * You are given an integer array nums and an integer x. In one operation, you can either remove the 
 * leftmost or the rightmost element from the array nums and subtract its value from x. 
 * Note that this modifies the array for future operations.

Return the minimum number of operations to reduce x to exactly 0 if it is possible, otherwise, return -1.

 

Example 1:

Input: nums = [1,1,4,2,3], x = 5
Output: 2
Explanation: The optimal solution is to remove the last two elements to reduce x to zero.
Example 2:

Input: nums = [5,6,7,8,9], x = 4
Output: -1
Example 3:

Input: nums = [3,2,20,1,1,3], x = 10
Output: 5
Explanation: The optimal solution is to remove the last three elements and the first two elements 
(5 operations in total) to reduce x to zero.

 *
 **/

public class MinimumOperationsToZero {
	public static void main(String[] args) {
		MinimumOperationsToZero moz = new MinimumOperationsToZero();
		int[] nums = new int[] {1,1,4,2,3};
		System.out.println(moz.minOperations(nums, 5));
		
		int[] nums2 = new int[] {5,6,7,8,9};
		System.out.println(moz.minOperations(nums2, 4));
		
		int[] nums3 = new int[] {3,2,20,1,1,3};
		System.out.println(moz.minOperations(nums3, 10));
		
		int[] nums4 = new int[] {1, 1};
		System.out.println(moz.minOperations(nums4, 3));
		
		int[] nums5 = new int[] {8828,9581,49,9818,9974,9869,9991,10000,10000,10000,9999,9993,9904,8819,1231,6309};
		System.out.println(moz.minOperations(nums5, 134365));
	}

	// We need to get minimum nums from start & end to sum up to 'x'.
	// Instead, we can convert the question to find the largest sub-array with sum = Sum(nums) - k.
	// The final answer would be nums.length - the largest array length from above.
	public int minOperations(int[] nums, int x) {
		int minOps = 0;
		int currSum = 0;
		for(int num : nums)
			currSum += num;
		
		int sum = currSum -x;
		
		boolean full = false;
		if(sum == 0) {
			full = true;
			sum = currSum;
		}
		
		int start = 0;
		int total=0;
		int idx = 0;
		while(idx < nums.length) {
			if(total + nums[idx] <= sum) {
				total += nums[idx];
				idx++;
			}else if (start < nums.length){
				total -= nums[start];
				start++;
			}else if (start >= nums.length) // If the nums cannot sum up to 'sum' and we reach the end of array, exit
				break;

			if(total == sum && minOps < idx - start) {
				minOps = idx - start;
			}
		}
		// If sum could not be found, return '-1'
		if(minOps == 0)
			return -1;
		
		if(full)
			return minOps;
		else
			return nums.length - minOps;
	}
}
