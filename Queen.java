package Queens;

public class Queen
{
	int x;
	int y;
	ChessBoard board;
	
	public Queen(ChessBoard b , int x, int y)
	{
		this.x = x;
		this.y = y;
		b.board1 = b.createBoard(b.rc);
		board = b;
		board.board1[x][y] = "Q";
		
	}
	
	public void QueenLeft(int x, int y)
	{
		if(y ==  board.board1[x].length - 1)
			board.board1[x][y] = "x";
		
		else
		{
		board.board1[x][y+1] = "x";
		QueenLeft(x,y+1);
		}
		
	}
	public void QueenRight(int x, int y)
	{
		if(y ==  0)
			board.board1[x][y] = "x";
		
		else
		{
		board.board1[x][y-1] = "x";
		QueenRight(x,y-1);
		}
		
		
		
	}
	public void QueenDown(int x, int y)
	{
		if(x ==  board.board1.length - 1)
			board.board1[x][y] = "x";
		
		else
		{
		board.board1[x+1][y] = "x";
		QueenDown(x + 1, y);
		}
		
	}
	public void QueenUp(int x, int y)
	{
		if(x ==  0)
			board.board1[x][y] = "x";
		
		else
		{
		board.board1[x-1][y] = "x";
		QueenUp(x - 1, y);
		}
		
	}
	public void diagnolLeft(int x,int y)
	{
		if( x == 0 || y == 0)
			board.board1[x][y] = "x";
		else
		{
			board.board1[x-1][y-1] = "x";
			diagnolLeft(x-1,y-1);
		}
	}
	public void diagnolRight(int x,int y)
	{
		if( x == board.board1.length - 1 || y == board.board1.length - 1)
			board.board1[x][y] = "x";
		else
		{
			board.board1[x+1][y+1] = "x";
			diagnolRight(x+1,y+1);
		}
	}
	public String toString()
	{
		String result = "\n";
		for (int row = 0; row < board.board1.length; row++)
		{
			for (int column = 0; column < board.board1[row].length; column++)
				result += board.board1[row][column] + "";
			result += "\n";
		}
		return result;
	}
	public void queenMoves( Queen Queen1)
	{
		Queen1.QueenLeft(Queen1.x,Queen1.y);
		Queen1.QueenRight(Queen1.x,Queen1.y);
		Queen1.QueenDown(Queen1.x, Queen1.y);
		Queen1.QueenUp(Queen1.x, Queen1.y);
		Queen1.diagnolLeft(Queen1.x,Queen1.y);
		Queen1.diagnolRight(Queen1.x,Queen1.y);
		
	}
	
	public Queen ifValid(Queen Queen )
	{
		if( board.board1[x][y].equals("-") )
			return Queen;
		else
		{
			Queen.y = Queen.y + 1;
			return ifValid(Queen);
			
		}
		
		
	}
	public static void main(String[] args)
	{
		ChessBoard myBoard = new ChessBoard(10);
		Queen Queen1 = new Queen(myBoard, 2,5);
		Queen1.queenMoves(Queen1);
		System.out.println(myBoard);
		
	}
	
	

}
