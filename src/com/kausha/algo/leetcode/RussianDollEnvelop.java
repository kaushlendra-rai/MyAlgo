package com.kausha.algo.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/russian-doll-envelopes/
/*
 * You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of an envelope.

One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.

Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).

Note: You cannot rotate an envelope.
 */

public class RussianDollEnvelop {

	public static void main(String[] args) {
		RussianDollEnvelop rd = new RussianDollEnvelop();

		//int[][] envelopes = new int[][] {{5,4},{6,4},{6,7}, {2,3}};
		//int[][] envelopes = new int[][] {{1, 1}, {1, 1}};
		int[][] envelopes = new int[][] {{5,3},{6,4},{6,7}, {2,3}};
		
		System.out.println(rd.maxEnvelopes(envelopes));
	}

	public int maxEnvelopes(int[][] envelopes) {
		List<Envelop> envelops = new ArrayList<>();
		int[] lis = new int[envelopes.length];
		for(int i=0; i<envelopes.length; i++) {
			envelops.add(new Envelop(envelopes[i][0], envelopes[i][1]));
			lis[i] = 1;
		}
		Collections.sort(envelops);
		
		for(int i=1; i < envelops.size(); i++) {
			for(int j=0; j <i; j++) {
				if(envelops.get(i).width > envelops.get(j).width && envelops.get(i).height > envelops.get(j).height &&
					lis[i] <= lis[j]) {
						lis[i] = lis[j] +1;
				}
			}
		}
		
		int maxdolls = 0;
		for(int i=0; i < lis.length; i++)
			if(lis[i] > maxdolls)
				maxdolls = lis[i];
		
        return maxdolls;
    }
}

class Envelop implements Comparable<Envelop>{
	int width;
	int height;
	public Envelop(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public int compareTo(Envelop envelop) {
		return this.width - envelop.width;
	}
}