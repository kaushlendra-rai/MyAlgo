package com.kausha.algo;

// http://www.geeksforgeeks.org/replace-every-element-with-the-greatest-on-right-side/
public class ReplaceANumberWithNextGreatestNumberInArray {

	public static void main(String[] args) {
		int[] arr = {3, 1, 5, 9, 13, 7, 4, 2, 6};
		replaceWithNextLargerNum(arr);
	}

	private static void replaceWithNextLargerNum(int[] nums){
		int nextLarger = nums[nums.length-1];
		for(int i = nums.length-2; i >=0 ; i--){
			int temp = nextLarger;
			if(nextLarger < nums[i]){
				nextLarger = nums[i];
			}
			
			nums[i] = temp;
		}
		
		for(int i = 0; i < nums.length; i++){
			System.out.println(nums[i]);
		}
	}
}
