package com.kausha.algo;

// http://stackoverflow.com/questions/19720349/find-next-higher-element-in-an-array-for-each-element
public class ReplaceANumberWithNextLargerNumberInArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {3, 1, 5, 9, 13, 7, 4, 2, 6, 14};
		replaceWithNextLargerNum(arr);
	}

	private static void replaceWithNextLargerNum(int[] nums){
		for(int i = 0; i < nums.length-1; i++){
			int nextLarger = nums[i];
			for(int j=i+1; j < nums.length; j++){
				if((nextLarger > nums[j] && nums[i] < nums[j]) 
						|| (nextLarger == nums[i] && nums[i] < nums[j]))
					nextLarger = nums[j];
			}
			
			if(nums[i] < nextLarger)
				nums[i] = nextLarger; 
		}
		
		for(int i = 0; i < nums.length; i++){
			System.out.println(nums[i]);
		}
	}
}
