package com.kausha.algo.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/merge-intervals/
public class IntervalMergeForArrays {
	public static void main(String[] args) {
		//int[][] interval = new int[][] {{4, 6}, {7, 8}, {10, 17}};
		//int[][] interval = new int[][] {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
		//int[][] interval = new int[][] {};
		//int[][] interval = new int[][] {{1, 4}, {4, 5}};
		//int[][] interval = new int[][] {{1, 4}, {2, 3}};
		int[][] interval = new int[][] {{1, 10}, {2, 3}, {4, 6}, {8, 12}, {12, 14}, {16, 18}};
		
		IntervalMergeForArrays il = new IntervalMergeForArrays();
		int[][] intersection = il.merge(interval);
		
		for(int i=0; i < intersection.length; i++) {
			System.out.println(intersection[i][0] + ", " + intersection[i][1]);
		}
	}
	
	public int[][] merge(int[][] intervals) {
		if(intervals.length == 0)
			return new int[][] {};
			
		// Sort by start number first and then merge.
		List<Range> rangeList = new ArrayList<>();
		for(int i = 0; i < intervals.length; i++)
			rangeList.add(new Range(intervals[i][0], intervals[i][1]));
		
		Collections.sort(rangeList);
		
		List<Range> mergedList = new ArrayList<>();
		
		int start = rangeList.get(0).start;
		int end = rangeList.get(0).end;
		for(int i = 1; i < intervals.length; i++) {
			if(end < rangeList.get(i).start) {
				mergedList.add(new Range(start, end));
				start = rangeList.get(i).start;
				
			}
			
			if(end < rangeList.get(i).end)
				end = rangeList.get(i).end;
		}
		mergedList.add(new Range(start, end));
		
		int[][] mergedRange = new int[mergedList.size()][2];
		// Convert the List to array
		for(int i=0; i < mergedList.size(); i++) {
			mergedRange[i] = new int[] {mergedList.get(i).start, mergedList.get(i).end};
			
		}
		
        return mergedRange;
    }
}

class Range implements Comparable<Range>{
		int start;
		int end;
		public Range(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Range range) {
			return start - range.start;
		}
}