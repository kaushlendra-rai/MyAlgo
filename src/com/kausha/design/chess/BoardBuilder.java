package com.kausha.design.chess;

// It would be used to build initial block layout & place players appropriately on the Board
public class BoardBuilder {
	
	ChessBoard chessBoard = new ChessBoard();
	boolean boardInitialized;
	
	// Initialize alternate Blocks as Black & White.
	public BoardBuilder initializeBlocksOnBoard(){
		// Sets color of alternate Blocks of Board as BLACK & WHITE
		boardInitialized = true;
		return this;
	}
	
	// Player1 has white pieces.
	public BoardBuilder placePlayer1(){
		if(!boardInitialized)
			throw new RuntimeException("Board must be initialized before placing players");
		
		return this;
	}
	
	// Player2 has black pieces.
	public BoardBuilder placePlayer2(){
		if(!boardInitialized)
			throw new RuntimeException("Board must be initialized before placing players");
		
		return this;
	}
	
	public ChessBoard build(){
		if(boardInitialized)
			return chessBoard;
		else
			return null;
	}
}