package com.kausha.algo.leetcode;

// https://leetcode.com/problems/single-number/
// Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
public class SingleNumber {

	public static void main(String[] args) {
		SingleNumber sn = new SingleNumber();
		//int[] nums = new int[] {2, 1, 2};
		//int[] nums = new int[] {4,1,2,1,2};
		int[] nums = new int[] {1};
		System.out.println(sn.singleNumber(nums));
	}
	
	public int singleNumber(int[] nums) {
		int single = 0;
		for(int i=0; i < nums.length; i++)
			single = single ^ nums[i];
		
        return single;
    }

}
