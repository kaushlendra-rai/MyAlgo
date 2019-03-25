package com.kausha.algo;

public class FindNumber2DSortedArrayBInarySearch_IterativeCorrect {
	public static void main(String[] args) {
		int[][] nums = {
				    {1 , 2 , 3 , 4 , 5},
					{6 , 7 , 8 , 9 , 10},
					{11, 12, 13, 14, 15},
					{16, 17, 18, 19, 20},
					{21, 22, 23, 34, 45}};
		
		boolean status = findNumber(nums, 5);
		System.out.println("Status = " + status);
	}

	private static boolean findNumber(int[][] nums, int i) {
		int left = 0;
		int right = nums[0].length-1;
		int top = 0;
		int bottom = nums.length-1;
		
		while(left < right && top <= bottom){
			int midRow = top + (bottom-top)/2;
			int midColumn = left + (right-left)/2;
			
			if(nums[midRow][midColumn] == i)
				return true;
			else if(nums[midRow][midColumn] > i){
				top = 0;
				left = 0;
				bottom = midRow;
				right = midColumn;
			}else{
				left = midColumn;
				top = midRow;
			}
			
			if(right == left+1 || bottom == top + 1)
				break;
		}
		
		System.out.println("Final Left = " + left + "  , Right = " + right);
		System.out.println("Final top = " + top + "  , bottom = " + bottom);
		
		for(int k = left; k <= right ; k++)
			// Ideally you perform binary Search here to get log(n) order
			for(int j=0; j < nums.length; j++)
				if(nums[j][k] == i)
					return true;
		
		for(int k = top; k <= bottom; k++)
			// Ideally you perform binary Search here to get log(n) order
			for(int j=0; j < nums[0].length; j++)
				if(nums[k][j] == i)
					return true;
		
		return false;
	}
}