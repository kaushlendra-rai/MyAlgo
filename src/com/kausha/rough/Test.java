package com.kausha.rough;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String, String> map = new LinkedHashMap<String, String>();
		
		map.put("name", "kaushal");
		map.put("name1", "kaushal1");
		map.put("name2", "kaushal2");
		map.put("name3", "kaushal3");
		map.put("name4", "kaushal4");
		
		for(Map.Entry<String, String> entry : map.entrySet()){
			System.out.println("Key = " + entry.getKey() + "   , Value = " + entry.getValue());
		}
		
		SortedSet<Integer> floor = new TreeSet<Integer>();
		floor.add(1);
		floor.add(3);
		floor.add(12);
		floor.add(9);
		floor.add(2);
		
		for(Integer val : floor)
			System.out.println(val);
		
		TreeSet<Integer> floor2 = new TreeSet<Integer>();
		floor2.descendingIterator();
		
	}

}
