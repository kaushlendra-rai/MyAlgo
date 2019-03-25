package com.kausha.algo;

public class RemoveAdjacentDuplicatesCharacters {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		StringBuilder str = new StringBuilder("abccddbaddz");
		System.out.println("Original String = " + str);
		System.out.println(removeAdjacentduplicates(str));
	}

	public static StringBuilder removeAdjacentduplicates(StringBuilder str){
		if(str == null || str.length() < 2)
			return str;
		
		StringBuilder sb = new StringBuilder();
		
		int backCounter = 0;
		int forwardCounter = 1;
		boolean duplicateFound = false;
		boolean duplicateFoundOnce = false;
		while(forwardCounter < str.length()){
			if(str.charAt(backCounter) == str.charAt(forwardCounter)){
				duplicateFound = true;
				duplicateFoundOnce = true;
				forwardCounter++;
			}else{
				if(!duplicateFound)
					sb.append(str.charAt(backCounter));
				
				duplicateFound = false;
				backCounter = forwardCounter;
				forwardCounter++;
			}
		}
		
		if(!duplicateFound)
			sb.append(str.charAt(forwardCounter -1));
		
		if(duplicateFoundOnce)
			sb = removeAdjacentduplicates(sb);
		
		return sb;
	}
}