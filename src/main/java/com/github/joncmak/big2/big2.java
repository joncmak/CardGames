package com.github.joncmak.big2;

import java.util.ArrayList;

import com.github.joncmak.deckOfCards.Card;
import com.github.joncmak.deckOfCards.Deck;

public class big2
{
	private ArrayList<Card> dealerHand;
	private ArrayList<Card> playerHand;
	
	private Deck mDeck;
	
	public big2(Deck pDeck)
	{
		mDeck = pDeck;
		
		dealerHand = new ArrayList<Card>();
		playerHand = new ArrayList<Card>();
	}
	
	public static int calculateValue(Card pCard)
	{
		int result = 0;
		
		//Calculate card number value
		if(pCard.getIntValue() == 1)
		{
			result = 13;
		}
		else if(pCard.getIntValue() == 2)
		{
			result = 14;
		}
		else
		{
			result = pCard.getIntValue();
		}
		
		//Calculate suit value
		if(pCard.getSuit() == "Diamond")
		{
			result += 1;
		}
		else if(pCard.getSuit() == "Club")
		{
			result += 2;
		}
		else if(pCard.getSuit() == "Heart")
		{
			result += 3;
		}
		else if(pCard.getSuit() == "Club")
		{
			result += 4;
		}
		return result;
	}
}
