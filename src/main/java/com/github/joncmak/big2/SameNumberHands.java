package com.github.joncmak.big2;

import java.util.List;

import com.github.joncmak.deckOfCards.Card;

public class SameNumberHands extends AbstractCardHand
{	
	public String name()
	{
		// TODO Auto-generated method stub
		return null;
	}

	public boolean validateHand(List<Card> pCards)
	{
		int cardNumber = pCards.get(0).getIntValue();
		for(Card card : pCards)
		{
			if(card.getIntValue() != cardNumber)
			{
				return false;
			}
		}
		return true;
	}
}
