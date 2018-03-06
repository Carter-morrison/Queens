package Queens;

public class ChessBoard
{
	public String[][] board1 = new String[rc][rc];
	public static int rc = 0;

	public ChessBoard(int boom)
	{
	rc = boom;
	board1 = createBoard(rc);
	}

	public static String[][] createBoard(int num)
	{
		 String[][] board1 = new String[rc][rc];
		 for(int row = 0; row < board1.length; row++)
		 {
			 for(int col = 0; col < board1[row].length; col++)
				 board1[row][col] = "-";
		 }
		 return board1;
	}
	public boolean isQueen(Queen q)
	{
		int row = board1.length;
		int col = board1[row].length;
		if(q.x == row && q.y == col)
			return true;
		else
			return false;
	}
//	public Queen ifValid(ChessBoard b,int x , int y )
//	{
//		if( board1[x][y].equals("-") )
//		{
//			Queen Queen = new Queen(b, x,y);
//			return Queen;
//		}
//			else
//		{
//			y = y + 1;
//			return ifValid(b, x,y+1);
//			
//		}
		
		
//	}
	public void QueenLeft(int x, int y)
	{
		if(y ==  board1[x].length - 1)
			board1[x][y] = "x";
		
		else
		{
		board1[x][y+1] = "x";
		QueenLeft(x,y+1);
		}
		
	}
	public void QueenRight(int x, int y)
	{
		if(y ==  0)
			board1[x][y] = "x";
		
		else
		{
		board1[x][y-1] = "x";
		QueenRight(x,y-1);
		}
		
		
		
	}
	public void QueenDown(int x, int y)
	{
		if(x ==  board1.length - 1)
			board1[x][y] = "x";
		
		else
		{
		board1[x+1][y] = "x";
		QueenDown(x + 1, y);
		}
		
	}
	public void QueenUp(int x, int y)
	{
		if(x ==  0)
			board1[x][y] = "x";
		
		else
		{
		board1[x-1][y] = "x";
		QueenUp(x - 1, y);
		}
		
	}
	public void diagnolLeft(int x,int y)
	{
		if( x == 0 || y == 0)
			board1[x][y] = "x";
		else
		{
			board1[x-1][y-1] = "x";
			diagnolLeft(x-1,y-1);
		}
	}
	public void diagnolRight(int x,int y)
	{
		if( x == board1.length - 1 || y == board1.length - 1)
			board1[x][y] = "x";
		else
		{
			board1[x+1][y+1] = "x";
			diagnolRight(x+1,y+1);
		}
	}

 
	
	public String toString()
	{
		String result = "\n";
		for (int row = 0; row < board1.length; row++)
		{
			for (int column = 0; column < board1[row].length; column++)
				result += board1[row][column] + "";
			result += "\n";
		}
		return result;
	}
	public static void main(String args[])
	{
		ChessBoard board = new ChessBoard(10);
		System.out.println(board);
		
	}

	public void queenAdd(Queen newQueen)
	{
		
		
	}
}
