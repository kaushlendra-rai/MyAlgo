package com.kausha.algo.ds;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;


public class AutoSuggestTrie {

	public static void main(String[] args) {
		String[] words = {"hello", "hero", "iamla", "i", "a", "amla", "mhe", "sonu", "amhe", "is"};
		TrieDataStructure dictionary = getDictionary(words);
		System.out.println(suggest(dictionary, "am", 3));
	}
	
	// We first traverse the trie up to the point of prefix string.
	// Thereafter, we treat it as a root node and do a pre-order traversal to get suggestions.
	public static List<String> suggest(TrieDataStructure dictionary, String prefix, int count){
		if(prefix == null || dictionary == null)
			return new ArrayList<String>();
		
		// If traversal is possible till till prefix, move, else return empty list
		int idx = 0;
		while(idx < prefix.length()){
			String key = prefix.substring(idx, idx+1);
			TrieDataStructure nextNode = dictionary.getNodes().get(key); 
			if(nextNode != null)
				dictionary = nextNode; 
			else
				return new ArrayList<String>();
			
			idx++;
		}
		
		List<String> suggestions = new ArrayList<>();
		suggest(dictionary, suggestions, count);
		
		return suggestions;
	}
	
	private static void suggest(TrieDataStructure dictionary, List<String> suggestions, int count) {
		if(dictionary == null)
			return;
		
		if(dictionary.isWord())
			suggestions.add(dictionary.getCompleteWord());
		
		// If we have got all the suggestions required, we are done. return from here.
		if(suggestions.size() == count)
			return;
		
		for(Entry<String, TrieDataStructure> node : dictionary.getNodes().entrySet()) {
			suggest(node.getValue(), suggestions, count);
		}
	}

	private static TrieDataStructure getDictionary(String[] words) {
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
