package com.kausha.algo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class PrintAllCombinationOfBrackets {
	public static void main(String[] args) {
		generateCombinations();
	}
	
	private static void generateCombinations(){
		Map<String, Integer> combinations = new HashMap<String, Integer>();
		int maxPairs = 5;
		
		combinations.put("(", 1);
		
		for(int i=0; i < (maxPairs *2) -1; i++){
			Map<String, Integer> tempCombinations = new HashMap<String, Integer>();
			
			Iterator<Entry<String, Integer>> iterator = combinations.entrySet().iterator();
			while(iterator.hasNext()){
				Entry<String, Integer> entry = iterator.next();
				int value = entry.getValue();
				String key = entry.getKey();
				
				if(value == 0){
					tempCombinations.put(key+"(", value+1);
				}else if(value > maxPairs){
					tempCombinations.put(key+")", value-1);
				}else if(value > 0){
					tempCombinations.put(key+")", value-1);
					tempCombinations.put(key+"(", value+1);
				}
			}
			
			combinations = tempCombinations;
		}
		
		// Print Valid combinations
		Iterator<Entry<String, Integer>> iterator = combinations.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<String, Integer> entry = iterator.next();
			int value = entry.getValue();
			String key = entry.getKey();
			
			if(value == 0){
				System.out.println(key);
			}
		}
	}
}