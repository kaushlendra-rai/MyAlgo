package com.kausha.algo2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NextLargerNumberWithSameDigits {

	public static void main(String[] args) {
		//System.out.println(getNextLargerNumber(4768543));
		//System.out.println(getNextLargerNumber(4768243));
		//System.out.println(getNextLargerNumber(654321));
		System.out.println(getNextLargerNumber(650321));
	}
	
	private static int getNextLargerNumber(int nums){
		int nextLarger = 0;
		
		int tempNum = nums;
		List<Integer> digits = new ArrayList<Integer>();
		
		int prevDigit = -1;
		int counter=0;
		while(tempNum > 0){
			int digit = tempNum%10;
			tempNum = tempNum/10;
			
			if(prevDigit <0 || digit > prevDigit){
				prevDigit = digit;
			}else if(digit < prevDigit){
				nextLarger = tempNum*10 + prevDigit;
				
				// Remove prevDigit from list
				System.out.println(digits.get(counter-1));
				digits.remove(counter-1);
				// Add the new digit to the list
				digits.add(digit);
				
				// Sort digits in increasing order and make a number out of it.
				Collections.sort(digits);
				
				for(int num : digits)
					nextLarger = nextLarger*10 + num;
				
				break;
			}
			
			digits.add(digit);
			counter++;
		}
		
		// If the number given is the largest number itself (sorted in descending order), return the number itself
		if(nextLarger == 0)
			nextLarger = nums;
		
		return nextLarger;
	}
}