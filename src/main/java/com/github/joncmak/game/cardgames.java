package com.github.joncmak.game;

import java.util.Scanner;

import com.github.joncmak.big2.big2;
import com.github.joncmak.blackjack.blackjack.blackjackGame;
import com.github.joncmak.deckOfCards.Deck;

public class cardgames
{
	public static void main(String[] args)
	{
		Scanner playerInput = new Scanner(System.in);

		System.out.println("Select a game: blackjack/big2");
		String game = playerInput.nextLine();
		
		if(game.equalsIgnoreCase("blackjack"))
		{
			Deck deck = new Deck(4);
			blackjackGame blackjack = new blackjackGame(deck);
			
			boolean replay = true;
			while(replay)
			{
				blackjack.gameStart(playerInput);

				System.out.println("Play again? Yes/No");
				String cmd = playerInput.nextLine();
				
				if(cmd.equalsIgnoreCase("yes") || cmd.equalsIgnoreCase("y"))
				{
					replay = true;
					blackjack.newRound();
				}
				else if(cmd.equalsIgnoreCase("no") || cmd.equalsIgnoreCase("n"))
				{
					replay = false;
				}
				else
				{
					System.out.println("invalid command");
				}
			}
		}
		else if(game.equalsIgnoreCase("big2"))
		{
			Deck deck = new Deck(1);
			big2 big2 = new big2(deck);
			
			boolean replay = true;
			
			while(replay)
			{
				big2.gameStart(playerInput);

				System.out.println("Play again? Yes/No");
				String cmd = playerInput.nextLine();
				
				if(cmd.equalsIgnoreCase("yes") || cmd.equalsIgnoreCase("y"))
				{
					replay = true;
					big2.newRound();
				}
				else if(cmd.equalsIgnoreCase("no") || cmd.equalsIgnoreCase("n"))
				{
					replay = false;
				}
				else
				{
					System.out.println("invalid command");
				}
			}
		}
		
		playerInput.close();
		System.out.println("Bye bye!");
		System.exit(0);
	}
}
