package com.kausha.algo;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RearrangeNoAdjscentSameCharacters {

	/**
	 * Given a string with repeated characters, task is rearrange characters in a string so that no two adjacent characters are same.
	 * 
	 * Input: aaabc 
		Output: abaca 
		
		Input: aaabb
		Output: ababa 
		
		Input: aa 
		Output: Not Possible
		
		Input: aaaabc 
		Output: Not Possible
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "aabbcc";
		System.out.println("Input string : " + str);
		String rearrangedStr = rearrangeString(str);
		System.out.println("Re-arranged str : "  + rearrangedStr);
	}

	private static String rearrangeString(String str) {
		// Build Max-Heap based on PriorityQueue
		PriorityQueue<CharacterNode> maxHeap = buildMaxHeap(str);
		
		//Build required string
		String result = buildNonAdjscentCharacterString(maxHeap); 
		return result;
	}
	
	private static String buildNonAdjscentCharacterString(PriorityQueue<CharacterNode> maxHeap) {
		StringBuilder sb = new StringBuilder();
		CharacterNode top = null;
		
		while(!maxHeap.isEmpty()){
			CharacterNode node = maxHeap.poll();
			// If the current character is the last node on the heap & has more than 1 character count left to be placed, 
			// then we cannot have a valid result. Break here.
			if(maxHeap.isEmpty() && node.count > 1){
				sb.append("Not Possible");
				break;
			}
			
			if(top != null){
				maxHeap.offer(top);
				top = null;
			}
			
			sb.append(node.character);
			node.count = node.count -1;
			
			if(node.count > 0)
				top = node;
		}
		
		return sb.toString();
	}

	private static PriorityQueue<CharacterNode> buildMaxHeap(String str) {
		int[] charFreq = new int[26];
		for(int i=0; i < str.length(); i++){
			char currentCharacter = str.charAt(i);
			//System.out.println("currentCharacter = " + currentCharacter);
			charFreq[currentCharacter - 'a'] = charFreq[currentCharacter - 'a'] + 1; 
		}
		PriorityQueue<CharacterNode> maxHeap = new PriorityQueue<CharacterNode>(new Comparator<CharacterNode>(){
			public int compare(CharacterNode node1, CharacterNode node2){
				return node2.count-node1.count; 
			}
		});
		
		for(int i=0; i < charFreq.length; i++){
			if(charFreq[i] > 0){
				CharacterNode node = new CharacterNode((char)(i+'a'), charFreq[i]);
				maxHeap.offer(node);
			}
		}
		
		return maxHeap;
	}
}

class CharacterNode{
	char character;
	int count;
	
	public CharacterNode(char currentCharacter, int count) {
		this.character = currentCharacter;
		this.count = count;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + character;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CharacterNode other = (CharacterNode) obj;
		
		if (character != other.character)
			return false;
		return true;
	}
	
}