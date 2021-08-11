package com.kausha.algo.leetcode;

import java.util.PriorityQueue;

// https://leetcode.com/problems/find-median-from-data-stream/
/**
 * The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle 
 * value and the median is the mean of the two middle values.

For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:

MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 * @author sinkar
 *
 */
public class MedianFromStreamOfNumbers {
	public static void main(String[] args) {
		MedianFinder mf = new MedianFinder();
		mf.addNum(1);
		mf.addNum(2);
		mf.addNum(3);
		mf.addNum(4);
		
		System.out.println(mf.findMedian());
	}
}

class MedianFinder {

	PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> b - a);
	PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        // We are performing shuffling to restore the sorting of numbers in the two heaps.
        if(maxHeap.size() < minHeap.size())
        	maxHeap.offer(minHeap.poll());
    }
    
    public double findMedian() {
    	System.out.println(maxHeap.size());
    	System.out.println(minHeap.size());
        if(maxHeap.size() != minHeap.size()) {
        	return maxHeap.peek();
        }else {
        	return (minHeap.peek() + maxHeap.peek())/2.0;
        }
    }
}