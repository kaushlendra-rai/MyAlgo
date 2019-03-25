package com.kausha.algo;


// Question: https://www.youtube.com/watch?v=kcVk30zzAmU

// My solution takes O(nk) time where n=number of elements & k=largest kth number
// If allowed to used extra space O(k), we can use  MIN_HEAP and achieve the same in O(nlogk)
public class FindNthLargestNumberInArray {
	public static void main(String[] args) {
		int[] arr = {1, 3, 9, 5, 7, 4, 8, 2};
		System.out.println("5th Largest number = " + findNthLargestNumber(arr, 5));
	}
	
	private static int findNthLargestNumber(int[] arr, int n){
		for(int i=0; i < n; i++){
			for(int j=i+1; j < arr.length; j++){
				if(arr[i] < arr[j]){
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		return arr[n-1];
	}
}