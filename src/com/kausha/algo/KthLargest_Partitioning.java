package com.kausha.algo;

// https://www.youtube.com/watch?v=hGK_5n81drs
public class KthLargest_Partitioning {
	public static void main(String[] args) {
		//int[] nums = {4, 2, 5, 1, 88, 3, 9};
		int[] nums = {4, 2, 5, 1, 88, 3, 9, 18, 22};
		//int[] nums = new int[] {3,2,3,1,2,4,5,5,6};
		System.out.println(kthLargest(nums, 4));
	}

	private static int kthLargest(int[] nums, int idx) {
		idx = nums.length - idx; // 2nd largest is the length-2 in the partially sorted array.
		int start =0;
		int end = nums.length -1;
		int mid = -1;
		while(mid != idx) {
			mid = partitionArray(nums, start, end);
			if(mid > idx)
				end = mid-1;
			else
				start = mid+1;
		}
		
		return nums[mid];
	}
	
	// Partition number around value of start index of the sub array. 
	private static int partitionArray(int[] nums, int start, int end) {
		int value = nums[start];
		
		while(start < end) {
			if(nums[start] < value) {
				start++;
			}else if(nums[end] > value){
				end--;
			}else {
				//Swap
				int temp = nums[start];
				nums[start] = nums[end];
				nums[end] = temp;
			}
		}
		
		return start;
	}
}
