package com.rai.kaushal.query;

public class QueryClause implements Expression{

	private QueryBlock queryBlock;
	private String operator;
	
	public QueryBlock getQueryBlock() {
		return queryBlock;
	}
	public void setQueryClause(QueryBlock queryBlock) {
		this.queryBlock = queryBlock;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	public String toString(){
		return operator + queryBlock.toString();
	}
}