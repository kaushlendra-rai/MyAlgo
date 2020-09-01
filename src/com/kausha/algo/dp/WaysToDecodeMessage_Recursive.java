package com.kausha.algo.dp;

// https://www.youtube.com/watch?v=qli-JCrSwuk&t=377s
/**
 * a = 1
 * b = 2
 * c = 3
 * d = 4
 * ..
 * ..
 * z = 26
 * 
 * 12 => {ab}, {l} => 2 (Number of ways = 2)
 * 123  => {1, 2, 3}, {1, 23} , {12, 3} => Number of ways = 3
 */
public class WaysToDecodeMessage_Recursive {
	public static void main(String[] args) {
		//String num = "12";
		String num = "123"; 
		System.out.println(getNumberOfWays(num));
	}

	public static int getNumberOfWays(String msg) {		
		return getNumberOfWays(msg, 0);
	}
	
	public static int getNumberOfWays(String msg, int idx) {
		if(msg.length() == idx)
			return 1;
		
		if(msg.length()-1 < idx || msg.charAt(idx) == '0')
			return 0;
		
		// ASCII value of '0' = 48, '26' = 54
		// If first digit is 1 or 2 & second digit is less than equal to 6, we have two ways of forming numbers 
		if(msg.charAt(idx) < 51 && (idx + 1) < msg.length() && msg.charAt(idx+1) < 55) {
			System.out.println("Inside 1");
			return getNumberOfWays(msg, idx+1) + getNumberOfWays(msg, idx+2); 
		}else {
			System.out.println("Inside 2");
			return getNumberOfWays(msg, idx+1);
		}
	}
}