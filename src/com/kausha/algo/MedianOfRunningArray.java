package com.kausha.algo;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianOfRunningArray {

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 14, 15, 6, 17, 8, 21};
		double[] medians = getMedian(nums);
		
	}

	private static double[] getMedian(int[] nums) {
		// Larger number goes on this Heap With minimum value at root.
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
			public int compare(Integer first, Integer second) {
				return second.compareTo(first);
			}
		});
		
		for(int i=0; i<nums.length; i++) {
			addNumberToHeap(nums[i], minHeap, maxHeap);
		}
		
		if(minHeap.size() == maxHeap.size()) {
			System.out.println(minHeap.poll());
			System.out.println(maxHeap.poll());
		}else if(minHeap.size() < maxHeap.size()) {
			System.out.println(maxHeap.poll());
		}else {
			System.out.println(minHeap.poll());
		}
		return null;
	}

	private static void addNumberToHeap(int num, PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
		if(minHeap.size() <=maxHeap.size()) {
			minHeap.offer(num);
		}else {
			if(minHeap.peek() > num)
				maxHeap.offer(num);
			else {
				maxHeap.offer(minHeap.poll());
				minHeap.offer(num);
			}
		}
		
	}
	
}
