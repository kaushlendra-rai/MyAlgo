package com.kausha.algo;

public class FindFirstOccurenceOfOneInSortedZeroOneArray_old {
	public static void main(String[] args) {
		int[] arr = {0, 0, 0, 0, 0, 1, 1};
		//int[] arr = {0, 0};
		//int[] arr = {1, 1, 1, 1, 1};
		
		System.out.println("Index = " + findIndex(arr));
	}

	private static int findIndex(int[] arr) {
		int index = -1;
		int start = 0;
		int end = arr.length - 1;
		
		while(start <= end){
			int mid = start + (end-start)/2;
			System.out.println("mid = " + mid);
			if(arr[mid] == 0){
				if(mid+1 <= end && arr[mid+1] == 1){
					index = mid+1;
					break;
				}else
					start = mid+1;
			}else{
				if(mid-1 >= start && arr[mid-1] == 0){
					index = mid;
					break;
				}else
					end = mid-1;
			}
		}
		
		return index;
	}
}