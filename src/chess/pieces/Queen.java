package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Queen extends ChessPiece
{

	public Queen( Board board, Color color ) 
	{
		super( board, color );
	}

	@Override
	public String toString() 
	{
		return "Q";
	}

	@Override
	public boolean[][] possibleMoves() 
	{
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position( 0, 0 );
		
		//above
		p.setValues( position.getRow() - 1, position.getColumn() );
		
		while ( getBoard().positionExists( p ) && ! getBoard().thereIsAPiece( p ) )
		{
			mat[p.getRow()][p.getColumn()] = true;
			
			p.setRow( p.getRow() - 1 );
		}
		
		validateOpponentInPosition( mat, p );
		
		//left
		p.setValues( position.getRow(), position.getColumn() - 1 );
		
		while ( getBoard().positionExists( p ) && ! getBoard().thereIsAPiece( p ) )
		{
			mat[p.getRow()][p.getColumn()] = true;
			
			p.setColumn( p.getColumn() - 1 );
		}
		
		validateOpponentInPosition( mat, p );
		
		//right
		p.setValues( position.getRow(), position.getColumn() + 1 );
		
		while ( getBoard().positionExists( p ) && ! getBoard().thereIsAPiece( p ) )
		{
			mat[p.getRow()][p.getColumn()] = true;
			
			p.setColumn( p.getColumn() + 1 );
		}
		
		validateOpponentInPosition( mat, p );
		
		//below
		p.setValues( position.getRow() + 1, position.getColumn() );
		
		while ( getBoard().positionExists( p ) && ! getBoard().thereIsAPiece( p ) )
		{
			mat[p.getRow()][p.getColumn()] = true;
			
			p.setRow( p.getRow() + 1 );
		}
		
		validateOpponentInPosition( mat, p );

        		//northwest
		p.setValues( position.getRow() - 1, position.getColumn() - 1 );
		
		while ( getBoard().positionExists( p ) && ! getBoard().thereIsAPiece( p ) )
		{
			mat[p.getRow()][p.getColumn()] = true;
			
			p.setValues( p.getRow() - 1, p.getColumn() - 1 );
		}
		
		validateOpponentInPosition( mat, p );
		
		//northeast
		p.setValues( position.getRow() - 1, position.getColumn() + 1 );
		
		while ( getBoard().positionExists( p ) && ! getBoard().thereIsAPiece( p ) )
		{
			mat[p.getRow()][p.getColumn()] = true;
			
			p.setValues( p.getRow() - 1, p.getColumn() + 1 );
		}
		
		validateOpponentInPosition( mat, p );
		
		//southeast
		p.setValues( position.getRow() + 1, position.getColumn() + 1 );
		
		while ( getBoard().positionExists( p ) && ! getBoard().thereIsAPiece( p ) )
		{
			mat[p.getRow()][p.getColumn()] = true;
			
			p.setValues( p.getRow() + 1, p.getColumn() + 1 );
		}
		
		validateOpponentInPosition( mat, p );
		
		//southweast
		p.setValues( position.getRow() + 1, position.getColumn() - 1 );
		
		while ( getBoard().positionExists( p ) && ! getBoard().thereIsAPiece( p ) )
		{
			mat[p.getRow()][p.getColumn()] = true;
			
			p.setValues( p.getRow() + 1, p.getColumn() - 1 );
		}
		
		validateOpponentInPosition( mat, p );
		
		return mat;
	}
	
	private void validateOpponentInPosition( boolean mat[][], Position p )
	{
		if ( getBoard().positionExists( p ) && isThereOpponentPiece( p ) )
		{
			mat[p.getRow()][p.getColumn()] = true;
		}
	}
}
