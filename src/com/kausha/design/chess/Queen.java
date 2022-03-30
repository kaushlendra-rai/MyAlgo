package com.kausha.design.chess;

public class Queen extends AbstractPiece {
	public Queen(Color color) {
		super(color, PieceType.QUEEN);
		active = true;
	}
	
	@Override
	public boolean isMoveValid(ChessBoard board, Block start, Block end) {
		
		return false;
	}

	@Override
	public void move(ChessBoard board, Block start, Block end) {

	}
}