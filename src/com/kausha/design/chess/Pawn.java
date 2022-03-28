package com.kausha.design.chess;

public class Pawn extends AbstractPiece {
	public Pawn(Color color) {
		super(color, PieceType.PAWN);
		active = true;
	}
	
	@Override
	public boolean isMoveable(ChessBoard board, Block source, Block target) {
		// Validate that the target block is not outside the ChessBoard
		// TODO some validation on  values for boarder of board.
		
		// If the source and target are already occupied and by same player, move is not possible
		// This check can be added for all pieces.
		if(source.occupied && target.occupied && source.piece.getColour().equals(target.piece.getColour()))
			return false;
		
		// Pawn can move only one step ahead.
		// Straight move
		if((target.getY(source.piece.getColour())  - source.getY(source.piece.getColour()) ==1) &&
				(target.getX(source.piece.getColour()) - source.getX(source.piece.getColour()) == 0) && !target.occupied){
			return true;
		}
		
		// Diagonal move
		if(target.occupied && (target.getY(source.piece.getColour())  - source.getY(source.piece.getColour()) ==1) && 
				((target.getX(source.piece.getColour()) - source.getX(source.piece.getColour()) == -1) ||
						(target.getX(source.piece.getColour()) - source.getX(source.piece.getColour()) == 1))) {
			
			return true;
		}
		
		return false;
	}

	@Override
	public void move(ChessBoard board, Block start, Block end) {
		if(end.piece != null) {
			end.piece.deactive();
		}
		
		end.piece = start.piece;
		end.occupied = true;
		
		start.piece = null;
		start.occupied = false;
	}
}