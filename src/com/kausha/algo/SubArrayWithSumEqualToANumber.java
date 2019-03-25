package com.kausha.algo;

// http://www.crazyforcode.com/sum-elements-array-sum-equal-number/
public class SubArrayWithSumEqualToANumber {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 5, 6, 7, 8};
		//System.out.println(subArrayExsist(arr, 15));
		System.out.println(subArrayExist(arr, 14));
	}
	
	private static boolean subArrayExist(int[] arr, int num){
		int startIndex = 0;
		int endIndex = 1;
		int sum = arr[0];
		
		while(endIndex < arr.length || (endIndex == arr.length && sum >= num)){
			if(sum == num)
				return true;
			
			if(sum < num){
				sum = sum + arr[endIndex++];
			}else{
				sum = sum - arr[startIndex++];
			}
		}
		
		return false;
	}
}