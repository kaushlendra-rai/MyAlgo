package com.kausha.algo.leetcode;

public class MaxProfit_1Easy {

	public static void main(String[] args) {
		MaxProfit_1Easy mp = new MaxProfit_1Easy();
		//int[] prices = new int[] {7,1,5,3,6,4};
		int[] prices = new int[] {7,6,4,3,1};
		
		System.out.println(mp.maxProfit(prices));
	}

	public int maxProfit(int[] prices) {
		if(prices.length <2)
        	return 0;
		
        int maxProfit = 0;
        int start = prices[0];
        
        for(int i=1; i< prices.length; i++) {
        	if(start > prices[i])
        		start = prices[i];
        	else if(maxProfit < prices[i] - start){
        		maxProfit = prices[i] - start;
        	}
        }
        return maxProfit;
    }
}
