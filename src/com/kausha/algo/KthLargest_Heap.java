package com.kausha.algo;

import java.util.PriorityQueue;

// We maintain a MinHeap of size k using PriorityQueue
public class KthLargest_Heap {
	public static void main(String[] args) {
		int[] nums = {4, 2, 5, 1, 88, 3, 9};
		System.out.println(kthLargest(nums, 6));
	}

	public static int kthLargest(int[] nums, int n) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		if(n > nums.length)
			return -1;
		
		for(int i=0; i < nums.length; i++) {
			if(i < n)
				minHeap.offer(nums[i]);
			else {
				if(minHeap.peek() <nums[i]) {
					minHeap.poll();
					minHeap.offer(nums[i]);
				}
			}
		}
		
		return minHeap.poll();
	}
}
