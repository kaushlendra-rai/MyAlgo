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
	
	private static void generateRandomNumbers(int size){
		int[] nums = new int[size];
		
		for(int i=0; i<size; i++)
			nums[i] = i;
		
		int last = size-1;
		int randomIndex = 0;
		Random rnd = new Random();
		for(int i=0; i<size; i++){
			randomIndex = rnd.nextInt(size-1);
			
			// Swap the random index with last processed index
			int temp = nums[last];
			nums[last] = nums[randomIndex];
			nums[randomIndex] = temp;
			
			last --;
		}
		
		for(int i=0; i<size; i++)
			System.out.println(nums[i]);
	}
}