package com.kausha.algo.leetcode;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

// https://leetcode.com/problems/sliding-window-maximum/
/**
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. 
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Example 2:

Input: nums = [1], k = 1
Output: [1]
Example 3:

Input: nums = [1,-1], k = 1
Output: [1,-1]
Example 4:

Input: nums = [9,11], k = 2
Output: [11]
Example 5:

Input: nums = [4,-2], k = 2
Output: [4]
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length
 * @author sinkar
 *
 */
public class SlidingWindowMax {

	public static void main(String[] args) {
		SlidingWindowMax sw = new SlidingWindowMax();
		//int[] nums = new int[] {1,3,-1,-3,5,3,6,7};
		//int[] nums = new int[] {1, 2, 3};
		int[] nums = new int[] {1, 3, 1, 2, 0, 5};
		int[] max = sw.maxSlidingWindow(nums,3);
		for(int num : max)
			System.out.println(num + ", ");
	}

	public int[] maxSlidingWindow(int[] nums, int k) {
	    int[] result = new int[nums.length-k+1];
	 
	    // Deque can be worked on both sides top and bottom.
	    Deque<Integer> deque = new LinkedList<>();
	    for(int i=0; i<nums.length; i++){
	        if(!deque.isEmpty()&&deque.peekFirst()==i-k) 
	            deque.poll();
	 
	        while(!deque.isEmpty()&&nums[deque.peekLast()]<nums[i])
	            deque.removeLast();
	 
	        deque.offer(i);
	 
	        if(i+1>=k)
	            result[i+1-k]=nums[deque.peek()];
	    }
	 
	    return result;
	}
	
	
	public int[] maxSlidingWindow_rep(int[] nums, int k) {
		// total number of max blocks = nums.length - k + 1
		int[] slidingMax = new int[nums.length - k + 1];

		Deque<Integer> queue = new LinkedList<>();
		int counter = 0;
		for(int i=0; i<nums.length; i++) {
			if(i < k-1)
				queue.offer(nums[i]);
			else {
				queue.offer(nums[i]);
				slidingMax[counter++] = queue.peek();
				queue.remove(nums[i-k+1]);
			}
		}
		
        return slidingMax;
    }
	
	// O(nlogn)
	public int[] maxSlidingWindow_needsMoreImprovement(int[] nums, int k) {
		// total number of max blocks = nums.length - k + 1
		int[] slidingMax = new int[nums.length - k + 1];

		Queue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>(){
			public int compare(Integer int1, Integer int2) {
				return int2-int1;
			}
		});
		int counter = 0;
		for(int i=0; i<nums.length; i++) {
			if(i < k-1)
				queue.offer(nums[i]);
			else {
				queue.offer(nums[i]);
				slidingMax[counter++] = queue.peek();
				queue.remove(nums[i-k+1]);
			}
		}
		
        return slidingMax;
    }

	// O(n*n)
	public int[] maxSlidingWindow_CorrectButNeedsPerformanceImprovement(int[] nums, int k) {
		// total number of max blocks = nums.length - k + 1
		int[] slidingMax = new int[nums.length - k + 1];
		
		for(int i=0; i<nums.length - k +1; i++) {
			int max = nums[i];
			for(int j=i+1; j < i + k; j++) {
				if(max < nums[j])
					max = nums[j];
			}
			slidingMax[i] = max;
		}
		
        return slidingMax;
    }
}
