package com.kausha.algo.leetcode;

public class CountContinuousSubArrayWithSumK {

	public static void main(String[] args) {
		CountContinuousSubArrayWithSumK sa = new CountContinuousSubArrayWithSumK();
		//int[] nums = new int[] {-1,2,1,-1,3};
		int[] nums = new int[] {3, 4, 7, 2, -3, 1, 4, 2};
		System.out.println(sa.subarraySum(nums, 7));
	}

	// Time: O(n^2)
	public int subarraySum(int[] nums, int k) {
		int count = 0;
		
		for(int i=0; i<nums.length; i++) {
			int sum = 0;
			for(int j=i; j < nums.length; j++) {
				sum += nums[j];
				
				if(sum == k)
					count++;
			}
		}
		
		return count;
	}
	public int subarraySum_old(int[] nums, int k) {
		int[] sum = new int[nums.length+1];
		for(int i=1; i <= nums.length; i++)
			sum[i] = sum[i-1] + nums[i-1];
		for(int i=0; i <= nums.length; i++)
			System.out.print(" " + sum[i]);
		System.out.println();
		int start = 0;
		int end = 1;
		int counter = 0;
		
		while(end < sum.length) {
			System.out.println("start:" + start + "  end:" + end + "  sum:" + (sum[end] - sum[start]));
			if(sum[end] - sum[start] == k) {
				System.out.println("Match found");
				counter++;
				end++;
				//start++;
			}else if(sum[end] - sum[start] < k) {
				end++;
			}else
				start++;
		}
		
        return counter;
    }
}
