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
		
	}
	
	public void QueenRow(int x, int y)
	{
		if( y == board.board1[x].length - 1 ) 
				board.board1[x][y] = "X";
		
		else
		{
			board.board1[x][y] = "X";
			QueenRow(x,y+1);
			//QueenColumun(x,y-1);
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
	
	public static void main(String[] args)
	{
		ChessBoard myBoard = new ChessBoard(10);
		Queen Queen1 = new Queen(myBoard, 2,5);
		System.out.println(Queen1);
		Queen1.QueenRow(Queen1.x,Queen1.y);
		System.out.println(myBoard);
		
	}
	

}