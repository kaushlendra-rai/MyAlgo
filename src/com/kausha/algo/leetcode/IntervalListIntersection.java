package com.kausha.algo.leetcode;

import java.util.ArrayList;

// https://leetcode.com/problems/interval-list-intersections/
/**
 * You are given two lists of closed intervals, firstList and secondList, where 
 * firstList[i] = [starti, endi] and secondList[j] = [startj, endj]. Each list of intervals
 *  is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

A closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.

The intersection of two closed intervals is a set of real numbers that are either empty or
 represented as a closed interval. For example, the intersection of [1, 3] and [2, 4] is [2, 3].

 

Example 1:


Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
Example 2:

Input: firstList = [[1,3],[5,9]], secondList = []
Output: []
Example 3:

Input: firstList = [], secondList = [[4,8],[10,12]]
Output: []
Example 4:

Input: firstList = [[1,7]], secondList = [[3,10]]
Output: [[3,7]]
 * @author sinkar
 *
 */
public class IntervalListIntersection {

	public static void main(String[] args) {
//		int[][] firstList = new int[][] {{0,2},{5,10},{13,23},{24,25}};
//		int[][] secondList = new int[][] {{1,5},{8,12},{15,24},{25,26}};

//		int[][] firstList = new int[][] {{0,2},{5,10},{13,23},{24,25}};
//		int[][] secondList = new int[][] {};
//		int[][] firstList = new int[][] {{1, 7}};
//		int[][] secondList = new int[][] {{3, 10}};
		
		int[][] firstList = new int[][] {{4, 6}, {7, 8}, {10, 17}};
		int[][] secondList = new int[][] {{5, 10}};
		
		IntervalListIntersection il = new IntervalListIntersection();
		int[][] intersection = il.intervalIntersection(firstList, secondList);
		
		for(int i=0; i < intersection.length; i++) {
			System.out.println(intersection[i][0] + ", " + intersection[i][1]);
		}
	}
	
	public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
		if(firstList == null || firstList.length == 0 || secondList == null || secondList.length == 0)
			return new int[][] {};
		
		int idx1 = 0;
		int idx2 = 0;
		ArrayList<int[]> blocks = new ArrayList<>();
		while(idx1 < firstList.length && idx2 < secondList.length) {
			if(firstList[idx1][0] <= secondList[idx2][0] && firstList[idx1][1] >= secondList[idx2][0]) {
				if(firstList[idx1][1] <= secondList[idx2][1]) {
					blocks.add(new int[] {secondList[idx2][0], firstList[idx1][1]});
					idx1++;
				}else {
					blocks.add(new int[] {secondList[idx2][0], secondList[idx2][1]});
					idx2++;
				}
			}else if(firstList[idx1][0] >= secondList[idx2][0] && firstList[idx1][0] <= secondList[idx2][1]) {
				if(firstList[idx1][1] <= secondList[idx2][1]) {
					blocks.add(new int[] {firstList[idx1][0], firstList[idx1][1]});
					idx1++;
				}else {
					blocks.add(new int[] {firstList[idx1][0], secondList[idx2][1]});
					idx2++;
				}
			}else if(firstList[idx1][0] <= secondList[idx2][0])
				idx1++;
			else
				idx2++;
		}

		int[][] result = new int[blocks.size()][2];
		for(int i=0; i < blocks.size(); i++)
			result[i] = blocks.get(i);
		
        return result;
    }

}
