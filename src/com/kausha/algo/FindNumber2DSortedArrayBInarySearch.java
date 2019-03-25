package com.kausha.algo;

//  http://waytocrack.com/blog/search-an-element-in-row-and-column-wise-sorted-matrix-ii/
public class FindNumber2DSortedArrayBInarySearch {
	public static void main(String[] args) {
		int[][] nums = {{1, 2, 3, 4, 5},
					{6, 7, 8, 9, 10},
					{11, 12, 13, 14, 15},
					{16, 17, 18, 19, 20},
					{21, 22, 23, 34, 45}};
		
		boolean status = findNumber(nums, 22);
		System.out.println("Status = " + status);
	}

	private static boolean findNumber(int[][] arr, int num) {
		if(arr == null)
			return false;
		
		return findNumberBinarySearch(arr, num, 0, arr.length-1, 0, arr.length-1);
	}

	private static boolean findNumberBinarySearch(int[][] arr, int num, int col_start,	int col_end, int row_start, int row_end) {
		// Terminal state. Find match
		if(row_end - row_start <=1 || col_end - col_start <= 1){
			for(int i = row_start; i <= row_end; i++){
				for(int j = col_start; j <= col_end; j++){
					if(arr[i][j] == num)
						return true;
				}
			}
			
			return false;
		}else{
			// Find mid-point
			int mid_row = row_start + (row_end-row_start)/2;
			int mid_col = col_start + (col_end - col_start)/2;
			
			if(arr[mid_row][mid_col] == num){
				return true;
			}else if(arr[mid_row][mid_col] < num){
				row_start = mid_row + 1;
				col_start = mid_col + 1;
			}else{
				row_end = mid_row - 1;
				col_end = mid_col - 1;
			}
			
			return findNumberBinarySearch(arr, num, col_start, col_end, row_start, row_end);
		}
	}
}