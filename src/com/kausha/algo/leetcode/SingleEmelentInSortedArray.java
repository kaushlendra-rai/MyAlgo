package com.kausha.algo.leetcode;

// https://leetcode.com/problems/single-element-in-a-sorted-array/
/**
 * You are given a sorted array consisting of only integers where every element appears exactly twice,
 *  except for one element which appears exactly once. Find this single element that appears only once.

Follow up: Your solution should run in O(log n) time and O(1) space.

 

Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: nums = [3,3,7,7,10,11,11]
Output: 10


 * @author sinkar
 *
 */
public class SingleEmelentInSortedArray {

	public static void main(String[] args) {
		SingleEmelentInSortedArray snd = new SingleEmelentInSortedArray();

		int[] nums = new int[] {1,1,2,3,3,4,4,8,8}; // 2
		//int[] nums = new int[] {3,3,7,7,10,11,11}; // 10
		
		//int[] nums = new int[] {1, 3,3,7,7,11,11}; // 1
		//int[] nums = new int[] {1, 1, 2, 2, 3};
		System.out.println(snd.singleNonDuplicate(nums));
	}

	// Log(n)
	public int singleNonDuplicate(int[] nums) {
		if(nums.length == 1)
			return nums[0];

		// Check uniqueness at boundary
		if(nums[0] != nums[1])
			return nums[0];
		if(nums[nums.length-1] != nums[nums.length-2])
			return nums[nums.length-1];
		
		int start = 0;
		int end = nums.length-1;
		int mid = 0;
		while(start <= end) {
			mid = start + (end-start)/2;
			// Match found
			if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1])
				break;
		
			if((mid%2 != 0 && nums[mid] == nums[mid-1]) || (mid%2 == 0 && nums[mid] == nums[mid+1]))
				start = mid+1;
			else
				end = mid-1;
		}
		
		return nums[mid];
	}
}
