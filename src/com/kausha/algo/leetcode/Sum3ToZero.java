package com.kausha.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/3sum/
/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that 
 * i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Example 2:

Input: nums = []
Output: []
 * @param nums
 * @return
 */
public class Sum3ToZero {

	public static void main(String[] args) {
		Sum3ToZero sz = new Sum3ToZero();
		//int nums[] = new int[] {-1,0,1,2,-1,-4};
		//int nums[] = new int[] {};
		int nums[] = new int[] {-1,-1,-2,2,0,-4, 4, 4, 4, -4, -4, 2};
		
		System.out.println(sz.threeSum(nums));

	}

	public List<List<Integer>> threeSum(int[] nums) {
		if(nums.length <3)
			return new ArrayList<>();
		
		List<List<Integer>> groups = new ArrayList<>();
		Set<String> set = new HashSet<>();
        Arrays.sort(nums);
        
        for(int i=0; i< nums.length-2; i++) {
        	int low = i+1;
    		int high = nums.length-1;
    		
    		int targetSum = nums[i] *-1;
    		
    		while(low < high) {
    			if(nums[low] + nums[high] == targetSum) {
    				List<Integer> num = new ArrayList<>();
    				num.add(nums[i]);
    				num.add(nums[low]);
    				num.add(nums[high]);
    				
    				String key = nums[i] + "," + nums[low] + "," + nums[high]; 
    				if(!set.contains(key)) {
    					groups.add(num);
    					set.add(key);
    				}
    				low++;
    				high--;
    			}else if(nums[low] + nums[high] < targetSum) {
    				low++;
    			}else
    				high--;
    		}
    	}
        
        return groups;
    }
}
