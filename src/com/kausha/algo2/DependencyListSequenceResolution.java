package com.kausha.algo2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// http://www.careercup.com/question?id=5134681810927616
/**
 * Given a list of dependency list of libraries (X depends on Y)
 * Generate a list in order in which libraries MUST be loaded.
 * 
 * Reference algorithm: https://en.wikipedia.org/wiki/Topological_sorting#Algorithms
 *  
 * @author sinkar
 *
 */
public class DependencyListSequenceResolution {
	public static void main(String[] args) {
		List<List<String>> dependencyList = getDependencyList();
		// First get all the dependencies which are top level on which no one is dependent
		List<String> topNodes = getIndependentDependencyList(dependencyList);
		
		// Create a Graph with adjacent nodes with a base reference to top level independent nodes
		
		// While creating graph, if cyclic graph is formed, throw exception
		
		// Perform Depth Based traversal
		
		System.out.println("topNodes = " + topNodes);
	}
	
	private static List<String> getIndependentDependencyList(List<List<String>> dependencyList){
		List<String> topNodes = new ArrayList<String>();
		
		for(int i=0; i < dependencyList.size(); i++)
			topNodes.add(dependencyList.get(i).get(0));
		
		Iterator<String> itr = topNodes.iterator();
		while(itr.hasNext()){
			int match = 0;
			String value = itr.next();
			
			for(int i=0; i < dependencyList.size(); i++){
				// Check if it is present in any other list
				if(dependencyList.get(i).contains(value))
					match++;
				
				if(match > 1){
					itr.remove();
					break;
				}
			}
		}
		
		return topNodes;
	}
	
	private static List<List<String>> getDependencyList(){
		List<List<String>> dependencyList = new ArrayList<List<String>>();
		List<String> d1 = new ArrayList<String>();
		d1.add("7");
		d1.add("11");
		d1.add("8");
		
		List<String> d2 = new ArrayList<String>();
		d2.add("5");
		d2.add("11");
		
		List<String> d3 = new ArrayList<String>();
		d3.add("3");
		d3.add("8");
		d3.add("10");
		
		List<String> d4 = new ArrayList<String>();
		d4.add("11");
		d4.add("2");
		d4.add("10");
		
		List<String> d5 = new ArrayList<String>();
		d5.add("8");
		d5.add("9");
		
		dependencyList.add(d1);
		dependencyList.add(d2);
		dependencyList.add(d3);
		dependencyList.add(d4);
		dependencyList.add(d5);
		
		return dependencyList;
	}
}