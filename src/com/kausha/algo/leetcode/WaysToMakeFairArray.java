package com.kausha.algo.leetcode;

// https://leetcode.com/problems/ways-to-make-a-fair-array/
/**
 * You are given an integer array nums. You can choose exactly one index (0-indexed) and remove the element. Notice that the index of the elements may change after the removal.

For example, if nums = [6,1,7,4,1]:

Choosing to remove index 1 results in nums = [6,7,4,1].
Choosing to remove index 2 results in nums = [6,1,4,1].
Choosing to remove index 4 results in nums = [6,1,7,4].
An array is fair if the sum of the odd-indexed values equals the sum of the even-indexed values.

Return the number of indices that you could choose such that after the removal, nums is fair.
 * @author sinkar
 *
 */
public class WaysToMakeFairArray {

	public static void main(String[] args) {
		WaysToMakeFairArray fa = new WaysToMakeFairArray();
		
		//int[] nums = new int[] {2,1,6,4}; // 1
		// int[] nums = new int[] {1, 1, 1}; // 3
		int[] nums = new int[] {1, 2, 3}; // 0
		System.out.println(fa.waysToMakeFair(nums));
	}

	public int waysToMakeFair(int[] nums) {
		int even = 0;
		int odd = 0;
		for(int i = 0; i < nums.length; i++) {
			if(i%2 == 0)
				even += nums[i];
			else
				odd += nums[i];
		}
		int currEven = 0;
		int currOdd = 0;
		
		int ways = 0;
		
		for(int i = 0; i < nums.length; i++) {
			if(i%2 == 0) {
				if(currEven + odd - currOdd == currOdd  + even - currEven - nums[i])
					ways++;
				
				currEven += nums[i];
			}else {
				if(currEven + odd - currOdd - nums[i] == currOdd + even - currEven)
					ways++;
				
				currOdd += nums[i];
			}
		}
		
        return ways;
    }
}
