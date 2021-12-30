package com.kausha.design.snakeladder;

import java.util.Random;

public class Dice {
	private static Random rnd = new Random();
	
	public static int roll() {
		return rnd.nextInt(6) + 1;
	}
}
