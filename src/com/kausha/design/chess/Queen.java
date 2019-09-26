package com.kausha.design.chess;

public class Queen implements Piece {
	Color colour;
	public Queen(Color colour) {
		this.colour = colour;
	}
	
	@Override
	public Color getColour() {
		return colour;
	}

	@Override
	public PieceType getPieceType() {
		return PieceType.QUEEN;
	}

	@Override
	public boolean isMoveable(ChessBoard board, Block start, Block end) {
		
		return false;
	}

	@Override
	public void move(ChessBoard board, Block start, Block end) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isActive() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deactive() {
		// TODO Auto-generated method stub
		
	}

}