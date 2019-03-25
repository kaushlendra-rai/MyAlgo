package com.kausha.algo;

// http://www.geeksforgeeks.org/rearrange-given-array-place/
public class ReorderNumbersinOrderN {

	/**
	 * Rearrange an array so that arr[i] becomes arr[arr[i]] with O(1) extra space
	 * Input: arr[]  = {3, 2, 0, 1}
	 * Output: arr[] = {1, 0, 3, 2}
	 */
	public static void main(String[] args) {
		int arr[] = {3, 2, 0, 1};

		rearrangeArray(arr);
	}
	
	private static void rearrangeArray(int[] nums){
		int index = 0;
		int shuffleCount = 0;
		
		for(int i=0; i < nums.length; i++){
			if(nums[i] != nums[nums[i]]){
				index = i;
				shuffleCount++;
			}
		}
		
		int temp = nums[index];
		
		for(int i=0; i < shuffleCount-1; i++){
			int nextIndex = nums[index];
			nums[index] = nums[nums[index]];
			index = nextIndex;
		}
		
		nums[index] = temp;
		
		for(int num : nums)
			System.out.println(num);
	}
}