package com.kausha.algo.leetcode;

// https://leetcode.com/problems/move-zeroes/
/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

 

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]
 * @author sinkar
 *
 */
public class MoveZeros {

	public static void main(String[] args) {
		MoveZeros mz = new MoveZeros();
		
		//int[] nums = new int[] {0,0,1,1, 1, 0,1};  // Output: [1,3,12,0,0]
		//int[] nums = new int[] {0,1,0,3,12};  // Output: [1,3,12,0,0]
		//int[] nums = new int[] {4,1,3,3,12};  // Output: {4,1,3,3,12}
		//int[] nums = new int[] {0, 0, 0};  // Output: {0, 0, 0}
		//int[] nums = new int[] {1, 1, 0};  // Output: {1, 1, 0}
		//int[] nums = new int[] {1};  // Output: {1}
		//int[] nums = new int[] {0};  // Output: {0}
		int[] nums = new int[] {1, 0};  // Output: {1, 0}
		
		mz.moveZeroes(nums);

		for(int num : nums)
			System.out.println(num);
	}

	public void moveZeroes(int[] nums) {
        int counter = 0;
        for(int i=0; i < nums.length; i++) {
        	if(nums[i] != 0)
        		nums[counter++] = nums[i];
        }
        for(int i=counter; i < nums.length; i++) {
        	nums[i] = 0;
        }
    }
}
