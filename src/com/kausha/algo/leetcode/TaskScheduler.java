package com.kausha.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

// https://leetcode.com/problems/task-scheduler/
/**
 * 621. Task Scheduler
Medium

Share
Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a
 different task. Tasks could be done in any order. Each task is done in one unit of time. For each unit
  of time, the CPU could complete either one task or just be idle.

However, there is a non-negative integer n that represents the cooldown period between two same tasks
 (the same letter in the array), that is that there must be at least n units of time between any two same tasks.

Return the least number of units of times that the CPU will take to finish all the given tasks.

 

Example 1:

Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: 
A -> B -> idle -> A -> B -> idle -> A -> B
There is at least 2 units of time between any two same tasks.
Example 2:

Input: tasks = ["A","A","A","B","B","B"], n = 0
Output: 6
Explanation: On this case any permutation of size 6 would work since n = 0.
["A","A","A","B","B","B"]
["A","B","A","B","A","B"]
["B","B","B","A","A","A"]
...
And so on.
Example 3:

Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
Output: 16
Explanation: 
One possible solution is
A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A
 

Constraints:

1 <= task.length <= 104
tasks[i] is upper-case English letter.
The integer n is in the range [0, 100].
 * @author sinkar
 *
 */
public class TaskScheduler {

	public static void main(String[] args) {
		TaskScheduler ts = new TaskScheduler();
		//char[] tasks = new char[] {'A', 'A', 'A', 'B', 'B', 'B'}; // 8  ..A -> B -> idle -> A -> B -> idle -> A -> B
		//System.out.println(ts.leastInterval(tasks, 2));
		//char[] tasks = new char[] {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}; // 8
		//char[] tasks = new char[] {'A', 'A', 'A', 'A', 'A'};
		char[] tasks = new char[] {'A', 'B', 'C', 'D', 'E', 'A', 'B', 'C', 'D', 'E'}; // 8  ..A -> B -> idle -> A -> B -> idle -> A -> B
		System.out.println(ts.leastInterval(tasks, 4));
	}

	public int leastInterval(char[] tasks, int n) {
		if(n == 0)
			return tasks.length;
		Map<Character, Integer> map = new HashMap<>();
		for(Character c : tasks)
			map.put(c, map.getOrDefault(c, 0) + 1);
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b-a);
		maxHeap.addAll(map.values());
		
		int cycles = 0;
		// Now we check if the Heap is empty or not.
		// The whole intent is to first pick the numbers with higher frequency till all number get exhausted.
		while(!maxHeap.isEmpty()) {
			List<Integer> usedNums = new ArrayList<>();
			// We run loop for 'n+1' because the tasks themselves should not get repeated in 'n' distance. 
			for(int i=0; i < n+1; i++) {
				if(!maxHeap.isEmpty()) {
					usedNums.add(maxHeap.poll());
				}
			}
			
			// If the picked numbers can still be used and put them back on heap.
			// Given it has been used once, decrement the available frequency by 1
			for(int used : usedNums) {
				if(--used > 0)
					maxHeap.add(used);
			}
			
			// If the Heap is empty, it implies that all the elements have been used in this flow.
			// If not, it implies that the n+1 elements picked from teh heap have been added successfully or else
			// compensated with extra sleeps.
			cycles += maxHeap.isEmpty() ? usedNums.size() : n+1;
		}
		
		return cycles;
	}
}