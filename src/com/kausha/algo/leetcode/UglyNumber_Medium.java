package com.kausha.algo.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/ugly-number-ii/
// Given an integer n, return the nth ugly number.
// Ugly number is a positive number whose prime factors only include 2, 3, and/or 5.
public class UglyNumber_Medium {

	public static void main(String[] args) {
		UglyNumber_Medium un = new UglyNumber_Medium();
		System.out.println(un.nthUglyNumber(10));
	}

	
	
	public int nthUglyNumber(int n) {
		if(n == 1)
			return 1;
		int[] nums = new int[n];
		nums[0] = 1;
		
		int next2Multiple = 0;
		int next3Multiple = 0;
		int next5Multiple = 0;
		int counter =1;
		int ugly = 1;
		while(counter < n) {
			int twos = nums[next2Multiple] * 2;
			int threes = nums[next3Multiple] * 3;
			int fives = nums[next5Multiple] * 5;
			
			ugly = Math.min(twos, Math.min(threes, fives));
			nums[counter++] = ugly;
			
			if(ugly == twos)
				next2Multiple++;
			if(ugly == threes)
				next3Multiple++;
			if(ugly == fives)
				next5Multiple++;
		}
		
		return ugly;
	}
	
	public int nthUglyNumber_FromPost(int n) {
	    if(n<=0)
	        return 0;
	 
	    ArrayList<Integer> list = new ArrayList<Integer>();
	    list.add(1);
	 
	    int i=0;
	    int j=0;
	    int k=0;
	 
	    while(list.size()<n){
	        int m2 = list.get(i)*2;
	        int m3 = list.get(j)*3;
	        int m5 = list.get(k)*5;
	 
	        int min = Math.min(m2, Math.min(m3, m5));
	        list.add(min);
	 
	        if(min==m2)
	            i++;
	 
	        if(min==m3)
	            j++;
	 
	        if(min==m5)
	            k++;
	    }
	 
	    return list.get(list.size()-1);
	}
	
	public int nthUglyNumber_Perf_timeout(int n) {
		if(n == 1)
			return 1;
		
		Set<Integer> ugly = new HashSet<>();
		ugly.add(1);
		int num = 2;
		int counter = 1;
		int uglyNumber = 0;
		while(counter < n) {
			//if((num%2 == 0)) && ugly.contains(num/2))|| (num%3 == 0 && ugly.contains(num/3)) || (num%5 == 0 && ugly.contains(num/5))) {
			if((num%2 == 0)) {
				if(ugly.contains(num/2)) {
					ugly.add(num);
					counter++;
					uglyNumber = num;
				}
			}else if (num%3 == 0) {
				if(ugly.contains(num/3)) {
					ugly.add(num);
					counter++;
					uglyNumber = num;
				}
			}else if(num%5 == 0) {
				if(ugly.contains(num/5)) {
					ugly.add(num);
					counter++;
					uglyNumber = num;
				}
			}
			num++;
		}
		
		return uglyNumber;
    }
}
