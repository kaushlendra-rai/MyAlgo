package com.kausha.algo.leetcode;

//https://leetcode.com/problems/sort-colors/
/**
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 * @author sinkar
 *
 */
public class SortRGBColorArray {
	public static void main(String[] args) {
		SortRGBColorArray sc = new SortRGBColorArray();
		
		int[] nums = new int[] {2,0,2,0,1,0};
		//int[] nums = new int[] {2,0,2,1,1,0};
		//int[] nums = new int[] {2, 2, 2, 1, 1};
		//int[] nums = new int[] {2, 0, 1};
		sc.sortColors(nums);
		
		for(int num : nums)
			System.out.print(" " + num);
	}

	public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int counter = 0;
        
        while(counter <= end) {
        	if(nums[counter] == 0) {
        		//System.out.println("####  0");
        		swap(nums, start++, counter++);
        	}else if(nums[counter] == 2) {
        		//System.out.println("####  2");
        		swap(nums, end--, counter);
        	}else {
        		System.out.println("####  1");
        		counter++;
        	}
        }
    }
	
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j]=temp;
	}
}
