package com.kausha.algo.leetcode;

public class MergeSortedArrays {

	public static void main(String[] args) {
		int[] nums1 = new int[8];
		nums1[0] = 1;
		nums1[1] = 3;
		nums1[2] = 5;
		nums1[3] = 6;
		int[] nums2 = new int[] {3, 6, 8, 9};
		MergeSortedArrays ma = new MergeSortedArrays();
		ma.merge(nums1, 4, nums2, 4);
		
		for(int i=0; i < nums1.length; i++)
			System.out.println(nums1[i]);
	}

	public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i= nums1.length-1; i >=0; i--) {
        	if(n > 0 && m > 0) {
	        	if(nums1[m-1] > nums2[n-1]) {
	        		nums1[i] = nums1[m-1];
	        		m--;
	        	}else {
	        		nums1[i] = nums2[n-1];
	        		n--;
	        	}
        	}else if(m > 0) {
        		nums1[i] = nums1[m-1];
        		m--;
        	}else {
        		nums1[i] = nums2[n-1];
        		n--;
        	}
        }
    }
}
