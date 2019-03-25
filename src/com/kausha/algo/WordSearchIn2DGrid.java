package com.kausha.algo;

public class WordSearchIn2DGrid {
//http://yucoding.blogspot.in/2013/02/leetcode-question-124-word-search.html
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// HOUSE, MOLE, MOON, MONDAY, SUN,, LEAD
		String[][] input = {
							{"A", "B", "H", "M", "O", "L"},
							{"Q", "U", "O", "O", "E", "E"},
							{"E", "S", "N", "N", "D", "A"},
							{"R", "U", "N", "D", "A", "Y"}
		};
		
		//String wordToFind = "MOLE";
		//String wordToFind = "MONDAY";
		String wordToFind = "MOM";

		System.out.println("Match status = " + findWordInGrid(input, wordToFind));
	}
	
	private static boolean findWordInGrid(String[][] input, String wordToFind) {
		
		for(int i = 0; i < input.length; i++){
			for(int j = 0; j < input[i].length; j++){
				// This array is to ensure that we do not get into a cyclic loop
				boolean visitedBlock[][] = new boolean[input.length][input[0].length];
				
				boolean matchFound = recursivelyFindMatch(input, wordToFind, visitedBlock, i, j, 0);
				
				if(matchFound)
					return true;
			}
		}
		
		return false;
	}

	private static boolean recursivelyFindMatch(String[][] input, String wordToFind, boolean[][] visitedBlock,
			int i, int j, int wordIndex) {
		
		// Check if wordIndex is valid
		if(wordToFind.length() <= wordIndex)
			return false;
		
		// Make check array indexes for being valid.
		if(i < 0 || i >= input.length || j < 0 || j >= input[i].length )
			return false;
		
		// Ensure that the block has not already been visited for this recursion flow
		if(visitedBlock[i][j])
			return false;
		
		// A copy of the earlier status should be used to ensure that the unsuccessful recursions do not pollute the
		// visitorBlock while other blocks are yet to be explored which actually might have a match from current position.
		boolean[][] newVisitorBlock = copyVisitorStatus(visitedBlock);
		
		// If the characters match
		if(wordToFind.substring(wordIndex, wordIndex + 1).equals(input[i][j])){
			// If the complete string has matched, return true.
			if(wordToFind.length()-1 == wordIndex)
				return true;
			
			// Mark the current location as visited.
			newVisitorBlock[i][j] = true;
			
			// check for all possible adjacent locations recursively for next possible match
			// Check LEFT move for next match
			if(recursivelyFindMatch(input, wordToFind, newVisitorBlock, i + 1, j, wordIndex + 1))
				return true;
			
			// Check RIGHT move for next match
			if(recursivelyFindMatch(input, wordToFind, newVisitorBlock, i - 1, j, wordIndex + 1))
				return true;
			
			// Check UP move for next match
			if(recursivelyFindMatch(input, wordToFind, newVisitorBlock, i, j - 1, wordIndex + 1))
				return true;
			// Check DOWN move for next match
			if(recursivelyFindMatch(input, wordToFind, newVisitorBlock, i, j + 1, wordIndex + 1))
				return true;
		}
		
		return false;
	}
	
	private static boolean[][] copyVisitorStatus(boolean[][] visitorStatus){
		boolean[][] newStatus = new boolean[visitorStatus.length][visitorStatus[0].length];
		
		for(int i=0; i<visitorStatus.length; i++)
			for(int j=0; j < visitorStatus[i].length; j++)
				newStatus[i][j] = visitorStatus[i][j];
		
		return newStatus;
	}
}