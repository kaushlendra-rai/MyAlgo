package com.kausha.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletsWithSumK {
	public static void main(String[] args) {
		int num[] = {1, 3, 5, 7, 9, 2, 6, 11, 24, 35, 67, 123, 654, 65, 76};
		
		List<String> triplets = findTripletsWithSum(num, 28);
		
		System.out.println("Triplets = " + triplets);
	}

	private static List<String> findTripletsWithSum(int[] nums, int sum) {
		// First Sort the number
		Arrays.sort(nums);
		List<String> triplets = new ArrayList<String>();
		
		for(int i=0; i < nums.length-2; i++){
			int residue = sum - nums[i];
			
			if(residue > 0){
				int start=i+1;
				int end = nums.length-1;
				
				while(start < end){
					if(nums[start] + nums[end] == residue){
						triplets.add(nums[i] + ", " + nums[start]  + " , " + nums[end]);
						break;
					}else if(nums[start] + nums[end] > residue){
						end--;
					}else{
						start++;
					}
				}
			}
		}
		
		return triplets;
	}
}