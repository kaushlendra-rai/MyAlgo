package com.kausha.algo.leetcode;

// https://leetcode.com/problems/remove-element/
public class RemoveElement {

	public static void main(String[] args) {
		RemoveElement re = new RemoveElement();
		//int[] nums = new int[] {3,2,2,3};
		int[] nums = new int[] {};
		int idx = re.removeElement(nums, 2);
		for(int i=0; i<idx; i++)
			System.out.println(nums[i]);
	}

	public int removeElement(int[] nums, int val) {
        int len = 0;
        for(int i=0; i < nums.length; i++)
        	if(nums[i] != val)
        		nums[len++] = nums[i];
        
        return len;
    }
}
