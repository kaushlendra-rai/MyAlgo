package com.kausha.algo.leetcode;

// https://leetcode.com/problems/jump-game-ii/
/**
 * 45. Jump Game II
Medium

5661

216

Add to List

Share
Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Your goal is to reach the last index in the minimum number of jumps.
You can assume that you can always reach the last index.

Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1,
 then 3 steps to the last index.
 * @author sinkar
 *
 */
public class JumpToEndOfArrayMinSteps {

	public static void main(String[] args) {
		//int[] nums = new int[]{2, 3, 1, 1, 4};  // 2
		//int[] nums = new int[]{2, 3, 1, 1, 2, 4, 2, 0, 1, 1};  // 4
		//int[] nums = new int[]{0, 3, 1, 1, 4};  // 0
		//int[] nums = new int[]{1, 0, 3, 1, 1, 4};  // 0
		int[] nums = new int[]{2,3,0,1,4};  // 0
		JumpToEndOfArrayMinSteps cj = new JumpToEndOfArrayMinSteps();
		System.out.println(cj.jump(nums));
	} 
	
	public int jump(int[] nums) {
		int maxCurr = 0;
		int jump = 0;
		int maxRange = 0;
		
		for(int i=0; i < nums.length -1; i++) {
			if(i + nums[i] > maxRange)
				maxRange = i + nums[i];

			// Handle case where we cannot move ahead because of '0' value.
			// e.g. int[] nums = new int[]{1, 0, 3, 1, 1, 4};  // 0   OR    int[] nums = new int[]{0, 3, 1, 1, 4};  // 0  
			if(i == maxRange && nums[i] == 0)
				return 0;
			
			if(i == maxCurr) {
				jump++;
				maxCurr = maxRange;
			}
		}
		
        return jump;
    }
}