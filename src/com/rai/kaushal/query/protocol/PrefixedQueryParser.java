package com.rai.kaushal.query.protocol;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrefixedQueryParser {
	
	public static void main(String[] args) throws Exception{
		
		String prefixQuery = "and(in(sastype, \"VisualExploration\", \"StoredProcess\"), in(sasauthordisplay, \"SAS Administrator\", \"Rai, Kaushal\"), le(creationdate, 1111), ge(creationdate, 3333), ge(modifieddate, 999), le(modifieddate, 5555))";
		
		String prefixQuery2 = "and(in(sastype, \"VisualExploration\", \"StoredProcess\"), in(sasauthor, \"sasadm\", \"sassearch\"))";
		
		String prefixQuery3 = "and(in(sastype, \"VisualExploration\", \"StoredProcess\"))";
		
		String prefixQuery4 = "and(in(sastype, \"VisualExploration\", \"StoredProcess\"), contains(title, \"data\"), matchAny(\"Sample\", title, description))";
		//String prefixQuery2 = "AND(IN(sastype, VisualExploration, StoredProcess), IN(sasauthor, sasadm))";
		
		String prefixQuery5 = "and(in(sastype, \"VisualExploration\", \"StoredProcess\"), matchAny(\"Sample\", title, description), contains(title, \"Shoe\"))";
		
		String prefixQuery6 = "and(in(sastype, \"VisualExploration\", \"StoredProcess\"), matchAny(\"Sample\", title, description))";
		
		//String prefixQuery7 = "and(matchAny(\"*\", title, description), in(sasauthordisplay, \"SAS Administrator\"))";
		String prefixQuery7 = "and(matchAny(\"Sample\"), in(sastype, \"VisualExploration\", \"StoredProcess\"))";
		//String prefixQuery7 = "and(matchAny(\"Sample , data\", title, description))";
		
		String prefixQuery8 = "and(matchAny(\"*\"), in(sasauthor, \"empty\"))";
		
		System.out.println(URLEncoder.encode(prefixQuery8, "UTF-8"));
		// Think for NOT/EXCLUDE option.
		//String prefixQuery = "AND(IN(sastype, Report.BI, StoredProcess), IN(sasowner, sasadm, sassearch), NOT(IN(sastype, Report, VisualExploration)), NOT(IN(sasowner, sinkar)))";
		SearchRequest searchRequest = parsePrefixedQuery(prefixQuery7);
		
		
	}

	private static final String STRING_OPERATOR = "in";
	private static final String MATH_GREATER_THAN_EQUAL_TO_OPERATOR = "ge";
	private static final String MATH_LESS_THAN_EQUAL_TO_OPERATOR = "le";
	private static final String NOT_IN_OPERATOR = "not(in";
	private static final String CONTAINS_OPERATOR = "contains";
	private static final String MATCH_ANY="matchAny";
	private static final String INTERNAL_AND="and";
	private static final String replacementToken = "_quote_";
	
	/**
	 * This method converts the prefixed faceted query to an object notation of 'SearchRequest'.
	 * 
	 * @param prefixQuery Input faceted query string in prefix notation
	 * @returnAn instance of 'SearchRequest' which is populated with required facets & range based expressions
	 * @throws Exception If any malformed query is provided, appropriate exception would be conveyed to the client. 
	 */
	public static SearchRequest parsePrefixedQuery(String prefixQuery) throws Exception{
		System.out.println("prefixQuery = " + prefixQuery);
		
		// Replace two consecutive double quotes "" (escaped sequence for a single double-quote " sent by client) to _quote_ in the query string.
		// It would be reverted to single double-quote in later stage
		if(prefixQuery.indexOf("\"\"") >0)
			prefixQuery = prefixQuery.replaceAll("\"\"", replacementToken);
		
		SearchRequest searchRequest = new SearchRequest();
		List<String> stringExpressionList = new ArrayList<String>();
		List<String> numericExpressionList = new ArrayList<String>();
		List<String> notSringExpressionList = new ArrayList<String>();
		List<String> compoundQueryExpressionList = new ArrayList<String>();
		String baseQueryExpression = null;
		// Escape the first clause of 'AND' added to the request which implies 'AND' between all the blocks thereafter.
		int startIndex = prefixQuery.indexOf('(') + 1;
		int bracesCounter = 0;
		boolean doubleQuotesOpen = false;
		
		for(int i=startIndex; i < prefixQuery.length()-1; i++){
			if(bracesCounter < 0)
				throw new Exception("Improper nesting of braces used. Invalid query = " + prefixQuery);
			
			if(')' == prefixQuery.charAt(i) && !doubleQuotesOpen){
				if(bracesCounter == 1){
					String expressionBlock = prefixQuery.substring(startIndex, i);
					System.out.println("expressionBlock = " + expressionBlock);
					if(expressionBlock.startsWith(STRING_OPERATOR))
						stringExpressionList.add(expressionBlock);
					else if(expressionBlock.startsWith(MATH_GREATER_THAN_EQUAL_TO_OPERATOR) || expressionBlock.startsWith(MATH_LESS_THAN_EQUAL_TO_OPERATOR))
						numericExpressionList.add(expressionBlock);
					else if(expressionBlock.startsWith(NOT_IN_OPERATOR))
						notSringExpressionList.add(expressionBlock.substring(0, expressionBlock.length() -1));
					else if(expressionBlock.startsWith(CONTAINS_OPERATOR))
						compoundQueryExpressionList.add(expressionBlock);
					else if(expressionBlock.startsWith(MATCH_ANY))
						baseQueryExpression = expressionBlock.substring(expressionBlock.indexOf("\"") + 1);
					else{
						// Throw an exception if any other operator is encountered
						throw new Exception("Invalid query block = " + expressionBlock);
					}
					
					startIndex = i + 1;
				}
				
				bracesCounter--;
			}else if('(' == prefixQuery.charAt(i)  && !doubleQuotesOpen){
				bracesCounter++;
			}else if(bracesCounter == 0 && (' ' == prefixQuery.charAt(i) || ',' == prefixQuery.charAt(i))){
				startIndex++;
			}else if('\"' == prefixQuery.charAt(i) && doubleQuotesOpen){
				doubleQuotesOpen = false;
			}else if('\"' == prefixQuery.charAt(i) && !doubleQuotesOpen){
				doubleQuotesOpen = true;
			}
		}
		
		// Handle the Query String and the Search Fields
		if(baseQueryExpression != null){
			populateBaseQueryInformation(baseQueryExpression, searchRequest);
		}
		
		// Once the segregation of blocks has been done, parse these blocks to populate the 'Searchrequest' object.
		if(stringExpressionList.size() > 0){
			List<String> requiredOperandNameList = new ArrayList<String>();
			List<String> requiredOperandValueList = new ArrayList<String>();
			populateStringFacet(stringExpressionList, requiredOperandNameList, requiredOperandValueList);
			searchRequest.setRequiredFields(requiredOperandNameList, requiredOperandValueList);
		}
		
		if(notSringExpressionList.size() > 0){
			List<String> excludeOperandNameList = new ArrayList<String>();
			List<String> excludeOperandValueList = new ArrayList<String>();
			populateStringFacet(notSringExpressionList, excludeOperandNameList, excludeOperandValueList);
			searchRequest.setExcludeFields(excludeOperandNameList, excludeOperandValueList);
		}
		
		if(compoundQueryExpressionList.size() > 0){
			List<String> compoundQueryOperandNameList = new ArrayList<String>();
			List<String> compoundQueryOperandValueList = new ArrayList<String>();
			populateStringFacet(compoundQueryExpressionList, compoundQueryOperandNameList, compoundQueryOperandValueList);
			searchRequest.setCompoundQueryFields(compoundQueryOperandNameList, compoundQueryOperandValueList);
		}
		
		if(numericExpressionList.size() > 0){
			List<String> operandNameList = new ArrayList<String>();
			List<Long> startRangeValueList = new ArrayList<Long>();
			List<Long> endRangeValueList = new ArrayList<Long>();
			
			populateRangeBasedQuery(numericExpressionList, operandNameList, startRangeValueList, endRangeValueList);
			searchRequest.setNumericRange(operandNameList, startRangeValueList, endRangeValueList);
		}
		
		return searchRequest;
	}

	/**
	 * This method populates the main query string and the 'Search Fields' for that query string.
	 * 
	 * @param baseQueryExpression The query expression having query string & search fields in appropriate format
	 * @param searchRequest The main request object which needs to be populated with query string and search fields.
	 */
	private static void populateBaseQueryInformation(String baseQueryExpression, SearchRequest searchRequest){
		System.out.println("baseQueryPhrase = " + baseQueryExpression);
		int divisionPoint = baseQueryExpression.indexOf('\"');
		String queryString = baseQueryExpression.substring(0, divisionPoint);
		
		// If the query string had two consecutive double-quotes replaced by the 'replacementToken', the token string must be
		// reverted back to a single double-quote, there by removing the escaping sequence requested by us to client.
		if(queryString.indexOf(replacementToken) > 0)
			queryString = queryString.replaceAll(replacementToken, "\"");
		System.out.println("Final queryString = " + queryString);
		List<String> fieldnames = new ArrayList<String>();
		
		int characterStartLocation = divisionPoint + 1;
		for(int i= characterStartLocation; i < baseQueryExpression.length(); i++){
			if(' ' == baseQueryExpression.charAt(i) || (',' == baseQueryExpression.charAt(i) && characterStartLocation == i)){
				characterStartLocation++;
			}else if(',' == baseQueryExpression.charAt(i) && characterStartLocation != i){
				String fieldName = baseQueryExpression.substring(characterStartLocation, i);
				characterStartLocation = i + 1;
				fieldnames.add(fieldName);
			}
		}
		
		fieldnames.add(baseQueryExpression.substring(characterStartLocation));
		
		String[] fieldNames = new String[fieldnames.size()];
		fieldnames.toArray(fieldNames);
		
		searchRequest.setQuery(queryString);
		searchRequest.setSearchFields(fieldNames);
	}
	
	/**
	 * This method parses the list of expressions for required and exclude expressions from a prefixed notation
	 * and populate appropriate lists with respective values.
	 * 
	 * @param stringExpressionList List of expressions which needs to be parsed for either required or exclude clause
	 * @param operandNameList The list of operand names in the expression that needs to be populated sequentially
	 * @param operandValueList The list of operator values in the expression that needs to be populated sequentially
	 * @throws Exception If any malformed query is provided, appropriate exception would be conveyed to the client.
	 */
	private static void populateStringFacet(List<String> stringExpressionList, List<String> operandNameList, 
			List<String> operandValueList) throws Exception{
			
		for(String stringExpression : stringExpressionList){
			int startIndex = stringExpression.lastIndexOf('(') +1;
			System.out.println("stringExpression = " + stringExpression);
			
			List<String> operands = getOperandTokens(stringExpression.substring(startIndex));
			
			if(operands.size() < 2){
				if(stringExpression.startsWith(STRING_OPERATOR))
					throw new Exception("Invalid query block = " + stringExpression + ")");
				else
					throw new Exception("Invalid query block = " + stringExpression + "))");
			}
			
			for(int i=1; i < operands.size(); i++){
				operandNameList.add(operands.get(0));
				operandValueList.add(operands.get(i));
				
				System.out.println("operands = " + operands.get(i));
			}
		}
	}

	/**
	 * It is possible that the operands have a comma - ',' present in the value. e.g. 'Langsley, Joy'
	 * In such cases, we cannot simply use a comma as an operand delimiter for split operation.
	 * We need manual parsing and splitting of the expression.
	 * 
	 * @param expression The base expression having first variable in plain string and 
	 * 					value encoded in double quotes
	 * @return A List of separated operands.
	 */
	private static List<String> getOperandTokens(String expression){
		List<String> tokenList = new ArrayList<String>();

		boolean doubbleQuotesOpen = false;
		int startIndex = 0;
		boolean firstoperandProcessed = false;
		
		for(int i=0; i < expression.length(); i++){
			if(',' == expression.charAt(i) && !doubbleQuotesOpen){
				String operand = null;
				
				if(firstoperandProcessed)
					operand = expression.substring(startIndex, i-1);
				else{
					operand = expression.substring(startIndex, i);
					firstoperandProcessed = true;
				}
				
				startIndex = i + 1;
				tokenList.add(operand);
			}else if('\"' == expression.charAt(i) && doubbleQuotesOpen){
				doubbleQuotesOpen = false;
				startIndex++;
			}else if(' ' == expression.charAt(i) && !doubbleQuotesOpen){
				startIndex++;
			}else if('\"' == expression.charAt(i) && !doubbleQuotesOpen){
				doubbleQuotesOpen = true;
			}
		}
		
		String lastOperand = expression.substring(startIndex, expression.length() - 1);
		tokenList.add(lastOperand);
		
		return tokenList;
	}
	
	/**
	 * This method parses the list of expressions for range based queries from a prefixed notation
	 * and populate appropriate lists with respective values.
	 * 
	 * @param numericExpressionList List of expressions which needs to be parsed for numeric range clause
	 * @param operandNameList The list of operand names in the expression that needs to be populated sequentially
	 * @param startRangeValueList  The list of start values for the range. 
	 * @param endRangeValueList  The list of end values for the range. 
	 * @throws Exception If any malformed query is provided, appropriate exception would be conveyed to the client. 
	 */
	private static void populateRangeBasedQuery(List<String> numericExpressionList, List<String> operandNameList, List<Long> startRangeValueList,
			List<Long> endRangeValueList) throws Exception{
		
		Map<String, Long> rangeValueCheckMap = new HashMap<String, Long>();
		
		for(String numericExpression : numericExpressionList){
			int startIndex = numericExpression.lastIndexOf('(') +1;
			
			String[] operands = numericExpression.substring(startIndex).split(",");
			
			if(operands.length < 2)
				throw new Exception("Invalid query block = " + numericExpression);
			
			Long firstValue = rangeValueCheckMap.get(operands[0]);
			Long secondvalue = Long.parseLong(operands[1].trim());
			
			if( firstValue != null){
				operandNameList.add(operands[0]);
				
				if(firstValue < secondvalue){
					startRangeValueList.add(firstValue);
					endRangeValueList.add(secondvalue);
				}else{
					startRangeValueList.add(secondvalue);
					endRangeValueList.add(firstValue);
				}
				
				rangeValueCheckMap.remove(operands[0]);
			}else{
				rangeValueCheckMap.put(operands[0], secondvalue);
			}
		}
		
		// If there was any expression that did not had both start & end values, then throw an exception
		if(rangeValueCheckMap.size() > 0)
			throw new Exception("Invalid query. Range based query is malformed.");
		
	}
}