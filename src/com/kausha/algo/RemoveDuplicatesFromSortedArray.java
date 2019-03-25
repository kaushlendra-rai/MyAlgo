package com.kausha.algo;

public class RemoveDuplicatesFromSortedArray {
// http://yucoding.blogspot.in/2013/02/leetcode-question-77-remove-duplicates.html

	public static void main(String[] args) {	
		removeDuplicates(new int[]{1, 1, 1, 2, 3, 3, 3, 4, 4});
	}

	public static void removeDuplicates(int[] num){
		int currentCounter = 1;
		
		for(int i=0; i < num.length-1; i++){
			if(num[i] != num[i+1]){
				num[currentCounter++] = num[i+1];
			}
		}
		
		for(int n : num)
			System.out.println(n +  " ");
		System.out.println("Total Number of unique numbers = " + currentCounter);
	}
}