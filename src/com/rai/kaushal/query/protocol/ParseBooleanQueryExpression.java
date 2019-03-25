package com.rai.kaushal.query.protocol;

import java.util.ArrayList;
import java.util.List;

import com.rai.kaushal.query.QueryExpression;
import com.rai.kaushal.query.QueryClause;

public class ParseBooleanQueryExpression {

	private static final List<String> stringOperatorList = new ArrayList<String>(2);
	
	static{
		stringOperatorList.add("EQ");
		stringOperatorList.add("LIKE");
	}
	
	public static void parseQueryExpression(QueryExpression queryExpression,  SearchRequest searchRequest) throws Exception{
		
		// For IR Studio & Lucene, QueryClause would not exist in Query Expression.
		List<QueryClause> expressionQueryClauseList = queryExpression.getQueryClauseList();
		if(expressionQueryClauseList!= null && expressionQueryClauseList.size() > 0)
			throw new Exception("Invalid Query");
		
		List<String> requiredFieldNameList = new ArrayList<String>();
		List<String> requiredFieldValueList = new ArrayList<String>();
		
		List<String> rangeVariableNameList = new ArrayList<String>();
		List<Long> startRangeValueList = new ArrayList<Long>();
		List<Long> endRangeValueList = new ArrayList<Long>();
		
		List<QueryExpression> compoundQueryClauseList = queryExpression.getQueryExpressionList();
		
		for(QueryExpression compoundQueryClause : compoundQueryClauseList){
			List<QueryClause> queryClauseList = compoundQueryClause.getQueryClauseList();
			
			boolean isStringOperator = true;
			
			for(QueryClause queryClause : queryClauseList){
				String operator = queryClause.getQueryBlock().getOperator().getOperatorValue();
				String variableName = queryClause.getQueryBlock().getFirstOperand().getOperandValue();
				String compareValue = queryClause.getQueryBlock().getSecondOperand().getOperandValue();
				
				long firstRangeValue = 0;
				long secondRangeValue = 0;
				
				if(stringOperatorList.contains(operator)){
					// All the QueryBlocks need to have same operator, i.e. either String or Math operators.
					if(!isStringOperator)
						throw new Exception("Invalid Query. All Blocks should have similar type of operator");
					
					requiredFieldNameList.add(variableName);
					requiredFieldValueList.add(compareValue);
				}else{
					isStringOperator = false;
					
					// All the QueryBlocks need to have same operator, i.e. either String or Math operators.
					if(isStringOperator)
						throw new Exception("Invalid Query. All Blocks should have similar type of operator");
					if(queryClauseList.size() != 2)
						throw new Exception("Invalid Query. Every range based query should have 2 blocks depicting start & end ranges.");
					
					if(rangeVariableNameList.contains(variableName)){
						secondRangeValue = Long.parseLong(compareValue);
						
						if(firstRangeValue < secondRangeValue){
							startRangeValueList.add(firstRangeValue);
							endRangeValueList.add(secondRangeValue);
						}else{
							startRangeValueList.add(secondRangeValue);
							endRangeValueList.add(firstRangeValue);
						}
					}
					else{
						firstRangeValue = Long.parseLong(compareValue);
						
						rangeVariableNameList.add(variableName);
					}
				}
			}
		}
		
		if(requiredFieldNameList.size() > 0)
			searchRequest.setRequiredFields(requiredFieldNameList, requiredFieldValueList);
		
		if(rangeVariableNameList.size() > 0)
			searchRequest.setNumericRange(rangeVariableNameList, startRangeValueList, endRangeValueList);
	}
}