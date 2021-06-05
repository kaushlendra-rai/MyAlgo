package com.kausha.algo.leetcode;

// https://leetcode.com/problems/longest-increasing-subsequence/
public class LargestIncreasingSubsequence {

	public static void main(String[] args) {
		LargestIncreasingSubsequence lis = new LargestIncreasingSubsequence();
		
		//int[] nums = new int[] {10,9,2,5,3,7,101,18};
		//int[] nums = new int[] {3, 4, -1, 0, 6, 2, 3};
		//int[] nums = new int[] {10};
		//int[] nums = new int[] {0,1,0,3,2,3};
		int[] nums = new int[] {7, 7, 7, 7, 7, 7};
		
		System.out.println(lis.lengthOfLIS(nums));
	}

	public int lengthOfLIS(int[] nums) {
		int[] seq = new int[nums.length];
		for(int i=0; i < nums.length; i++)
			seq[i] = 1;
		
		for(int i=1; i < nums.length; i++) {
			for(int j=0; j < i; j++) {
				if(nums[i] > nums[j] && seq[j] >= seq[i])
					seq[i] = seq[j] +1;
			}
		}
		
		int lis = seq[0];
		for(int i=1; i < nums.length; i++)
			if(seq[i] > lis)
				lis = seq[i];
		
        return lis;
    }
}
