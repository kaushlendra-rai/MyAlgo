package com.kausha.algo;

public class FindMissingNumberInAnArray {
	
	public static void main(String[] args) {
		int[] input = {2, 3, 5,1 , 6};
		//int[] input = {5, 2, 1, 4};
		
		System.out.println("Missing number = " + findMissingNumber(input));
		
		System.out.println(missingNumber2(input));
	}

	// This method is valid even if the numbers are long or integer.
	// The other approach of subtracting numbers from the total sum of all numbers might fail
	// as the sum of numbers might exceed the range of that number type (e.g. integer or long)
	public static int findMissingNumber(int[] numArray){
		int missingNumber =0;
		
		for(int i=0; i < numArray.length; i++){
			int temp = numArray[i];
			System.out.println("temp = " + temp);
			// If the number is already in place, continue with next number
			if(temp-1 == i)
				continue;
			
			numArray[i] =numArray[temp-1]; 
			numArray[temp-1] = temp;
		}
		
		for(int i=0; i < numArray.length; i++){
			if((i+1) != numArray[i]){
				missingNumber = i+1;
				break;
			}
		}
		return missingNumber;
	}
	
	/**
	 * Approach 2
	 * @param numbers
	 * @return
	 */
	public static int missingNumber(int[] numbers){
		long missingNumber = numbers.length + 1;
		
		for(int i=0; i<numbers.length; i++)
			missingNumber += (i+1) - numbers[i];
		
		return (int)missingNumber;
	}
	
	public static int missingNumber2(int[] numbers){
		long missingNumber = numbers.length + 1;
		
		for(int i=0; i<numbers.length; i++)
			missingNumber = missingNumber ^ (i+1) ^ numbers[i];
		
		
		return (int)missingNumber;
	}
}