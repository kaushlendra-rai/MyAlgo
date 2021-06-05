package com.kausha.algo.leetcode;

// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
public class MinimumInRotatedSortedArray {

	public static void main(String[] args) {
		MinimumInRotatedSortedArray rs = new MinimumInRotatedSortedArray();
		// int[] nums = new int[] {3, 4, 5, 1, 2};
		//int[] nums = new int[] {2, 3, 4, 5, 1};
		//int[] nums = new int[] {2, 3, 4, 5};
		//int[] nums = new int[] {2, 1};
		//int[] nums = new int[] {4,5,6,7,0,1,2};
		int[] nums = new int[] {11,13,15,17};
		System.out.println(rs.findMin(nums));
	}

	public int findMin(int[] nums) {
		int start = 0;
		int end = nums.length-1;
		// Handle edge cases if smallest is at the boundaries of array.
		if(nums.length == 1 || nums[0] <= nums[nums.length-1])
			return nums[0];
		else if(nums[0] > nums[nums.length-1] && nums[nums.length-2] > nums[nums.length-1]) {
			return nums[nums.length-1];
		}
		while(start <= end) {
			int mid = start + (end-start)/2;
			//System.out.println("start: " + start + " , end: " + end + ", mid: " + mid);
			if((nums[mid-1] > nums[mid] && nums[mid+1] > nums[mid])) {
				return nums[mid];
			}if(nums[start] > nums[mid]) {
				// Smallest number towards left of mid.
				end = mid;
			}else {
				start = mid;
			}
		}
		
        return nums[0];
    }
}
