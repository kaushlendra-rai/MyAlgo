package com.kausha.algo;

public class FindIfAStringIsARotationOfAotherString {
	public static void main(String[] args) {
		String str1 = "Sample";
		String str2 = "mpleSa";
		boolean isRotated = findIfStringIsRotated(str1, str2);
		
		System.out.println("Is Rotated = " + isRotated);
	}

	private static boolean findIfStringIsRotated(String str1, String str2) {
		boolean isRotated = false;
		
		if(str1== null || str2 == null || str1.length() != str2.length())
			return isRotated;
		
		// If the string str2 is a rotation of str1, then if we append the str2 to str2, then the 
		// string str1 should exist in this new string.
		// E.g. Word "Sample" exists in mpleSampleSa ('mpleSa' concatenated twice)  
		str2 = str2 + str2;
		
		for(int i=0; i<=str1.length(); i++){
			boolean match = true;
			
			for(int j=0; j<str1.length(); j++){
				if(str1.charAt(j) != str2.charAt(i+j)) {
					match = false;
					break;
				}
			}
			
			if(match){
				isRotated = true;
				break;
			}
		}

		return isRotated;
	}
}