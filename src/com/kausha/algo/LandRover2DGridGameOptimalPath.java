package com.kausha.algo;

import java.util.LinkedList;
import java.util.Queue;

public class LandRover2DGridGameOptimalPath {

	public static void main(String[] args) {
		int[][] grid = getInitializedInputGrid();
		Node[][] nodeStatus = initializeNodeStatus(grid);
		Queue<Node> queue = new LinkedList<Node>();
		
		if(grid[0][0] == 1)
			nodeStatus[0][0].setCount(1);
		
		queue.offer(nodeStatus[0][0]);
		traverseGrid(grid, queue, nodeStatus);
		
		System.out.println("\nOUTPUT ::");
		printShortestPathNew(nodeStatus);
	}

	private static void traverseGrid(int[][] grid, Queue<Node> queue, Node[][] nodeStatus){
		while(!queue.isEmpty()){
			Node node = queue.poll();
			
			if(grid[node.getX()][node.getY()] != 0){
				updateNodeValue(grid, node.getX()-1, node.getY(), queue, nodeStatus, node);
				updateNodeValue(grid, node.getX()+1, node.getY(), queue, nodeStatus, node);
				updateNodeValue(grid, node.getX(), node.getY()-1, queue, nodeStatus, node);
				updateNodeValue(grid, node.getX(), node.getY()+1, queue, nodeStatus, node);
			}
		}
	}
	
	private static void updateNodeValue(int[][] grid, int x, int y, Queue<Node> queue, Node[][] nodeStatus, Node parentNode){
		if(x >=0 && x < nodeStatus.length && y >= 0 && y < nodeStatus[0].length){
			Node node = nodeStatus[x][y];
			
			// If a Shorter path found, update count and add the new node for further traversal.
			if(grid[x][y] != 0 && node.getCount() > parentNode.getCount() + grid[x][y]){
				node.setCount(parentNode.getCount() + 1);
				
				node.setParentX(parentNode.getX());
				node.setParentY(parentNode.getY());
				queue.offer(node);
			}
		}
	}
	
	private static void printShortestPathNew(Node[][] nodeStatus){
		int x = nodeStatus.length-1;
		int y = nodeStatus[0].length-1;
		
		while(x + y > 0){
			Node node = nodeStatus[x][y];
			System.out.println("x, y = " + node.getX() + " , " + node.getY());
			x = node.getParentX();
			y = node.getParentY();
		}
		
		System.out.println("x, y = 0 , 0");
	}
	
	private static int[][] getInitializedInputGrid() {
		int[][] grid = {{1, 0, 0, 0, 0, 0, 1, 1, 1},
						{1, 0, 1, 1, 1, 1, 1, 1, 0},
						{1, 1, 1, 1, 0, 0, 0, 1, 0},
						{1, 0, 1, 1, 1, 0, 0, 1, 1},
						{1, 1, 1, 0, 1, 0, 0, 0, 1}};
		
		return grid;
	}
	
	private static Node[][] initializeNodeStatus(int[][] grid){
		Node[][] nodeStatus = new Node[grid.length][grid[0].length];
		
		for(int i = 0; i < grid.length; i++){
			for(int j=0; j < grid[0].length; j++){
				Node node = new Node();
				node.setX(i);
				node.setY(j);
				node.setCount(Integer.MAX_VALUE);
				
				nodeStatus[i][j] = node;
			}
		}
		
		System.out.println("INPUT ::");
		for(int i = 0; i < grid.length; i++){
			for(int j=0; j < grid[0].length; j++){
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
		
		return nodeStatus;
	}
}

class Node{
	// It is the distance of the Top-Left node from current node.
	private int count;
	
	private int x;
	private int y;
	
	private int parentX;
	private int parentY;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getParentX() {
		return parentX;
	}
	public void setParentX(int parentX) {
		this.parentX = parentX;
	}
	public int getParentY() {
		return parentY;
	}
	public void setParentY(int parentY) {
		this.parentY = parentY;
	}
}