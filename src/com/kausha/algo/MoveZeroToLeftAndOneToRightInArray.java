package com.kausha.algo;

public class MoveZeroToLeftAndOneToRightInArray {
	public static void main(String[] args) {
		int[] nums = {1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1};
		
		moveZeroAndOne(nums);
		
		for(int num : nums)
			System.out.print(num + " , ");
	}

	private static void moveZeroAndOne(int[] nums) {
		int zeroIndex = nums.length-1;
		int oneIndex = 0;
		
		while(zeroIndex > oneIndex){
			for(int i=oneIndex; i < zeroIndex; i++)
				if(nums[i] == 0)
					oneIndex++;
				else
					break;
			
			for(int i=zeroIndex; i >=oneIndex ; i--)
				if(nums[i] == 1)
					zeroIndex--;
				else
					break;
			
			if(zeroIndex > oneIndex)
				swap(nums, zeroIndex, oneIndex);
		}
	}
	
	private static void swap(int nums[], int x, int y){
		int temp = nums[x];
		nums[x] = nums[y];
		nums[y] = temp;
	}
}