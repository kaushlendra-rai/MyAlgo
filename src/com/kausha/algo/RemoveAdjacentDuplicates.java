package com.kausha.algo;

public class RemoveAdjacentDuplicates {
	public static void main(String[] args) {
		
		StringBuilder str = new StringBuilder("abccddbadd");
		System.out.println("Original String = " + str);
		System.out.println("Final : "+ removeAdjacentduplicates(str));
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