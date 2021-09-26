package com.kausha.algo.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-consecutive-sequence/
/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 * @author sinkar
 *
 */
public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
		//int[] nums = new int[] {100,4,200,1,3,2};
		int[] nums = new int[] {0,3,7,2,5,8,4,6,0,1};
		
		//int[] nums = new int[] {};
		//int[] nums = new int[] {1,2,0,1};
		System.out.println(lcs.longestConsecutive(nums));
	}

	
	/**
	 * O(n)
	 * We maintain a Set of numbers.
	 * We check if there exists next number in the set.
	 * If not, then we start moving back and check the sequence of numbers that exists for current number
	 * and maintain the longest sequence and return it. 
	 * @param nums
	 * @return
	 */
	public int longestConsecutive(int[] nums) {
		int max = 0;
		Set<Integer> set = new HashSet<>();
		for(int num : nums)
			set.add(num);
		
		for(int num : nums) {
			int count = 0;
			if(!set.contains(num+1)) {
				while(set.contains(num--))
					count++;
				if(count > max)
					max = count;
			}
			
		}
		return max;
	}
	// Below code is nLogn
	public int longestConsecutive_nLogn(int[] nums) {
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
