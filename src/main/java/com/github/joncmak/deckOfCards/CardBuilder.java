package com.github.joncmak.deckOfCards;

import com.github.jonmak.CardDeckInterfaces.ICardBuilder;

public class CardBuilder implements ICardBuilder
{
	private String mSuit;
	private String mStringValue;
	private int mIntegerValue;
	
	public CardBuilder()
	{
	}
	
	public CardBuilder setSuit(String pSuit)
	{
		mSuit = pSuit;
		return this;
	}

	public CardBuilder setStringValue(String pStringValue)
	{
		mStringValue = pStringValue;
		return this;
	}

	public CardBuilder setIntegerValue(int pIntValue)
	{
		mIntegerValue = pIntValue;
		return this;
	}

	public String getSuit()
	{
		return mSuit;
	}

	public String getStringValue()
	{
		return mStringValue;
	}

	public int getIntValue()
	{
		return mIntegerValue;
	}

	public Card build()
	{
		return new Card(this);
	}
}
