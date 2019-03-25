package com.kausha.algo;

public class FindMissingNumberReplacedByRepeatingNumber {

	public static void main(String[] args) {
		//int arr[] = {0, 3, 4, 1, 0, 5};
		int arr[] = {3, 0, 4, 1, 0, 5};
		findMissingNumber(arr);
	}

	private static void findMissingNumber(int[] arr){
		for(int i=0; i < arr.length; i++){
			int num = arr[i]; 
			if(num < 0)
				num*=-1;
			
			arr[num] *=-1;
		}
		
		int[] numArr = new int[4];
		for(int i=0; i < 4; i++)
			numArr[i] =-1;
		
		int[] numArrIndex = new int[4];
		int counter = 0;
		for(int i=0; i < arr.length; i++){
			System.out.println("arr[i] = " + arr[i]);
			if(arr[i] >=0){
				numArr[counter] = arr[i];
				numArrIndex[counter++] = i;
			}
		}
		
		// In numArr, If there are '2' numbers > 0, It means that the duplicate and missing number are occupied at their indexes
		// If it is '3', One number is at duplicate location or missing number location
		// If it is '4', duplicates are neither at missing location, nor at duplicate location.
		// Work accordingly.
		
		// ####  BELOW IS NOT CORRECT & works only for #2 & #3 scenario.
		if(numArr[0] == numArr[1]){
			System.out.println("Missing Number 1= " + numArrIndex[2]);
		}else if(numArr[1] == numArr[2]){
			System.out.println("Missing Number 2= " + numArrIndex[0]);
		}else{
			System.out.println("Missing Number 3= " + numArrIndex[1]);
		}
	}
}