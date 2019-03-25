package com.rai.kaushal.query;

public class QueryBlock{

	private Operand firstOperand;
	private Operator operator;
	private Operand secondOperand;
	
	public Operand getFirstOperand() {
		return firstOperand;
	}
	public void setFirstOperand(Operand firstOperand) {
		this.firstOperand = firstOperand;
	}
	public Operator getOperator() {
		return operator;
	}
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	public Operand getSecondOperand() {
		return secondOperand;
	}
	public void setSecondOperand(Operand secondOperand) {
		this.secondOperand = secondOperand;
	}
	
	public String toString(){
		return "(" + firstOperand.toString() + " " + operator.toString() + " '" + secondOperand.toString() + "') ";
	}
}