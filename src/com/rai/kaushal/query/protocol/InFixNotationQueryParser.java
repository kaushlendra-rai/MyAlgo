package com.rai.kaushal.query.protocol;

import java.util.ArrayList;
import java.util.List;

import com.rai.kaushal.query.Expression;
import com.rai.kaushal.query.Operand;
import com.rai.kaushal.query.Operator;
import com.rai.kaushal.query.QueryBlock;
import com.rai.kaushal.query.QueryClause;
import com.rai.kaushal.query.QueryExpression;

public class InFixNotationQueryParser {

	public static void main(String[] args) throws Exception{
		//String query = "AND(sastype EQ Report.BI) AND(sasowner EQ sasadm)";
		//String query = "AND(OR(sastype EQ Report.BI) OR(sastype EQ StoredProcess)) AND(sasowner EQ sasadm)";
		
		String query = "AND((sastype EQ Report.BI)  AND(AND(createdate > 0) AND(createdate < 1000)) (sastype EQ StoredProcess) AND((modifiedDate > 222222) (modifiedDate < 333333))) AND(sasowner EQ sasadm)";
		Expression expression = parseQuery(query);
		
		System.out.println("expression = " + expression.toString());
	}
	
	// Sample queries possible:
	// VALID AS PER DAVID BIESACK BUT INVALID AS PER ME::
	// AND( OR((sastype = Report.BI) (sastype = StoredProcess)) OR((sasowner = sasadm) (sasowner = sasadm)) (createddate > 0) ( modifieddate < 78678687768))
	// 
	// CORRECT AS PER ME::
	// AND( AND((sastype = Report.BI) (sastype = StoredProcess)) AND((sasowner = sasadm) (sasowner = sasadm)) AND(createddate > 0) AND( modifieddate < 78678687768))
	//
	// ######################   Sample Scenarios   ########################
	// AND(sastype = Report.BI)
	// AND((sastype = Report.BI) (sastype = StoredProcess))
	// AND( AND((sastype = Report.BI) (sastype = StoredProcess)) AND(sasowner = sasadm))
	// AND( AND((sastype = Report.BI) (sastype = StoredProcess)) AND((sasowner = sasadm) (sasowner = sasadm)) AND(createddate > 0) AND( modifieddate < 78678687768))
	
	// Also possible:
	// AND(sastype EQ Report.BI) AND(sasowner EQ sasadm)
	// AND((sastype EQ Report.BI) (sastype EQ StoredProcess)) AND(sasowner EQ sasadm)
	// AND((sastype EQ Report.BI) (sastype EQ StoredProcess)) AND((sasowner EQ sasadm) (sasowner EQ sassearch))
	
	public static Expression parseQuery(String query) throws Exception{
		System.out.println("Input Query = " + query);
		
		String normalizedQuery = normalizeQuery(query);
		
		System.out.println("Normalized Query = " + normalizedQuery);
		System.out.println("\n\n");
		Expression queryExpression = recursiveQueryBuilder(normalizedQuery, null);
		
		return queryExpression;
	}
	
	protected static String normalizeQuery(String query){
		StringBuilder normalizedQuery = new StringBuilder();
		int startIndex = 0;

		// One task of this method is to embed an 'OR' clause just before an opening braces '('
		// if there are no Clause present before it.
		for(int i=0; i < query.length(); i++){
			if('(' == query.charAt(i)){
				
				normalizedQuery.append(query.subSequence(startIndex, i));
				
				if(' ' == query.charAt(i-1) || '(' == query.charAt(i-1) || ')' == query.charAt(i-1)){
					normalizedQuery.append("OR");
				}
				
				normalizedQuery.append("(");
				startIndex = i + 1;
			}
		}
		
		normalizedQuery.append(query.subSequence(startIndex, query.length()));
		
		return normalizedQuery.toString();
	}

	/**
	 * 
	 * 
	 * @param query
	 */
	protected static Expression recursiveQueryBuilder(String query, String clauseOnQuery) throws Exception{
		int startIndex = 0;
		int bracketCounter = 0;
		String clause = null;
		
		Expression expression = null;
		List<QueryClause> queryClauseList = new ArrayList<QueryClause>();
		List<QueryExpression> queryExpressionList = new ArrayList<QueryExpression>();
		
		if(query.indexOf("(") >= 0){
			for(int i=0; i < query.length(); i++){
				if(bracketCounter < 0){
					// This is a case where the braces are miss-aligned e.g. - AND)sastype EQ StoredProcess(
					throw new Exception("Malformed query filter. Proper nesting of braces is required");
				}else if('(' == query.charAt(i)){
					
					if(bracketCounter == 0){
						clause = query.substring(startIndex, i).trim();
						startIndex = i + 1;
					}
					
					bracketCounter++;
				}else if(')' == query.charAt(i)){
					bracketCounter--;
					
					// Check if a proccessable block has been parsed. If it has been parsed then send it back
					// for recursive Query building.				
					if(bracketCounter == 0){
						Expression internalExpression = recursiveQueryBuilder(query.substring(startIndex, i), clause);

						if(internalExpression instanceof QueryClause)
							queryClauseList.add((QueryClause)internalExpression);
						else
							queryExpressionList.add((QueryExpression)internalExpression);
						
						startIndex = i + 1;
					}
				}
			}
			
			QueryExpression queryExpression = new QueryExpression();
			
			if(queryClauseList.size() > 0)
				queryExpression.setQueryClauseExpr(queryClauseList);
			
			if(queryExpressionList.size() > 0)
				queryExpression.setQueryExpressionList(queryExpressionList);
			
			queryExpression.setQueryExpressionOperator(clauseOnQuery);

			expression = queryExpression;
		}else{
			// This is the last level of braces and contains only operator & operands.
			// Build and return the 
			QueryBlock queryBlock = new QueryBlock();
			
			String[] queryTerms = query.split(" ", 3);
			
			queryBlock.setFirstOperand(new Operand(queryTerms[0]));
			queryBlock.setOperator(new Operator(queryTerms[1]));
			queryBlock.setSecondOperand(new Operand(queryTerms[2]));
			
			QueryClause queryClause = new QueryClause();
			queryClause.setQueryClause(queryBlock);
			queryClause.setOperator(clauseOnQuery);

			expression = queryClause;
		}
		
		return expression;
	}
}