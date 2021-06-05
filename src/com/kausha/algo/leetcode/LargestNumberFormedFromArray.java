package com.kausha.algo.leetcode;

public class LargestNumberFormedFromArray {

	public static void main(String[] args) {
		LargestNumberFormedFromArray ln = new LargestNumberFormedFromArray();

		//int[] nums = new int[] {10,2}; // 210
		//int[] nums = new int[] {3,30,34,5,9}; // 9534330
		//int[] nums = new int[] {1}; // 1
//		int[] nums = new int[] {10}; // 10
		int[] nums = new int[] {0, 0}; // 0
		//int[] nums = new int[] {0, 2, 0}; // 200
		//int[] nums = new int[] {0, 0, 0, 1}; // 1000
		System.out.println(ln.largestNumber(nums));
	}

	/**
	 * Another approach apart from below solution was to have a comparator doing the same comparision as below
	 * for Arrays.sort(nums, Comparator<>).
	 * Array.sort is nlogn
	 * 
	 * Below code is O(n^2).
	 * 
	 * @param nums
	 * @return
	 */
	public String largestNumber(int[] nums) {
		for(int i=0; i < nums.length-1; i++) {
			for(int j=i+1; j < nums.length; j++) {
				if(("" + nums[i] + nums[j]).compareTo("" + nums[j] + nums[i]) < 0) {
					// Swap
					int temp = nums[j];
					nums[j]=nums[i];
					nums[i] = temp;
				}
			}
		}
		// Special handling where the nums array has only '0'. In such cases the start '0' index itself will be having '0'
		// So, we return only string '0' directly.
		if(nums[0] == 0)
			return "0";
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i < nums.length; i++)
			sb.append(nums[i]);
		
        return sb.toString();
    }
}
