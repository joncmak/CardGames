package tictactoe;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class gameAI
{
	private List<Point> mMoveList;
	
	public gameAI()
	{
		mMoveList = new ArrayList<Point>();
	}
	
	public int calculateMove(Tictactoe pGame)
	{
		switch(mMoveList.size())
		{
			case 0:
				if(pGame.getSymbol(0, 0).equals(""))
				{
					mMoveList.add(new Point(0, 0));
					pGame.setSymbol(0, 0, "O");
				}
				else if(pGame.getSymbol(0, 2).equals(""))
				{
					mMoveList.add(new Point(0, 2));
					pGame.setSymbol(0, 2, "O");
				}
				else if(pGame.getSymbol(2, 0).equals(""))
				{
					mMoveList.add(new Point(2, 0));
					pGame.setSymbol(2, 0, "O");
				}
				else if(pGame.getSymbol(2, 2).equals(""))
				{
					mMoveList.add(new Point(2, 2));
					pGame.setSymbol(2, 2, "O");
				}
				break;
			case 1:
				if(pGame.getSymbol(0, 0).equals("O") && pGame.getSymbol(2, 2).equals(""))
				{
					mMoveList.add(new Point(2, 2));
					pGame.setSymbol(2, 2, "O");
				}
				else if(pGame.getSymbol(0, 2).equals("O") && pGame.getSymbol(2, 0).equals(""))
				{
					mMoveList.add(new Point(2, 0));
					pGame.setSymbol(2, 0, "O");
				}
				else if(pGame.getSymbol(2, 0).equals("O") && pGame.getSymbol(0, 2).equals(""))
				{
					mMoveList.add(new Point(0, 2));
					pGame.setSymbol(0, 2, "O");
				}
				else if(pGame.getSymbol(2, 2).equals("O") && pGame.getSymbol(0, 0).equals(""))
				{
					mMoveList.add(new Point(0, 0));
					pGame.setSymbol(0, 0, "O");
				}
				break;
			case 2:
				if(checkPlayerWin())
				{
					
					break;
				}
				
				Point lastMove = mMoveList.get(1);
				if((lastMove.x == 0 && lastMove.y == 2) || (lastMove.x == 2 && lastMove.y == 0))
				{
					if(pGame.getSymbol(2, 2).equals(""))
					{
						mMoveList.add(new Point(2, 2));
						pGame.setSymbol(2, 2, "O");
					}
					else if(pGame.getSymbol(0, 0).equals(""))
					{
						mMoveList.add(new Point(0, 0));
						pGame.setSymbol(0, 0, "O");
					}
				}
				else if((lastMove.x == 0 && lastMove.y == 0) || (lastMove.x == 2 && lastMove.y == 2))
				{
					if(pGame.getSymbol(2, 0).equals(""))
					{
						mMoveList.add(new Point(2, 0));
						pGame.setSymbol(2, 0, "O");
					}
					else if(pGame.getSymbol(0, 2).equals(""))
					{
						mMoveList.add(new Point(0, 2));
						pGame.setSymbol(0, 2, "O");
					}
				}
				break;
			case 3: case 4:
				lastMove = new Point();
				if(mMoveList.size() == 3)
				{
					lastMove = mMoveList.get(2);
				}
				else if(mMoveList.size() == 4)
				{
					lastMove = mMoveList.get(3);
				}
				
				if(lastMove.x == 0 && lastMove.y == 2)
				{
					if(pGame.getSymbol(0, 1).equals(""))
					{
						mMoveList.add(new Point(0, 1));
						pGame.setSymbol(0, 1, "O");
					}
					else if(pGame.getSymbol(1, 2).equals(""))
					{
						mMoveList.add(new Point(1, 2));
						pGame.setSymbol(1, 2, "O");
					}
				}
				else if(lastMove.x == 2 && lastMove.y == 0)
				{
					if(pGame.getSymbol(1, 0).equals(""))
					{
						mMoveList.add(new Point(1, 0));
						pGame.setSymbol(1, 0, "O");
					}
					else if(pGame.getSymbol(2, 1).equals(""))
					{
						mMoveList.add(new Point(2, 1));
						pGame.setSymbol(2, 1, "O");
					}
				}
				else if(lastMove.x == 0 && lastMove.y == 0)
				{
					if(pGame.getSymbol(0, 1).equals(""))
					{
						mMoveList.add(new Point(0, 1));
						pGame.setSymbol(0, 1, "O");
					}
					else if(pGame.getSymbol(1, 0).equals(""))
					{
						mMoveList.add(new Point(1, 0));
						pGame.setSymbol(1, 0, "O");
					}
				}
				else if(lastMove.x == 2 && lastMove.y == 2)
				{
					if(pGame.getSymbol(2, 1).equals(""))
					{
						mMoveList.add(new Point(2, 1));
						pGame.setSymbol(2, 1, "O");
					}
					else if(pGame.getSymbol(1, 2).equals(""))
					{
						mMoveList.add(new Point(1, 2));
						pGame.setSymbol(1, 2, "O");
					}
				}
				break;
		}

		return 0;
	}
	
	//TODO add checking to prevent easy player wins
	private boolean checkPlayerWin()
	{
		
		return false;
	}
}
