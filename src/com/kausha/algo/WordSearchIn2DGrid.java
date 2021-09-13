package com.kausha.algo;


public class WordSearchIn2DGrid {
	//http://yucoding.blogspot.in/2013/02/leetcode-question-124-word-search.html
		
		/**
		 * @param args
		 */
		public static void main(String[] args) {
			// HOUSE, MOLE, MOON, MONDAY, SUN,, LEAD
			char[][] input = {
								{'A', 'B', 'H', 'M', 'O', 'L'},
								{'Q', 'U', 'O', 'O', 'E', 'E'},
								{'E', 'S', 'N', 'N', 'D', 'A'},
								{'R', 'U', 'N', 'D', 'A', 'Y'}
			};
			
			//String wordToFind = "MOLE";  // true
			//String wordToFind = "MONDAY";
			String wordToFind = "MOM"; // false
			WordSearchIn2DGrid ws = new WordSearchIn2DGrid();
			
			System.out.println("Match status = " + ws.exist(input, wordToFind));
		}
		
		public boolean exist(char[][] board, String word) {
			for(int i = 0; i < board.length; i++){
				for(int j = 0; j < board[i].length; j++){
					boolean matchFound = recursivelyFindMatch(board, i, j, word, 0);
					
					if(matchFound)
						return true;
				}
			}
			
			return false;
		}

		private boolean recursivelyFindMatch(char[][] input, int i, int j, String wordToFind, int wordIndex) {
			// Check if wordIndex is valid
			if(wordToFind.length() == wordIndex)
				return true;
			
			// Make check array indexes for being valid.
			if(i < 0 || i >= input.length || j < 0 || j >= input[i].length )
				return false;
			
			if(wordToFind.charAt(wordIndex) != input[i][j])
				return false;
			
			char temp = input[i][j];
			input[i][j] = '*';
			
			if(recursivelyFindMatch(input, i + 1, j, wordToFind, wordIndex + 1) 
				|| recursivelyFindMatch(input, i- 1, j, wordToFind, wordIndex + 1)
				|| recursivelyFindMatch(input, i, j - 1, wordToFind, wordIndex + 1)
				|| recursivelyFindMatch(input, i, j + 1, wordToFind, wordIndex + 1))
				return true;
			
			// If match not found, revert the state to original
			input[i][j] = temp;
			
			return false;
		}
		
		// This approach requires an extra [][] of visited noted, hence discarded.
		private boolean recursivelyFindMatch_old(char[][] input, String wordToFind, boolean[][] visitedBlock,
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
			boolean[][] newVisitorBlock = copyVisitorStatus_old(visitedBlock);
			
			// If the characters match
			if(wordToFind.charAt(wordIndex) == input[i][j]){
				// If the complete string has matched, return true.
				if(wordToFind.length()-1 == wordIndex)
					return true;
				
				// Mark the current location as visited.
				newVisitorBlock[i][j] = true;
				
				// check for all possible adjacent locations recursively for next possible match
				// Check LEFT move for next match
				if(recursivelyFindMatch_old(input, wordToFind, newVisitorBlock, i + 1, j, wordIndex + 1))
					return true;
				
				// Check RIGHT move for next match
				if(recursivelyFindMatch_old(input, wordToFind, newVisitorBlock, i - 1, j, wordIndex + 1))
					return true;
				
				// Check UP move for next match
				if(recursivelyFindMatch_old(input, wordToFind, newVisitorBlock, i, j - 1, wordIndex + 1))
					return true;
				// Check DOWN move for next match
				if(recursivelyFindMatch_old(input, wordToFind, newVisitorBlock, i, j + 1, wordIndex + 1))
					return true;
			}
			
			return false;
		}
		
		private boolean[][] copyVisitorStatus_old(boolean[][] visitorStatus){
			boolean[][] newStatus = new boolean[visitorStatus.length][visitorStatus[0].length];
			
			for(int i=0; i<visitorStatus.length; i++)
				for(int j=0; j < visitorStatus[i].length; j++)
					newStatus[i][j] = visitorStatus[i][j];
			
			return newStatus;
		}
	}