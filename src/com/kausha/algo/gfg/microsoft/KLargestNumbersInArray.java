package com.kausha.algo.gfg.microsoft;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class KLargestNumbersInArray {

	public static void main(String[] args) {
		int[] arr = new int[] {12,5,787,1,23}; //23, 787
		//int[] arr = new int[] {12}; // 12
		System.out.println(kLargest(arr, 5, 4));

	}

	public static ArrayList<Integer> kLargest(int arr[], int n, int k)
    {
        ArrayList<Integer> kLargestNums = new ArrayList<>();
     
        if(arr == null)
        	return kLargestNums;
        
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        for(int i=0; i < arr.length; i++) {
        	if(i < k)
        		heap.offer(arr[i]);
        	else {
        		if(heap.peek() < arr[i]) {
        			heap.poll();
        			heap.offer(arr[i]);
        		}
        	}
        }
        
        while(!heap.isEmpty())
        	kLargestNums.add(heap.poll());
        
        Collections.reverse(kLargestNums);
        return kLargestNums;
    }
}
