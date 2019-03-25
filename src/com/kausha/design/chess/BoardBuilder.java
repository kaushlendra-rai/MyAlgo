package com.kausha.design.chess;

// It would be used to build initial block layout & place players appropriately on the Board
public class BoardBuilder {
	
	ChessBoard chessBoard = new ChessBoard();
	boolean boardInitialized;
	
	public BoardBuilder initializeBlocksOnBoard(){
		
		boardInitialized = true;
		return this;
	}
	
	public BoardBuilder placePlayer1(){
		if(!boardInitialized)
			throw new RuntimeException("Board must be initialized before placing players");
		
		return this;
	}
	
	public BoardBuilder placePlayer2(){
		if(!boardInitialized)
			throw new RuntimeException("Board must be initialized before placing players");
		
		return this;
	}
	
	public ChessBoard build(){
		return chessBoard;
	}
}