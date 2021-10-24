package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece
{
	private Color color;
	private int moveCount;
	
	public ChessPiece( Board board, Color color ) 
	{
		super( board );
		this.color = color;
	}

	public Color getColor() 
	{
		return color;
	}

	protected void increaseMoveCount()
	{
		moveCount++;
	}

	protected void decreaseMoveCount()
	{
		moveCount--;
	}

	public int getMoveCount()
	{
		return moveCount;
	}

	public ChessPosition getChessPosition()
	{
		return ChessPosition.fromPosition( position );
	}
	
	protected boolean isThereOpponentPiece( Position position )
	{
		ChessPiece cp = (ChessPiece) getBoard().piece( position );
		
		boolean isOpponent = cp != null && cp.getColor() != color;
		
		return isOpponent;
	}
}
