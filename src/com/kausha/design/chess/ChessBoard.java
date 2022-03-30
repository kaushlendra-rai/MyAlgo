package com.kausha.design.chess;

public class ChessBoard {
	// Keeping constructor with default access modifier so that it could be instantiated only by BoardBuilder
	ChessBoard(){
	}
	
	Block[][] chessBoard = new Block[8][8];
	
	// By Default, game would be started by player with White piece
	boolean nextMoveByWhitePiece = true;
	Player player1;
	Player player2;
	
	public Status move(Player player, Block source, Block target) throws InvalidMoveException{
		
		return Status.Running;
	}
}
