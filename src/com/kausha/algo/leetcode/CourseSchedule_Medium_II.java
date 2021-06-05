package com.kausha.algo.leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/course-schedule-ii/
/**
 * There are a total of n courses you have to take labelled from 0 to n - 1.

Some courses may have prerequisites, for example, if prerequisites[i] = [ai, bi] this means you must take the course bi before the course ai.

Given the total number of courses numCourses and a list of the prerequisite pairs, return the ordering of courses you should take to finish all courses.

If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
 * @author sinkar
 *
 */
public class CourseSchedule_Medium_II {

	public static void main(String[] args) {
		CourseSchedule_Medium_II cs = new CourseSchedule_Medium_II();
		//int[][] prerequisites = new int[][] {{1,0}}; // numCourses=2 Ans 0, 1 (in that order)
		int[][] prerequisites = new int[][] {{1,0}, {2, 0}, {3, 1}, {3, 2}}; // numCourses=2 Ans 0, 1 (in that order)
		int numCourses = 2;
		int[] schedule = cs.findOrder(numCourses, prerequisites);
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
        
        Iterator<Map.Entry<Integer, List<Integer>>> itr = courseLink.entrySet().iterator();
        while(itr.hasNext()) {
        	Map.Entry<Integer, List<Integer>> entry = itr.next();
        	System.out.println("Key:" + entry.getKey() + " , values: " + entry.getValue());
        }
        
        Set<Integer> startPoints = new HashSet<>(courseLink.keySet());
        //Collection<List<Integer>> valueList = courseLink.values();
        for(List<Integer> valueList : courseLink.values()) {
        	startPoints.removeAll(valueList);
        }
        System.out.println("Start Point: " + startPoints);
		return new int[] {};
    }

}