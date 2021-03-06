package com.kausha.algo.leetcode;

public class MinimumJumpsToReachEnd {

	public static void main(String[] args) {
		int nums[] = new int[]{2, 3, 1, 1, 2, 4, 2, 0, 1, 1};
		//int nums[] = new int[]{2};

		int minJumpsToEnd = getMinJumpsToEnd(nums);
		System.out.println(minJumpsToEnd);
	}

	// If nums array is null or empty, jumps would be '-1'.
	private static int getMinJumpsToEnd(int[] nums) {
		if (nums == null || nums.length == 0)
			return -1;
		
		int[] hops = new int[nums.length];
		for(int i=0; i < nums.length-1; i++) {
			// We are not supposed to jump & count at the same location, hence j starts with '1' and not '0'.
			for(int j=1; j <= nums[i]; j++) {
				// Ensure that we stay in the limits of the array length.
				// If the existing node has not been visited before, then the comparison does not exists. Initialize it.
				if(i + j < nums.length && (hops[i + j] == 0 || hops[i + j] > hops[i] + 1))
					hops[i+j] = hops[i] + 1;
			}
		}

		return hops[nums.length-1];
	}
}
