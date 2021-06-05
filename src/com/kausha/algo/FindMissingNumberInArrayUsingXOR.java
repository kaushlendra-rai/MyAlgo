package com.kausha.algo;

public class FindMissingNumberInArrayUsingXOR {
	
	public static void main(String[] args) {
		//int arr[] = {0, 3, 4, 1, 5};
		//int arr[] = {3, 0, 1};
		int[] arr = new int[] {0, 1, 2, 3, 5};

		findMissingNumber(arr);	

	}

	private static void findMissingNumber(int[] arr) {
		int xor1 = 0;
		int xor2 = arr[0];
		
		for(int i=1; i< arr.length + 1; i++)
			xor1 = xor1 ^ i;
		
		for(int i=1; i< arr.length; i++)
			xor2 = xor2 ^ arr[i];
		
		int missingNum = xor1 ^ xor2;
		
		System.out.println("MissingNumber = " + missingNum);
	}
}