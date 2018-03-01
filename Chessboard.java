package com.java.queens;

public class Chessboard
{
	public String[][] board1 = new String[rc][rc];
	public static int rc = 0;

	public Chessboard(int boom)
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
		Chessboard board = new Chessboard(10);
		System.out.println(board);
		
	}
}
