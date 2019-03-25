package com.kausha.algo.ds;

import java.util.HashMap;
import java.util.Map;

public class TrieDataStructure {
	private String value;
	private Map<String, TrieDataStructure> nodes = new HashMap<String, TrieDataStructure>();
	private boolean word;
	private String completeWord;

	public String getCompleteWord() {
		return completeWord;
	}

	public void setCompleteWord(String completeWord) {
		this.completeWord = completeWord;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Map<String, TrieDataStructure> getNodes() {
		return nodes;
	}

	public void addNode(String character, TrieDataStructure node) {
		nodes.put(character, node);
	}
	
	public boolean isWord() {
		return word;
	}

	public void setWord(boolean word) {
		this.word = word;
	}

	@Override
	public boolean equals(Object obj){
		if(this == obj)
			return true;
		
		if(value == null || obj == null)
			return false;
		
		if(obj instanceof TrieDataStructure){
			TrieDataStructure temp = (TrieDataStructure) obj;
			
			if(temp.getValue() != null && value.equals(temp.getValue()))
				return true;
		}
		
		return false;
	}

	@Override
	public int hashCode(){
		return value.hashCode();
	}
}