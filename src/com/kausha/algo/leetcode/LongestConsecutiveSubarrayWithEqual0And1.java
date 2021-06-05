package com.kausha.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/contiguous-array/
// https://www.youtube.com/watch?v=9ZyLjjk536U
/**
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 * @author sinkar
 *
 */
public class LongestConsecutiveSubarrayWithEqual0And1 {
	public static void main(String[] args) {
		LongestConsecutiveSubarrayWithEqual0And1 lc = new LongestConsecutiveSubarrayWithEqual0And1();
		
		//int[] nums = new int[] {0, 1};
		//int[] nums = new int[] {0, 1, 1, 0};
		//int[] nums = new int[] {0, 1, 0};
		int[] nums = new int[] {1, 1, 0, 0, 1, 1, 0, 1, 1};
		System.out.println(lc.findMaxLength(nums));
	}

	
	public int findMaxLength(int[] nums) {
        int maxLen = 0;
        Map<Integer, Integer> sumMap = new HashMap<>();
        int sum = 0;
        // for '0' we add '-1' & for '1' we add '1'.
        for(int i=0; i<nums.length; i++) {
        	sum += nums[i] == 0 ? -1:1;
        	if(sum == 0) {
        		if(maxLen < (i+1))
        			maxLen = i+1;
        	}
        	else if(sumMap.get(sum) == null) {
        		sumMap.put(sum, i);
        	}else {
        		if(maxLen < (i - sumMap.get(sum)))
        			maxLen = i - sumMap.get(sum);
        	}
        }
        
        return maxLen;
    }
}
