package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece
{

	public King( Board board, Color color ) 
	{
		super( board, color );
	}
	
	@Override
	public String toString() 
	{
		return "K";
	}
	
	private boolean canMove( Position position )
	{
		boolean canMove = false;
		
		ChessPiece p = (ChessPiece) getBoard().piece( position );
		
		canMove = p == null || p.getColor() != getColor();
		
		return canMove;
	}

	@Override
	public boolean[][] possibleMoves() 
	{
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position( 0, 0 );
		
		//above
		p.setValues( position.getRow() - 1, position.getColumn() );
		
		if ( getBoard().positionExists( p ) && canMove( p ) )
		{
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//below
		p.setValues( position.getRow() + 1, position.getColumn() );
		
		if ( getBoard().positionExists( p ) && canMove( p ) )
		{
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//left
		p.setValues( position.getRow(), position.getColumn() - 1 );
		
		if ( getBoard().positionExists( p ) && canMove( p ) )
		{
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//right
		p.setValues( position.getRow(), position.getColumn() + 1 );
		
		if ( getBoard().positionExists( p ) && canMove( p ) )
		{
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//northwest
		p.setValues( position.getRow() - 1, position.getColumn() - 1 );
		
		if ( getBoard().positionExists( p ) && canMove( p ) )
		{
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//northeast
		p.setValues( position.getRow() - 1, position.getColumn() + 1 );
		
		if ( getBoard().positionExists( p ) && canMove( p ) )
		{
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//southwest
		p.setValues( position.getRow() + 1, position.getColumn() - 1 );
		
		if ( getBoard().positionExists( p ) && canMove( p ) )
		{
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//southeast
		p.setValues( position.getRow() + 1, position.getColumn() + 1 );
		
		if ( getBoard().positionExists( p ) && canMove( p ) )
		{
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		return mat;
	}
}
