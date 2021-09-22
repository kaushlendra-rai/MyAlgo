package com.kausha.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/subarray-sum-equals-k/
/**
 * Given an array of integers nums and an integer k, return the total number of continuous
 *  subarrays whose sum equals to k.

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
 

Constraints:

1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107
 * @author sinkar
 *
 */
public class CountSubArraySumEqualK {
	public static void main(String[] args) {
		CountSubArraySumEqualK cak = new CountSubArraySumEqualK();
		int[] nums = new int[] {1,2,3};
		System.out.println(cak.subarraySum(nums, 3));
		
		int[] nums1 = new int[] {1,1,1};
		System.out.println(cak.subarraySum(nums1, 2));
		
		int[] nums2 = new int[] {1,2,3};
		System.out.println(cak.subarraySum(nums2, 6));
		
		System.out.println(cak.subarraySum(nums2, 8));
		
		int[] nums3 = new int[] {1,-1,0};
		System.out.println(cak.subarraySum(nums3, 0));
	
	}

	public int subarraySum(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        
        for(int i=0; i< nums.length; i++) {
        	sum = sum + nums[i];
        	int key = sum - k;
        	if(map.containsKey(key))
        		count += map.get(key);

        	map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}
