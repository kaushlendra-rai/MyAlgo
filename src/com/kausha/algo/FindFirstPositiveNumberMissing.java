package com.kausha.algo;

public class FindFirstPositiveNumberMissing {
	public static void main(String[] args) {
		int[] nums = {4, 2, 5,6, 9, 1};
		
		int missingNumber = findLeastPositiveMissingNUmber(nums);
		System.out.println("missingNumber = " + missingNumber);
	}

	private static int findLeastPositiveMissingNUmber(int[] nums) {
		for(int i = 0; i < nums.length; i++)
			if(nums[i] < nums.length && nums[i] > 0)
				nums[nums[i]-1] = nums[nums[i]-1] * -1;
		
		for(int i = 0; i < nums.length; i++)
			if(nums[i] > 0)
				return i + 1;
		
		return 0;
	}
}