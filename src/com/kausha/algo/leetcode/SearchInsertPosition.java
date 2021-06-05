package com.kausha.algo.leetcode;

// https://leetcode.com/problems/search-insert-position/

public class SearchInsertPosition {

	public static void main(String[] args) {
		//int[] nums = new int[] {1,3,5,6};
		int[] nums = new int[] {1};
		SearchInsertPosition insert = new SearchInsertPosition();
		System.out.println(insert.searchInsert(nums, 0));
	}

	public int searchInsert(int[] nums, int target) {
		if(nums == null || nums.length == 0)
			return 0;
		
		int start = 0;
		int end = nums.length-1;
		
		while(start < end) {
			int mid = start + (end-start)/2;
			
			if(nums[mid] == target)
				return mid;
			else if(nums[mid] < target){
				start = mid+1;
			}else
				end = mid-1;
		}
		if(nums[start] < target)
			start = start+1;
		return start;
    }
}
