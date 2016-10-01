package tictactoe;

import java.util.Scanner;

public class GameSetup
{
	private static boolean mEnableNumpad = false;
	
	public static void main(String[] args)
	{
		Scanner playerInput = new Scanner(System.in);
		Tictactoe game = new Tictactoe();
		gameAI ai = new gameAI();
		
		System.out.println("Select a control scheme: coordinates/numpad");
		String controls = playerInput.nextLine();

		if(controls.equals("coordinates"))
		{
			mEnableNumpad = false;
			System.out.println("selected coordinates");
		}
		else if(controls.equals("numpad"))
		{
			mEnableNumpad = true;
			System.out.println("selected numpad");
		}
		
		boolean continueGame = true;
		
		while(continueGame)
		{
			//game loop
			while(!game.checkWinConditions())
			{
				//player turn
				System.out.println("enter command:");
				if(mEnableNumpad)
				{
					int coord = playerInput.nextInt();
					if((1 <= coord) && (coord <= 9))
					{
						game.setSymbol(coord, "X");
						System.out.println("Set: " + game.mNumpadCoords.get(coord));
					}
					else
					{
						System.out.println("invalid coordinates");
						break;
					}
				}
				else
				{
					String coords = playerInput.nextLine();
					String pattern = "[0-2],\\s*[0-2]";
					
					if(coords.matches(pattern))
					{
						int x = Integer.parseInt(coords.split(",")[0].replaceAll("\\s+", ""));
						int y = Integer.parseInt(coords.split(",")[1].replaceAll("\\s+", ""));
						
						if(game.getSymbol(x, y) == "")
						{
							game.setSymbol(x, y, "X");
							System.out.println("Set: " + x + ", " + y);
						}
						else
						{
							System.out.println("invalid coordinates");
							break;
						}
					}
					else
					{
						System.out.println("invalid coordinates");
						break;
					}
				}
				//AI turn
				ai.calculateMove();
			}
			System.out.println("Game Over\n Play Again?");
			//play again?
			String playAgain = playerInput.nextLine();
			if(playAgain.equals("Y"))
				continueGame = true;
			else if(playAgain.equals("N"))
				continueGame = false;
		}
		
		playerInput.close();
	}
}
