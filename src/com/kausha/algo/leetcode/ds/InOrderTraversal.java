package com.kausha.algo.leetcode.ds;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {

	public static void main(String[] args) {
//		TreeNode b1 = new TreeNode(7);
//		TreeNode b2 = new TreeNode(3);
//		TreeNode b3 = new TreeNode(9);
//		TreeNode b4 = new TreeNode(11);
//		b1.left = b2;
//		b1.right = b3;
//		b3.right = b4;
		
//		TreeNode b1 = new TreeNode(1); // 1, 3, 2
//		TreeNode b2 = new TreeNode(2);
//		TreeNode b3 = new TreeNode(3);
//		b1.right = b2;
//		b2.left = b3;
		
		//TreeNode b1 = null;
		
		//TreeNode b1 = new TreeNode(1);
		
//		TreeNode b1 = new TreeNode(1);
//		TreeNode b2 = new TreeNode(2);
//		b1.left = b2;
//		
		TreeNode b1 = new TreeNode(1);
		TreeNode b2 = new TreeNode(2);
		b1.right = b2;
		
		InOrderTraversal iot = new InOrderTraversal();
		System.out.println(iot.inorderTraversal(b1));
	}

	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        if(root == null)
        	return values;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while(!stack.isEmpty()) {
        	TreeNode node = stack.pop();
        	TreeNode left = node.left;
        	
        	if(node.right != null) {
        		stack.push(node.right);
        	}

        	if(node.left != null) {
        		stack.push(node.left);
        	}
        }
        
        return values;
    }
	
	public List<Integer> inorderTraversal_rec(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        if(root == null)
        	return values;
        inorderTraversal_rec(root, values);
        return values;
    }
        
	private void inorderTraversal_rec(TreeNode root, List<Integer> values) {
        if(root == null)
          	return;
           
        if(root.left != null) 
        	inorderTraversal_rec(root.left, values);
            
        values.add(root.val);
        
         if(root.right != null)
        	 inorderTraversal_rec(root.right, values);
	}
}
