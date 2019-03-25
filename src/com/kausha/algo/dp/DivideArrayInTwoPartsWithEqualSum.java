package com.kausha.algo.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// http://www.dsalgo.com/2013/02/back-to-content-array-equal-sum.html
public class DivideArrayInTwoPartsWithEqualSum {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7};
		
		List<Integer> firstHalf = divideArrayInEqualParts(arr);
		System.out.println("firstHalf = " + firstHalf);
	}

	private static List<Integer> divideArrayInEqualParts(int[] arr) {
		// If the sum of array elements is odd, array cannot be split. Return null
		int sum = 0;
		for(int num : arr)
			sum+=num;
		
		if(sum%2 == 1)
			return null;
		
		// We now only need to figure out the nums having sum equal to half of total sum
		sum = sum/2;
		
		Arrays.sort(arr);
		
		int[][] memo = new int[arr.length+1][sum+1];
		int lastnum = 0;
		
		outer:
		for(int i=1; i <= arr.length; i++){
			lastnum = i;
			for(int j=1; j <= sum; j++){
				if(arr[i-1] > j)
					memo[i][j] = memo[i-1][j];
				else
					memo[i][j] = arr[i-1] + memo[i-1][j - arr[i-1]];
				
				if(memo[i][j] == sum)
					break outer;
			}
		}
		
		// Print array
		printArray(memo);
		
		System.out.println("memo[arr.length][sum] = " + memo[arr.length][sum]);
		
		// If last element of memo if equal to sum, only then array can be split in half
		if(memo[lastnum][sum] != sum){
			return null;
		}
		
		// Find the numbers to be split the array
		List<Integer> half = new ArrayList<Integer>();
		
		int i=lastnum;
		int j = sum;
		
		while(sum>0){
			if(memo[i][j] == sum && memo[i-1][j] == sum){
				i--;
			}else if(memo[i][j] == sum){
				half.add(i);
				sum = sum-i;
			}else
				j--;
		}
		
		
		return half;
	}
	
	private static void printArray(int[][] arr){
		for(int i = 0; i < arr.length; i++){
			for(int j=0; j < arr[0].length; j++){
				System.out.print(arr[i][j] + "   ");
			}
			System.out.println("");
		}
	}
}