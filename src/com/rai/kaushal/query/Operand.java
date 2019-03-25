package com.rai.kaushal.query;

public class Operand {
	
	private String operandValue;

	public Operand(String operandValue){
		this.operandValue = operandValue;
	}

	public String getOperandValue() {
		return operandValue;
	}

	public String toString(){
		return operandValue;
	}
}