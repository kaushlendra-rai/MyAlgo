package com.kausha.algo.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DivideArrayInTwoPartsWithEqualSum {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 21};
		//int[] arr = {2, 5, 6, 7, 10};
		//int[] arr = {1, 5, 6};
		
		List<Integer> firstHalf = divideArrayInEqualParts(arr);
		System.out.println(" DP firstHalf = " + firstHalf);
		
		List<Integer> firstHalfBasic = divideArrayInEqualParts_Basic_Exponential(arr);
		System.out.println(" Basic firstHalf = " + firstHalfBasic);
	}
	
	private static List<Integer> divideArrayInEqualParts_Basic_Exponential(int[] arr) {
		int sum = 0;
		for(int num : arr)
			sum += num;
		
		if(sum%2 != 0)
			return Collections.EMPTY_LIST;
		
		sum = sum/2;
		
		List<Integer> half = divideArrayInEqualParts_Basic(arr, sum, 0);
		
		return half;
	}

	private static List<Integer> divideArrayInEqualParts_Basic(int[] arr, int sum, int idx) {
		if(sum == 0)
			return new ArrayList<Integer>();
		if(idx == arr.length)
			return null;
		List<Integer> half = divideArrayInEqualParts_Basic(arr, sum-arr[idx], idx+1);
		
		if(half != null) {
			// If a half match is found, add the current number contributing to the half of the array sum.
			half.add(arr[idx]);
		}else {
			half = divideArrayInEqualParts_Basic(arr, sum, idx+1);
		}
		
		return half;
	}
	
	// This is a DP problem
	private static List<Integer> divideArrayInEqualParts(int[] nums) {
		// First find the sum of all numbers
		int sum = 0;
		for(int num : nums)
			sum += num;
		int half = sum/2;
		// We will fill the elements with numbers that can be formed using the current number.
		// We check at every number if we have reached the required sum/2 at every 'x'.
		// x axis: number from 0 - sum
		// y axis: available number in array.
		int[][] grid = new int[nums.length+1][sum];
		//grid[0][0] = 1;
		
		//The index of number from nums at which the sum matched the required value.
		// This would be helpful in tracking the numbers that added to the required sum.
		int lastIndex = 0;
		outer:
		for(int i=1; i<=nums.length; i++) {
			lastIndex = i;
			for(int j=1; j<sum; j++) {
				if(j < nums[i-1])
					grid[i][j] = grid[i-1][j];
				else
					grid[i][j] = nums[i-1] + grid[i-1][j-nums[i-1]];
				
				if(grid[i][j] == half)
					break outer;
			}
		}
		
		if(grid[lastIndex][half] == half)
			System.out.println("Match is Found!!!!!!!!!!!!!!!!");
		else
			return null;
		
		// Find the list of number which form the sum
		// Now we need to track down the numbers that formed the half. We have the last index of nums & the sum to track it.
		List<Integer> halfList = new ArrayList<>();
		while(half > 0) {
			if(grid[lastIndex][half] != grid[lastIndex-1][half]) {
				halfList.add(nums[lastIndex-1]);
				half -= nums[lastIndex-1];
			}
			
			lastIndex--;
		}

		return halfList;
	}
}