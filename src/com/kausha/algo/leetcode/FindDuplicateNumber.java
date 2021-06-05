package com.kausha.algo.leetcode;

// https://leetcode.com/problems/find-the-duplicate-number/
public class FindDuplicateNumber {

	public static void main(String[] args) {
		FindDuplicateNumber dup = new FindDuplicateNumber();
		//int[] nums = new int[] {1, 2, 3, 4, 7, 5, 3, 6};
		//int[] nums = new int[]{1,3,4,2,2};
		//int[] nums = new int[]{3,1,3,4,2};
		//int[] nums = new int[]{1,1};
		int[] nums = new int[]{1,1,2};
		System.out.println(dup.findDuplicate(nums));

	}
	
	public int findDuplicate(int[] nums) {
		int duplicate = -1;
        for(int i =0; i < nums.length; i++) {
        	int num = Math.abs(nums[i]);
        	if(nums[num] < 0) {
        		duplicate = num;
        		break;
        	}else
        		nums[num] = nums[num] * -1;
        }
        
        return duplicate;
    }

}
