package com.kausha.algo.leetcode;

import java.util.Stack;

// https://leetcode.com/problems/largest-rectangle-in-histogram/submissions/
public class LargestRectangleInHistogram {

	public static void main(String[] args) {
		//int[] charts = {2, 2, 3, 4, 5, 3, 1};
		//int[] charts = {1, 2, 3, 4, 5, 1, 1, 4, 1, 1, 1, 2};
		//int[] charts = {1, 2, 3, 4, 4, 1, 2, 3, 4, 15, 5, 5, 5};
		// int[] charts = {2, 1, 5, 6, 2, 3};
		// int[] charts = {2, 3, 3, 2};
		// int[] charts = {2, 3};
		 //int[] charts = {2, 3, 0, 3};
		//int[] charts = {2, 3, 0, 5};
		//int[] charts = {2, 1, 2};
		 int[] charts = {2, 1, 3, 4, 2, 3};
		LargestRectangleInHistogram hist = new LargestRectangleInHistogram();
		System.out.println(hist.largestRectangleArea(charts));
	}

	public int largestRectangleArea(int[] heights) {
		if(heights.length == 0)
			return 0;
		
		Stack<Integer> heightStack = new Stack<>();
		Stack<Integer> idxStack = new Stack<>();
		int maxArea = heights[0];
		heightStack.push(heights[0]);
		idxStack.push(0);
		
		for(int i=1; i< heights.length; i++) {
			int heightTop = 0;
			if(!heightStack.isEmpty())
				heightTop = heightStack.peek();
			
			if(heightTop < heights[i]) {
				heightStack.push(heights[i]);
				idxStack.push(i);
			} else if(heightTop > heights[i]) {
				int lastPoppedIdx = 0;
				// Process all heights larger than current height.
				while(heightTop > heights[i]) {
					int height = heightStack.pop();
					lastPoppedIdx = idxStack.pop();

					if(maxArea < height*(i-lastPoppedIdx))
						maxArea = height*(i-lastPoppedIdx);
					
					if(!heightStack.isEmpty())
						heightTop = heightStack.peek();
					else
						heightTop = 0;
				}
				// Put the new height on the top.
				heightStack.push(heights[i]);
				idxStack.push(lastPoppedIdx);
			}
		}
		
		while(!heightStack.isEmpty()) {
			//System.out.println("heightStack.peek():" + heightStack.peek() + ", idxStack.peek():" + idxStack.peek() + ", maxArea: " + maxArea);
			int area = heightStack.pop() * (heights.length - idxStack.pop());
			if(area > maxArea)
				maxArea = area;
		}
		
		return maxArea;
	}
	

}
