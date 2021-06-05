package com.kausha.algo.leetcode;

// https://leetcode.com/problems/rotate-array/
// Given an array, rotate the array to the right by k steps, where k is non-negative.
public class RotateArrayNTimes {

	public static void main(String[] args) {
		RotateArrayNTimes ra = new RotateArrayNTimes();
//		int[] nums = new int[] {1, 2, 3, 4, 5, 6, 7};
//		 ra.rotate(nums, 3);
//		int[] nums = new int[] {1, 2, 3, 4};
//		 ra.rotate(nums, 2);
		int[] nums = new int[] {1, 2};
		 ra.rotate(nums, 3);
//		int[] nums = new int[] {-1,-100,3,99};
//		ra.rotate(nums, 2);
		for(int num: nums)
			System.out.print(num + " ");
	}

	// O(n). Total rotations done here is only 'n'.
	public void rotate(int[] nums, int k) {
		k = k%nums.length;
		if(nums.length <2 || k == 0)
			return;
		
		// We are rotating the array in place in O(n) time;
		// The objective here is to first hold the number at index which needs to be replaced.
		// Next we replace the number.
		// We then put the number held at it's (oldIndex+k)%nums.length (array rotation).
		int counter = 0;
		for(int n=0; n <k; n++) {
			int temp = nums[n];
			int nextIdx = n + k;
	        for(int i=n; i<nums.length; i++) {
	        	int nextTmp = nums[nextIdx];
	        	nums[nextIdx] = temp;
	        	temp = nextTmp;
	        	counter++;
	        	// If we have rotated all the nums.length numbers, we are done.
	        	if(counter == nums.length)
	        		return;
	        	nextIdx = (nextIdx + k)%nums.length;
	        	// If a cycle is detected, break the loop and continue with next number to it.
	        	if(nextIdx == n)
	        		break;
	        }

	        nums[nextIdx] = temp;
	        counter++;
	     // If we have rotated all the nums.length numbers, we are done.
	        if(counter == nums.length)
        		return;
		}
    }
	
	
	// The below rotation algo traverses the array twice... is O(n)
	public void rotate_2N(int[] nums, int k) {
		k = k%nums.length;
		if(nums.length <2 || k == 0)
			return;
		
		ReverseArr(nums, 0, nums.length - k-1);
		ReverseArr(nums, nums.length - k, nums.length-1);
		ReverseArr(nums, 0, nums.length-1);
    }
	
	private void ReverseArr(int[] nums, int start, int end) {
		for(int i=start; i<=start + (end-start)/2; i++) {
			int temp = nums[i];
			nums[i] = nums[end + start -i];
			nums[end + start -i] = temp;
		}
    }

	public void rotate_failed(int[] nums, int k) {
		// We are rotating the array in place in O(n) time;
		// The objective here is to first hold the number at index which needs to be replaced.
		// Next we replace the number.
		// We then put the number held at it's (oldIndex+k)%nums.length (array rotation).
		int temp = nums[0];
		int nextIdx = k;
        for(int i=0; i<nums.length; i++) {
        	System.out.println("temp: " + temp + " , nextIdx: " + nextIdx);
        	int nextTmp = nums[nextIdx];
        	nums[nextIdx] = temp;
        	temp = nextTmp;
        	nextIdx = (nextIdx + k)%nums.length;
        }
    }
}
