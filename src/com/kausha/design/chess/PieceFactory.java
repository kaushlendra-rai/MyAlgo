package com.kausha.design.chess;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class PieceFactory {

	private static Map<String, Class> typeClassMap = new HashMap<String, Class>();
	private static Map<String, Class> strategyClassMap = new HashMap<String, Class>();
	
	// Populate maps statically because we know that chess piece types are constant and they would not extend to new types
	static{
		
	}
	
	public static Piece getPiece(PieceType type){
		Piece piece = getPieceForType(type);

		MoveStrategy moveStrategy = getMoveStrategyForType(type);
		
		piece.setStrategy(moveStrategy);
		
		return piece;
	}
	
	private static MoveStrategy getMoveStrategyForType(PieceType type) {
		
		return null;
	}
	private static Piece getPieceForType(PieceType type) {
		Piece piece;
		Class pieceClass = typeClassMap.get(type);
		
		if(pieceClass == null)
			throw new RuntimeException("Invalid piece type : " + type);
		else{
			try{
				Constructor productConstructor = pieceClass.getDeclaredConstructor(new Class[] { String.class });
				piece =  (Piece)productConstructor.newInstance(new Object[] { });
			}catch(Exception e){
				System.out.println("Exception while getting Piece for type : " + type);
				throw new RuntimeException("Exception while getting Piece for type : " + type, e);
			}
		}
		
		return piece;
	}
}
