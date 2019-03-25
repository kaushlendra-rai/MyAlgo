package com.rai.kaushal.query;

import java.util.ArrayList;
import java.util.List;

public class QueryExpression implements Expression{

	private List<QueryClause> queryClauseList = new ArrayList<QueryClause>();
	private List<QueryExpression> queryExpressionList = new ArrayList<QueryExpression>();
	
	private String queryExpressionOperator;
	
	public List<QueryClause> getQueryClauseList() {
		return queryClauseList;
	}
	
	public void setQueryClauseExpr(List<QueryClause> queryClauseList){
		this.queryClauseList = queryClauseList;
	}
	
	public void setQueryExpressionList(List<QueryExpression> compoundQueryClauseList){
		this.queryExpressionList = compoundQueryClauseList;
	}
	
	public List<QueryExpression> getQueryExpressionList() {
		return queryExpressionList;
	}
	
	public String getQueryExpressionOperator() {
		return queryExpressionOperator;
	}

	public void setQueryExpressionOperator(String queryExpressionOperator) {
		this.queryExpressionOperator = queryExpressionOperator;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		
		if(queryExpressionOperator != null)
			sb.append(queryExpressionOperator).append("(");
		
		if(queryClauseList.size() > 0)
			for(QueryClause queryClause : queryClauseList)
				sb.append(queryClause.toString());
		
		if(queryExpressionList.size() > 0)
			for(QueryExpression queryExpression : queryExpressionList)
				sb.append(queryExpression.toString());
		
		if(queryExpressionOperator != null)
			sb.append(") ");
		
		return sb.toString();
	}
}