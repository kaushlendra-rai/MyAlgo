package com.kausha.algo;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepetitiveCharacter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(nonRepetitiveCharacter("kaushal kumar"));
	}

	public static String nonRepetitiveCharacter(String str){
		LinkedHashMap<String, Integer> linkedMap = new LinkedHashMap<String, Integer>();
		for(int i=0; i < str.length(); i++){
			char character = str.charAt(i);
			
			if(linkedMap.containsKey(String.valueOf(character)))
				linkedMap.put(String.valueOf(character), linkedMap.get(String.valueOf(character)) + 1);
			else
				linkedMap.put(String.valueOf(character), 1);
		}
		
		for(Map.Entry<String, Integer> entry : linkedMap.entrySet())
			if(entry.getValue() == 1)
				return entry.getKey();
		
		return null;
	}
}