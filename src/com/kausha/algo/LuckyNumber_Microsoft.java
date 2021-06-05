package com.kausha.algo;

// https://www.geeksforgeeks.org/lucky-numbers/
// Sample Lucky nums 1,3,7,13 ... rest in between are not. 
public class LuckyNumber_Microsoft {

	public static void main(String[] args) {
		//System.out.println(isLucky(5));
		System.out.println(isLucky(13));
	}
	
	public static boolean isLucky(int  num) {
		int counter = 2;
		while(counter <= num) {
			if(num%counter == 0)
				return false;
			
			// If the index of the number is not getting removed by the counter, we evaluate the position
			// of our 'num' after the numbers have been removed based on counter.
			// We just focus on the index of the original 'num' and it's movement and not intermediate numbers.
			num = num - num/counter;
			
			// First time we remove 2nd elements, then 3rd, then 4rth from the remaining numbers.
			counter++;
		}
		return true;
	}

}
