package com.kausha.algo.leetcode;

// https://leetcode.com/problems/find-peak-element/
/**
 * A peak element is an element that is strictly greater than its neighbors.

Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -Infinity.

 

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
 * @author sinkar
 *
 */

// One clarification MUST be asked, what happens if there is a repeated number sequence around the kind-of-peak, e.g.
// 
public class FindPeakElementLeetCode {

	public static void main(String[] args) {
	//int[] nums = new int[] {2, 3, 4, 6, 9}; // Ans 4
	//int[] nums = new int[] {2, 3, 6, 6, 5}; //  -1 because the peak-to-be is around number '6', but there is no actual peak
	// . Do ask how it is to ber reported.
	int[] nums = new int[] {2, 3, 4, 6, 5};
	System.out.println(findPeak(nums));
	}
	
	public static int findPeak(int[] nums) {
		if(nums == null || nums.length == 0)
			return -1;
		else if(nums.length == 1)
			return 0;
		
		
		// Handle edge-cases of start & end numbers.
		if(nums[0] > nums[1])
			return 0;
		if(nums[nums.length-1] > nums[nums.length-2])
			return nums.length-1;
		
		int peak = -1;
		for(int i=1; i < nums.length-1; i++) {
			if(nums[i] > nums[i-1] && nums[i] > nums[i+1])
				peak = i;
		}
		return peak;
	}
}
