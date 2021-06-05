package com.kausha.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/max-points-on-a-line/
public class MaxPointsOnALine {

	public static void main(String[] args) {
		MaxPointsOnALine mp = new MaxPointsOnALine();

		//int[][] points = new int[][] {{1, 2}};
		//int[][] points = new int[][] {{1, 1}, {2, 2}, {3, 3}}; // 3
		// int[][] points = new int[][] {{-1, 1}, {0, 0}, {1, 1}, {2, 2}, {3, 3}}; // 4
		//int[][] points = new int[][] {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}}; // 4
		// int[][] points = new int[][] {{-6, -1}, {3, 1}, {12, 3}};
		
//		int[][] points = new int[][]{{54,153},{1,3},{0,-72},{-3,3},{12,-22},{-60,-322},{0,-5},{-5,1},{5,5},{36,78},{3,-4},{5,0},{0,4},
//			{-30,-197},{-5,0},{60,178},{0,0},{30,53},{24,28},{4,5},{2,-2},{-18,-147},{-24,-172},{-36,-222},{-42,-247},{2,3},{-12,-122},
//			{-54,-297},{6,-47},{-5,3},{-48,-272},{-4,-2},{3,-2},{0,2},{48,128},{4,3},{2,4}};
		//int[][] points = new int[][]{{2, 2}, {4, 6}, {4, 3}, {6, 7}};
		//int[][] points = new int[][]{{2, 3}, {3, 3}, {-5, 3}};
		int[][] points = new int[][]{{7,3},{19,19},{-16,3},{13,17},{-18,1},{-18,-17},{13,-3},{3,7},{-11,12},{7,19},{19,-12},{20,-18},{-16,-15},{-10,-15},{-16,-18},{-14,-1},{18,10},{-13,8},{7,-5},{-4,-9},{-11,2},{-9,-9},{-5,-16},{10,14},{-3,4},{1,-20},{2,16},{0,14},{-14,5},{15,-11},{3,11},{11,-10},{-1,-7},{16,7},{1,-11},{-8,-3},{1,-6},{19,7},{3,6},{-1,-2},{7,-3},{-6,-8},{7,1},{-15,12},{-17,9},{19,-9},{1,0},{9,-10},{6,20},{-12,-4},{-16,-17},{14,3},{0,-1},{-18,9},{-15,15},{-3,-15},{-5,20},{15,-14},{9,-17},{10,-14},{-7,-11},{14,9},{1,-1},{15,12},{-5,-1},{-17,-5},{15,-2},{-12,11},{19,-18},{8,7},{-5,-3},{-17,-1},{-18,13},{15,-3},{4,18},{-14,-15},{15,8},{-18,-12},{-15,19},{-9,16},{-9,14},{-12,-14},{-2,-20},{-3,-13},{10,-7},{-2,-10},{9,10},{-1,7},{-17,-6},{-15,20},{5,-17},{6,-6},{-11,-8}};
			
		System.out.println(mp.maxPoints(points));
	}
	
	// We iterate in nested loop, find the slope for a given set of points.
	// For a given starting point, if the slope between starting and other point already exists, it implies that the 
	// point is on the line with the same slope. 
	// If they do, then those points are on the line for the given pair.
	public int maxPoints(int[][] points) {
        if(points.length < 3)
        	return points.length;
        int maxCount = 0;
        Map<Double, Integer> slopes = new HashMap<>();
        for(int i = 0; i < points.length; i++) {
        	int vertical = 0;
        	// We keep duplicate one for the initial match of the first point from the outer loop.
        	int duplicate = 1;
        	for(int j= i+1; j < points.length; j++) {
        		// Cannot do Division by Zero. Vertical point
        		if(points[i][0] == points[j][0]) {
        			// Check if duplicate
        			if(points[i][1] == points[j][1])
        				duplicate++;
        			else
        				vertical++;
        		}
        		else {
        			double slope = points[i][1] == points[j][1] ? 0.0 : (double)(points[i][1] - points[j][1])/(double)(points[i][0] - points[j][0]);
        		
	        		if(slopes.get(slope) == null)
	        			slopes.put(slope, 1);
	        		else
	        			slopes.put(slope, slopes.get(slope) + 1);
        		}
        	}
        	for(Integer val : slopes.values())
        		if(val + duplicate > maxCount)
        			maxCount = val + duplicate;
        	if(vertical + duplicate > maxCount)
    			maxCount = vertical + duplicate;
        	
        	slopes.clear();
        }
		return maxCount;
    }
}