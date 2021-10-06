package com.kausha.algo.leetcode;

// https://leetcode.com/problems/find-pivot-index/
/**
 * Given an array of integers nums, calculate the pivot index of this array.

The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all
 the numbers strictly to the index's right.

If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left.
 This also applies to the right edge of the array.

Return the leftmost pivot index. If no such index exists, return -1.

 

Example 1:

Input: nums = [1,7,3,6,5,6]
Output: 3
Explanation:
The pivot index is 3.
Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
Right sum = nums[4] + nums[5] = 5 + 6 = 11
Example 2:

Input: nums = [1,2,3]
Output: -1
Explanation:
There is no index that satisfies the conditions in the problem statement.


 * @author sinkar
 *
 */
public class PivotalIndex {

	public static void main(String[] args) {
		PivotalIndex pi = new PivotalIndex();
		
		//int[] nums = new int[] {1,7,3,6,5,6}; // 3
		//int[] nums = new int[] {1,2, 3}; // -1
		//int[] nums = new int[] {2,1, -1}; // 0
		//int[] nums = new int[] {2,1, -1}; // 0
		//int[] nums = new int[] {-1,-1,1,1,0,0};
		//int[] nums = new int[] {-1,0,1,1,-1,1};
		int[] nums = new int[] {-1,-1,0,1,1,-1};
		System.out.println(pi.pivotIndex(nums));

	}

	public int pivotIndex(int[] nums) {
		// Boundary condition
		if(nums.length == 1)
			return 0;
		else if(nums.length == 2)
			return -1;
		
		int[] sum = new int[nums.length];
		sum[0] = nums[0];
		for(int i=1; i < nums.length; i++)
			sum[i] = sum[i-1] + nums[i];
		
		// Handle case where the pivot is around the 1st number.
		if(sum[nums.length-1]-sum[0] == 0)
			return 0;
		
		for(int i=1; i < nums.length-1; i++) {
			if(sum[i-1] == sum[nums.length-1] - sum[i])
				return i;
		}

		// Handle case where the pivot is around the last number.
		if(sum[nums.length-2] == 0) {
				return nums.length-1;
		}

		return -1;
    }
}
