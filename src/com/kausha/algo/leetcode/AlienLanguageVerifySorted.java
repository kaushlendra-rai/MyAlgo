package com.kausha.algo.leetcode;

public class AlienLanguageVerifySorted {
	public static void main(String[] args) {
		AlienLanguageVerifySorted alv = new AlienLanguageVerifySorted();
		
		String[] words = new String[]{"hello","leetcode"};
		String order = "hlabcdefgijkmnopqrstuvwxyz";
		
		System.out.println(alv.isAlienSorted(words, order));
	}

	public boolean isAlienSorted(String[] words, String order) {
		// First build base ascii sequence
		int[] dict = new int[26];
		for(int i=0; i< dict.length; i++)
			dict[order.charAt(i) - 'a'] = i;
		
		for(int i=1; i < words.length; i++) {
			if(compareAlienWords(words[i-1], words[i], dict) > 0)
				return false;
		}
        return true;
    }

	private int compareAlienWords(String str1, String str2, int[] dict) {
		int i=0;
		while(i < str1.length() && i < str2.length()) {
			// If strings do not match, a decision is made for words sort order.
			if(dict[str1.charAt(i)-'a'] - dict[str2.charAt(i)-'a'] != 0)
				return dict[str1.charAt(i)-'a'] - dict[str2.charAt(i)-'a'];
			i++;
		}
		// Case where the string match completely till the end character, however, str1 is a larger string than str2,
		// it makes str1 greater than str2, thereby making two strings unsorted.
		return str1.length() - str2.length();
	}
}
