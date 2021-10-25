package com.kausha.algo.leetcode.ds;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
/**
 * You are given a perfect binary tree where all leaves are on the same level,
 *  and every parent has two children. The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node,
 the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.
 * @author sinkar
 *
 */
public class BSTPopulateNextPointerWithRightSibling {

	public static void main(String[] args) {
		BSTPopulateNextPointerWithRightSibling pn = new BSTPopulateNextPointerWithRightSibling();

		Node b1 = new Node(3);
		Node b2 = new Node(9);
		Node b3 = new Node(20);
		Node b4 = new Node(15);
		Node b5 = new Node(7);
		b1.left = b2;
		b1.right = b3;
		b3.left = b4;
		b3.right = b5;
		
		pn.connect(b1);
		
		System.out.println(b1.val);
		System.out.println(b1.next);
		System.out.println(b2.val);
		System.out.println(b2.next.val);
		System.out.println(b2.next.next);
	}

	
	public Node connect(Node root) {
		if(root == null)
			return null;
		
		// We do a level order traversal and then connect.
		Queue<Node> queue = new LinkedList<>();
		Queue<Node> children = new LinkedList<>();
		
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			if(node.left != null)
				children.offer(node.left);
			if(node.right != null)
				children.offer(node.right);
			
			if(!queue.isEmpty()) {
				node.next = queue.peek();
			}else {
				queue = children;
				children = new LinkedList<>();
			}
		}
		
        return root;
    }
}
