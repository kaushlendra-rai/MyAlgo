package com.kausha.algo;

// http://www.geeksforgeeks.org/search-in-row-wise-and-column-wise-sorted-matrix/
public class FindNumberInSorted2DArray {
	public static void main(String[] args) {
		int[][] nums = {{1, 2, 3, 4, 5},
					{6, 7, 8, 9, 10},
					{11, 12, 13, 14, 15},
					{16, 17, 18, 19, 20},
					{21, 22, 23, 24, 25}};
		
		boolean status = findNumber(nums, 19);
		System.out.println("Status = " + status);
	}

	private static boolean findNumber(int[][] arr, int num) {
		int j= arr[0].length-1;
		int i = 0;
		
		while(j >= 0 && i < arr.length){
			if(arr[i][j] == num)
				return true;
			else if(arr[i][j] < num){
				i++;
			}else
				j--;
		}
		
		return false;
	}
}