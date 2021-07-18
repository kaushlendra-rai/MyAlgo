package com.kausha.algo.gfg.microsoft;

public class Node
{
	int data ;
	Node next;
	Node left, right;
	Node(int d)
	{
		data = d;
		next = null;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + data;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (data != other.data)
			return false;
		return true;
	}
	
	
}