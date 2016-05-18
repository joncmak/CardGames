package com.github.joncmak.big2;

import java.util.List;

import com.github.joncmak.deckOfCards.Card;

public class SameSuitHands extends AbstractCardHand
{
	public String name()
	{
		// TODO Auto-generated method stub
		return null;
	}

	public boolean validateHand(List<Card> pCards)
	{
		String cardSuit = pCards.get(0).getSuit();
		for(Card card : pCards)
		{
			if(card.getSuit() != cardSuit)
			{
				return false;
			}
		}
		return true;
	}
}
