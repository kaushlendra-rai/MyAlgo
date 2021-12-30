package com.kausha.algo.leetcode;

// https://leetcode.com/problems/max-consecutive-ones/
/**
 * Given a binary array nums, return the maximum number of consecutive 1's in the array.

 

Example 1:

Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum 
number of consecutive 1s is 3.
Example 2:

Input: nums = [1,0,1,1,0,1]
Output: 2
 

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
 * @author sinkar
 *
 */
public class MaxConsecutiveOnes {

	public static void main(String[] args) {
		MaxConsecutiveOnes mc = new MaxConsecutiveOnes();
		System.out.println(mc.findMaxConsecutiveOnes(new int[] {1,1,0,1,1,1}));
		System.out.println(mc.findMaxConsecutiveOnes(new int[] {1,0,1,1,0,1}));
		System.out.println(mc.findMaxConsecutiveOnes(new int[] {1,0,1,1,0,0, 0}));
		System.out.println(mc.findMaxConsecutiveOnes(new int[] {1}));
		System.out.println(mc.findMaxConsecutiveOnes(new int[] {0}));
	}
	
	public int findMaxConsecutiveOnes(int[] nums) {
        int max = nums[0];
        int count = nums[0];
        
        for(int i=1; i < nums.length; i++) {
        	if(nums[i] == 1 && nums[i-1] == 1) {
        		count++;
        	}else if(nums[i] == 0) {
        		max = max < count ? count : max;
        		count = 0;
        	}else {
        		count = 1;
        	}
        }
        // Handle case where trailing numbers are '1'.
        max = max < count ? count : max;
        
        return max;
    }

}
