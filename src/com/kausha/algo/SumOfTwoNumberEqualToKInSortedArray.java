package com.kausha.algo;

public class SumOfTwoNumberEqualToKInSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] num = {1, 2, 3, 4, 5, 6, 7, 8, 8, 9, 10, 11, 12, 12, 13, 15, 16};
		printNumbers(num, 10);

	}
	
	private static void printNumbers(int[] num, int sum){
		int start = 0;
		int end = num.length -1;
		
		while(end > start){
			if((num[start] + num[end]) == sum){
				System.out.println("Pair = " + num[start] + " , " + num[end]);
				start++;
				end--;
			}else if((num[start] + num[end]) > sum){
				end--;
			}else{
				start++;
			}
		}
	}
}