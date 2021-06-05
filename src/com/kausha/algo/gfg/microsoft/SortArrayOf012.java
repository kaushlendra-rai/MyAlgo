package com.kausha.algo.gfg.microsoft;

//https://practice.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1/?company[]=Microsoft&company[]=Microsoft&page=1&query=company[]Microsoftpage1company[]Microsoft
/**
 * Given an array of size N containing only 0s, 1s, and 2s; sort the array in ascending order.

Example 1:

Input: 
N = 5
arr[]= {0 2 1 2 0}
Output:
0 0 1 2 2
Explanation:
0s 1s and 2s are segregated 
into ascending order.

 * @author sinkar
 *
 */
public class SortArrayOf012 {

	public static void main(String[] args) {
//		int[] arr = new int[] {0, 2, 1, 2, 0}; //  0 0 1 2 2
//		int[] arr2 = new int[] {0, 2, 1, 0, 0}; //  0 0 0 1 2
		int[] arr = new int[] {0, 0, 0 , 0}; //  0 0 1 2 2
		int[] arr2 = new int[] {0}; //  0 0 0 1 2
		SortArrayOf012.sort012(arr, arr.length);
		SortArrayOf012.sort012(arr2, arr2.length);
		for(int num : arr)
			System.out.print(" " + num);
		System.out.println();
		for(int num : arr2)
			System.out.print(" " + num);
	}

	public static void sort012(int a[], int n)
    {
         int low = 0;
         int high = a.length-1;
         int idx = 0;
         
         while(idx <= high) {
        	 if(a[idx] == 0) {
        		 swap(a, low++, idx++);
        	 }else if(a[idx] == 2) {
        		 swap(a, high--, idx);
        	 }else {
        		 idx++;
        	 }
         }
    }

	private static void swap(int[] a, int low, int idx) {
		int temp = a[low];
		a[low] = a[idx];
		a[idx] = temp;
	}
}
