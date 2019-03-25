package com.kausha.algo;

public class FindSubArrayWithMaximumSum {
	public static void main(String[] args) {
		int[] nums = {-2, -4, -1, -3, -6, -9};
		getMaxSubArray(nums);
	}

	private static void getMaxSubArray(int[] nums){
		// Global sum
		int largestSum = nums[0];
		
		// Local current sum
		int localSum = nums[0];
		
		// Indexes for Max Global sequence
		int startIndex = 0;
		int endIndex = 0;
		
		int startTemp = 0;
		
		for(int i=1; i<nums.length; i++){
			if(localSum < 0){
				localSum = nums[i];
				startTemp = i;
			}else
				localSum += nums[i];
			
			if(largestSum  < localSum){
				largestSum = localSum;
				startIndex = startTemp;
				endIndex = i;
			}
		}
		
		System.out.println("startIndex = " + startIndex);
		System.out.println("endIndex = " + endIndex);
	}
}