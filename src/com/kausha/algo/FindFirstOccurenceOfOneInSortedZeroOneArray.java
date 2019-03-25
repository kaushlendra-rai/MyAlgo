package com.kausha.algo;

public class FindFirstOccurenceOfOneInSortedZeroOneArray {
	public static void main(String[] args) {
		//int[] arr = {0, 0, 0, 0, 0, 1, 1};
		//int[] arr = {0, 0};
		int[] arr = {1, 1, 1, 1, 1};
		
		System.out.println("Index = " + findIndex(arr));
	}

	private static int findIndex(int[] arr) {
		
		int start = 0;
		int end = arr.length -1;
		int index = -1;
		
		while(end >= start){
			
			int mid = start + (end-start)/2;
			
			// Check if Mid is a '1'
			if(arr[mid] == 1){
				// If left no of mid is '1', we need to process left
				if(mid > 0 && arr[mid-1] == 1){
					end = mid-1;
				}else if(mid == 0 || (mid > 0 && arr[mid-1] == 0)){
					index = mid;
					break;
				}
			}else{
				start = mid+1;
			}
		}
		
		return index;
	}
}