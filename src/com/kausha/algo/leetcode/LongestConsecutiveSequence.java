package com.kausha.algo.leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/longest-consecutive-sequence/
public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
		//int[] nums = new int[] {100,4,200,1,3,2};
		//int[] nums = new int[] {0,3,7,2,5,8,4,6,0,1};
		
		//int[] nums = new int[] {};
		int[] nums = new int[] {1,2,0,1};
		System.out.println(lcs.longestConsecutive(nums));
	}
	
	public int longestConsecutive(int[] nums) {
		Arrays.sort(nums);
		int start = 0;
		int maxLen = 0;
		
		// Manage duplicates in the consecutive length with counter.
		int duplicateCounter = 0;
		for(int i=1; i< nums.length; i++) {
			if(nums[i-1] == nums[i])
				duplicateCounter++;
			else if(nums[i-1] + 1 != nums[i]) {
				if(i - start - duplicateCounter > maxLen)
					maxLen = i-start - duplicateCounter;
				
				start =i;
				duplicateCounter = 0;
			}
		}
		
		if(nums.length - start - duplicateCounter> maxLen)
			maxLen = nums.length - start - duplicateCounter;
		
        return maxLen;
    }
}
