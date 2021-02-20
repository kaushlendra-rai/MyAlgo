package com.kausha.algo;

// Get the First & last index of a number in  a sorted array. If number not found, return -1 respectively.
public class FirstAndLastIndexOfKInSortedArray {

	public static void main(String[] args) {
		//Sorted Array with duplicates
		int[] arr = new int[] {1, 2, 2, 3, 5, 6, 6, 6, 6, 9};
		int[] idx = getFirstAndLastIndexOfNum(arr, 9);
		System.out.printf("First index %d and Last index: %d match at:", idx[0], idx[1]);
	}

	// We search the start & end indexes using Binary search.
	private static int[] getFirstAndLastIndexOfNum(int[] arr, int num) {
		int[] idx = new int[2];
		if(arr == null || arr.length == 0) {
			idx[0] = -1;
			idx[1] = -1;
			return idx; 
		}
		
		idx[0] = findNumIndex(arr, num, true);
		idx[1] = findNumIndex(arr, num, false);
		
		return idx;
	}

	private static int findNumIndex(int[] arr, int num, boolean left) {
		int start = 0;
		int end = arr.length-1;
		int idx = -1;
		
		while(start <= end) {
			int mid = start + (end-start)/2;
			if(arr[mid] == num) {
				if(left) {
					if(mid==0 || (mid>0 && arr[mid-1] != num)) {
						idx = mid;
						break;
					}else
						end = mid-1;
				}else {
					if(mid==arr.length-1 || (mid<arr.length-1 && arr[mid+1] != num)) {
						idx = mid;
						break;
					}else
						start = mid+1;
				}
			}else if(arr[mid] < num){
				start = mid+1;
			}else
				end = mid-1;
		}
		
		return idx;
	}
}
