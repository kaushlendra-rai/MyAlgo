package com.kausha.algo.leetcode;

import java.util.Stack;

// https://leetcode.com/problems/next-greater-element-ii/
/**
 * Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]),
 *  return the next greater number for every element in nums.

The next greater number of a number x is the first greater number to its traversing-order next in 
the array, which means you could search circularly to find its next greater number. If it doesn't exist,
 return -1 for this number.

 

Example 1:

Input: nums = [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number. 
The second 1's next greater number needs to search circularly, which is also 2.
Example 2:

Input: nums = [1,2,3,4,3]
Output: [2,3,4,-1,4]
 
 * @author sinkar
 *
 */
public class NextGreaterElement_2 {

	public static void main(String[] args) {
		NextGreaterElement_2 nge = new NextGreaterElement_2();
		//int[] nums = new int[] {1, 2, 1};
		// int[] nums = new int[] {1,2,3,4,3}; //  2 3 4 -1 4
		int[] nums = new int[] {1,2, 3, 4}; //  2 3 4 -1
		//int[] nums = new int[] {5, 4, 3, 2, 1}; // [-1,5,5,5,5]
		int[] result = nge.nextGreaterElements(nums);

		for(int num : result)
			System.out.print(" " + num);
	}
	
	public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>(); // Stack maintains the index of numbers
        
        for(int i = 0; i < nums.length*2;) {
        	if(!stack.isEmpty() && nums[i%nums.length] > nums[stack.peek()%nums.length]) {
        		result[stack.pop()%nums.length] = nums[i%nums.length];
        	}else if(i < nums.length)
        		stack.push(i++);
        	else
        		i++;
        }

        //  Any residual number which is still in stack does not have a next larger number. Set value to -1.
        while(!stack.isEmpty()) {
        	result[stack.pop()] = -1;
        }
        
        return result;
    }
}
