package com.kausha.algo;

public class ContineousSubArraysWithAGivenSum {

	public static void main(String[] args) {
		int[] nums = new int[] {1, 4, 2, 3, 5, 8};
		int sum = 8;
		printContigousSubArrayWithSum(nums, sum);
	}
	
	public static void printContigousSubArrayWithSum(int[] arr, int sum) {
		if(arr == null || arr.length == 0) {
			System.out.println("Null or empty array provided. No pairs found");
			return;
		}
		int localSum = 0;
		int start = 0;
		
		for(int i=0; i < arr.length && start < arr.length; ) {
			if(localSum + arr[i] == sum) {
				System.out.printf("Sum found between indexs start: %d, end: %d", start, i);
				localSum = localSum - arr[start];
				start++;
			}else if(localSum + arr[i] < sum){
				localSum += arr[i];
				i++;
			}else {
				localSum = localSum - arr[start];
				start++;
			}
		}
	}
}
