package com.kausha.algo.leetcode.ds;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/path-sum-iii/submissions/
public class PathSum {

	public static void main(String[] args) {
//		TreeNode b1 = new TreeNode(7);
//		TreeNode b2 = new TreeNode(3);
//		TreeNode b3 = new TreeNode(3);
//		TreeNode b4 = new TreeNode(19);
//		TreeNode b5 = new TreeNode(19);
//		b1.left = b2;
//		b1.right = b3;
//		b3.right = b4;
//		b2.left = b5;

//		TreeNode b1 = new TreeNode(10);
//		TreeNode b2 = new TreeNode(5);
//		TreeNode b3 = new TreeNode(-3);
//		TreeNode b4 = new TreeNode(3);
//		TreeNode b5 = new TreeNode(2);
//		TreeNode b6 = new TreeNode(11);
//		TreeNode b7 = new TreeNode(3);
//		TreeNode b8 = new TreeNode(2);
//		TreeNode b9 = new TreeNode(1);
//		b1.left = b2;
//		b1.right = b3;
//		b2.left = b4;
//		b2.right = b5;
//		b3.right = b6;
//		b4.left = b7;
//		b4.right = b8;
//		b5.right = b9;		
		//TreeNode b1 = new TreeNode(7);
		
//		TreeNode b1 = new TreeNode(7);
//		TreeNode b2 = new TreeNode(3);
//		b1.left = b2;

		TreeNode b1 = new TreeNode(0);
		TreeNode b2 = new TreeNode(1);
		TreeNode b3 = new TreeNode(1);
		b1.left = b2;
		b1.right = b3;

		PathSum ps = new PathSum();
		System.out.println(ps.pathSum(b1, 1));
	}
	
	// We need pre-order traversal
	public int pathSum(TreeNode root, int sum) {
        if(root == null)
        	return 0;
        
        List<Integer> list = new ArrayList<>();
        int paths = pathSum(root, sum, list);
        return paths;
    }

	public int pathSum(TreeNode root, int sum, List<Integer> list) {
        if(root == null)
        	return 0;
        
        // Check if adding current node helps us achieve the sum.
        list.add(root.val);
        int localSum = 0;
        int totalMatch = 0;
        System.out.println("List: " + list);
        for(int i=list.size()-1; i>=0; i--) {
        	System.out.println(list.get(i));
        	localSum += list.get(i);
        	if(localSum == sum) {
        		totalMatch += 1;
        		System.out.println("Match found");
        		//break;
        	}
        }
        
        int leftMatch = pathSum(root.left, sum, list);
        int rightMatch = pathSum(root.right, sum, list);
        totalMatch += leftMatch + rightMatch;
        
        list.remove(list.size()-1);
        
        return totalMatch;
    }
}
