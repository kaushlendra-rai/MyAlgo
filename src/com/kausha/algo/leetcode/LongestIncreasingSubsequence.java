package com.kausha.algo.leetcode;

// Tushar roy https://www.youtube.com/watch?v=CE2b_-XfVDk
public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] nums = new int[] {3, 4, -1, 0, 6, 2, 3};
		System.out.println(longestIncreasingSubsequence(nums));
	}

	public static int longestIncreasingSubsequence(int[] nums) {
		if(nums == null || nums.length == 1)
			return 0;
		
		int size = 0;
		int[] sequence = new int[nums.length];
		
		// Every number in itself is at least single longest sequence.
		for(int i=0; i< nums.length; i++) {
			sequence[i] = 1;
		}
		
		for(int i=1; i < nums.length; i++) {
			for(int j = 0; j < i; j++) {
				if(nums[i] > nums[j] && sequence[i] <= sequence[j])
					sequence[i] += 1;
			}
		}
		
		// Find the maximum value of sequence.
		for(int i=0; i< sequence.length; i++)
			if(sequence[i] > size)
				size = sequence[i];
		
		return size;
	}
}
