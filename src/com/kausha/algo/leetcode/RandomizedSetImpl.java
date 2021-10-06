package com.kausha.algo.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

// https://leetcode.com/problems/insert-delete-getrandom-o1/
/**
 * Implement the RandomizedSet class:

RandomizedSet() Initializes the RandomizedSet object.
bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when
 this method is called). Each element must have the same probability of being returned.
You must implement the functions of the class such that each function works in average O(1) time complexity.

 

Example 1:

Input
["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
[[], [1], [2], [2], [], [1], [2], []]
Output
[null, true, false, true, 2, true, false, 2]

Explanation
RandomizedSet randomizedSet = new RandomizedSet();
randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
randomizedSet.insert(2); // 2 was already in the set, so return false.
randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.
 * @author sinkar
 *
 */
public class RandomizedSetImpl {
	public static void main(String[] args) {
		RandomizedSet rs = new RandomizedSet();
//		System.out.println(rs.insert(1));
//		System.out.println(rs.remove(2));
//		System.out.println(rs.insert(2));
//		System.out.println(rs.getRandom());
//		System.out.println(rs.remove(1));
//		System.out.println(rs.insert(2));
//		System.out.println(rs.getRandom());
		
		System.out.println(rs.insert(3));
		System.out.println(rs.insert(3));
		System.out.println(rs.getRandom());
		System.out.println(rs.getRandom());
		System.out.println(rs.insert(1));
		System.out.println(rs.remove(3));
		System.out.println(rs.getRandom());
		System.out.println(rs.getRandom());
		System.out.println(rs.insert(0));
		System.out.println(rs.remove(0));
		
	}

}

class RandomizedSet {

	private Map<Integer, Integer> keyVal;
	private Map<Integer, Integer> valKey;
	AtomicInteger ai = new AtomicInteger();
	
    /** Initialize your data structure here. */
    public RandomizedSet() {
    	keyVal = new HashMap<>();
    	valKey = new HashMap<>();    
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
    	boolean present = keyVal.containsKey(val);
    	if(!present) {
	    	Integer key = ai.getAndIncrement();
	        keyVal.put(val, key);
	        valKey.put(key, val);
    	}
        
        return !present;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
    	boolean present = keyVal.containsKey(val);
    	if(present) {
    		Integer key = keyVal.get(val);
    		keyVal.remove(val);
    		valKey.remove(key);
    	}
    	return present;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
    	Random rnd = new Random();
    	Integer rndValue = 0;
    	while(true) {
    		Integer rndNum = rnd.nextInt(ai.get());
    		rndValue= valKey.get(rndNum);
    		if(rndValue != null)
    			break;
    	}

        return rndValue;
    }
}