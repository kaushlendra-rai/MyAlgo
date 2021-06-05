package com.kausha.algo.gfg.microsoft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateParanthesis {

	public static void main(String[] args) {
		GenerateParanthesis gp = new GenerateParanthesis();

		System.out.println(gp.AllParenthesis(3));
		System.out.println(gp.AllParenthesis(1));
		System.out.println(gp.AllParenthesis(0));
	}

	public List<String> AllParenthesis(int n) 
    {
        List<String> parenthesis = new ArrayList<>();
        
        generateParenthesis(parenthesis, "", n, n);
        
        return parenthesis;
    }

	private void generateParenthesis(List<String> parenthesis, String str, int left, int right) {
		if(left == 0 && right==0) {
			parenthesis.add(str);
			return;
		}
		
		// We do not want to generate illegal pairs where left < right at any point...e.g: ))((
		// Hence return in such cases and do not process such cases any further.
		if(left > right)
			return;
		
		if(left > 0)
			generateParenthesis(parenthesis, str + "(", left-1, right);
		if(right > 0)
			generateParenthesis(parenthesis, str + ")", left, right-1);
	}
}
