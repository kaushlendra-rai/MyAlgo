package com.kausha.algo.leetcode;

// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class FirstAndLastIndexOfNumberInSortedArray {

	public static void main(String[] args) {
		int[] nums = new int[] {5, 7, 7, 8, 8, 10};
		
		FirstAndLastIndexOfNumberInSortedArray firstLast = new FirstAndLastIndexOfNumberInSortedArray();
		int[] idx = firstLast.searchRange(nums, 8);
		System.out.println("Range: " + idx[0] + " , " + idx[1]);
	}
	
	public int[] searchRange(int[] nums, int target) {
		int[] result = new int[] {-1, -1};
		if(nums.length == 0)
			return result;

		result[0]=searchRange(nums, target, true, 0);
		if(result[0] != -1)
			result[1]=searchRange(nums, target, false, result[0]);
		
		return result;
    }

	private int searchRange(int[] nums, int target, boolean left, int start) {
		int end = nums.length-1;
		
		while(start <= end) {
			int mid = start + (end-start)/2;
			if(target == nums[mid]) {
				System.out.println("mid = " + mid);
				if(left) {
					if((mid > 0 && nums[mid-1] != target) || mid == 0)
						return mid;
					else
						end = mid-1;
				}else {
					if((mid < nums.length-1 && nums[mid+1] != target) || mid == nums.length -1)
						return mid;
					else
						start = mid+1;
				}
			}else if(target < nums[mid]){
				end = mid-1;
			}else
				start = mid+1;
		}
		
		return -1;
    }
}
