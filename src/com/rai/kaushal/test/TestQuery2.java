package com.rai.kaushal.test;

import java.util.ArrayList;
import java.util.List;

import com.rai.kaushal.query.ClauseOperatorConstants;
import com.rai.kaushal.query.ComparisionOperatorConstants;
import com.rai.kaushal.query.Operand;
import com.rai.kaushal.query.Operator;
import com.rai.kaushal.query.QueryBlock;
import com.rai.kaushal.query.QueryClause;
import com.rai.kaushal.query.QueryExpression;

public class TestQuery2 {

	
	public static void main(String[] args) {
		Operand op1 = new Operand("sasauthor");
		Operator optr = new Operator(ComparisionOperatorConstants.STRING_EQ.getOperatorValue());
		Operand op2 = new Operand("sasadm");
		
		QueryBlock queryClause = new QueryBlock();
		queryClause.setFirstOperand(op1);
		queryClause.setOperator(optr);
		queryClause.setSecondOperand(op2);
		
		Operand op11 = new Operand("sasauthor");
		Operator optr11 = new Operator(ComparisionOperatorConstants.STRING_EQ.getOperatorValue());
		Operand op21 = new Operand("sassearch");
		
		QueryBlock queryClause11 = new QueryBlock();
		queryClause11.setFirstOperand(op11);
		queryClause11.setOperator(optr11);
		queryClause11.setSecondOperand(op21);
		
		QueryClause queryBlock = new QueryClause();
		queryBlock.setOperator(ClauseOperatorConstants.OR.name());
		queryBlock.setQueryClause(queryClause);
		
		QueryClause queryBlock11 = new QueryClause();
		queryBlock11.setOperator(ClauseOperatorConstants.OR.name());
		queryBlock11.setQueryClause(queryClause11);
		
		List<QueryClause> queryBlockList = new ArrayList<QueryClause>();
		queryBlockList.add(queryBlock);
		queryBlockList.add(queryBlock11);
		
		QueryExpression cqc = new QueryExpression();
		cqc.setQueryClauseExpr(queryBlockList);
		// =======================================================================================
		
		Operand op31 = new Operand("sastype");
		Operator optr3 = new Operator(ComparisionOperatorConstants.STRING_EQ.getOperatorValue());
		Operand op32 = new Operand("Report.BI");
		
		QueryBlock queryClause3 = new QueryBlock();
		queryClause3.setFirstOperand(op31);
		queryClause3.setOperator(optr3);
		queryClause3.setSecondOperand(op32);
		
		Operand op311 = new Operand("sastype");
		Operator optr311 = new Operator(ComparisionOperatorConstants.STRING_EQ.getOperatorValue());
		Operand op321 = new Operand("StoredProcess");
		
		QueryBlock queryClause311 = new QueryBlock();
		queryClause311.setFirstOperand(op311);
		queryClause311.setOperator(optr311);
		queryClause311.setSecondOperand(op321);
		
		Operand op331 = new Operand("sastype");
		Operator optr332 = new Operator(ComparisionOperatorConstants.STRING_EQ.getOperatorValue());
		Operand op333 = new Operand("VisualExploration");
		
		QueryBlock queryClause331 = new QueryBlock();
		queryClause331.setFirstOperand(op331);
		queryClause331.setOperator(optr332);
		queryClause331.setSecondOperand(op333);
		
		QueryClause queryBlock3 = new QueryClause();
		queryBlock3.setOperator(ClauseOperatorConstants.OR.name());
		queryBlock3.setQueryClause(queryClause3);
		
		QueryClause queryBlock311 = new QueryClause();
		queryBlock311.setOperator(ClauseOperatorConstants.OR.name());
		queryBlock311.setQueryClause(queryClause311);
		
		QueryClause queryBlock331 = new QueryClause();
		queryBlock331.setOperator(ClauseOperatorConstants.OR.name());
		queryBlock331.setQueryClause(queryClause331);
		
		List<QueryClause> queryBlockList3 = new ArrayList<QueryClause>();
		queryBlockList3.add(queryBlock3);
		queryBlockList3.add(queryBlock311);
		queryBlockList3.add(queryBlock331);
		
		QueryExpression cqc3 = new QueryExpression();
		cqc3.setQueryClauseExpr(queryBlockList3);

		
	
		
		// =======================================================================================
		QueryExpression cqc4 = new QueryExpression();
		addCompoundQueryClauseExpr(cqc4);
		
		// =====================================================================================
		List<QueryExpression> compoundQueryClauseList = new ArrayList<QueryExpression>();
		compoundQueryClauseList.add(cqc);
		compoundQueryClauseList.add(cqc3);
		compoundQueryClauseList.add(cqc4);
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
		QueryExpression cqcFinal = new QueryExpression();
		cqcFinal.setQueryExpressionList(compoundQueryClauseList);
		//QueryExpression qe = new QueryExpression();
		//qe.setQueryClauseList(queryBlockList);
		//qe.setCompoundQueryClauseList(compoundQueryClauseList);
		
		System.out.println("Boolean Query Expression = " + cqcFinal);
	}

	
	private static void addCompoundQueryClauseExpr(QueryExpression cqc){
		Operand op1 = new Operand("modifieddatelong");
		Operator optr = new Operator(ComparisionOperatorConstants.MATH_GTEQ.getOperatorValue());
		Operand op2 = new Operand("123700345843");
		
		QueryBlock queryClause = new QueryBlock();
		queryClause.setFirstOperand(op1);
		queryClause.setOperator(optr);
		queryClause.setSecondOperand(op2);
		
		Operand op11 = new Operand("modifieddatelong");
		Operator optr11 = new Operator(ComparisionOperatorConstants.MATH_LTEQ.getOperatorValue());
		Operand op21 = new Operand("123788686787");
		
		QueryBlock queryClause11 = new QueryBlock();
		queryClause11.setFirstOperand(op11);
		queryClause11.setOperator(optr11);
		queryClause11.setSecondOperand(op21);
		
		QueryClause queryBlock = new QueryClause();
		queryBlock.setOperator(ClauseOperatorConstants.AND.getOperatorName());
		queryBlock.setQueryClause(queryClause);
		
		QueryClause queryBlock11 = new QueryClause();
		queryBlock11.setOperator(ClauseOperatorConstants.AND.getOperatorName());
		queryBlock11.setQueryClause(queryClause11);
		
		List<QueryClause> queryBlockList = new ArrayList<QueryClause>();
		queryBlockList.add(queryBlock);
		queryBlockList.add(queryBlock11);
		
		cqc.setQueryClauseExpr(queryBlockList);
		
	}
}