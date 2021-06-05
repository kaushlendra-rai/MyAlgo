package com.kausha.algo.leetcode;

import java.util.Arrays;

public class TwoNumberSum {

	public static void main(String[] args) {
//		int[] pair = twoSum(new int[] {2,7,11,15}, 9);
		int[] pair = twoSum(new int[] {-1, 0}, -1);
		//int[] pair = twoSum(new int[] {3, 3}, 6);
		System.out.println("pairs : " + pair[0] + " , " + pair[1]);
	}

	public static int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length < 2)
        	return new int[] {};
        
        int start = 0;
        int end = numbers.length-1;

        while(start < end) {
        	int sum = numbers[start] + numbers[end];
        	if(sum == target)
        		return new int[] {start+1, end+1};
        	else if(sum < target)
        		start++;
        	else
        		end--;
        }
        
        return new int[] {};
    }
}
