package com.kausha.algo.gfg.microsoft;

// https://practice.geeksforgeeks.org/problems/josephus-problem/1/?company[]=Microsoft&company[]=Microsoft&page=1&query=company[]Microsoftpage1company[]Microsoft
/**
 * Given the total number of persons n and a number k which indicates that k-1 persons are skipped and kth person is killed in circle in a fixed direction.

The task is to choose the safe place in the circle so that when you perform these operations starting from 1st place in the circle, you are the last one remaining and survive.

Example 1:

Input:
n = 3 k = 2
Output: 3
Explanation: There are 3 persons so 
skipping 1 person i.e 1st person 2nd 
person will be killed. Thus the safe 
position is 3.
 * @author sinkar
 *
 */
public class JosephusProblem {

	public static void main(String[] args) {
		JosephusProblem jp = new JosephusProblem();
		System.out.println(jp.josephus(3, 2)); // 3
		System.out.println(jp.josephus(5, 3)); // 4
	}

	// Have added this method just to have indexes start from '1' instead of '0'
	public int josephus(int n, int k) {
		return josephusRec(n, k) + 1;
	}
	
	private int josephusRec(int n, int k)
    {
		// There is only one element left, it is the last element on index '0'. We we return index '0'.
        if(n == 1)
        	return 0;
        
        int left = josephusRec(n-1, k);
        // Here we try to normalize the base number obtained for current 'n'.  
        left = (left + k)%n;
        
        return left;
    }
}
