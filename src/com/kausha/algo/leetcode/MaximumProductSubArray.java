package com.kausha.algo.leetcode;

public class MaximumProductSubArray {

	public static void main(String[] args) {
		MaximumProductSubArray mp = new MaximumProductSubArray();

		//int[] nums = new int[] {2,3,-2,4};
		//int[] nums = new int[] {-2,0,-1};
		int[] nums = new int[] {4, -2, -3};
		//int[] nums = new int[] {0, 2};
		//int[] nums = new int[] {-2,3,-4};
		//int[] nums = new int[] {-2,3,-4, -8, -4};
		//int[] nums = new int[] {-3,0,1,-2}; // 1
		//int[] nums = new int[]{2,-5,-2,-4,3}; // 24
		System.out.println(mp.maxProduct(nums));
		System.out.println(mp.maxProduct_my(nums));
	}
	
	public int maxProduct(int[] nums) {
	    int[] max = new int[nums.length];
	    int[] min = new int[nums.length];
	 
	    max[0] = min[0] = nums[0];
	    int result = nums[0];
	 
	    for(int i=1; i<nums.length; i++){
	        if(nums[i]>0){
	            max[i]=Math.max(nums[i], max[i-1]*nums[i]);
	            min[i]=Math.min(nums[i], min[i-1]*nums[i]);
	        }else{
	            max[i]=Math.max(nums[i], min[i-1]*nums[i]);
	            min[i]=Math.min(nums[i], max[i-1]*nums[i]);
	        }
	 
	        result = Math.max(result, max[i]);
	    }
	 
	    return result;
	}
	
	public int maxProduct_my(int[] nums) {
		int maxProduct = nums[0];
		int max = nums[0];
		int min = nums[0];
		for(int i=1; i<nums.length; i++) {
			int tempMax = max;
			int tempMin = min;
			if(nums[i] < 0) {
				max = Math.max(nums[i], tempMin * nums[i]);
				min = Math.min(nums[i], tempMax * nums[i]);
			}else {
				max = Math.max(nums[i], tempMax * nums[i]);
				min = Math.min(nums[i], tempMin * nums[i]);
			}
			if(maxProduct < max)
				maxProduct = max;
		}
		
        return maxProduct;
    }
	
	public int maxProduct_my_ORG(int[] nums) {
		int maxProduct = nums[0];
		int product = nums[0];
		for(int i=1; i<nums.length; i++) {
			if(i < nums.length-1 && product * nums[i] < 0 & nums[i+1] < 0)
				product = product * nums[i];
			else if(product < product * nums[i]) {
				product = product * nums[i];
				if(product > maxProduct)
					maxProduct = product;
			}else {
				if(product > maxProduct)
					maxProduct = product;
				product = nums[i];
			}
		}
		
		if(product > maxProduct)
			maxProduct = product;
		
        return maxProduct;
    }
}
