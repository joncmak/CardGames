package com.github.joncmak.big2;

import java.util.ArrayList;
import java.util.List;

import com.github.joncmak.deckOfCards.Card;
import com.github.jonmak.CardDeckInterfaces.ICardHand;

public abstract class AbstractCardHand implements ICardHand
{
	public abstract boolean validateHand(List<Card> pCards);
	
	private ArrayList<Card> mCardList = new ArrayList<Card>();
	
	public int getValue()
	{
		int result = 0;
		for(Card card : mCardList)
		{
			result += big2.calculateValue(card);
		}
		return result;
	}
		
	public void addCards(List<Card> pCards)
	{
		mCardList.addAll(pCards);
	}
}
