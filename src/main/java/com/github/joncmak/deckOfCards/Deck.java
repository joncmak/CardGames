package com.github.joncmak.deckOfCards;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import com.github.jonmak.CardDeckInterfaces.IDeck;

public class Deck implements IDeck
{
	private LinkedList<Card> mDeck;
	
	public Deck()
	{	
		mDeck = new LinkedList<Card>();
		generate();
	}
	
	public Deck(int pNumOfDecks)
	{
		mDeck = new LinkedList<Card>();
		
		for(int i = 0; i < pNumOfDecks; i++)
		{
			generate();
		}
	}
	
	public void generate()
	{
		CardBuilder builder = new CardBuilder();
		
		for(String suit : Card.sSuits)
		{
			for(String value : Card.sStringValues)
			{
				//construct
				builder.setSuit(suit);
				builder.setStringValue(value);
				builder.setIntegerValue(Card.sStringValues.indexOf(value)+1);
				mDeck.add(builder.build());
			}
		}
	}

	public void add(List<Card> pCards)
	{
		// TODO Auto-generated method stub
		
	}

	public void shuffle()
	{
		Collections.shuffle(mDeck);
	}

	public Card draw()
	{
		return mDeck.remove();
	}

	public List<Card> draw(int numberOfCards)
	{
		List<Card> result = new LinkedList<Card>();
		for(int i = 0; i < numberOfCards; i++)
		{
			result.add(mDeck.remove());
		}
		return result;
	}
}
