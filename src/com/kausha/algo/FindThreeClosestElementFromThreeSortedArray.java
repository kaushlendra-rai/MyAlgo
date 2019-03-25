package com.kausha.algo;

//  http://www.geeksforgeeks.org/find-three-closest-elements-from-given-three-sorted-arrays/
public class FindThreeClosestElementFromThreeSortedArray {
	public static void main(String[] args) {
		int[] a = {1, 4, 10};
	    int[] b = {2, 15, 20};
	    int[] c = {8, 10, 12};
	    
	    findClosest(a, b, c);
	}

	private static void findClosest(int[] a, int[] b, int[] c) {
		int i=0, j=0, k=0;
		
		int lowestDiff = Integer.MAX_VALUE;
		int a1=0, b1 = 0, c1 = 0;
		
		while(i <a.length && j < b.length && k < c.length){
			int minimum = min(a[i], min(b[j], c[k]));
			int maximum = max(a[i], max(b[j], c[k]));
			
			if(lowestDiff > (maximum - minimum)){
				a1 = i;
				b1=j;
				c1 = k;
				
				lowestDiff = maximum - minimum;
			}
			
			if(a[i] == minimum)
				i++;
			else if(b[j] == minimum)
				j++;
			else
				k++;
		}
		
		System.out.println(a[a1]  + " , " + b[b1] + "  ,  " + c[c1]);
	}

	private static int min(int i, int j) {
		return i < j?i:j;
	}
	
	private static int max(int i, int j) {
		return i < j?j:i;
	}
}