package com.kausha.algo.leetcode;

import java.util.Stack;

// https://leetcode.com/problems/number-of-visible-people-in-a-queue/
/**
 * Hard

There are n people standing in a queue, and they numbered from 0 to n - 1 in left to right order.
You are given an array heights of distinct integers where heights[i] represents the height of the ith person.

A person can see another person to their right in the queue if everybody in between is shorter than both
 of them. More formally, the ith person can see the jth person if i < j and
  min(heights[i], heights[j]) > max(heights[i+1], heights[i+2], ..., heights[j-1]).

Return an array answer of length n where answer[i] is the number of people the ith person can see
 to their right in the queue.

 

Example 1:



Input: heights = [10,6,8,5,11,9]
Output: [3,1,2,1,1,0]
Explanation:
Person 0 can see person 1, 2, and 4.
Person 1 can see person 2.
Person 2 can see person 3 and 4.
Person 3 can see person 4.
Person 4 can see person 5.
Person 5 can see no one since nobody is to the right of them.
Example 2:

Input: heights = [5,1,2,3,10]
Output: [4,1,1,1,0]
 

Constraints:

n == heights.length
1 <= n <= 105
1 <= heights[i] <= 105
All the values of heights are unique.
 * @author sinkar
 *
 */
public class NumberOfVisiblePeopleInQueue {

	public static void main(String[] args) {
		NumberOfVisiblePeopleInQueue vp = new NumberOfVisiblePeopleInQueue();
		//int[] nums = new int[] {10,6,8,5,11,9};  // 3 1 2 1 1 0
		int[] nums = new int[] {5,1,2,3,10}; //  4 1 1 1 0
		
		int[] result = vp.canSeePersonsCount(nums);
		for(int num : result)
			System.out.print(" " + num);
	}
	
	public int[] canSeePersonsCount(int[] heights) {
		int[] nums = new int[heights.length];
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i< heights.length;i++) {
			// If the current number is greater than or equal to the head number of stack, it implies
			// that there would be no more numbers that the head can see after the new number. Just increment and pop it.
			while(!stack.isEmpty() && heights[stack.peek()] <= heights[i]) {
				++nums[stack.pop()];
			}
			
			// We reach here if the top number on stack is larger than the current number
			// In such case, we need to increment the number that the number has seen successfully.
			if(!stack.isEmpty())
				++nums[stack.peek()];
			
			// Push the current number on the stack.
			stack.push(i);
		}
		
		return nums;
	}
	
	public int[] canSeePersonsCount_Slow(int[] heights) {
		int[] nums = new int[heights.length];
		for(int i=0; i< heights.length-1; i++) {
			// If the current number is smaller than next number, the count can only be '1'. 
			if(heights[i+1] >= heights[i] ) {
				nums[i] = 1;
				continue;
			}
			
			// We need to consider case of increasing number only.
			// Also, we need to stop in case where the number ahead is larger than or equal to current number
			// because we cannot see beyond that limit.
			int count = 1;
			int nextNum = heights[i+1];
			for(int j=i+2; j < heights.length; j++) {
				if(heights[j] > nextNum) {
					count++;
					nextNum = heights[j];
					
					if(heights[j] >= heights[i] )
						break;
				}
			}
			nums[i] = count;
		}
		
		return nums;
    }

}
