package com.kausha.algo.leetcode;

// https://leetcode.com/problems/find-the-winner-of-an-array-game/
/**
 * Given an integer array arr of distinct integers and an integer k.

A game will be played between the first two elements of the array (i.e. arr[0] and arr[1]). 
In each round of the game, we compare arr[0] with arr[1], the larger integer wins and remains at position 0 
and the smaller integer moves to the end of the array. The game ends when an integer wins k consecutive rounds.

Return the integer which will win the game.

It is guaranteed that there will be a winner of the game.
 * @author sinkar
 *
 */
public class WinnerOfAnArrayGame {

	public static void main(String[] args) {
		WinnerOfAnArrayGame wag = new WinnerOfAnArrayGame();
		//int[] arr = new int[] {2,1,3,5,4,6,7}; // k=2 Ans : 5
		//int[] arr = new int[] {3, 2, 1}; // k=10 Ans : 3
		// int[] arr = new int[] {1,9,8,2,3,7,6,4,5}; // k=7 Ans : 9
		//int[] arr = new int[] {1,11,22,33,44,55,66,77,88,99}; // k=1000000000 Ans : 9
		//System.out.println(wag.getWinner(arr, 1000000000));
		//int[] arr = new int[] {1,2}; // k=1 Ans : 2
		
		
		int[] arr = new int[] {2,1,3,5,4,6,7};
				
		System.out.println(wag.getWinner(arr, 2));
	}

	public int getWinner(int[] arr, int k) {
		int winner = arr[0];
		int count = 0;
		if(k > arr.length)
			k = arr.length-1;
		int idx = 1;
		while(true) {
			System.out.println("arr[0] : " + arr[0] + "  , arr[1]: " + arr[1] );
			if(arr[0] < arr[idx]) {
				arr[0] = arr[idx];
				
				winner = arr[0];
				count = 1;
			}else {
				count++;
			}
			if(count == k || idx == arr.length-1)
				return winner;
			idx++;
		}
    }
}
