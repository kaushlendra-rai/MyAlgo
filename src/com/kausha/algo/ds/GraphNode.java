package com.kausha.algo.ds;

import java.util.List;

public class GraphNode {
	public List<GraphNode> adjscentNodes;
	public int value;
	
	public GraphNode(int value){
		this.value = value;
	}

	public GraphNode(){
	}
	
	public List<GraphNode> getAdjscentNodes() {
		return adjscentNodes;
	}

	public void setAdjscentNodes(List<GraphNode> adjscentNodes) {
		this.adjscentNodes = adjscentNodes;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
