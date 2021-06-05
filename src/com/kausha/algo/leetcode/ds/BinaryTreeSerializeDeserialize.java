package com.kausha.algo.leetcode.ds;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeSerializeDeserialize {

	public static void main(String[] args) {
		CodecB codec = new CodecB();

		TreeNode b1 = new TreeNode(3);
		TreeNode b2 = new TreeNode(9);
		TreeNode b3 = new TreeNode(20);
		TreeNode b4 = new TreeNode(15);
		TreeNode b5 = new TreeNode(7);
		b1.left = b2;
		b1.right = b3;
		b3.left = b4;
		b3.right = b5;
		
		String ser = codec.serialize(null);
		System.out.println("Serialized BST: " + ser);
		
		TreeNode dser = codec.deserialize(ser);
		if(dser != null)
			System.out.println(dser.val);
		if(dser != null && dser.left != null)
			System.out.println(dser.left.val);
		if(dser != null &&  dser.right != null)
			System.out.println(dser.right.val);
		if(dser != null && dser.right != null && dser.right.left != null)
			System.out.println(dser.right.left.val);
		if(dser != null &&  dser.right != null && dser.right.right != null)
			System.out.println(dser.right.right.val);
	}

}

class CodecB {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    	if(root == null)
    		return "#";
    	
    	StringBuilder sb = new StringBuilder();
    	// Do a level order traversal to serialize the tree.
    	Queue<TreeNode> queue = new LinkedList<>();
    	queue.offer(root);
    	Queue<TreeNode> children = new LinkedList<>();
    	while(!queue.isEmpty()) {
    		TreeNode node = queue.poll();
    		if(node != null) {
    			sb.append(node.val).append(" ");
    			children.offer(node.left);
    			children.offer(node.right);
    		}else
    			sb.append("# ");
    		
    		if(queue.isEmpty()) {
    			queue = children;
    			children = new LinkedList<>();
    		}
    	}
    	
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	if("#".contentEquals(data))
    		return null;
    	String[] vals = data.split(" ");
    	Queue<TreeNode> queue = new LinkedList<>();
    	Queue<TreeNode> children = new LinkedList<>();
    	TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
    	queue.offer(root);
    	
    	for(int i=1; i < vals.length; i++) {
    		TreeNode node = queue.poll();
    		TreeNode left = null;
    		if(!"#".contentEquals(vals[i])) {
    			left = new TreeNode(Integer.parseInt(vals[i]));
    			children.offer(left);
    		}
    		node.left = left;
    		i++;
    		TreeNode right = null;
    		if(!"#".contentEquals(vals[i])) {
    			right = new TreeNode(Integer.parseInt(vals[i]));
    			children.offer(right);
    		}
    		node.right = right;
    		
    		if(queue.isEmpty()) {
    			queue = children;
    			children = new LinkedList<>();
    		}
    	}
    	
        return root;
    }
}