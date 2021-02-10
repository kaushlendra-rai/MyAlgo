package com.kausha.algo;

import java.util.Stack;

/**
 * Google Question:
Given a gird of NxN cells, with Integer cell values, we can define a path effort of a path from source (0,0) to the
 destination (N-1, N-1) as the max of the absolute differences of the adjacent cell values. While traversing, you can 
 move up, down, left and right — 4 moves from the current cell in the grid.
 For a given Threshold value, find if it is possible to have a path in such a matrix with the effort not greater than
 the threshold value, from source to destination.

Example:
If we have a 3x3 matrix as follows -
[[1, 2, 3],
[4, 5, 6],
[7, 8, 9]]
Let’s say the threshold is 3.
Result: true
One of the path is : 1 -> 2 -> 5 -> 8 -> 9. the abs differences of the adj cells in this path is — [1, 3, 3, 1], max of them is 3 => thus the path has an effort 3.
 * @author sinkar
 *
 */

public class ThresholdPathIn2DMatrix {

	
	public static void main(String[] args) {
		int[][] matrix = new int[][] {{ 1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		
		int threshold = 3; // true as explained in the example in the question above.
		// int threshold = 2; // false here as we cannot reach the other corner with this threshold value.
		System.out.println(isPathPossible(matrix, threshold));
	}

	private static boolean isPathPossible(int[][] matrix, int threshold) {
		boolean pathExists = false;
		
		Stack<Coordinate> stack = new Stack<Coordinate>();
		// Maintains track if a block has already been traversed to ensure we do not repeat it.
		boolean[][] visitedMatrix = new boolean[matrix.length][matrix[0].length];
		
		Coordinate root = new Coordinate(0, 0);
		stack.push(root);
		
		while(!stack.isEmpty()) {
			Coordinate node = stack.pop();
			if(node.x == matrix.length-1 && node.y == matrix[0].length-1) {
				pathExists = true;
				break;
			}
			
			// If we have not reached the end, discover nodes that can be added for exploration.
			// Add left node
			if(node.x > 0 && !visitedMatrix[node.y][node.x-1] && (Math.abs(matrix[node.y][node.x] - matrix[node.y][node.x-1])) <= threshold) {
				stack.push(new Coordinate(node.x-1, node.y));
			}
			// Add right node
			if(node.x < matrix[0].length-1 && !visitedMatrix[node.y][node.x+1] && (Math.abs(matrix[node.y][node.x] - matrix[node.y][node.x+1])) <= threshold) {
				stack.push(new Coordinate(node.x+1, node.y));
			}
			// Add the up node
			if(node.y > 0 && !visitedMatrix[node.y-1][node.x]  && (Math.abs(matrix[node.y][node.x] - matrix[node.y-1][node.x])) <= threshold) {
				stack.push(new Coordinate(node.x, node.y-1));
			}
			// Add the down node
			if(node.y < matrix.length-1 && !visitedMatrix[node.y+1][node.x]  && (Math.abs(matrix[node.y][node.x] - matrix[node.y+1][node.x])) <= threshold) {
				stack.push(new Coordinate(node.x, node.y+1));
			}
			
			visitedMatrix[node.y][node.x] = true;
		}
		
		return pathExists;
	}
}

class Coordinate{
	int x;
	int y;
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
}