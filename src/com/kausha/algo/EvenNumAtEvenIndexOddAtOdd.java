package com.kausha.algo;

public class EvenNumAtEvenIndexOddAtOdd {
	public static void main(String[] args) {
		//int[] arr = {1, 4, 2, 4, 5, 23, 45, 3, 6};
		//int[] arr = {2, 5, 7, 8, 1, 6, 9, 1, 1, 6};
		int[] arr = {2, 4, 6, 8, 10, 1, 3, 5, 7, 9};
		
		shuffleNumsInArray(arr);
		
		for(int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
	}
	
	private static void shuffleNumsInArray(int[] arr){
		int even = 0;
		int odd = 1;
		while(true){
			
			while(even < arr.length && arr[even]%2 == 0)
				even = even + 2;
			
			while(odd < arr.length && arr[odd]%2 == 1)
				odd = odd + 2;
			
			if(even < arr.length && odd < arr.length){
				int temp = arr[even];
				arr[even] = arr[odd];
				arr[odd] = temp;
			}else
				break;
		}
	}
}