package com.kausha.algo;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianOfRunningArray {

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
		double[] medians = getMedian(nums);
		for(double num : medians)
			System.out.println(num);
	}
	
	public static double[] getMedian(int[] nums){
		// PriorityQueue is a MIN-HEAP implementation, i.e. minimum value at the top
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		
		// In order to get a MAX-HEAP, we flip the comparator return value sign
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
			@Override
			public int compare(Integer first, Integer second){
				return first.compareTo(second) * -1;
			}
		});
		
		double[] medians = new double[nums.length];
		
		for(int i=0; i < nums.length; i++){
			addNumberToHeap(nums[i], minHeap, maxHeap);
			balanceHeap(minHeap, maxHeap);
			medians[i] = findMedian(minHeap, maxHeap);
			
		}
		
		return medians;
	}

	private static double findMedian(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
		PriorityQueue<Integer> largerQueue = minHeap.size() > maxHeap.size() ? minHeap : maxHeap;
		PriorityQueue<Integer> smallerQueue = minHeap.size() > maxHeap.size() ? maxHeap : minHeap;
		
		if(largerQueue.size() == smallerQueue.size()){
			return ((double)largerQueue.peek() * smallerQueue.peek())/2;
		}else
			return largerQueue.peek();
	}

	private static void balanceHeap(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
		PriorityQueue<Integer> largerQueue = minHeap.size() > maxHeap.size() ? minHeap : maxHeap;
		PriorityQueue<Integer> smallerQueue = minHeap.size() > maxHeap.size() ? maxHeap : minHeap;
		
		if(largerQueue.size() - smallerQueue.size() > 1)
			smallerQueue.offer(largerQueue.poll());
		
	}

	private static void addNumberToHeap(int number, PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
		if(minHeap.size() == 0 || minHeap.peek() < number)
			minHeap.offer(number);
		else
			maxHeap.offer(number);
	}
}