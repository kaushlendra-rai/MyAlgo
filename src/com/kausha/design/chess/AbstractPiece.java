package com.kausha.design.chess;

public abstract class AbstractPiece implements Piece {
	Color color;
	PieceType type;
	boolean active;
	
	public AbstractPiece(Color color, PieceType type) {
		this.color = color;
		this.type = type;
		active = true;
	}
	
	@Override
	public Color getColour() {
		return color;
	}

	@Override
	public PieceType getPieceType() {
		return type;
	}

	@Override
	public boolean isActive() {
		return active;
	}

	@Override
	public void deactive() {
		active = false;
	}
}
