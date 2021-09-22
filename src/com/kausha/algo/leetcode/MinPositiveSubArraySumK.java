package com.kausha.algo.leetcode;

// https://leetcode.com/problems/minimum-size-subarray-sum/
/**
 * Given an array of positive integers nums and a positive integer target, return the minimal length
 *  of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than 
 *  or equal to target. If there is no such subarray, return 0 instead.

 

Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
 * @author sinkar
 *
 */
public class MinPositiveSubArraySumK {
	public static void main(String[] args) {
		MinPositiveSubArraySumK msk = new MinPositiveSubArraySumK();
		int[] nums = new int[] {1,1,4,2,3};
		System.out.println(msk.minSubArrayLen(5, nums));
		
		int[] nums1 = new int[]{2,3,1,2,4,3};
		System.out.println(msk.minSubArrayLen(7, nums1));
		
		int[] nums2 = new int[]{1,4,4};
		System.out.println(msk.minSubArrayLen(4, nums2));

		System.out.println(msk.minSubArrayLen(9, nums2));
		
		int[] nums3 = new int[]{1,1,1,1,1,1,1,1};
		System.out.println(msk.minSubArrayLen(11, nums3));
		
		int[] nums4 = new int[]{1, 2, 3, 4, 5};
		System.out.println(msk.minSubArrayLen(11, nums4));
	}
	
	public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        
        int sum = 0;
        int start = 0;
        int idx = 0;
        while(idx < nums.length && start < nums.length) {
        	if (sum + nums[idx] >= target) {
    			minLen = minLen < idx - start ? minLen : idx - start;
    		}
        	
        	if(sum + nums[idx] <= target) {
        		sum += nums[idx++];
        	}else {
        		sum = sum- nums[start++];
        	}
        }
        
        if(minLen == Integer.MAX_VALUE)
        	return 0;
        
        return minLen+1;
    }

}
