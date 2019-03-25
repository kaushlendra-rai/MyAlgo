package com.kausha.algo;

public class SortArrayContainingSetOf3Characters {
// Question from::
	// http://linearspacetime.blogspot.in/2012/05/sort-character-array-containing-only.html
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] input = {"G", "R", "B", "B", "G", "R", "G", "R", "B", "G", "B", "R", "G", "B", "B"};
		
		//String[] input = {"R", "R", "G", "R", "B", "B", "G", "R", "G", "R", "B", "G", "B", "R", "G"};

		sortRBG(input);
		for(String str : input)
			System.out.print(str + " ");
	}

	private static String[] sortRBG(String[] input){
		int left = 0;
		int right = input.length -1;
		
		while("R".equals(input[left]))
			left++;
		
		while("B".equals(input[right]))
			right--;
		
		int mid = left;
		
		while(mid < right && left<right){
			if(input[mid].equals("R")){
				input[mid] = input[left];
				input[left] = "R";
				
				left++;		
			}else if(input[mid].equals("B")){
				input[mid] = input[right];
				input[right] = "B";
				
				right--;
			}else{
				mid++;
			}
		}
				
		return input;
	}
}