package com.kausha.algo.gfg.microsoft;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import com.sun.tools.sjavac.server.SysInfo;

// https://practice.geeksforgeeks.org/problems/269f61832b146dd5e6d89b4ca18cbd2a2654ebbe/1/?company[]=Microsoft&company[]=Microsoft&page=1&query=company[]Microsoftpage1company[]Microsoft
public class CovidSpread {

	public static void main(String[] args) {
		CovidSpread cs = new CovidSpread();
//		int[][] hospital = new int[][] {  // 2
//			{2, 1, 0, 2, 1},
//			{1, 0, 1, 2, 1},
//			{1, 0, 0, 2, 1},
//		};
		
//		int[][] hospital = new int[][] {  // -1
//			{2, 1, 0, 2, 1},
//			{0, 0, 1, 2, 1},
//			{1, 0, 0, 2, 1},
//		};
		
		int[][] hospital = new int[][] {  // 2
			{1, 2, 0},
			{0, 0, 0},
		};
		
		System.out.println(cs.helpaterp(hospital));
	}

	public int helpaterp(int[][] hospital) {
		// We use Breadth-first traversal approach with nodes being the current grid and adjNodes the valid up/right/etc.
        int counter = 0;
        int left = 0;
        Queue<Grid> queue = new LinkedList<>();
        Queue<Grid> children = new LinkedList<>();
        // Scan through the hospital and find all initial grid nodes to start with.
        for(int i=0; i< hospital.length; i++) {
        	for(int j=0; j < hospital[0].length; j++) {
        		if(hospital[i][j] == 2)
        			queue.offer(new Grid(i, j));
        		if(hospital[i][j] == 0)
        			left++;
        	}
        }

        // We set value of node to '3' to indicate that it has been traversed.
        while(!queue.isEmpty()) {
        	Grid node = queue.poll();
        	if(hospital[node.x][node.y] != 3) {
	        	// Check for node's validity of boundary conditions of grid.
	        	if(node.x -1>= 0 && node.y >= 0 && hospital[node.x-1][node.y] ==1)
	        		children.add(new Grid(node.x-1, node.y));
	        	if(node.x >= 0 && node.y-1 >= 0 && hospital[node.x][node.y-1] ==1)
	        		children.add(new Grid(node.x, node.y-1));
	        	if(node.x +1 <= hospital.length-1  && node.y >= 0 && hospital[node.x +1][node.y] ==1)
	        		children.add(new Grid(node.x+1, node.y));
	        	if(node.x >= 0 && node.y +1 <= hospital[0].length-1 && hospital[node.x][node.y+1] ==1)
	        		children.add(new Grid(node.x, node.y+1));
	        	
	        	hospital[node.x][node.y] = 3;
	        	left++;

	        	if(queue.isEmpty() && !children.isEmpty()) {
	        		counter++;
	        		queue = children;
	        		children = new LinkedList<>();
	        	}
        	}
        }
        
        if(left == hospital.length * hospital[0].length)
        	return counter;
        else
        	return -1;
    }
}

class Grid{
	int x;
	int y;
	
	int val;
	public Grid(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int hashCode() {
		return ("" +x +y).hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		Grid grid = (Grid) obj;
		if(this.x == grid.x && this.y == grid.y)
			return true;
		else
			return false;
	}
}