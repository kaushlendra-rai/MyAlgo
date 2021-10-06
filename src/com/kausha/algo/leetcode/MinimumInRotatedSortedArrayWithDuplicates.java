package com.kausha.algo.leetcode;

// Hard
// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
/**
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
 *  For example, the array nums = [0,1,4,4,5,6,7] might become:

[4,5,6,7,0,1,4] if it was rotated 4 times.
[0,1,4,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the
 array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums that may contain duplicates, return the minimum element of this array.

You must decrease the overall operation steps as much as possible.

 

Example 1:

Input: nums = [1,3,5]
Output: 1
Example 2:

Input: nums = [2,2,2,0,1]
Output: 0
 

Constraints:

n == nums.length
1 <= n <= 5000
-5000 <= nums[i] <= 5000
nums is sorted and rotated between 1 and n times.


 * @author sinkar
 *
 */
public class MinimumInRotatedSortedArrayWithDuplicates {

	public static void main(String[] args) {
		MinimumInRotatedSortedArrayWithDuplicates rs = new MinimumInRotatedSortedArrayWithDuplicates();
		// int[] nums = new int[] {3, 4, 5, 1, 2};
		//int[] nums = new int[] {2, 3, 4, 5, 1};
		//int[] nums = new int[] {2, 3, 4, 5};
		//int[] nums = new int[] {2, 1};
		//int[] nums = new int[] {4,5,6,7,0,1,2};
		//int[] nums = new int[] {11,13,15,17};
		
		//int[] nums = new int[] {2,2,2,0,1};
		//int[] nums = new int[] {2,2,2,0, 0,1};
		//int[] nums = new int[] {4, 4, 4, 4, 5, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3};
		//int[] nums = new int[] {1, 1};
		//int[] nums = new int[] {1, 1, 1, 1};
		//int[] nums = new int[] {3, 1, 1, 1, 1};
		int[] nums = new int[] {10, 1, 10, 10, 10};
		//int[] nums = new int[] {1, 1, 3, 1};
		System.out.println(rs.findMin(nums));
	}

	public int findMin(int[] nums) {
		// Handle edge cases if smallest is at the boundaries of array.
		if(nums.length == 1 || nums[0] < nums[nums.length-1]) // min at start
			return nums[0];
		else if(nums[0] > nums[nums.length-1] && nums[nums.length-2] > nums[nums.length-1]) { // min at end
			return nums[nums.length-1];
		}
		
		int start = 0;
		int end = nums.length-1;
		while(start < end) {
			int mid = start + (end-start)/2;
			//System.out.println("start: " + start + " , end: " + end + ", mid: " + mid);
			// A case where start == end == mid, this happens when lowest number is duplicated. 
			// It too must be handled to avoid infinite loop.
			if(mid > 0 && (nums[mid-1] > nums[mid] && nums[mid+1] > nums[mid])) {
				return nums[mid];
			}if(nums[start] > nums[mid]) {
				// Smallest number towards left of mid.
				end = mid;
			}else if(nums[start] == nums[mid] && nums[mid] == nums[end]) {
				end--;
			}else if(start == mid){
				if(nums[start] > nums[end])
					start = end;
				break;
			}else
				start = mid;
		}
		
        return nums[start];
    }
}
