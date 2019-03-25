package com.kausha.design.chess;

public interface Piece {
	Color getColour();
	
	PieceType getPieceType();
	
	MoveStrategy getStrategy();
	
	void setStrategy(MoveStrategy moveStrategy);
}
