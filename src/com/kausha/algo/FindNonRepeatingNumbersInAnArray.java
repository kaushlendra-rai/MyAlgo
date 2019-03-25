package com.kausha.algo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FindNonRepeatingNumbersInAnArray {

	
	public static void main(String[] args) {
		
		int[] nums = {1, 2, 3, 6, 3, 5, 3, 5, 2, 5, 99, 4, 7};
		printNonRepeatingNumbers(nums);
	}

	private static void printNonRepeatingNumbers(int[] nums){
		Map<Integer, Boolean> numMap = new HashMap<Integer, Boolean>();
		
		for(int i=0; i<nums.length; i++){
			if(numMap.containsKey(nums[i]))
				numMap.put(nums[i], Boolean.FALSE);
			else
				numMap.put(nums[i], Boolean.TRUE);
		}
		
		Iterator<Map.Entry<Integer, Boolean>> itr = numMap.entrySet().iterator();
		
		while(itr.hasNext()){
			Map.Entry<Integer, Boolean> entry = itr.next();
			if(entry.getValue())
				System.out.println(entry.getKey());
		}
	}
}