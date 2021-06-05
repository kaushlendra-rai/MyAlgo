package com.kausha.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/majority-element-ii/
public class MajorityElement_Medium {

	public static void main(String[] args) {
		MajorityElement_Medium me = new MajorityElement_Medium();
		//int[] nums = new int[] {3,2,3};
		//int[] nums = new int[] {2,2,1,1,1,2,2};
		//int[] nums = new int[] {2};
		int[] nums = new int[] {1, 2, 3, 2, 2, 3, 1, 1, 2, 1};
		System.out.println(me.majorityElement(nums));

	}

	public List<Integer> majorityElement(int[] nums) {
		int num1 = nums[0];
		int num2 = 0;
		int cnt1 = 1;
		int cnt2 = 0;
		
		for(int i=1; i < nums.length; i++) {
			if(nums[i] == num1)
				cnt1++;
			else if(nums[i] == num2)
				cnt2++;
			else if(cnt1 <= 0) {
				num1 = nums[i];
				cnt1 = 1;
			}else if(cnt2 <= 0) {
				num2 = nums[i];
				cnt2 = 1;
			}else {
				cnt1--;
				cnt2--;
			}
		}
		
		cnt1 = 0;
		cnt2 = 0;
		// Find the actual frequency of the two most frequent numbers.
		for(int num : nums) {
			if(num == num1)
				cnt1++;
			else if(num == num2)
				cnt2++;
		}
		
		List<Integer> majority = new ArrayList<>();
		if(cnt1 > nums.length/3)
			majority.add(num1);
		if(cnt2 > nums.length/3)
			majority.add(num2);
		
        return majority;
    }
}
