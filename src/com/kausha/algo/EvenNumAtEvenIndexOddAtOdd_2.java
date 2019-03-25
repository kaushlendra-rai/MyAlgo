package com.kausha.algo;

public class EvenNumAtEvenIndexOddAtOdd_2 {
	public static void main(String[] args) {
		//int[] arr = {1, 4, 2, 4, 5, 23, 45, 3, 6};
		//int[] arr = {2, 5, 7, 8, 1, 6, 9, 1, 1, 6};
		int[] arr = {2, 4, 6, 8, 10, 1, 3, 5, 7, 9};
		
		shuffleNumsInArray(arr);
		
		for(int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
	}

	private static void shuffleNumsInArray(int[] arr) {
		int even = 0;
		int odd = 1;
		int counter = 0;
		
		while(counter < arr.length){
			if(arr[counter] %2 == 0 && counter%2 ==1 && even < arr.length){
				int temp = arr[even];
				arr[even] = arr[counter];
				arr[counter] = temp;
				
				even+=2;
			}if(arr[counter] %2 == 1 && counter%2 ==0 && odd < arr.length){
				int temp = arr[odd];
				arr[odd] = arr[counter];
				arr[counter] = temp;
				
				odd+=2;
			}else
				counter++;
		}
	}
	
}