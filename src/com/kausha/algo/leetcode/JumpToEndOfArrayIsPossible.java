package com.kausha.algo.leetcode;

// https://leetcode.com/problems/jump-game/
/**
 * 55. Jump Game
Medium

7723

475

Add to List

Share
You are given an integer array nums. You are initially positioned at the array's first index, 
and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * @author sinkar
 *
 */
public class JumpToEndOfArrayIsPossible {

	public static void main(String[] args) {
		//int[] nums = new int[]{2,3,1,1,4}; // true
		int[] nums = new int[]{3,2,1,0,4};  // false
		//int[] nums = new int[]{1, 1, 2, 5, 2, 1, 0, 0, 1, 3};  // true
		//int[] nums = new int[]{1, 1, 2, 3, 2, 1, 0, 0, 1, 3};  // false
		//int[] nums = new int[]{0, 1, 1, 2};  // false
		JumpToEndOfArrayIsPossible cj = new JumpToEndOfArrayIsPossible();
		System.out.println(cj.canJump(nums));
	}
	
	public boolean canJump(int[] nums) {
		int maxJump = 0;
		
		for(int i=0; i< nums.length-1; i++) {
			// If we cannot proceed ahead, return false.
			if(nums[i] == 0 && i == maxJump)
				return false;

			if(i + nums[i] > maxJump)
				maxJump = i + nums[i];
		}
		
		return true;
    }

}
