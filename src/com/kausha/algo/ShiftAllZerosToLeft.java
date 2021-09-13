package com.kausha.algo;

public class ShiftAllZerosToLeft {
	public static void main(String[] args) {
		int[] nums = {0, 1, 0, 0, 0, 2, 3, 4, 5, 0, 0, 6, 7, 0};
		shiftZeros(nums);
		for(int num : nums)
			System.out.print(num + " , ");
		
		System.out.println();
		
		int[] nums1 = {0, 1, 0, 0, 0, 2, 3, 4, 5, 0, 0, 6, 7, 0};
		shiftZeros_simple(nums1);
		for(int num : nums1)
			System.out.print(num + " , ");
	}

	private static void shiftZeros_simple(int[] nums) {
		int counter = 0;
		int idx = nums.length-1;
		
		for(int i = nums.length-1; i >= 0; i--) {
			if(nums[i] != 0) {
				nums[idx--] = nums[i];
			}else
				counter++;
		}
		
		for(int i=0; i < counter; i++)
			nums[i] = 0;
	}
	
	private static void shiftZeros(int[] nums) {
		int zeroCounter = -1;
		int index = nums.length-1;
		
		while(index>=0){
			//If number is '0'
			if(nums[index] == 0){
				if(zeroCounter < 0)
					zeroCounter = index;
				index--;
			}else{
				if(zeroCounter > 0){
					//Swap numbers
					swap(nums, index, zeroCounter);
					
					// Find next zero counter if available
					boolean counterFound = false;
					for(int i= zeroCounter-1; i >=index; i--){
						if(nums[i] == 0){
							zeroCounter = i;
							counterFound = true;
							break;
						}
					}
					
					if(!counterFound)
						zeroCounter = -1;
				}
				
				index--;
			}
		}
	}
	
	private static void swap(int nums[], int x, int y){
		int temp = nums[x];
		nums[x] = nums[y];
		nums[y] = temp;
	}
}