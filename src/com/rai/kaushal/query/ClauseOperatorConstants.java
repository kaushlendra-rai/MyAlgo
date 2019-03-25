package com.rai.kaushal.query;

public enum ClauseOperatorConstants {

	AND("AND", "+"),
	OR("OR", " "),
	NOT("NOT", "-")
	;
	
	private String operatorName;
	private String operatorValue;
	
	ClauseOperatorConstants(String operatorName, String operatorValue){
		this.operatorName = operatorName;
		this.operatorValue = operatorValue;
	}

	public String getOperatorName() {
		return operatorName;
	}
	
	public String getOperatorValue() {
		return operatorValue;
	}	 
}