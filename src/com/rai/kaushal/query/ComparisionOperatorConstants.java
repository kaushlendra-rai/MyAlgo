package com.rai.kaushal.query;

public enum ComparisionOperatorConstants {

	MATH_GTEQ("GTEQ", ">="),
	MATH_GT("GT", ">"),
	MATH_LTEQ("LTEQ", "<="),
	MATH_LT("LT", "<"),
	MATH_EQ("EQ", "="),
	
	STRING_EQ("EQ", "EQ"),
	STRING_LIKE("LIKE", "%");
	
	private String operatorName;
	private String operatorValue;
	
	ComparisionOperatorConstants(String operatorName, String operatorValue){
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