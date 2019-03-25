package com.kausha.algo;

public class SplitBinarySearch {

	/**
	 * Rotated Binary Search problem (values at the end of the array 
	 * are shifted to the front where the array remains to be in a sorted order)
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] sortedNum = {8,9,10,11, 12, 13, 14, 15, 16, 17, 1,2,3,4,5,6};
		
		//int[] sortedNum = {8,9,14,1,2,3,4,5,6};

		System.out.println(searchNumber(sortedNum, 24));
	}

	private static boolean searchNumber(int[] arr, int i) {
		int start = 0;
		int end = arr.length-1;
		
		// First find the pivotal point if rotated
		if(arr[0] > arr[arr.length-1]){
			while(start < end){
				int mid = start + (end-start)/2;
				if(arr[start] < arr[mid])
					start = mid+1;
				else
					end = mid-1;
			}
			
			if(arr[start] < arr[start-1]){
				if(i <= arr[arr.length-1]){
					end = arr.length - 1;
				}else{
					end = start - 1;
					start = 0;
				}
			}else{
				if(i < arr[0]){
					start = start + 1;
					end = arr.length - 1;
				}else{
					end = start;
					start = 0;
				}
			}
			
		}
		System.out.println("start = " + start +   "   ,   end = " + end);
		//Perform binary search
		
		
		return binarySearch(arr, start, end, i);
	}

	private static boolean binarySearch(int[] arr, int start, int end, int i) {
		while(start <= end){
			int mid = start + (end-start)/2;
			
			if(arr[mid] == i)
				return true;
			
			if(i > arr[mid])
				start = mid+1;
			else
				end = mid-1;
		}
		
		return false;
	}
}