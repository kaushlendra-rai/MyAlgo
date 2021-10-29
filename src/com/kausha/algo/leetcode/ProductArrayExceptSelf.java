package com.kausha.algo.leetcode;

// https://leetcode.com/problems/product-of-array-except-self/
/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all 
 * the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

 

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]

The basic could be solved using a variable having a product of all numbers and for each index, 
dividing the product with the number at that index.
Follow up:

Could you solve it in O(n) time complexity and without using division?
Could you solve it with O(1) constant space complexity? (The output array does not count as extra space 
for space complexity analysis.)

 * @author sinkar
 *
 */
public class ProductArrayExceptSelf {

	public static void main(String[] args) {
		ProductArrayExceptSelf pa = new ProductArrayExceptSelf();

		//int[] nums = new int[] {1,2,3,4}; //Output: [24,12,8,6]
		//int[] nums = new int[] {-1,1,0,-3,3}; //Output: [0,0,9,0,0]
		
		int[] nums = new int[] {1,0}; //Output: [0,0]
		
		int[] result = pa.productExceptSelf(nums);
		
		for(int num : result)
			System.out.print(" " + num);
	}

	// Without '/' (division) operator.
	public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int[] leftProd = new int[nums.length];
        leftProd[0] = nums[0];
        int[] rightProd  = new int[nums.length];
        rightProd[nums.length-1] = nums[nums.length-1];
        
        for(int i=1; i<nums.length; i++)
        	leftProd[i] = leftProd[i-1] * nums[i];
        for(int i=nums.length-2; i >=0; i--)
        	rightProd[i] = rightProd[i+1] * nums[i];
        
         
        for(int i=0; i<nums.length; i++) {
        	int left = i == 0 ? 1 : leftProd[i-1];
        	int right = i == nums.length-1 ? 1 : rightProd[i+1];
        	result[i] = left * right;
        }
        
        return result;
    }
}
