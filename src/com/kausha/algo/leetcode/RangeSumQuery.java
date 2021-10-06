package com.kausha.algo.leetcode;

// https://leetcode.com/problems/range-sum-query-mutable/
/**
 * Given an integer array nums, handle multiple queries of the following types:

Update the value of an element in nums.
Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
Implement the NumArray class:

NumArray(int[] nums) Initializes the object with the integer array nums.
void update(int index, int val) Updates the value of nums[index] to be val.
int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive 
(i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 

Example 1:

Input
["NumArray", "sumRange", "update", "sumRange"]
[[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
Output
[null, 9, null, 8]

Explanation
NumArray numArray = new NumArray([1, 3, 5]);
numArray.sumRange(0, 2); // return 1 + 3 + 5 = 9
numArray.update(1, 2);   // nums = [1, 2, 5]
numArray.sumRange(0, 2); // return 1 + 2 + 5 = 8
 
 * @author sinkar
 *
 */
public class RangeSumQuery {

	public static void main(String[] args) {
//		NumArray na = new NumArray(new int[] {-2, 0, 3, -5, 2, -1});
//		
//		System.out.println(na.sumRange(0, 2)); // 1
//		System.out.println(na.sumRange(2, 5)); // -1
//		System.out.println(na.sumRange(0, 5)); // -3

//		NumArray na = new NumArray(new int[] {-2});
//		System.out.println(na.sumRange(0, 0));
		
		NumArray na = new NumArray(new int[] {1, 3, 5});
		System.out.println(na.sumRange(0, 2));
		na.update(1, 2);
		System.out.println(na.sumRange(0, 2));
		
	}
}

class NumArray {
	private int[] numSum;
    
	public NumArray(int[] nums) {
    	numSum = new int[nums.length  +1];
    	
    	// pre-compute index-sum
    	int sum = 0;
    	for(int i=0; i < nums.length; i++) {
    		sum = sum + nums[i];
    		numSum[i+1] = sum;
    	}
    }
    
    public void update(int index, int val) {
        int num = numSum[index+1] - numSum[index];
        int diff = val - num;
        
        for(int i=index+1; i < numSum.length; i++)
        	numSum[i] = numSum[i] + diff;
    }

    public int sumRange(int left, int right) {
        return numSum[right+1] - numSum[left];
    }
}