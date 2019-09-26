package com.kausha.design.chess;

public class Block {
	private int x;
	private int y;
	
	boolean occupied;
	Color color;
	
	Piece piece;
	
	// It MUST be noted that x & y values are expected to be positive only.
	// If we keep player 'One' toward us and see x & y going positive for player 'One' moves.
	// However, if we do not take into account Player 'Two''s view, numbers might go in negative and moves of PAWN might become invalid.
	//Lets keep white color player towards us (Normal X & Y)
	// For Player with color Black, we return him values as x = 7-x & y = 7-y 
	public int getX(Color color) {
		if(Color.WHITE.equals(color))
			return x;
		else 
			return 7-x; 
	}
	
	public int getY(Color color) {
		if(Color.WHITE.equals(color))
			return y;
		else 
			return 7-y;
	}
}