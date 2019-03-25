package com.kausha.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * This program calculates all the possible combination of words from the given word.
 * (Duplicates are allowed in this case)
 * @author sinkar
 *
 */
public class AllCharacterPermutation {
		/**
		 * @param args
		 */
		public static void main(String[] args) {
			List<String> result = rotate(new ArrayList<String>(), "Sonu");
			System.out.println("Length of the result =  " + result.size());
			System.out.println(result);
		}
		
		public static List<String> rotate(List<String> currentCombos, String pending)
		{
			List<String> temp = new ArrayList<String>(); 
			if(currentCombos.size() == 0)
			{
				temp.add(pending.substring(0, 1));
				pending = pending.substring(1);
			}
			else
			{
				// Recursion convergence
				if(pending.length() == 0)
					return currentCombos;
				else
				{
					String newStr = pending.substring(0, 1);
					for(String str : currentCombos)
					{
						for(int i = 0; i <= str.length(); i++)
						{
							temp.add(str.substring(0,i) + newStr + str.substring(i));
						}
					}
				}
				pending = pending.substring(1);
			}
			
			return rotate(temp, pending);
		}
	}