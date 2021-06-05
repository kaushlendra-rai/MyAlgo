package com.kausha.algo.leetcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// https://leetcode.com/problems/rotting-oranges/
/**
 * You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 * @author sinkar
 *
 */
public class RotteningOranges {

	public static void main(String[] args) {
		RotteningOranges ro = new RotteningOranges();
		
		//int[][] grid = new int[][] {{2,1,1},{1,1,0},{0,1,1}};
		//int[][] grid = new int[][] {{2,1,1},{0,1,1},{1,0,1}};
		//int[][] grid = new int[][] {{0, 2}}; // 0
		//int[][] grid = new int[][] {{1}}; //-1
		//int[][] grid = new int[][] {{2, 2, 2}}; // 0
		int[][] grid = new int[][] {{1}, {2}, {1}, {1}}; // 2
		System.out.println(ro.orangesRotting(grid));
	}

//	public int orangesRotting(int[][] grid) {
//		Set<MatrixNode> fresh = new HashSet<>();
//		Set<MatrixNode> rotten = new HashSet<>();
//		Set<MatrixNode> newRotten = new HashSet<>();
//		
//		for(int i=0; i < grid.length; i++)
//			for(int j=0; j<grid[0].length; j++)
//				if(grid[i][j] == 1)
//					fresh.add(new MatrixNode(i, j));
//				else if(grid[i][j] == 2)
//					rotten.add(new MatrixNode(i, j));
//		
//		if(fresh.size() > 0 && rotten.size() == 0)
//			return -1;
//		
//		Iterator<MatrixNode> itr = rotten.iterator();
//		int time = 0;
//		boolean oneMatchFound = false;
//		while(itr.hasNext()) {
//			String rottenNode = itr.next();
//			String[] rottenPoints = rottenNode.split(" ");
//			int i = Integer.parseInt(rottenPoints[0]);
//			int j = Integer.parseInt(rottenPoints[1]);
//			// Check if any neighbor node is fresh, if it is, add it to the new rotten set;
//			if(fresh.contains((i+1) + " " + j)) {
//				newRotten.add((i+1) + " " + j);
//				fresh.remove((i+1) + " " + j);
//				oneMatchFound = true;
//			}
//			if(fresh.contains((i-1) + " " + j)) {
//				newRotten.add((i-1) + " " + j);
//				fresh.remove((i-1) + " " + j);
//				oneMatchFound = true;
//			}
//			if(fresh.contains(i + " " + (j+1))) {
//				newRotten.add(i + " " + (j+1));
//				fresh.remove(i + " " + (j+1));
//				oneMatchFound = true;
//			}
//			if(fresh.contains(i + " " + (j-1))) {
//				newRotten.add(i + " " + (j-1));
//				fresh.remove(i + " " + (j-1));
//				oneMatchFound = true;
//			}
//			
////			System.out.println("Fresh: " + fresh);
////			System.out.println("rotten: " + rotten);
////			System.out.println("newRotten: " + newRotten);
//			
//			if(fresh.size() == 0 || (newRotten.size() == 0 && rotten.size() == 0)) {
//				break;
//			}
//			if(!itr.hasNext()) {
//				rotten = newRotten;
//				itr = rotten.iterator();
//				newRotten = new HashSet<>();
//				if(oneMatchFound == true)
//					time++;
//				oneMatchFound = false;
//			}
//		}
//		// Some fresh orange is not reachable.
//		if(fresh.size() > 0)
//			return -1;
//		if(oneMatchFound)
//			time++;
//		
//        return time;
//    }
	
	public int orangesRotting(int[][] grid) {
		Set<String> fresh = new HashSet<>();
		Set<String> rotten = new HashSet<>();
		Set<String> newRotten = new HashSet<>();
		
		for(int i=0; i < grid.length; i++)
			for(int j=0; j<grid[0].length; j++)
				if(grid[i][j] == 1)
					fresh.add(i + " " + j);
				else if(grid[i][j] == 2)
					rotten.add(i + " " + j);
		
		if(fresh.size() > 0 && rotten.size() == 0)
			return -1;
		
		Iterator<String> itr = rotten.iterator();
		int time = 0;
		boolean oneMatchFound = false;
		while(itr.hasNext()) {
			String rottenNode = itr.next();
			String[] rottenPoints = rottenNode.split(" ");
			int i = Integer.parseInt(rottenPoints[0]);
			int j = Integer.parseInt(rottenPoints[1]);
			// Check if any neighbor node is fresh, if it is, add it to the new rotten set;
			if(fresh.contains((i+1) + " " + j)) {
				newRotten.add((i+1) + " " + j);
				fresh.remove((i+1) + " " + j);
				oneMatchFound = true;
			}
			if(fresh.contains((i-1) + " " + j)) {
				newRotten.add((i-1) + " " + j);
				fresh.remove((i-1) + " " + j);
				oneMatchFound = true;
			}
			if(fresh.contains(i + " " + (j+1))) {
				newRotten.add(i + " " + (j+1));
				fresh.remove(i + " " + (j+1));
				oneMatchFound = true;
			}
			if(fresh.contains(i + " " + (j-1))) {
				newRotten.add(i + " " + (j-1));
				fresh.remove(i + " " + (j-1));
				oneMatchFound = true;
			}
			
//			System.out.println("Fresh: " + fresh);
//			System.out.println("rotten: " + rotten);
//			System.out.println("newRotten: " + newRotten);
			
			if(fresh.size() == 0 || (newRotten.size() == 0 && rotten.size() == 0)) {
				break;
			}
			if(!itr.hasNext()) {
				rotten = newRotten;
				itr = rotten.iterator();
				newRotten = new HashSet<>();
				if(oneMatchFound == true)
					time++;
				oneMatchFound = false;
			}
		}
		// Some fresh orange is not reachable.
		if(fresh.size() > 0)
			return -1;
		if(oneMatchFound)
			time++;
		
        return time;
    }
}

class MatrixNode{
	int x;
	int y;
	int time;
	public MatrixNode(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + time;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MatrixNode other = (MatrixNode) obj;
		if (time != other.time)
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	

}