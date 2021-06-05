package com.kausha.algo.leetcode;

// https://leetcode.com/problems/first-missing-positive/
public class FirstMissingPositive {

	public static void main(String[] args) {
		FirstMissingPositive fmp = new FirstMissingPositive();
		int[] nums = new int[] {3, 4, -1, 1};
		//int[] nums = new int[] {1, 2, 0};
		//int[] nums = new int[] {7, 8, 9, 10};
		//int[] nums = new int[] {1, 2};
		//int[] nums = new int[] {-1, -2};
		System.out.println(fmp.firstMissingPositive(nums));

	}
	
	// This approach has O(n) time and (1) space.
	public int firstMissingPositive(int[] nums) {
		if(nums.length == 0)
			return 1;
		for(int i=0; i< nums.length; i++)
			if(nums[i] < 0)
				nums[i] = 0;
		
		for(int i=0; i< nums.length; i++) {
			int idx = Math.abs(nums[i]);
			if(idx > 0 && idx <= nums.length)
				nums[idx-1] = -1 * nums[idx-1];
		}
		for(int i=0; i< nums.length; i++)
			System.out.println("******* nums[i]: " + nums[i]);
		
		int missingValue = nums.length +1;
		
		for(int i=0; i< nums.length; i++) {
			System.out.println("nums[i]: " + nums[i]);
			if(nums[i] >= 0) {
				missingValue = i+1;
				break;
			}
		}
        return missingValue;
    }
	
	// This method uses O(n) BUT 'n' extra space.
	// Follow up: Could you implement an algorithm that runs in O(n) time and uses constant extra space?
	public int firstMissingPositive_ExtraSpace(int[] nums) {
		if(nums.length == 0)
			return 1;
		
		int[] missing = new int[nums.length];
		for(int i=0; i< nums.length; i++)
			if(nums[i] > 0 && nums[i] <= nums.length)
				missing[nums[i]-1] = 1;
		
		int missingValue = -1;
		
		for(int i=0; i< nums.length; i++)
			if(missing[i] == 0) {
				missingValue = i+1;
				break;
			}
		
		if(missingValue == -1)
			missingValue = nums.length+1;
		
        return missingValue;
    }
}
