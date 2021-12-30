package com.kausha.algo.leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/3sum-closest/
/**
 * Given an integer array nums of length n and an integer target, find three integers in nums such that
 *  the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.

 

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Example 2:

Input: nums = [0,0,0], target = 1
Output: 0
 * @author sinkar
 *
 */
public class Sum3ClosestToK {

	public static void main(String[] args) {
		Sum3ClosestToK sc = new Sum3ClosestToK();
		//int[] nums = new int[] {-1,2,1,-4};
		//int target = 1;
		int[] nums = new int[] {0,0,0};
		int target = 1;
		
		System.out.println(sc.threeSumClosest(nums, target));
	}
	
	public int threeSumClosest(int[] nums, int target) {
        int minDiff = Integer.MAX_VALUE;
        int minNum = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0; i< nums.length-2; i++) {
        	int low = i+1;
        	int high = nums.length-1;
        	
        	while(low < high) {
	        	int diff = Math.abs(nums[i] + nums[low] + nums[high] - target);
	        	//System.out.println("minDiff: " + minDiff + "   diff: " + diff);
	        	if(diff < minDiff) {
	        		minDiff = diff;
	        		minNum = nums[i] + nums[low] + nums[high];
	        	}
	        	
	        	if(nums[i] + nums[low] + nums[high] < target)
	        		low++;
	        	else
	        		high--;
        	}
        }
        
        return minNum;
    }

}
