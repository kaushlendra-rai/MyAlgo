package com.kausha.algo.leetcode;

// https://leetcode.com/problems/kth-largest-element-in-an-array/
//Given an integer array nums and an integer k, return the kth largest element in the array.
//Note that it is the kth largest element in the sorted order, not the kth distinct element.
public class KthLargestNumberInAnArray {

	public static void main(String[] args) {
		KthLargestNumberInAnArray kl = new KthLargestNumberInAnArray();
//		int[] nums = new int[] {3,2,1,5,6,4};
//		System.out.println(kl.findKthLargest(nums, 2));
//		
//		int[] nums = new int[] {3,2,3,1,2,4,5,5,6}; // Ans:  4
//		System.out.println(kl.findKthLargest(nums, 4));
		
		int[] nums = new int[] {3,2,1,5,6,4, 9, 3, 45, 7, 2, 8, 13};

		System.out.println("Original array:");
		for(int n : nums)
			System.out.print(" " + n);
		System.out.println("\n\nChanges:");
		System.out.println("\n\n" + kl.findKthLargest(nums, 2));
		
		System.out.println("\n");
//		for(int n : nums)
//			System.out.print(" " + n);
//		int[] nums = new int[] {3};
//		System.out.println(kl.findKthLargest(nums, 1));
		
		
//		int[] nums = new int[]{3,3,3,3,4,3,3,3,3};
//		System.out.println(kl.findKthLargest(nums, 1));

	}

	// We solve it using partitioning
	public int findKthLargest(int[] nums, int k) {		
		int kthIndex = nums.length - k;
		int start = 0;
		int end = nums.length -1;
		int mid = -1;
		
		while(mid != kthIndex) {
			mid = partitionK(nums, start, end);
			//System.out.println("\nmid:" + mid);
			//for(int n : nums)
			//	System.out.print(" " + n);
			//System.out.println();
			if(mid < kthIndex)
				start = mid+1;
			else if(mid > kthIndex)
				end = mid-1;
			else
				break;
		}
        return nums[mid];
    }

	// This method returns the index location of nums[start] position in the array.
	// We do not actually sort the array. We are just fixing the position of this number in array.
	private int partitionK(int[] nums, int start, int end) {
		int num = nums[start];
		while(start < end) {
			if(nums[start] < num)
				start++;
			else if(nums[end] > num)
				end--;
			else if(nums[start] == nums[end]) {
				start++;
			}else {
				int temp = nums[start];
				nums[start] = nums[end];
				nums[end] = temp;
			}
		}
		//System.out.println("start:" + start + " , end: " + end);
		return start;
	}
}
