package com.kausha.design.chess;

public interface Piece {
	Color getColour();
	
	PieceType getPieceType();
	boolean isActive();
	void deactive();
	
	boolean isMoveable(ChessBoard board, Block start, Block end);
	
	void move(ChessBoard board, Block start, Block end);
}
