package com.kausha.algo.gfg.microsoft;

// https://practice.geeksforgeeks.org/problems/longest-consecutive-1s-1587115620/1/?company[]=Microsoft&company[]=Microsoft&page=1&query=company[]Microsoftpage1company[]Microsoft

public class LongestConsecutive1s {

	public static void main(String[] args) {
		System.out.println(maxConsecutiveOnes(0)); // 0
		System.out.println(maxConsecutiveOnes(1)); // 1
		System.out.println(maxConsecutiveOnes(14)); // 3
		System.out.println(maxConsecutiveOnes(222)); // 4

	}

	public static int maxConsecutiveOnes(int N) {
		int maxCount = 0;
        int count = 0;
		
        int one = 0;
        boolean prevOne = false;
        for(int i=0; i<32; i++) {
        	one = 1 << i;
        	if((one & N) > 0) {
        		if (prevOne)
        			count++;
        		else
        			count = 1;
        		prevOne = true;
        		
        		if(count > maxCount)
        			maxCount = count;
        	}else
        		prevOne = false;
        		
        }
        
        return maxCount;
    }
}
