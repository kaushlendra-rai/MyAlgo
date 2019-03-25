package com.kausha.algo.ds;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class SplitWordsUsingDictionary {
	public static void main(String[] args) {
		TrieDataStructure dictionary = getDictionary();
		
		//String word = "iamhero";
		//String word = "iamheros";
		String word = "sonuisahero";
		//String word = "hero";
		
		List<String> wordList = getSplitWordList(dictionary, word);
		System.out.println("wordList = " + wordList);
	}	

	public static List<String> getSplitWordList(TrieDataStructure dictionary, String word){
		if(dictionary == null || word == null)
			return Collections.EMPTY_LIST;
		
		List<String> wordList = new LinkedList<String>();
		getWords(dictionary, dictionary, word, 0, wordList);
		
		return wordList;
	}
	
	private static boolean getWords(TrieDataStructure root,TrieDataStructure dictionary, String word, int index, List<String> wordList){
		
		// This would be a case where there is NO MATCH FOUND for a word and searching for word reached the end of word-length
		if(word.length() == index)
			return false;
		
		String character = word.substring(index, index+1);
		TrieDataStructure term = dictionary.getNodes().get(character);
		
		// There is no match for the character in the dictionary at current level 
		if(term == null)
			return false;
		else{
			// Check if it is a word
			if(term.isWord()){
				// Check if all the characters have matched by this time.
				// If they have, we have found the word list.
				// Below is the terminal condition for the recursion
				if(index == word.length()-1){
					wordList.add(term.getCompleteWord());
					return true;
				}
				else if(getWords(root, root, word, index+1, wordList)){
					// This section would be entered only when the last word in the input
					// string matched the dictionary term.
					wordList.add(term.getCompleteWord());
					return true;
				}
			}
			
			if(getWords(root, term, word, index+1, wordList)){
				return true;
			}
		}
		
		return false;
	}
	
	private static TrieDataStructure getDictionary() {
		String[] words = {"hello", "hero", "iamla", "i", "a", "am", "mhe", "sonu", "amhe", "is"};
		TrieDataStructure root = new TrieDataStructure();
		for(String word : words){
			buildDictionary(root, word);
		}
		
		return root;
	}
	
	private static void buildDictionary(TrieDataStructure node, String word) {
		TrieDataStructure newNode = null;
		for(int i=0; i < word.length(); i++){
			String character = word.substring(i, i+1);
			TrieDataStructure term = node.getNodes().get(character);
			
			if(term == null){
				newNode = new TrieDataStructure();
				newNode.setValue(character);
				node.addNode(character, newNode);
				
				node = newNode;
			}else{
				node = term;
			}
		}
		
		node.setCompleteWord(word);
		node.setWord(true);
	}
}