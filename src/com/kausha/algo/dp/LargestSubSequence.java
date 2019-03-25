 package com.kausha.algo.dp;

import java.util.ArrayList;
import java.util.List;

// https://docs.google.com/file/d/0B0n2c8pfA4EoNW5YWmptRGdTS2UwakdjbVpJbXNOZw/edit
// http://www.thelearningpoint.net/computer-science/algorithms-dynamic-programming---longest-common-subsequence
public class LargestSubSequence {
	public static void main(String[] args) {
		String str1 = "ABCBDAB";
		String str2 = "BDCABA";

		int[][] matchGrid = getLargestSubSequence(str1, str2);
		
		for(int i=0; i<matchGrid.length; i++){
			for(int j=0; j < matchGrid[0].length; j++){
				System.out.print(matchGrid[i][j] +", ");
			}
			System.out.println("");
		}
		
		printLargestSubSequence(matchGrid, str1);
	}
	
	private static int[][] getLargestSubSequence(String str1, String str2){
		int[][] matchGrid = new int[str1.length() + 1][str2.length() +1];
		
		for(int i=0; i<str1.length(); i++){
			for(int j=0; j<str2.length(); j++){
				if(str1.charAt(i) == str2.charAt(j)){
					// Point to be NOTED is that it is only the diagonal matches which indicate the matching character
					// If we follow the diagonal track, we can find the location of character matches when ever the values
					// is incremented.
					matchGrid[i+1][j+1] = matchGrid[i][j] + 1;
				}else{
					// If the characters did not match, escape the character and copy the largest matched sequence 
					if(matchGrid[i][j+1] > matchGrid[i+1][j])
						matchGrid[i+1][j+1] = matchGrid[i][j+1];
					else
						matchGrid[i+1][j+1] = matchGrid[i+1][j];
				}
			}
		}
		
		return matchGrid;
	}
	
	private static void printLargestSubSequence(int[][] matchGrid, String str1){
		int i = matchGrid.length-1;
		int j = matchGrid[0].length-1;
		
		List<Integer> index = new ArrayList<Integer>();
		
		if(matchGrid[i][j] ==0)
			System.out.println("No SubSequence Found");
		
		while(true){
			if(matchGrid[i][j] == matchGrid[i-1][j]){
				i--;
			}else{
				if(matchGrid[i][j] != matchGrid[i-1][j-1])
					index.add(i);
				
				i--;
				j--;
			}
			
			if(i==0 || j==0)
				break;
		}
		
		for(int k = index.size()-1; k >= 0; k--)
			System.out.print(str1.charAt(index.get(k)-1));
	}
}