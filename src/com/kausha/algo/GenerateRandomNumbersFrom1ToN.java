package com.kausha.algo;

import java.util.Random;

/**
 * http://stackoverflow.com/questions/196017/unique-random-numbers-in-o1
 * http://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle
 * @author sinkar
 *
 */
public class GenerateRandomNumbersFrom1ToN {
	public static void main(String[] args) {
		generateRandomNumbers(10);
	}
	
	// We start with filling random numbers from the last of the array and 
	// also reduce the window of random integer simultaneously.
	private static void generateRandomNumbers(int size){
		int[] nums = new int[size];
		
		for(int i=0; i<size; i++)
			nums[i] = i;

		int randomIndex;
		Random rnd = new Random();
		for(int i=size-1; i>0; i--){
			randomIndex = rnd.nextInt(size-1);
			
			// Swap the random index with last processed index
			int temp = nums[i];
			nums[i] = nums[randomIndex];
			nums[randomIndex] = temp;
		}
		
		for(int i=0; i<size; i++)
			System.out.println(nums[i]);
	}
}