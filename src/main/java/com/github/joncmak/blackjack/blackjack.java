package com.github.joncmak.blackjack;

import java.util.ArrayList;
import java.util.Scanner;

import com.github.joncmak.deckOfCards.Card;
import com.github.joncmak.deckOfCards.Deck;

public class blackjack
{
	public static class blackjackGame
	{
		private ArrayList<Card> dealerHand;
		private ArrayList<Card> playerHand;
		
		private Deck mDeck;
		
		public blackjackGame(Deck pDeck)
		{
			mDeck = pDeck;
			
			dealerHand = new ArrayList<Card>();
			playerHand = new ArrayList<Card>();
		}
		
		private int getHandValue(ArrayList<Card> pHand)
		{
			int result = 0;
			boolean hasAce = false;
			
			for(Card card : pHand)
			{
				if(card.getIntValue() == 1)
				{
					hasAce = true;
				}
				
				result += getCardValue(card);
			}
			
			if(hasAce)
			{
				result = result + 10 <= 21 ? result + 10: result;
			}
			
			return result;
		}
		
		private int getCardValue(Card pCard)
		{			
			if(pCard.getIntValue() > 10)
			{
				return 10;
			}
			else
			{	
				return pCard.getIntValue();
			}			
		}
		
		private void printPlayerHand()
		{			
			String result = "Player Hand: ";

			StringBuilder buffer = new StringBuilder();
			buffer.append(result);
			for(Card card : playerHand)
			{
				buffer.append("[").append(card.print()).append("] ");
			}
			System.out.println(buffer);
			System.out.println("Player Hand Total: " + getHandValue(playerHand));
			System.out.println("");
		}
		
		private void printDealerHand(boolean pFirstRound)
		{			
			String result = "Dealer Hand: ";

			StringBuilder buffer = new StringBuilder();
			buffer.append(result);
			if(pFirstRound)
			{
				buffer.append("[").append(dealerHand.get(0).print()).append("] [?]");
			}
			else
			{
				for(Card card : dealerHand)
				{
					buffer.append("[").append(card.print()).append("] ");
				}
			}
			System.out.println(buffer);
		}
		
		private boolean playerTurn(Scanner pInput)
		{
			while(getHandValue(playerHand) <= 21)
			{	
				if(getHandValue(playerHand) == 21)
				{
					break;
				}
				else
				{
					System.out.println("Hit or Stand?");
					String cmd = pInput.nextLine();
					
					if(cmd.equalsIgnoreCase("hit"))
					{
						//draw card
						playerHand.add(mDeck.draw());
						printPlayerHand();
					}
					else if(cmd.equalsIgnoreCase("stand"))
					{
						//dealer turn
						break;
					}
					else
					{
						System.out.println("invalid command");
					}
				}
			}
			return getHandValue(playerHand) <= 21? true : false;
		}
		
		private boolean dealerTurn()
		{
			while(getHandValue(dealerHand) < 17)
			{
				dealerHand.add(mDeck.draw());
			}
			printDealerHand(false);
			
			int finalValue = getHandValue(dealerHand);
			System.out.println("Dealer Hand Total: " + finalValue);
			System.out.println("");
			
			return finalValue <= 21? true : false;
		}
		
		public void gameStart(Scanner pInputScanner)
		{
			mDeck.shuffle();
			
			playerHand.addAll(mDeck.draw(2));
			dealerHand.addAll(mDeck.draw(2));
			
			printPlayerHand();
			printDealerHand(true);
			
			boolean playerSafe = playerTurn(pInputScanner);
			
			boolean dealerSafe = dealerTurn();
			
			if(playerSafe)
			{
				if(dealerSafe)
				{
					if(getHandValue(playerHand) > getHandValue(dealerHand))
					{
						//win
						System.out.println("You Win!");
					}
					else if(getHandValue(playerHand) == getHandValue(dealerHand))
					{
						System.out.println("You tie!");
					}
					else
					{
						System.out.println("You lose!");
					}
				}
				else
				{
					//win
					System.out.println("Dealer bust! You Win!");

				}
			}
			else
			{
				//lose
				System.out.println("You bust! You lose!");
			}
		}
		
		public void newRound()
		{
			playerHand.clear();
			dealerHand.clear();
		}
	}
}
