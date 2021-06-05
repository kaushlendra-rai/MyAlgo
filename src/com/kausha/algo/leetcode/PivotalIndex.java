package com.kausha.algo.leetcode;

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
