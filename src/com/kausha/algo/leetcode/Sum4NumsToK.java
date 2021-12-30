package com.kausha.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/4sum/
public class Sum4NumsToK {

	public static void main(String[] args) {
		Sum4NumsToK fs = new Sum4NumsToK();
//		int[] nums = new int[] {1,0,-1,0,-2,2};
//		int target = 0;
		int[] nums = new int[] {2, 2, 2 ,2, 2};
		int target = 8;
		System.out.println(fs.fourSum(nums, target));
	}

	public List<List<Integer>> fourSum(int[] nums, int target) {
		if(nums.length <4)
			return new ArrayList<>();
		
		List<List<Integer>> groups = new ArrayList<>();
		Set<String> set = new HashSet<>();
        Arrays.sort(nums);
        
        for(int i=0; i< nums.length-3; i++) {
        	for(int j=i+1; j < nums.length- 2; j++) {
        		int low = j+1;
        		int high = nums.length-1;
        		
        		int targetSum = target-nums[i] - nums[j];
        		
        		while(low < high) {
        			if(nums[low] + nums[high] == targetSum) {
        				List<Integer> num = new ArrayList<>();
        				num.add(nums[i]);
        				num.add(nums[j]);
        				num.add(nums[low]);
        				num.add(nums[high]);
        				
        				String key = nums[i] + "," + nums[j] + "," + nums[low] + "," + nums[high]; 
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
        }
        
		return groups;
    }
}
