package com.kausha.algo;

public class RegularExpressionParser_old {

	public static void main(String[] args) {
		//String words = "my name kaushal rai";
		//String expression = "*sh?*l";
		
		String words = "import java.util.concurrent.ExecutorService;";
		String expression = "*Executor*Service*";
		
		parseExpression(words, 0, expression, 0);
		System.out.println(matchRegularExpression(expression, words, 0, 0));
	}

	private static void parseExpression(String word, int wordIndex, String expression, int expressionIndex){
		if(word.length() == wordIndex && expression.length() == expressionIndex){
			System.out.println("Match Found");
			return ;
		}
		if(word.length() <= wordIndex || expression.length() <= expressionIndex){
			return;
		}
		
		if('*' == expression.charAt(expressionIndex)){
			// Match the expression '*' with the current character of the word  and move ahead for matching
			// this '*' for the next character too.
			parseExpression(word, wordIndex+1, expression, expressionIndex);
			
			parseExpression(word, wordIndex, expression, expressionIndex + 1);
			
			// Match the expression '*' with the current character of the word  and move ahead for matching
			// next character of the expression with next character in the word.
			parseExpression(word, wordIndex+1, expression, expressionIndex + 1);
			
		}else if('?' == expression.charAt(expressionIndex) || word.charAt(wordIndex) == expression.charAt(expressionIndex)){
			// Match the expression '?' with the current character of the word  and move ahead for matching
			// If discrete character match occurs, proceed with matching next character in word and expression.
			// next character of the expression with next character in the word.
			parseExpression(word, wordIndex+1, expression, expressionIndex + 1);
		}
	}
	
	/**
	 * Working.
	 * @param expression
	 * @param line
	 * @param queryIndex
	 * @param lineIndex
	 * @return
	 */
	private static boolean matchRegularExpression(String expression, String line, int queryIndex, int lineIndex) {
		boolean matchFound = false;
		// Terminal Condition
		// If the String has so far matched and last character of query is '*', return match Found = true
		
		if(expression.length()-1 == queryIndex && expression.charAt(queryIndex) == '*')
			return true;
		
		if(queryIndex == expression.length() && lineIndex <= line.length())
			return true;
		
		if(queryIndex < expression.length() && lineIndex == line.length())
			return false;
		
		if(queryIndex == expression.length() || lineIndex == line.length())
			return false;
		
		if(expression.charAt(queryIndex) == '*'){
			matchFound = matchRegularExpression(expression, line, queryIndex, lineIndex + 1);
			
			if(!matchFound)
				matchFound = matchRegularExpression(expression, line, queryIndex+1, lineIndex);
		}else if(expression.charAt(queryIndex) == '?'){
			matchFound = matchRegularExpression(expression, line, queryIndex+1, lineIndex + 1);
		}else if(expression.charAt(queryIndex) == line.charAt(lineIndex)){
			matchFound = matchRegularExpression(expression, line, queryIndex+1, lineIndex + 1);
		}
		
		return matchFound;
	}
}