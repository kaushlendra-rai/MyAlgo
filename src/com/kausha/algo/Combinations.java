package com.kausha.algo;

import java.util.ArrayList;
import java.util.List;

public class Combinations
{
	public static void main(String[] aaa)
	{
		String name="Sonum";
	/*	String[] start={name.substring(0,1)};
		String[] combos=combo(start,name.substring(1,2),name.substring(2),2);
		
		for(int i=0;i<combos.length;i++)
			System.out.println(combos[i] + "  ----- > " + i);
	*/	
		List<String> result = combo2(null, name);
		System.out.println("result.size() = " + result.size());
		System.out.println("result = " + result);
	}
	
	public static String[] combo(String[] base, String s, String left,int counter)
	{
		String[] temp=new String[counter*base.length];
		int k=0;
		
		for(int i=0;i<base.length;i++)
		{
			temp[k++]=s+base[i];
			for(int j=0;j<base[i].length();j++)
				temp[k++]=base[i].substring(0,j+1)+s+base[i].substring(j+1);
		}
		
		if(left.length()>0)
			return combo(temp,left.substring(0,1),left.substring(1),counter+1);
		else
			return temp;
		
	}
	
	public static List<String> combo2(List<String> currentList, String remainingString){
		List<String> combinationsList = new ArrayList<String>();
		if(currentList == null){
			// API invoked first time.
			combinationsList.add(remainingString.substring(0,1));
			return combo2(combinationsList, remainingString.substring(1));
		}else if(remainingString == null || remainingString.length() == 0){
			return currentList;
		}else{
			String newCharacter = remainingString.substring(0,1);
			for(String word : currentList){
				// Insert the new character before the word.
				combinationsList.add(newCharacter + word);
				
				for(int i=0; i < word.length(); i++)
					combinationsList.add(word.substring(0, i+1) + newCharacter + word.substring(i+1));
			}
			
			return combo2(combinationsList, remainingString.substring(1));
		}
	}
}