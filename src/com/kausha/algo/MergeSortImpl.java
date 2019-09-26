package com.kausha.algo;

public class MergeSortImpl {

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

	private static void mergesort(int[] nums, int[] work, int i, int j) {
		if(i <j){
			int mid = i + (j-i)/2;
			
			mergesort(nums, work, i, mid);
			mergesort(nums, work, mid+1, j);
			
			merge(nums, work, i, j, mid);
		}
	}

	private static void merge(int[] nums, int[] work, int start, int end, int mid) {
		int counter1 = start;
		int counter2 = mid + 1;
		int workCounter = start;
		while(workCounter <= end){
			if(counter1 <= mid && counter2 <= end){
				if(nums[counter1] < nums[counter2])
					work[workCounter++] = nums[counter1++];
				else
					work[workCounter++] = nums[counter2++];
			}else if(counter1 <= mid){
				work[workCounter++] = nums[counter1++];
			}else{
				work[workCounter++] = nums[counter2++];
			}
		}
		
		// Update array with sorted numbers from work array.
		for(int k=start; k <= end; k++)
			nums[k] = work[k];
	}
}