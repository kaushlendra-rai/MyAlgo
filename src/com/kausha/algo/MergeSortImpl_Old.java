package com.kausha.algo;

public class MergeSortImpl_Old {

	public static void main(String[] args) {
		int[] nums = {2, 5, 8, 1, 6, 7, 9};

		int[] work = new int[nums.length];

		System.out.print(" Input : ");
		for(int num : nums)
			System.out.print(num + "  ");
		
		mergesort(nums, work, 0, nums.length-1);
		
		System.out.print("\n\n Output : ");
		for(int num : nums)
			System.out.print(num + "  ");
	}
	
	public static void mergesort(int[] nums, int[] work, int start, int end){
		if(start < end){
			int mid = start + (end-start)/2;
			mergesort(nums, work, start, mid);
			mergesort(nums, work, mid+1, end);
			
			merge(nums, work, start, mid, end);
		}
	}
	
	private  static void merge(int[] nums, int[] work, int start, int mid, int end){
		// It is to be assumed that nums from start-mid & mid-end are sorted.
		boolean loop = true;
		int counter1 = start;
		int counter2 = mid+1;
		int workCounter = start;
		
		while(loop){
			if(counter1 > mid){
				// Copy all elements from 2nd end to work
				for(int i=counter2; i<=end; i++)
					work[workCounter++] = nums[i];
				break;
			}
			
			if(counter2 > end){
				// Copy all elements from start-mid to work
				for(int i=counter1; i<=mid; i++)
					work[workCounter++] = nums[i];
				break;
			}
			
			// Swap the number if the numbers in are not is sorted order
			if(nums[counter1] < nums[counter2]){
				work[workCounter] = nums[counter1]; 
				counter1++;
			}else{
				work[workCounter] = nums[counter2]; 
				counter2++;
			}
			
			workCounter++;
		}
		
		// Copy the sorted work array into main array
		for(int i=start; i <= end; i++)
			nums[i] = work[i];
	}
}