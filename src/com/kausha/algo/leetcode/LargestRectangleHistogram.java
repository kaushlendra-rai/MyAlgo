package com.kausha.algo.leetcode;

public class LargestRectangleHistogram {

	public static void main(String[] args) {
		LargestRectangleHistogram rec = new LargestRectangleHistogram();
		int[] heights = new int[] {2,1,5,6,2,3};
		System.out.println(rec.largestRectangleArea(heights));
	}

	public int largestRectangleArea(int[] heights) {
		if(heights.length == 0)
			return 0;
		
		int[] temp = new int[heights.length];
		temp[0] = heights[0];
		
		for(int i=1; i<heights.length; i++) {
			int min = heights[i];
			int localArea = 0;  
			for(int j=i-1; j >= 0; j--) {
				localArea = (i-j) * min;
				if(localArea > temp[i])
					temp[i] = localArea;
				if(min > heights[j])
					min = heights[j];
			}
		}
		
        return 0;
    }
}
