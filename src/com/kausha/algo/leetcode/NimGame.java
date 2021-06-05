package com.kausha.algo.leetcode;

// https://www.youtube.com/watch?v=ndR2buBWVc8
/**
 * You are playing the following Nim Game with your friend:

Initially, there is a heap of stones on the table.
You and your friend will alternate taking turns, and you go first.
On each turn, the person whose turn it is will remove 1 to 3 stones from the heap.
The one who removes the last stone is the winner.
Given n, the number of stones in the heap, return true if you can win the game assuming both you and your friend play optimally, otherwise return false.
 * @author sinkar
 *
 */
public class NimGame {

	public static void main(String[] args) {
		NimGame ng = new NimGame();
		
		System.out.println(ng.canWinNim(8));
		System.out.println(ng.canWinNim(7));
		System.out.println(ng.canWinNim(1));
		System.out.println(ng.canWinNim(4));
	}
	
	// If we observe the pattern of win and loose (Given I, the primary user moves first):
	// 1	2	3	4	5	6	7	8	9
	// w	w	w	l	w	w	w	l	w
	// It turns out to be a divisibility by 4 problem. If divisible by '4' I loose, else I win.
	public boolean canWinNim(int n) {
		if(n%4 == 0)
			return false;
		else
			return true;
    }

}
