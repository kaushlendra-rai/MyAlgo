package com.kausha.algo.leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

// https://leetcode.com/problems/course-schedule-ii/
/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. 
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you 
 * must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers,
 return any of them. If it is impossible to finish all courses, return an empty array.

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
Example 2:

Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
Example 3:

Input: numCourses = 1, prerequisites = []
Output: [0]

 * @author sinkar
 *
 */
public class CourseSchedule_Medium_II {

	public static void main(String[] args) {
		CourseSchedule_Medium_II cs = new CourseSchedule_Medium_II();
		//int[][] prerequisites = new int[][] {{1,0}}; // numCourses=2 Ans 0, 1 (in that order)
		
//		int[][] prerequisites = new int[][] {{1,0}, {2, 0}, {3, 1}, {3, 2}}; // numCourses=4, Output: 0, 2, 1, 3
//		int[] schedule = cs.findOrder(4, prerequisites);
		
//		int[][] prerequisites = new int[][] {{1,0}}; // numCourses=2 Ans 0, 1 (in that order)
//		int[] schedule = cs.findOrder(2, prerequisites);
		
		int[][] prerequisites = new int[][] {}; // numCourses=2 Ans 0, 1 (in that order)
		int[] schedule = cs.findOrder(1, prerequisites);
		
		for(int num : schedule)
			System.out.println(num + ", ");
	}
	
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		// If there is no dependency, send the list of courses in order.
        if(prerequisites.length == 0) {
        	int[] order = new int[numCourses];
        	for(int i=0; i< numCourses; i++)
        		order[i] = i;
        	return order;
        }
        
        Map<Integer, List<Integer>> courseLink = new HashMap<>();
        for(int[] tuple : prerequisites) {
        	if(courseLink.get(tuple[1]) == null) {
        		List<Integer> dep = new ArrayList<>();
        		dep.add(tuple[0]);
        		courseLink.put(tuple[1], dep);
        	}else {
        		List<Integer> dep = courseLink.get(tuple[1]);
        		dep.add(tuple[0]);
        	}
        }
        
     // maintain visited courses.
        int[] visited = new int[numCourses];
        // We maintain the order of course in stack The first node to get complete exploration should be added first
        // followed by the others in the DFS traversal in DAG.
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i < numCourses; i++)
        	if(!canFinish_DFS(courseLink, visited, i, stack))
        		return new int[0];
        
        int[] courseOrder = new int[stack.size()];
        int idx = 0;
        while(!stack.isEmpty())
        	courseOrder[idx++] = stack.pop();
        return courseOrder;
    }

	private boolean canFinish_DFS(Map<Integer, List<Integer>> courseLink, int[] visited, int idx, Stack<Integer> stack) {
		if(visited[idx] == 1)
			return true;
		// If while traversing the graph, we encounter '-1', it implies that we have reached a circular dependency because that node is still being processed.
		// Hence, we must return false from here.
		if (visited[idx] == -1)
			return false;
		
		visited[idx] = -1;
		if(courseLink.get(idx) != null) {
			for(int course : courseLink.get(idx)) {
				if(!canFinish_DFS(courseLink, visited, course, stack))
					return false;
			}
		}
		
		visited[idx] = 1;
		stack.push(idx);
		
		return true;
	}
}