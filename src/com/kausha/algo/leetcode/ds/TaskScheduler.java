package com.kausha.algo.leetcode.ds;

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
		//char[] tasks = new char[] {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}; // 8
		//char[] tasks = new char[] {'A', 'A', 'A', 'A', 'A'};
		char[] tasks = new char[] {'A', 'B', 'C', 'D', 'E', 'A', 'B', 'C', 'D', 'E'}; // 8  ..A -> B -> idle -> A -> B -> idle -> A -> B
		System.out.println(ts.leastInterval(tasks, 4));
	}

	public int leastInterval(char[] tasks, int n) {
		if(n == 0)
			return tasks.length;
		int[] freq = new int[26];
		for(char c : tasks)
			freq[c-'A'] +=1;
		
		Arrays.sort(freq);
		return 0;
	}
	
	
	public int leastInterval_old(char[] tasks, int n) {
		if(n == 0)
			return tasks.length;
		
		Map<Character, Integer> taskMap = new HashMap<>();
		for(char c : tasks)
			taskMap.put(c, taskMap.getOrDefault(c, 0)+1);
		
		PriorityQueue<TaskData> pq = new PriorityQueue<>();
		for(Character key : taskMap.keySet())
			pq.offer(new TaskData(key, taskMap.get(key)));
		int counter = 0;
		List<TaskData> tdList = new ArrayList<>();
		while(!pq.isEmpty()) {
			TaskData td = pq.poll();
			
			if(td.distance % (n+1) == 0) {
				td.count--;
				td.distance = (td.distance % (n+1)) +1;
				counter++;
				System.out.print(td.character + " ");
					
				for(TaskData tdListData : tdList)
					pq.offer(tdListData);

				tdList = new ArrayList<>();
				
				if(td.count > 0)
					pq.offer(td);
			}else {
				td.distance = (td.distance % (n+1)) +1;
				tdList.add(td);
			}
			
			if(pq.isEmpty() && tdList.size() > 0) {
				// Special handling for last element having single type
				if(tdList.size() == 1) {
					counter += tdList.get(0).count * (n+1);
					break;
				}
				
				for(TaskData tdListData : tdList) {
					tdListData.distance = (tdListData.distance % (n+1)) +1;
					pq.offer(tdListData);
				}
				tdList = new ArrayList<>();
				
				// Case where we cannot get subsequent characters/tasks available due to 'n', we add fillers like 'idle'
				counter++;
				System.out.print("idle ");
			}
		}
		
        return counter;
    }
}

class TaskData implements Comparable<TaskData>{
	char character;
	int count;
	int distance;
	int lastCounter;
	public TaskData(char c, int count) {
		this.character = c;
		this.count =  count;
	}
	
	@Override
	public int compareTo(TaskData o) {
		return o.count - this.count;
	}
}