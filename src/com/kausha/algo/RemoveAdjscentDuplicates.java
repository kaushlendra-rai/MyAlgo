package com.kausha.algo;

// https://www.youtube.com/watch?v=yJv_ltADGuA
public class RemoveAdjscentDuplicates {

	public static void main(String[] args) {
		System.out.println(removeAdjDups("acaaabbbacdddd"));
		System.out.println(removeAdjDups("acaaabbbac"));
		System.out.println(removeAdjDups("aac"));
		System.out.println(removeAdjDups("a"));
	}

	public static String removeAdjDups(String str) {
		if(str.length() == 1)
			return str;
		
		StringBuilder sb = new StringBuilder();
		int counter = 0;
		while(counter< str.length()-1) {
			if(str.charAt(counter) != str.charAt(counter+1)) {
				sb.append(str.charAt(counter));
				counter++;
			}else {
				while(counter< str.length()-1 && str.charAt(counter) == str.charAt(counter+1))
					counter++;
				// Skip the last character of duplicates when the last dup character does not match the next character.
				counter++;
			}
		}
		// Handling the last character
		if(str.length() > 1 && str.charAt(str.length() -1) != str.charAt(str.length()-2))
			sb.append(str.charAt(str.length()-1));
		
		return sb.toString(); 
	}
}
