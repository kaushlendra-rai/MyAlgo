package com.kausha.algo.ds;

public class TreeNode {

	public TreeNode left;
	public TreeNode right;
	public int value;
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public TreeNode(int value){
		this.value = value;
	}
	
	public TreeNode() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean equals(Object obj){
		if(obj == null || !(obj instanceof TreeNode))
			return false;
		
		if(value == ((TreeNode)obj).value)
			return true;
		else
			return false;
	}
}