package com.kausha.algo.leetcode;

public class MissingNumber {

	public static void main(String[] args) {
		MissingNumber mn = new MissingNumber();
		//int[] nums = new int[] {0, 1, 2, 3, 5};	
		//int[] nums = new int[] {3, 0, 1};
		//int[] nums = new int[] {0, 1};
		//int[] nums = new int[] {9,6,4,2,3,5,7,0,1};
		int[] nums = new int[] {0};
		System.out.println(mn.missingNumber(nums));

	}

	public int missingNumber(int[] nums) {
		int missing = nums.length;
		for(int i=0; i < nums.length; i++)
			missing = missing ^ i ^nums[i];
		
        return missing;
	}
}
