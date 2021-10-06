package com.kausha.algo.leetcode;

import java.util.*;

// https://leetcode.com/problems/permutations/
/**
 Given an array nums of distinct integers, return all the possible permutations. 
 You can return the answer in any order.

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]

 * @author sinkar
 *
 */
public class Permutations {

	public static void main(String[] args) {
		Permutations p = new Permutations();
		int[] nums = new int[] {1, 2, 3};
		//int[] nums = new int[] {0};
		System.out.println(p.permute(nums));
	}

	public List<List<Integer>> permute(int[] arrNums) {
        List<Integer> nums = new ArrayList<>();
        for(int num : arrNums)
        	nums.add(num);
        
        List<List<Integer>> result = new ArrayList<>();
        permute(result, nums, new ArrayList<>());
        
		return result;
    }
	
	public void permute(List<List<Integer>> result, List<Integer> remaining, List<Integer> curr) {
        if(remaining.isEmpty()) {
        	result.add(curr);
        }else {
        	for(int i=0; i < remaining.size(); i++) {
        		List<Integer> nums = new ArrayList<>();
        		List<Integer> newCurr = new ArrayList<>(curr);
        		for(int j=0; j < remaining.size(); j++)
        			if(i != j)
        				nums.add(remaining.get(j));
        		newCurr.add(remaining.get(i));
        		permute(result, nums, newCurr);
        	}
        }
    }
}
