package com.kausha.algo;

public class SortNConsecutiveNumberInAnArray {

	public static void main(String[] args) {
		int arr[] = {1, 0, 3, 2, 4};

		rearrangeArray(arr);
	}

	// This method also handles scenarios where a number is 
	// already in-place and does not require any kind of swapping.
	private static void rearrangeArray(int[] nums){
		int temp = nums[0];
		for(int i=0; i<nums.length-1; i++){
			int currVal = nums[temp];
			if(temp == nums[temp]){
				if(temp == nums.length-1)
					temp = nums[0];
				else
					temp = nums[temp +1];
				
				i--;
				
				continue;
			}
			
			nums[temp] = temp;
			temp = currVal;
		}
		
		nums[temp] = temp;
		for(int i=0; i<nums.length; i++)
			System.out.println(nums[i]);
	}
}