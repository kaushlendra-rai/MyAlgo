package com.kausha.algo.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

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