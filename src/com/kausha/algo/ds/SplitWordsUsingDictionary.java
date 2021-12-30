package com.kausha.algo.ds;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class SplitWordsUsingDictionary {
	public static void main(String[] args) {
		TrieDataStructure dictionary = getDictionary();
		
		String word = "iamhero";
		//String word = "iamheros";
		//String word = "sonuisahero";
		//String word = "hero";
		
		List<String> wordList = getSplitWordList(dictionary, word);
		System.out.println("wordList = " + wordList);
	}	

	public static List<String> getSplitWordList(TrieDataStructure dictionary, String word){
		if(dictionary == null || word == null)
			return Collections.EMPTY_LIST;
		
		List<String> wordList = new LinkedList<String>();
		splitWordList(dictionary, dictionary, word, 0, wordList);
		
		return wordList;
	}
	
	private static boolean splitWordList(TrieDataStructure dict, TrieDataStructure node, String word, int idx, List<String> wordList) {
		if(idx == word.length())
			return false;
		
		String nextChar = word.substring(idx, idx+1);
		TrieDataStructure newNode = node.getNodes().get(nextChar);
		
		if(newNode == null) // No match found
			return false;
		
		if(newNode.isWord()) {
			if(idx == word.length()-1) {
				wordList.add(newNode.getCompleteWord());
				return true;
			}
			
			if(splitWordList(dict, dict, word, idx+1, wordList)) {
				wordList.add(newNode.getCompleteWord());
				return true;
			}
		}

		return splitWordList(dict, newNode, word, idx+1, wordList);
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