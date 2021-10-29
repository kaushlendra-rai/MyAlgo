package com.kausha.algo.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/subarray-sum-equals-k/
/**
 * Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.

 

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
 * @author sinkar
 *
 */
public class CountContinuousSubArrayWithSumK {

	public static void main(String[] args) {
		CountContinuousSubArrayWithSumK sa = new CountContinuousSubArrayWithSumK();
		//int[] nums = new int[] {-1,2,1,-1,3};
		int[] nums = new int[] {3, 4, 7, 2, -3, 1, 4, 2};
		int[] nums2 = new int[] {3, 4, 7, 2, 3, 1, 4, 2};
		int[] nums3 = new int[] {3, 9, -2, 4, 1, -7, 2 , 6, -5, 8, -3, -7, 6, 2, 1};
		//System.out.println(sa.subarraySum(nums, 7));
		//System.out.println(sa.subarraySum_OrderN(nums, 7));
		System.out.println(sa.subarraySum(nums3, 5));
		
		int[] nums4 = new int[] {1, 2, 3};
		System.out.println(sa.subarraySum(nums4, 3));
		
		int[] nums5 = new int[] {1, 1, 1};
		System.out.println(sa.subarraySum(nums5, 2));
		//System.out.println(sa.subarraySum_On_PositiveNumbersOnly(nums2, 7));
	}

	// O(n): Prefix sum approach with HashMap
	public int subarraySum(int[] nums, int k) {
		// We are using Map instead of Set because there are chances where multiple sub-Arrays sum up to same value.
		// In such cases, we need to 
		// Include them in the count as well.
		// The multiple values exists because the sum of some range equals to '0'.
		// Hence their addition to sub-array does not increase/decrease the overall sum. 
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int sum = 0;
		int count=0;
		for(int num : nums) {
			sum += num;
			if(map.containsKey(sum-k))
				count += map.get(sum-k);
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		
		return count;
	}
	
	// O(n) for Positive numbers only.
	public int subarraySum_On_PositiveNumbersOnly(int[] nums, int k) {
		int count = 0;
		int sum = 0;
		int firstIdx = 0;
		
		int i = 0;
		while(i < nums.length) {
			if(k > sum) {
				sum = sum + nums[i];
				i++;
			}
			
			if(sum == k) {
				count++;
				//System.out.println("i = " + i);
			}
				
			if(sum >= k) {
				sum -= nums[firstIdx];
				firstIdx++;
			}
		}
		
		return count;
	}
	
	// Time: O(n^2)
	public int subarraySum_On2(int[] nums, int k) {
		int count = 0;
		
		for(int i=0; i<nums.length; i++) {
			int sum = 0;
			for(int j=i; j < nums.length; j++) {
				sum += nums[j];
				
				if(sum == k)
					count++;
			}
		}
		
		return count;
	}
	public int subarraySum_old(int[] nums, int k) {
		int[] sum = new int[nums.length+1];
		for(int i=1; i <= nums.length; i++)
			sum[i] = sum[i-1] + nums[i-1];
		for(int i=0; i <= nums.length; i++)
			System.out.print(" " + sum[i]);
		System.out.println();
		int start = 0;
		int end = 1;
		int counter = 0;
		
		while(end < sum.length) {
			System.out.println("start:" + start + "  end:" + end + "  sum:" + (sum[end] - sum[start]));
			if(sum[end] - sum[start] == k) {
				System.out.println("Match found");
				counter++;
				end++;
				//start++;
			}else if(sum[end] - sum[start] < k) {
				end++;
			}else
				start++;
		}
		
        return counter;
    }
}
