package tictactoe;

import java.awt.Point;
import java.util.HashMap;

public class Tictactoe
{
	private String[][] mBoard;
	public HashMap<Integer, Point> mNumpadCoords;
	
	public Tictactoe()
	{
		mBoard = new String[3][3];
		mNumpadCoords = new HashMap<Integer, Point>();
		
		fillNumpadCoords();
	}
	
	public void printBoard()
	{
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				String symbol = getSymbol(i, j);
				if(symbol.equals(""))
					System.out.print("[ ]");
				else
					System.out.print("[" + symbol  + "]");
			}
			System.out.println();
		}
	}
	
	private void fillNumpadCoords()
	{
		mNumpadCoords.put(1, new Point(0,2));
		mNumpadCoords.put(2, new Point(1,2));
		mNumpadCoords.put(3, new Point(2,2));
		mNumpadCoords.put(4, new Point(0,1));
		mNumpadCoords.put(5, new Point(1,1));
		mNumpadCoords.put(6,  new Point(2,1));
		mNumpadCoords.put(7, new Point(0,0));
		mNumpadCoords.put(8,  new Point(1,0));
		mNumpadCoords.put(9, new Point(2,0));
	}
	
	public String getSymbol(int x, int y)
	{
		String result = mBoard[x][y];
		
		return result != null ? result : "";
	}
	
	public boolean setSymbol(int x, int y, String symbol)
	{
		if(getSymbol(x,y).equals(""))
		{
			mBoard[x][y] = symbol;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean setSymbol(int n, String symbol)
	{
		Point coordinates = mNumpadCoords.get(n);
		return setSymbol(coordinates.x, coordinates.y, symbol);
	}
	
	public boolean hasEmpty()
	{
		for(int x = 0; x < 3; x++)
		{
			for(int y = 0; y < 3; y++)
			{
				if(mBoard[x][y] == null)
				{
					return true;
				}

			}
		}
		return false;
	}
	
	public boolean checkWinConditions()
	{	
		for(int x = 0; x < 3; x++)
		{
			if(mBoard[x][0] != null)
			{
				if(((mBoard[x][0] == mBoard[x][1]) && (mBoard[x][1] == mBoard[x][2])) || 
				((mBoard[0][x] == mBoard[1][x])&&(mBoard[1][x] == mBoard[2][x])))
				{
					return true;
				}
			}
		}
		
		if(mBoard[1][1] != null)
		{
			if(((mBoard[0][0] == mBoard[1][1])&&(mBoard[1][1] == mBoard[2][2]))||
					((mBoard[2][0] == mBoard[1][1])&&(mBoard[1][1] == mBoard[0][2])))
			{
				return true;
			}
		}
		
		return false;
	}
}
