package com.kausha.algo.leetcode;

public class MajorityElement {

	public static void main(String[] args) {
		MajorityElement me = new MajorityElement();
		//int[] nums = new int[] {3,2,3};
		//int[] nums = new int[] {2,2,1,1,1,2,2};
		int[] nums = new int[] {2};
		System.out.println(me.majorityElement(nums));

	}

	public int majorityElement(int[] nums) {
		int maxCounter = 1;
		int num = nums[0];
		
		for(int i=1; i < nums.length; i++) {
			if(nums[i] == num)
				maxCounter++;
			else {
				if(maxCounter == 0) {
					maxCounter = 1;
					num = nums[i];
				}else
					maxCounter--;
			}
		}
		
        return num;
    }
}
