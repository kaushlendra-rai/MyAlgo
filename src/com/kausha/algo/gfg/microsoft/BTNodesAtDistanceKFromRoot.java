package com.kausha.algo.gfg.microsoft;

import java.util.ArrayList;

// https://practice.geeksforgeeks.org/problems/k-distance-from-root/1/?company[]=Microsoft&company[]=Microsoft&page=1&query=company[]Microsoftpage1company[]Microsoft
public class BTNodesAtDistanceKFromRoot {
	public static void main(String[] args) {
		BTNodesAtDistanceKFromRoot bnt = new BTNodesAtDistanceKFromRoot();
		
		Node root = new Node(1);
		Node node1 = new Node(2);
		Node node2 = new Node(3);
		Node node3 = new Node(4);
		Node node4 = new Node(5);
		Node node5 = new Node(6);
		Node node6 = new Node(7);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node2.left = node4;
		node2.right = node5;
		node3.right = node6;
		
		System.out.println(bnt.Kdistance(root, 2)); // 4, 5, 6
		System.out.println(bnt.Kdistance(root, 0)); // 1
	}

	ArrayList<Integer> Kdistance(Node root, int k)
    {
         ArrayList<Integer> distant = new ArrayList<>();
         kDistance(root, k, 0, distant);
         return distant;
    }
	
	private void kDistance(Node root, int k, int currentHeight, ArrayList<Integer> distant) {
		if(root == null)
			return;
		if(currentHeight == k) {
			distant.add(root.data);
			return;
		}
		
		kDistance(root.left, k, currentHeight + 1, distant);
		kDistance(root.right, k, currentHeight + 1, distant);
	}
}
