package com.kausha.algo.leetcode.ds;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// https://leetcode.com/problems/serialize-and-deserialize-bst/
// MInd it, it is BST and not binary Tree. We need to use property of BST to save on space.
public class BSTSerializeDeserialize {

	public static void main(String[] args) {
		Codec codec = new Codec();

		TreeNode b1 = new TreeNode(10);
		TreeNode b2 = new TreeNode(5);
		TreeNode b3 = new TreeNode(20);
		TreeNode b4 = new TreeNode(15);
		TreeNode b5 = new TreeNode(30);
		b1.left = b2;
		b1.right = b3;
		b3.left = b4;
		b3.right = b5;
		
		String ser = codec.serialize(b1);
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

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    	if(root == null)
    		return "";
    	
    	StringBuilder sb = new StringBuilder();
    	// Do a pre-order traversal to serialize the tree.
    	Stack<TreeNode> stack = new Stack<>();
    	stack.push(root);
    	while(!stack.isEmpty()) {
    		TreeNode node = stack.pop();
    		if(node != null) {
    			sb.append(node.val).append(" ");
    			stack.push(node.right);
    			stack.push(node.left);
    		}
    	}
    	
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	if("".contentEquals(data))
    		return null;
    	String[] vals = data.split(" ");
    	Queue<TreeNode> queue = new LinkedList<>();
    	for(String val : vals)
    		queue.offer(new TreeNode(Integer.parseInt(val)));
    	
    	return deserialize(queue, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public TreeNode deserialize(Queue<TreeNode> queue, long min, long max) {
    	if(queue.isEmpty())
    		return null;
    	TreeNode node = queue.peek();
    	if(node.val <= min || node.val >= max)
    		return null;
    	
    	queue.poll(); // We already have the node above, we can remove the value that we are going to consume.
    	node.left = deserialize(queue, min, node.val);
    	node.right = deserialize(queue, node.val, max);
    	
    	return node;
    }
}