package com.github.joncmak.big2.player;

import java.util.ArrayList;
import java.util.List;

import com.github.joncmak.big2.interfaces.IPlayer;
import com.github.joncmak.deckOfCards.Card;

public abstract class AbstractPlayer implements IPlayer
{
	protected ArrayList<Card> mHand;

	public AbstractPlayer()
	{
		mHand = new ArrayList<Card>();
	}
	
	public void printHand(List<Card> pHand)
	{
		String result = "Hand: ";
		int cardIndex = 0;
		
		for(Card card : pHand)
		{
			result += cardIndex + ": " + card.print() + "\n";
			cardIndex++;
		}
		
		System.out.println(result);
	}
	
	public void addHand(List<Card> pHand)
	{
		mHand.addAll(pHand);
	}
	
	public void clearHand()
	{
		mHand.clear();
	}
	
	public boolean emptyHand()
	{
		return mHand.isEmpty();
	}
}
