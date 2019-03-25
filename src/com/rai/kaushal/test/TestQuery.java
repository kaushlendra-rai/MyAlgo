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

public class TestQuery {

	
	public static void main(String[] args) {
		Operand op1 = new Operand("name");
		Operator optr = new Operator(ComparisionOperatorConstants.STRING_EQ.getOperatorValue());
		Operand op2 = new Operand("Kaushal");
		
		QueryBlock queryClause = new QueryBlock();
		queryClause.setFirstOperand(op1);
		queryClause.setOperator(optr);
		queryClause.setSecondOperand(op2);
		
		Operand op11 = new Operand("company");
		Operator optr11 = new Operator(ComparisionOperatorConstants.STRING_EQ.getOperatorValue());
		Operand op21 = new Operand("SAS");
		
		QueryBlock queryClause11 = new QueryBlock();
		queryClause11.setFirstOperand(op11);
		queryClause11.setOperator(optr11);
		queryClause11.setSecondOperand(op21);
		
		QueryClause queryBlock = new QueryClause();
		queryBlock.setOperator(ClauseOperatorConstants.AND.name());
		queryBlock.setQueryClause(queryClause);
		
		QueryClause queryBlock11 = new QueryClause();
		queryBlock11.setOperator(ClauseOperatorConstants.AND.name());
		queryBlock11.setQueryClause(queryClause11);
		
		List<QueryClause> queryBlockList = new ArrayList<QueryClause>();
		queryBlockList.add(queryBlock);
		queryBlockList.add(queryBlock11);
		
		// =======================================================================================
		QueryExpression cqc = new QueryExpression();
		cqc.setQueryClauseExpr(queryBlockList);

		
		List<QueryExpression> compoundQueryClauseList = new ArrayList<QueryExpression>();
		compoundQueryClauseList.add(cqc);
		
		// =======================================================================================
		
		addCompoundQueryClauseExpr(cqc);
		
		
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
		QueryExpression qe = new QueryExpression();
		qe.setQueryClauseExpr(queryBlockList);
		qe.setQueryExpressionList(compoundQueryClauseList);
		qe.setQueryExpressionOperator(ClauseOperatorConstants.AND.name());
		System.out.println("Boolean Query Expression = " + qe);
	}

	private static void addCompoundQueryClauseExpr(QueryExpression cqc){
		Operand op1 = new Operand("AGE");
		Operator optr = new Operator(ComparisionOperatorConstants.MATH_GTEQ.getOperatorValue());
		Operand op2 = new Operand("25");
		
		QueryBlock queryClause = new QueryBlock();
		queryClause.setFirstOperand(op1);
		queryClause.setOperator(optr);
		queryClause.setSecondOperand(op2);
		
		Operand op11 = new Operand("experience");
		Operator optr11 = new Operator(ComparisionOperatorConstants.MATH_GT.getOperatorValue());
		Operand op21 = new Operand("10");
		
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
		
		QueryExpression cqcNew = new QueryExpression();
		cqcNew.setQueryClauseExpr(queryBlockList);

		/*Operand op51 = new Operand("sastype");
		Operator optr51 = new Operator(ComparisionOperatorConstants.STRING_EQ.getOperatorValue());
		Operand op52 = new Operand("Report.BI");
		
		QueryBlock queryClause51 = new QueryBlock();
		queryClause11.setFirstOperand(op51);
		queryClause11.setOperator(optr51);
		queryClause11.setSecondOperand(op52);
		
		QueryClause queryClause5 = new QueryClause();
		queryClause5.setOperator(ClauseOperatorConstants.AND.name());
		queryClause5.setQueryClause(queryClause51);
		
		List<QueryClause> queryClauseList = new ArrayList<QueryClause>();
		queryClauseList.add(queryClause5);*/
		
		List<QueryExpression> compoundQueryClauseList = new ArrayList<QueryExpression>();
		compoundQueryClauseList.add(cqcNew);
		
		cqc.setQueryExpressionList(compoundQueryClauseList);
		cqc.setQueryExpressionOperator(ClauseOperatorConstants.AND.name());
		//cqc.setQueryClauseExpr(queryClauseList, null);
	}
}