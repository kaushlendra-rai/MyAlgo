package com.kausha.algo;

public class FirstNonRepeatingCharacterInString {

	// 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getFirstNonRepeatingCharacterInString("aakzbcddnmnmct");
	}
	
	private static void getFirstNonRepeatingCharacterInString(String str){
		int[] duplicate = new int[256];
		
		for(int i=0; i<str.length(); i++)
			duplicate[str.charAt(i)] = duplicate[str.charAt(i)] + 1;
		
		for(int i=0; i<str.length(); i++)
			if(duplicate[str.charAt(i)] == 1){
				System.out.println(str.charAt(i));
				break;
			}
		
		System.out.println("All characters have a duplicate");
	}
}
