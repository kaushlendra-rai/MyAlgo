package com.kausha.algo;

public class FirstNonRepeatingCharacterInString {

	// 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getFirstNonRepeatingCharacterInString("aakzbcddnmnmctk");
	}
	
	private static void getFirstNonRepeatingCharacterInString(String str){
		int[] duplicate = new int[256];
		int[] ordered = new int[256];
		int orderCounter = 0;
		for(int i=0; i<str.length(); i++) {
			duplicate[str.charAt(i)] = duplicate[str.charAt(i)] + 1;
			
			if(duplicate[str.charAt(i)] ==1)
				ordered[orderCounter++] = str.charAt(i); 
				
		}
		//Better than below approach
		for(int i=0; i<orderCounter; i++) {
			if(duplicate[ordered[i]]==1) {
				System.out.printf("%c\n",ordered[i]);
				break;
			}
		}
		
		for(int i=0; i<str.length(); i++)
			if(duplicate[str.charAt(i)] == 1){
				System.out.println(str.charAt(i));
				break;
			}
		
		System.out.println("All characters have a duplicate");
	}
}
