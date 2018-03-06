package Queens;

public class Queen
{
	int x;
	int y;
	//public static ChessBoard board ;
	public Queen(int x, int y)
	{
		
		this.x = x;
		this.y = y;
		//board = b;
	
		
	}
	
	public void QueenLeft(ChessBoard board, int x, int y)
	{
		if(y ==  board.board1[x].length - 1)
			board.board1[x][y] = "x";
		
		else
		{
		board.board1[x][y+1] = "x";
		QueenLeft(board, x,y+1);
		}
		
	}
	public void QueenRight(ChessBoard board,int x, int y)
	{
		if(y ==  0)
			board.board1[x][y] = "x";
		
		else
		{
		board.board1[x][y-1] = "x";
		QueenRight(board , x,y-1);
		}
		
		
		
	}
	public void QueenDown(ChessBoard board,int x, int y)
	{
		if(x ==  board.board1.length - 1)
			board.board1[x][y] = "x";
		
		else
		{
		board.board1[x+1][y] = "x";
		QueenDown(board, x + 1, y);
		}
		
	}
	public void QueenUp(ChessBoard board,int x, int y)
	{
		if(x ==  0)
			board.board1[x][y] = "x";
		
		else
		{
		board.board1[x-1][y] = "x";
		QueenUp(board,x - 1, y);
		}
		
	}
	public void diagnolLeft(ChessBoard board,int x,int y)
	{
		if( x == 0 || y == 0)
			board.board1[x][y] = "x";
		else
		{
			board.board1[x-1][y-1] = "x";
			diagnolLeft(board, x-1,y-1);
		}
	}
	public void diagnolDownLeft(ChessBoard board,int x,int y)
	{
		if( x >= board.board1.length - 1 || y == 0)
			board.board1[x][y] = "x";
		else
		{
			board.board1[x+1][y-1] = "x";
			diagnolDownLeft(board, x+1,y-1);
		}
	}
	public void diagnolUpRight(ChessBoard board, int x, int y)
	{
		if( x == 0 || y >= board.board1.length - 1)
			board.board1[x][y] = "x";
		else
		{
			board.board1[x-1][y+1] = "x";
			diagnolUpRight(board, x-1,y+1);
		}
	}
	public void diagnolRight(ChessBoard board,int x,int y)
	{
		if( x == board.board1.length - 1 || y == board.board1.length - 1)
			board.board1[x][y] = "x";
		else
		{
			board.board1[x+1][y+1] = "x";
			diagnolRight(board, x+1,y+1);
		}
	}
	
	public String toString()
	{
		return "Q";
	}
	public void queenMoves(ChessBoard board, Queen Queen1)
	{
		Queen1.QueenLeft(board, Queen1.x,Queen1.y);
		Queen1.QueenRight(board,Queen1.x,Queen1.y);
		Queen1.QueenDown(board,Queen1.x, Queen1.y);
		Queen1.QueenUp(board,Queen1.x, Queen1.y);
		Queen1.diagnolLeft(board,Queen1.x,Queen1.y);
		Queen1.diagnolRight(board,Queen1.x,Queen1.y);
		Queen1.diagnolUpRight(board, Queen1.x, Queen1.y);
		Queen1.diagnolDownLeft(board, Queen1.x, Queen1.y);
		addQueen(board, Queen1);
		
		
	}
	
	public static Queen ifValid(ChessBoard board, int x, int y )
	{
		if( y >= board.board1.length - 1 || board.board1[x][y].equals("-") )
			{
			Queen Queen = new Queen(x,y);
			return Queen;
			
			
			}
			else
		{
			return ifValid(board,x, y+1);
			
		}
		
		
	}
	public static void createQueens(ChessBoard b, Queen q)
	{
		Queen Q1;
		
	
		for(int x = q.x ; q.x < b.board1.length;x++ )
		{
				
		
				Q1 = ifValid(b,x, q.y);

					
				Q1.queenMoves(b, Q1);
				addQueen(b,Q1);
				System.out.println(b);
			
			
		}
		
		
	}
	public static void createQueensRec(ChessBoard b, Queen q)
	{
		if( q.y >= b.board1.length - 1)
		{
			q.y = 0;
			 createQueensRec( b , q);
			
		}
		if( q.x >= b.board1.length - 1 )
		{
			
		}
		else
		{
			Queen newQueen = ifValid(b ,  q.x , q.y);
			newQueen.queenMoves(b, newQueen);
				createQueensRec(b, newQueen);
			
			
		}
	}
	
	public static void addQueen( ChessBoard b, Queen q)
	{
		b.board1[q.x][q.y] = "Q";
		
		
	}
	

	
	public static void main(String[] args)
	{
		ChessBoard myBoard = new ChessBoard(10);
		Queen Queen1 = new Queen(0,0);
		//Queen1.queenMoves(myBoard, Queen1);
		//createQueens(myBoard);
		Queen1.queenMoves(myBoard, Queen1);
//		Queen1.diagnolLeft(myBoard, Queen1.x, Queen1.y);
//		Queen1.diagnolRight(myBoard, Queen1.x, Queen1.y);
//		Queen1.diagnolUpRight(myBoard, Queen1.x, Queen1.y);
//		Queen1.diagnolDownLeft(myBoard, Queen1.x, Queen1.y);
		
		
//		Queen1.addQueen(myBoard, Queen1);
		
		createQueens(myBoard,Queen1);
		System.out.println(myBoard);
		
	}
	
	

}
