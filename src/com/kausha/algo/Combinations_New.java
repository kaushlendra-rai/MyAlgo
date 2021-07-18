package com.kausha.algo;

import java.util.ArrayList;
import java.util.List;

public class Combinations_New{
	public static void main(String[] aaa) {
		String name="Sonum";
	
		List<String> result = combo(name);
		System.out.println("result.size() = " + result.size());
		System.out.println("result = " + result);
	}
	public static List<String> combo(String str){
		List<String> currentList = new ArrayList<String>();
		combo(currentList, "", str);
		
		return currentList;
	}
	
	public static void combo(List<String> currentList, String currStr, String remainingString){
		if(remainingString == null || remainingString.length() == 0){
			currentList.add(currStr);
		}else{
			for(int i=0; i < remainingString.length(); i++) {
				String rem1 = remainingString.substring(0, i);
				String rem2 = remainingString.substring(i+1);
				String remainingNew = rem1 + rem2;
				combo(currentList, currStr + remainingString.charAt(i), remainingNew);
			}
		}
	}
}