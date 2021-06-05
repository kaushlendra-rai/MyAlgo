package com.kausha.algo.leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/course-schedule/
/**
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

 * @author sinkar
 *
 */
public class CourseSchedule_Medium {

	public static void main(String[] args) {
		CourseSchedule_Medium cs = new CourseSchedule_Medium();
		//int[][] prerequisites = new int[][] {{1,0}}; // numCourses=2 Ans 0, 1 (in that order)
		//int[][] prerequisites = new int[][] {{1,0}, {2, 0}, {3, 1}, {3, 2}}; // numCourses=4 Ans 0, 1 (in that order)
		// int numCourses = 4;
		int[][] prerequisites = new int[][] {{1,0}, {0, 1}}; // numCourses=2 Ans 0, 1 (in that order)
		int numCourses = 2;
		//int[][] prerequisites = new int[][] {{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}};
		//int numCourses = 20;
		System.out.println(cs.canFinish(numCourses, prerequisites));
	}
	
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		// If there is no dependency, send the list of courses in order.
        if(prerequisites.length == 0)
        	return true;
        Map<Integer, List<Integer>> courseLink = new HashMap<>();
        for(int[] tuple : prerequisites) {
        	if(courseLink.containsKey(tuple[1])) {
        		List<Integer> dep = courseLink.get(tuple[1]);
        		dep.add(tuple[0]);
        	}else {
        		List<Integer> dep = new ArrayList<>();
        		dep.add(tuple[0]);
        		courseLink.put(tuple[1], dep);
        	}
        }
        
        // maintain visited courses.
        int[] visited = new int[numCourses];
        
        for(int i=0; i < numCourses; i++)
        	if(!canFinish_DFS(courseLink, visited, i))
        		return false;
        return true;
    }

	private boolean canFinish_DFS(Map<Integer, List<Integer>> courseLink, int[] visited, int i) {
		if(visited[i] == 1)
			return true;
		// If while traversing the graph, we encounter '-1', it implies that we have reached a circular dependency because that node is still being processed.
		// Hence, we must return false from here.
		if (visited[i] == -1)
			return false;
		
		visited[i] = -1;
		if(courseLink.get(i) != null) {
			for(int course : courseLink.get(i)) {
				if(!canFinish_DFS(courseLink, visited, course))
					return false;
			}
		}
		
		visited[i] = 1;
		
		return true;
	}
}