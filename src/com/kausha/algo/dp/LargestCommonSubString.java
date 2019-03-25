package com.kausha.algo.dp;

//https://www.youtube.com/watch?v=RUckZMzqUcw
// Can also refer from 'LargestSubSequence.java'
public class LargestCommonSubString {
	public static void main(String[] args) {
		
		// Answer should be -  'lobo'
//		System.out.println(getLargestCommonSubString("helloboyz", "lobostart"));
		System.out.println(getLargestCommonSubString("lolobostart", "helloboyz"));
	}
	
	public static String getLargestCommonSubString(String str1, String str2){
		int[][] match = new int[str1.length() + 1][str2.length() +1];
		
		String largestString = null;
		int largestLength = 0;
		for(int i= 0; i < str1.length(); i++){
			for(int j=0; j < str2.length(); j++){
				if(str1.charAt(i) == str2.charAt(j)){
					match[i+1][j+1] = match[i][j] + 1;
					
					if(largestLength < match[i+1][j+1])
						largestString = str2.substring(j-match[i][j], j+1);
				}
			}
		}
		
		return largestString;
	}
}