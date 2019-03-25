package com.kausha.algo;

public class RemoveAdjacentDuplicatesCharactersRecursively {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		StringBuilder str = new StringBuilder("abccddbaddz");
		System.out.println("Original String = " + str);
		System.out.println(removeAdjacentDuplicatesRecursively(str));
	}

	public static StringBuilder removeAdjacentDuplicatesRecursively(StringBuilder str){
		if(str == null || str.length() < 2)
			return str;
		
		StringBuilder sb = new StringBuilder();
		
		int backCounter = 0;
		int forwardCounter = 1;
		boolean duplicateFound = false;
		
		while(forwardCounter < str.length()){
			if(str.charAt(backCounter) == str.charAt(forwardCounter)){
				duplicateFound = true;
				forwardCounter++;
			}else{
				if(!duplicateFound){
					backCounter++;
					forwardCounter++;
				}else{
					break;
				}
			}
		}
		
		sb.append(str.substring(0, backCounter)).append(str.substring(forwardCounter, str.length()));
		System.out.println(sb);
		
		if(str.equals(sb))
			return sb;
		else return removeAdjacentDuplicatesRecursively(sb);
	}
}