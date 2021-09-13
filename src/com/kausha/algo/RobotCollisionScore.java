package com.kausha.algo;

public class RobotCollisionScore {

	/**
	 * https://www.hackerrank.com/contests/101hack48/challenges/walking-robots
	 * 
	 * •The robots are initially spaced apart on an infinitely long straight line. 
	 * Some of them begin moving simultaneously at the same constant speed. Two robots moving in the same direction never collide.
		•Two robots moving toward each other will crash, break down, and stay at that point forever. This counts as  collisions.
		•A robot moving toward a non-moving robot will crash into it, break down, and stay at that point forever. This counts as  collision.

		To clarify, whenever a moving robot crashes onto another robot, it will stay at that point and become a non-moving robot at that location. 
		Return an integer denoting the total number of collisions that eventually occur after movement begins.

		Sample Input 0

		5
		r
		lrrl
		rrrll
		rrdlldrr
		rrrdllrllrrl
		
		Sample Output 0
		
		0
		3
		5
		4
		11

	 * @param args
	 */
	public static void main(String[] args) {
		//char[] input = {'l', 'r'};
		char[] input = {'l', 'r', 'd'};
		// rrrdllrllrrl
		//char[] input = {'r', 'r', 'r', 'l', 'l', 'r', 'l', 'l', 'r', 'r', 'l'};
		
		// rrdlldrr
		//char[] input = {'r', 'r', 'd', 'l', 'l', 'd', 'r', 'r'};
		//char[] input = {'r', 'r', 'd', 'r', 'r', 'r', 'l'};
		//char[] input = {'l', 'l', 'r', 'r', 'd', 'd', 'd', 'r', 'r', 'r', 'l', 'r'};
		System.out.println(getTotalColissions(input));
	}

	private static int getTotalColissions(char[] input) {
		int collisionCount = 0;
		
		int rIndex = -1;
		int deadIndex = -1;
		
		for(int i=0; i < input.length; i++){
			if(input[i] == 'r'){
				if(rIndex == -1)
					rIndex = i;
				
			}else if(input[i] == 'l'){
				// If there exists a robot moving to right, it collides with this left and makes them dead robot
				// So, also update the dead robot index
				if(rIndex >= 0){
					collisionCount += i -rIndex;
					rIndex = -1;
					deadIndex = i;
				}else if(deadIndex >= 0){
					collisionCount +=1;
					deadIndex = i;
				}
			}else{
				// If Dead Robot is encountered
				if(rIndex >=0){
					collisionCount+= i-rIndex;
					rIndex = -1;
					deadIndex = i;
				}
			}
		}
		
		return collisionCount;
	}

}